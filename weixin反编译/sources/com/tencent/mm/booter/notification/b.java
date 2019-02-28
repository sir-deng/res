package com.tencent.mm.booter.notification;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.bk.a;
import com.tencent.mm.bl.d;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.f.a.ob;
import com.tencent.mm.f.a.ov;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.j.f;
import com.tencent.mm.plugin.bbom.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.y.aj;
import com.tencent.mm.y.am;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.s;
import com.tencent.mm.y.t;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;
import java.util.Map;

public final class b implements aj, am {
    Context context = null;
    au fFE;
    private String gBd;
    private String gBe;
    String gBf;
    Intent gBg;
    private boolean gBh;
    private int gBi;
    private boolean gBj;
    private long gBk;
    f gBl = a.gBQ;
    private e gBm;
    @SuppressLint({"HandlerLeak"})
    ag gBn = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            ad.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", true).apply();
            String string = message.getData().getString("notification.show.talker");
            String string2 = message.getData().getString("notification.show.message.content");
            int i = message.getData().getInt("notification.show.message.type");
            int i2 = message.getData().getInt("notification.show.tipsflag");
            x.i("MicroMsg.MMNotification", "notify need to deal: %s", string);
            try {
                if (message.what == 1) {
                    b.a(b.this, string, string2, i, i2, true);
                } else {
                    b.a(b.this, string, string2, i, i2, false);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMNotification", e, "showNotifiHandler", new Object[0]);
            }
        }
    };
    private final c gBo = new c<ob>() {
        {
            this.xmG = ob.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ob obVar = (ob) bVar;
            if (obVar != null && (obVar instanceof ob)) {
                cg cgVar = obVar.fGN.fFE;
                if (cgVar != null) {
                    b bVar2 = b.this;
                    if (cgVar.field_isSend == 1) {
                        x.w("MicroMsg.MMNotification", "notifyRevorkMessage is sender , msgid:%d ", Long.valueOf(cgVar.field_msgSvrId));
                    } else {
                        bVar2.fFE = cgVar;
                        int d = f.d(cgVar);
                        bVar2.talker = cgVar.field_talker;
                        String str = cgVar.field_content;
                        int type = cgVar.getType();
                        bVar2.gBf = "";
                        bVar2.gBg = null;
                        x.i("MicroMsg.MMNotification", "notifyRevorkMessage talker:%s msgid:%d type:%d tipsFlag:%d content:%s", bVar2.talker, Long.valueOf(cgVar.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(d), bi.Wz(str));
                        if (bVar2.gBl.a(bVar2.talker, bVar2.fFE, d, true)) {
                            bVar2.gBn.sendMessageDelayed(b.a(bVar2.talker, str, type, d, 1), 200);
                        } else {
                            x.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                        }
                    }
                }
            }
            return false;
        }
    };
    private final c gBp = new c<ov>() {
        {
            this.xmG = ov.class.getName().hashCode();
        }

        private boolean a(ov ovVar) {
            if (ovVar != null && (ovVar instanceof ov)) {
                String str = ovVar.fHG.fGc;
                int i = ovVar.fHG.msgType;
                b bVar = b.this;
                try {
                    x.w("showSendMsgFailNotification fromUserName:%s msgType:%d", str, Integer.valueOf(i));
                    if (!ChattingUI.class.getName().equals(((RunningTaskInfo) ((ActivityManager) bVar.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName())) {
                        Intent intent = new Intent(bVar.context, ChattingUI.class);
                        intent.putExtra("nofification_type", "pushcontent_notification");
                        intent.putExtra("Intro_Is_Muti_Talker", true);
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("MainUI_User_Last_Msg_Type", i);
                        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                        intent.addFlags(67108864);
                        Notification notification = new Builder(bVar.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(bVar.context.getString(R.l.dGB)).setContentText(bVar.context.getString(R.l.evo)).setContentIntent(PendingIntent.getActivity(bVar.context, 35, intent, 1073741824)).getNotification();
                        notification.icon = a.bYI();
                        notification.defaults |= 1;
                        notification.flags |= 16;
                        bVar.a(35, notification, true);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMNotification", e, "", new Object[0]);
                }
            }
            return false;
        }
    };
    String talker;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.booter.notification.b r29, java.lang.String r30, java.lang.String r31, int r32, int r33, boolean r34) {
        /*
        r4 = "MicroMsg.MMNotification";
        r5 = "jacks dealNotify, talker:%s, msgtype:%d, tipsFlag:%d, isRevokeMesasge:%B content:%s";
        r6 = 5;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r30;
        r7 = 1;
        r8 = java.lang.Integer.valueOf(r32);
        r6[r7] = r8;
        r7 = 2;
        r8 = java.lang.Integer.valueOf(r33);
        r6[r7] = r8;
        r7 = 3;
        r8 = java.lang.Boolean.valueOf(r34);
        r6[r7] = r8;
        r7 = 4;
        r8 = com.tencent.mm.sdk.platformtools.bi.Wz(r31);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        if (r34 == 0) goto L_0x00f8;
    L_0x002d:
        r4 = 2;
        r4 = new boolean[r4];
        r4 = {0, 0};
    L_0x0033:
        r5 = 0;
        r6 = r4[r5];
        r5 = 1;
        r7 = r4[r5];
        if (r6 != 0) goto L_0x020c;
    L_0x003b:
        if (r7 != 0) goto L_0x020c;
    L_0x003d:
        r4 = 1;
    L_0x003e:
        r5 = "MicroMsg.MMNotification";
        r8 = new java.lang.StringBuilder;
        r9 = "updateNotifyInfo: silent = ";
        r8.<init>(r9);
        r8 = r8.append(r4);
        r8 = r8.toString();
        com.tencent.mm.sdk.platformtools.x.d(r5, r8);
        r5 = 1;
        r0 = r29;
        r0.gBj = r5;
        if (r4 != 0) goto L_0x007d;
    L_0x005b:
        r4 = "MicroMsg.MMNotification";
        r5 = new java.lang.StringBuilder;
        r8 = "updateNotifyInfo : modify lastNotSilentTime = ";
        r5.<init>(r8);
        r0 = r29;
        r8 = r0.gBk;
        r5 = r5.append(r8);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.d(r4, r5);
        r4 = java.lang.System.currentTimeMillis();
        r0 = r29;
        r0.gBk = r4;
    L_0x007d:
        r0 = r29;
        r4 = r0.gBl;
        r0 = r29;
        r5 = r0.gBd;
        r4 = r4.gBP;
        r4 = r4.gBH;
        r8 = "MicroMsg.Notification.AppMsg.Handle";
        r9 = "dealCurChattingTalker, talker: %s, curChattingTalker: %s, needSound: %B, needShake: %B";
        r10 = 4;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r10[r11] = r30;
        r11 = 1;
        r10[r11] = r5;
        r11 = 2;
        r12 = java.lang.Boolean.valueOf(r6);
        r10[r11] = r12;
        r11 = 3;
        r12 = java.lang.Boolean.valueOf(r7);
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.x.d(r8, r9, r10);
        r8 = com.tencent.mm.sdk.platformtools.bi.oN(r30);
        if (r8 != 0) goto L_0x0264;
    L_0x00af:
        r8 = com.tencent.mm.sdk.platformtools.bi.oN(r5);
        if (r8 != 0) goto L_0x0264;
    L_0x00b5:
        r0 = r30;
        r8 = r0.equals(r5);
        if (r8 == 0) goto L_0x0264;
    L_0x00bd:
        if (r7 != 0) goto L_0x00c1;
    L_0x00bf:
        if (r6 == 0) goto L_0x00c7;
    L_0x00c1:
        r8 = com.tencent.mm.j.a.zv();
        if (r8 != 0) goto L_0x020f;
    L_0x00c7:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION] is current talker chatroom & no shake & no sound";
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);
        r4 = 1;
    L_0x00d1:
        if (r4 == 0) goto L_0x0267;
    L_0x00d3:
        r4 = "MicroMsg.MMNotification";
        r5 = "[no notificaion], iscurrent Chatting Talker true, talker[%s] curChattingTalker[%s] needSound[%B] needShake[%B]";
        r8 = 4;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r30;
        r9 = 1;
        r0 = r29;
        r10 = r0.gBd;
        r8[r9] = r10;
        r9 = 2;
        r6 = java.lang.Boolean.valueOf(r6);
        r8[r9] = r6;
        r6 = 3;
        r7 = java.lang.Boolean.valueOf(r7);
        r8[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.w(r4, r5, r8);
    L_0x00f7:
        return;
    L_0x00f8:
        r0 = r29;
        r6 = r0.gBm;
        r0 = r29;
        r7 = r0.fFE;
        r0 = r29;
        r8 = r0.gBj;
        r0 = r29;
        r10 = r0.gBk;
        r4 = 2;
        r5 = new boolean[r4];
        r5 = {1, 1};
        r4 = com.tencent.mm.booter.notification.a.e.xv();
        r9 = com.tencent.mm.booter.notification.a.e.xx();
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4, r9);
        if (r4 != 0) goto L_0x01b4;
    L_0x011c:
        r4 = com.tencent.mm.booter.notification.a.e.xu();
        if (r4 != 0) goto L_0x01d7;
    L_0x0122:
        r4 = 1;
    L_0x0123:
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4);
        if (r4 != 0) goto L_0x01b4;
    L_0x0129:
        r4 = com.tencent.mm.booter.notification.a.e.ew(r30);
        if (r4 != 0) goto L_0x01da;
    L_0x012f:
        r4 = 1;
    L_0x0130:
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4);
        if (r4 != 0) goto L_0x01b4;
    L_0x0136:
        r4 = com.tencent.mm.booter.notification.a.e.ft(r33);
        r9 = com.tencent.mm.booter.notification.a.e.fu(r33);
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4, r9);
        if (r4 != 0) goto L_0x01b4;
    L_0x0144:
        r4 = 0;
        r6.gCc = r4;
        r4 = "keep_app_silent";
        r4 = com.tencent.mm.sdk.platformtools.af.VK(r4);
        if (r4 == 0) goto L_0x01dd;
    L_0x0150:
        r4 = 1;
        r6.gCc = r4;
    L_0x0153:
        r8 = "MicroMsg.Notification.Silent.Handle";
        r9 = "check Refresh Keep is NOT Silent: %B";
        r4 = 1;
        r10 = new java.lang.Object[r4];
        r11 = 0;
        r4 = r6.gCc;
        if (r4 != 0) goto L_0x01ff;
    L_0x0161:
        r4 = 1;
    L_0x0162:
        r4 = java.lang.Boolean.valueOf(r4);
        r10[r11] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r8, r9, r10);
        r4 = r6.gCc;
        if (r4 != 0) goto L_0x0202;
    L_0x016f:
        r4 = 1;
    L_0x0170:
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4);
        if (r4 != 0) goto L_0x01b4;
    L_0x0176:
        r0 = r30;
        r4 = com.tencent.mm.booter.notification.a.e.a(r0, r7);
        if (r4 != 0) goto L_0x0205;
    L_0x017e:
        r4 = 1;
    L_0x017f:
        r4 = com.tencent.mm.booter.notification.a.e.a(r5, r4);
        if (r4 != 0) goto L_0x01b4;
    L_0x0185:
        r4 = 0;
        r4 = r5[r4];
        if (r4 == 0) goto L_0x0197;
    L_0x018a:
        r6 = 0;
        r7 = r5[r6];
        r4 = com.tencent.mm.booter.notification.a.e.ev(r30);
        if (r4 != 0) goto L_0x0208;
    L_0x0193:
        r4 = 1;
    L_0x0194:
        r4 = r4 & r7;
        r5[r6] = r4;
    L_0x0197:
        r4 = 0;
        r4 = r5[r4];
        if (r4 == 0) goto L_0x01aa;
    L_0x019c:
        r4 = 0;
        r6 = r5[r4];
        r0 = r32;
        r1 = r31;
        r7 = com.tencent.mm.booter.notification.a.e.o(r0, r1);
        r6 = r6 & r7;
        r5[r4] = r6;
    L_0x01aa:
        r4 = com.tencent.mm.booter.notification.a.e.xw();
        if (r4 != 0) goto L_0x020a;
    L_0x01b0:
        r4 = 1;
    L_0x01b1:
        com.tencent.mm.booter.notification.a.e.a(r5, r4);
    L_0x01b4:
        r4 = "MicroMsg.Notification.Silent.Handle";
        r6 = "finally silent, sound: %B, shake: %B";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = 0;
        r9 = r5[r9];
        r9 = java.lang.Boolean.valueOf(r9);
        r7[r8] = r9;
        r8 = 1;
        r9 = 1;
        r9 = r5[r9];
        r9 = java.lang.Boolean.valueOf(r9);
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r4, r6, r7);
        r4 = r5;
        goto L_0x0033;
    L_0x01d7:
        r4 = 0;
        goto L_0x0123;
    L_0x01da:
        r4 = 0;
        goto L_0x0130;
    L_0x01dd:
        r12 = 0;
        r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r4 > 0) goto L_0x01e8;
    L_0x01e3:
        r4 = 0;
        r6.gCc = r4;
        goto L_0x0153;
    L_0x01e8:
        r12 = java.lang.System.currentTimeMillis();
        r4 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r4 <= 0) goto L_0x0153;
    L_0x01f0:
        r12 = java.lang.System.currentTimeMillis();
        r14 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r10 = r10 + r14;
        r4 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r4 >= 0) goto L_0x0153;
    L_0x01fb:
        r6.gCc = r8;
        goto L_0x0153;
    L_0x01ff:
        r4 = 0;
        goto L_0x0162;
    L_0x0202:
        r4 = 0;
        goto L_0x0170;
    L_0x0205:
        r4 = 0;
        goto L_0x017f;
    L_0x0208:
        r4 = 0;
        goto L_0x0194;
    L_0x020a:
        r4 = 0;
        goto L_0x01b1;
    L_0x020c:
        r4 = 0;
        goto L_0x003e;
    L_0x020f:
        r8 = "MicroMsg.Notification.AppMsg.Handle";
        r9 = "notification.shake: curChatting needShake~: %B";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r12 = java.lang.Boolean.valueOf(r7);
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.x.i(r8, r9, r10);
        r8 = r4.mContext;
        com.tencent.mm.sdk.platformtools.bi.m(r8, r7);
        if (r6 == 0) goto L_0x0241;
    L_0x0229:
        r8 = com.tencent.mm.j.a.zz();
        r9 = "MicroMsg.Notification.AppMsg.Handle";
        r10 = "notification.playSound: curChattingTalker: %s";
        r11 = 1;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r11[r12] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r9, r10, r11);
        r4 = r4.fgL;
        r4.ey(r8);
    L_0x0241:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r8 = "[NO NOTIFICATION] is current talker end. talker[%s], current ChattingTalker[%s]. shake %B, sound: %B";
        r9 = 4;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r9[r10] = r30;
        r10 = 1;
        r9[r10] = r5;
        r5 = 2;
        r10 = java.lang.Boolean.valueOf(r7);
        r9[r5] = r10;
        r5 = 3;
        r10 = java.lang.Boolean.valueOf(r6);
        r9[r5] = r10;
        com.tencent.mm.sdk.platformtools.x.i(r4, r8, r9);
        r4 = 1;
        goto L_0x00d1;
    L_0x0264:
        r4 = 0;
        goto L_0x00d1;
    L_0x0267:
        r0 = r29;
        r4 = r0.gBl;
        r0 = r29;
        r5 = r0.gBh;
        r4 = r4.gBP;
        r4 = r4.gBH;
        if (r5 == 0) goto L_0x0303;
    L_0x0275:
        if (r7 != 0) goto L_0x0279;
    L_0x0277:
        if (r6 == 0) goto L_0x027f;
    L_0x0279:
        r5 = com.tencent.mm.j.a.zv();
        if (r5 != 0) goto L_0x02a7;
    L_0x027f:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION] is mainUI & no shake & no sound";
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);
        r4 = 1;
    L_0x0289:
        if (r4 == 0) goto L_0x0305;
    L_0x028b:
        r4 = "MicroMsg.MMNotification";
        r5 = "[no notificaion], isMainUI true, needSound[%B] needShake[%B]";
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r6 = java.lang.Boolean.valueOf(r6);
        r8[r9] = r6;
        r6 = 1;
        r7 = java.lang.Boolean.valueOf(r7);
        r8[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.w(r4, r5, r8);
        goto L_0x00f7;
    L_0x02a7:
        r5 = "MicroMsg.Notification.AppMsg.Handle";
        r8 = "notification.shake: mainUI needShake~: %B";
        r9 = 1;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r11 = java.lang.Boolean.valueOf(r7);
        r9[r10] = r11;
        com.tencent.mm.sdk.platformtools.x.i(r5, r8, r9);
        if (r7 == 0) goto L_0x02c7;
    L_0x02bc:
        r5 = com.tencent.mm.j.a.zA();
        if (r5 == 0) goto L_0x02c7;
    L_0x02c2:
        r5 = r4.mContext;
        com.tencent.mm.sdk.platformtools.bi.m(r5, r7);
    L_0x02c7:
        if (r6 == 0) goto L_0x02e7;
    L_0x02c9:
        r5 = com.tencent.mm.j.a.zy();
        if (r5 == 0) goto L_0x02e7;
    L_0x02cf:
        r5 = com.tencent.mm.j.a.zz();
        r8 = "MicroMsg.Notification.AppMsg.Handle";
        r9 = "notification.playSound: is mainUItalker: %s";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r10[r11] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r8, r9, r10);
        r4 = r4.fgL;
        r4.ey(r5);
    L_0x02e7:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION] is mainUI end. shake %B, sound: %B";
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = java.lang.Boolean.valueOf(r7);
        r8[r9] = r10;
        r9 = 1;
        r10 = java.lang.Boolean.valueOf(r6);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r8);
        r4 = 1;
        goto L_0x0289;
    L_0x0303:
        r4 = 0;
        goto L_0x0289;
    L_0x0305:
        r4 = 436207665; // 0x1a000031 float:2.6469934E-23 double:2.155152217E-315;
        r0 = r32;
        if (r0 != r4) goto L_0x03b4;
    L_0x030c:
        r4 = com.tencent.mm.sdk.platformtools.bi.Wn(r31);
        r4 = com.tencent.mm.x.g.a.fV(r4);
        if (r4 == 0) goto L_0x032e;
    L_0x0316:
        r5 = "MicroMsg.MMNotification";
        r8 = new java.lang.StringBuilder;
        r9 = "ljd:c2c hongbao message for c2cShowNotification is ";
        r8.<init>(r9);
        r9 = r4.hez;
        r8 = r8.append(r9);
        r8 = r8.toString();
        com.tencent.mm.sdk.platformtools.x.e(r5, r8);
    L_0x032e:
        r5 = new java.util.ArrayList;
        r5.<init>();
        r8 = new com.tencent.mars.smc.IDKey;
        r8.<init>();
        r9 = 313; // 0x139 float:4.39E-43 double:1.546E-321;
        r8.SetID(r9);
        r9 = 0;
        r8.SetKey(r9);
        r10 = 1;
        r8.SetValue(r10);
        r5.add(r8);
        if (r4 == 0) goto L_0x0382;
    L_0x034b:
        r8 = "1002";
        r9 = r4.her;
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x0382;
    L_0x0356:
        r8 = r4.hez;
        r9 = 1;
        if (r8 != r9) goto L_0x0382;
    L_0x035b:
        r4 = new com.tencent.mars.smc.IDKey;
        r4.<init>();
        r6 = 313; // 0x139 float:4.39E-43 double:1.546E-321;
        r4.SetID(r6);
        r6 = 1;
        r4.SetKey(r6);
        r6 = 1;
        r4.SetValue(r6);
        r5.add(r4);
        r4 = com.tencent.mm.plugin.report.service.g.pWK;
        r6 = 1;
        r4.a(r5, r6);
        r4 = "MicroMsg.MMNotification";
        r5 = "ljd:c2c hongbao message for notification is hide!";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        goto L_0x00f7;
    L_0x0382:
        if (r4 == 0) goto L_0x03b4;
    L_0x0384:
        r8 = "1002";
        r4 = r4.her;
        r4 = r8.equals(r4);
        if (r4 == 0) goto L_0x03b4;
    L_0x038f:
        r4 = new com.tencent.mars.smc.IDKey;
        r4.<init>();
        r8 = 313; // 0x139 float:4.39E-43 double:1.546E-321;
        r4.SetID(r8);
        r8 = 2;
        r4.SetKey(r8);
        r8 = 1;
        r4.SetValue(r8);
        r5.add(r4);
        r4 = com.tencent.mm.plugin.report.service.g.pWK;
        r8 = 1;
        r4.a(r5, r8);
        r4 = "MicroMsg.MMNotification";
        r5 = "ljd:c2c hongbao message for notification is show!";
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);
    L_0x03b4:
        r4 = 318767153; // 0x13000031 float:1.6155966E-27 double:1.574918993E-315;
        r0 = r32;
        if (r0 != r4) goto L_0x03d6;
    L_0x03bb:
        com.tencent.mm.y.as.Hm();
        r4 = com.tencent.mm.y.c.Db();
        r5 = com.tencent.mm.storage.w.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
        r8 = 1;
        r4 = r4.getBoolean(r5, r8);
        if (r4 != 0) goto L_0x03d6;
    L_0x03cb:
        r4 = "MicroMsg.MMNotification";
        r5 = "It is a service notify message and the show tips switch is off. So do not show notification.";
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);
        goto L_0x00f7;
    L_0x03d6:
        r0 = r29;
        r4 = r0.fFE;
        if (r4 == 0) goto L_0x040b;
    L_0x03dc:
        r4 = com.tencent.mm.plugin.biz.a.a.class;
        r4 = com.tencent.mm.kernel.g.h(r4);
        r4 = (com.tencent.mm.plugin.biz.a.a) r4;
        r0 = r29;
        r5 = r0.fFE;
        r5 = r5.field_talker;
        r4 = r4.fX(r5);
        if (r4 == 0) goto L_0x040b;
    L_0x03f0:
        com.tencent.mm.y.as.Hm();
        r4 = com.tencent.mm.y.c.Db();
        r5 = com.tencent.mm.storage.w.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
        r8 = 1;
        r4 = r4.getBoolean(r5, r8);
        if (r4 != 0) goto L_0x040b;
    L_0x0400:
        r4 = "MicroMsg.MMNotification";
        r5 = "It is a wxa custom session notify message and the show tips switch is off. So do not show notification.";
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);
        goto L_0x00f7;
    L_0x040b:
        r0 = r29;
        r8 = r0.gBl;
        r0 = r29;
        r4 = r0.fFE;
        if (r4 != 0) goto L_0x049c;
    L_0x0415:
        r4 = 0;
        r20 = r4;
    L_0x0419:
        r0 = r29;
        r14 = r0.gBf;
        r0 = r29;
        r10 = r0.gBg;
        r4 = r8.gBP;
        r5 = com.tencent.mm.j.a.zx();
        if (r5 != 0) goto L_0x042c;
    L_0x0429:
        com.tencent.mm.booter.notification.e.cancel();
    L_0x042c:
        r0 = r4.gBH;
        r19 = r0;
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "in sample Notify: needSound: %B, needShake: %B, msgContent: ==, msgType: %d, talker: %s, customNotify: %s, isRevokeMessage:%b";
        r8 = 6;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r11 = java.lang.Boolean.valueOf(r6);
        r8[r9] = r11;
        r9 = 1;
        r11 = java.lang.Boolean.valueOf(r7);
        r8[r9] = r11;
        r9 = 2;
        r11 = java.lang.Integer.valueOf(r32);
        r8[r9] = r11;
        r9 = 3;
        r8[r9] = r30;
        r9 = 4;
        r8[r9] = r14;
        r9 = 5;
        r11 = java.lang.Boolean.valueOf(r34);
        r8[r9] = r11;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r8);
        r4 = com.tencent.mm.j.a.zv();
        if (r4 != 0) goto L_0x04a6;
    L_0x0464:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION]new MsgNotification setting no notification";
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);
    L_0x046d:
        r5 = new com.tencent.mm.f.a.ke;
        r5.<init>();
        r4 = r5.fCq;
        r0 = r30;
        r4.talker = r0;
        r8 = r5.fCq;
        if (r6 != 0) goto L_0x0ab0;
    L_0x047c:
        r4 = 1;
    L_0x047d:
        r8.fCr = r4;
        r4 = r5.fCq;
        r4.fCs = r7;
        r4 = r5.fCq;
        r6 = com.tencent.mm.j.f.eV(r30);
        r4.fof = r6;
        r4 = com.tencent.mm.sdk.b.a.xmy;
        r4.m(r5);
        r4 = com.tencent.mm.y.s.hgU;
        r4 = com.tencent.mm.y.t.hz(r4);
        r0 = r29;
        r0.gBi = r4;
        goto L_0x00f7;
    L_0x049c:
        r0 = r29;
        r4 = r0.fFE;
        r4 = r4.field_msgSvrId;
        r20 = r4;
        goto L_0x0419;
    L_0x04a6:
        r4 = com.tencent.mm.j.a.zw();
        if (r4 != 0) goto L_0x04dd;
    L_0x04ac:
        r4 = 64;
        r0 = r32;
        if (r0 == r4) goto L_0x04c4;
    L_0x04b2:
        r4 = 50;
        r0 = r32;
        if (r0 == r4) goto L_0x04c4;
    L_0x04b8:
        r4 = 52;
        r0 = r32;
        if (r0 == r4) goto L_0x04c4;
    L_0x04be:
        r4 = 53;
        r0 = r32;
        if (r0 != r4) goto L_0x04dd;
    L_0x04c4:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = new java.lang.StringBuilder;
        r8 = "NotificationConfig.isNewVoipMsgNotification() is false,msgType is ";
        r5.<init>(r8);
        r0 = r32;
        r5 = r5.append(r0);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);
        goto L_0x046d;
    L_0x04dd:
        r4 = com.tencent.mm.j.f.eW(r30);
        if (r4 == 0) goto L_0x0530;
    L_0x04e3:
        r18 = "@bottle";
    L_0x04e6:
        r0 = r19;
        r5 = r0.fgL;
        r4 = com.tencent.mm.j.f.eW(r18);
        if (r4 == 0) goto L_0x0533;
    L_0x04f0:
        r4 = com.tencent.mm.j.f.Ac();
    L_0x04f4:
        r5.gCv = r4;
        r4 = com.tencent.mm.j.f.zZ();
        r5.gCt = r4;
        r4 = com.tencent.mm.j.f.Ab();
        r5.gCu = r4;
        r4 = com.tencent.mm.j.f.eV(r18);
        r5.gCs = r4;
        if (r34 == 0) goto L_0x0535;
    L_0x050a:
        r0 = r19;
        r4 = r0.fgL;
        r4 = r4.gCt;
        if (r4 > 0) goto L_0x0535;
    L_0x0512:
        r0 = r19;
        r4 = r0.fgL;
        r4 = r4.gCu;
        if (r4 > 0) goto L_0x0535;
    L_0x051a:
        r0 = r19;
        r4 = r0.fgL;
        r4 = r4.gCw;
        if (r4 != 0) goto L_0x0535;
    L_0x0522:
        r4 = 1;
    L_0x0523:
        if (r4 == 0) goto L_0x0537;
    L_0x0525:
        r4 = "MicroMsg.Notification.AppMsg.Handle";
        r5 = "[NO NOTIFICATION] no refresh notify by revoke";
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);
        goto L_0x046d;
    L_0x0530:
        r18 = r30;
        goto L_0x04e6;
    L_0x0533:
        r4 = 0;
        goto L_0x04f4;
    L_0x0535:
        r4 = 0;
        goto L_0x0523;
    L_0x0537:
        r8 = com.tencent.mm.booter.notification.c.xj();
        r0 = r19;
        r15 = r0.fgL;
        r4 = r15.gCv;
        r5 = -1;
        if (r4 != r5) goto L_0x0550;
    L_0x0544:
        r4 = com.tencent.mm.j.f.eW(r18);
        if (r4 == 0) goto L_0x0719;
    L_0x054a:
        r4 = com.tencent.mm.j.f.Ac();
    L_0x054e:
        r15.gCv = r4;
    L_0x0550:
        r4 = r15.gCt;
        r5 = -1;
        if (r4 != r5) goto L_0x055b;
    L_0x0555:
        r4 = com.tencent.mm.j.f.zZ();
        r15.gCt = r4;
    L_0x055b:
        r4 = r15.gCu;
        r5 = -1;
        if (r4 != r5) goto L_0x0566;
    L_0x0560:
        r4 = com.tencent.mm.j.f.Ab();
        r15.gCu = r4;
    L_0x0566:
        r4 = r15.gCs;
        r5 = -1;
        if (r4 != r5) goto L_0x0571;
    L_0x056b:
        r4 = com.tencent.mm.j.f.eV(r18);
        r15.gCs = r4;
    L_0x0571:
        r4 = com.tencent.mm.j.a.zx();
        r15.gCw = r4;
        r15.gCz = r6;
        r15.gCA = r7;
        r4 = r15.gCm;
        r5 = r15.mContext;
        r9 = r31;
        r4.a(r5, r6, r7, r8, r9);
        r4 = r15.gCn;
        r0 = r31;
        r1 = r32;
        r4.y(r0, r1);
        r9 = r15.gCo;
        r11 = r15.mContext;
        r5 = r15.gCt;
        r4 = r15.gCv;
        r12 = r15.gCw;
        if (r10 == 0) goto L_0x071c;
    L_0x0599:
        r9.Ks = r10;
    L_0x059b:
        r4 = r15.gCw;
        if (r4 == 0) goto L_0x09ff;
    L_0x059f:
        r12 = r15.gCp;
        r0 = r15.mContext;
        r16 = r0;
        r4 = r15.gCv;
        r0 = r15.gCs;
        r17 = r0;
        r10 = "";
        r5 = com.tencent.mm.j.f.eW(r18);
        if (r4 < 0) goto L_0x0799;
    L_0x05b4:
        if (r5 == 0) goto L_0x079f;
    L_0x05b6:
        r5 = 1;
        r4 = java.lang.Math.max(r5, r4);
        r5 = com.tencent.mm.R.l.epO;
        r0 = r16;
        r5 = r0.getString(r5);
        r9 = r16.getResources();
        r11 = com.tencent.mm.R.j.duP;
        r13 = 1;
        r13 = new java.lang.Object[r13];
        r22 = 0;
        r23 = java.lang.Integer.valueOf(r4);
        r13[r22] = r23;
        r4 = r9.getQuantityString(r11, r4, r13);
        r9 = r4;
    L_0x05d9:
        com.tencent.mm.y.as.Hm();
        r11 = com.tencent.mm.y.c.Fh();
        r0 = r18;
        r22 = r11.Fd(r0);
        r23 = com.tencent.mm.j.f.eX(r18);
        r13 = 0;
        if (r23 == 0) goto L_0x0ab9;
    L_0x05ed:
        r11 = com.tencent.mm.j.f.eZ(r18);
        r24 = com.tencent.mm.j.f.eY(r18);
        if (r11 <= 0) goto L_0x0ab9;
    L_0x05f7:
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r25 = com.tencent.mm.R.l.euq;
        r0 = r16;
        r1 = r25;
        r25 = r0.getString(r1);
        r0 = r25;
        r11 = r11.append(r0);
        if (r24 != 0) goto L_0x088e;
    L_0x060e:
        r24 = 1;
        r0 = r17;
        r1 = r24;
        if (r0 <= r1) goto L_0x0878;
    L_0x0616:
        r4 = r11.append(r4);
        r4 = r4.toString();
        r11 = r4;
    L_0x061f:
        if (r34 == 0) goto L_0x0893;
    L_0x0621:
        r9 = 0;
        r10 = r13;
    L_0x0623:
        if (r34 == 0) goto L_0x09f5;
    L_0x0625:
        if (r23 == 0) goto L_0x09eb;
    L_0x0627:
        r4 = r31;
    L_0x0629:
        r13 = 1;
        r0 = r17;
        if (r0 <= r13) goto L_0x09f8;
    L_0x062e:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = r16.getResources();
        r13 = com.tencent.mm.R.j.duQ;
        r14 = 1;
        r14 = new java.lang.Object[r14];
        r16 = 0;
        r22 = java.lang.Integer.valueOf(r17);
        r14[r16] = r22;
        r0 = r17;
        r11 = r11.getQuantityString(r13, r0, r14);
        r10 = r10.append(r11);
        r4 = r10.append(r4);
        r4 = r4.toString();
    L_0x0656:
        r12.mTitle = r5;
        r12.gCB = r4;
        r4 = r12;
    L_0x065b:
        r4.gCC = r9;
        r5 = r15.gCr;
        r4 = r15.gCw;
        if (r4 != 0) goto L_0x0681;
    L_0x0663:
        r9 = r5.gBY;
        if (r9 == 0) goto L_0x0681;
    L_0x0667:
        r9 = "MicroMsg.NotificationAvatar";
        r10 = "recycle bitmap:%s";
        r11 = 1;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r13 = r5.gBY;
        r13 = r13.toString();
        r11[r12] = r13;
        com.tencent.mm.sdk.platformtools.x.i(r9, r10, r11);
        r9 = r5.gBY;
        r9.recycle();
    L_0x0681:
        r9 = 0;
        r5.gBY = r9;
        r9 = com.tencent.mm.sdk.platformtools.ad.getContext();
        if (r4 == 0) goto L_0x069b;
    L_0x068a:
        r4 = com.tencent.mm.j.f.eW(r18);
        if (r4 != 0) goto L_0x069b;
    L_0x0690:
        if (r9 == 0) goto L_0x0698;
    L_0x0692:
        r4 = com.tencent.mm.platformtools.t.oN(r18);
        if (r4 == 0) goto L_0x0a95;
    L_0x0698:
        r4 = 0;
    L_0x0699:
        r5.gBY = r4;
    L_0x069b:
        r4 = com.tencent.mm.booter.notification.queue.b.xp();
        r0 = r18;
        r4 = r4.et(r0);
        r0 = r19;
        r5 = r0.fgL;
        r5 = r5.gCn;
        r11 = r5.gCa;
        r0 = r19;
        r5 = r0.fgL;
        r5 = r5.gCm;
        r12 = r5.gBZ;
        r0 = r19;
        r5 = r0.fgL;
        r9 = r5.gCo;
        r5 = r5.mContext;
        r10 = r9.Ks;
        if (r10 != 0) goto L_0x0aa8;
    L_0x06c1:
        r13 = 0;
    L_0x06c2:
        r0 = r19;
        r5 = r0.fgL;
        r5 = r5.gCp;
        r14 = r5.mTitle;
        r0 = r19;
        r5 = r0.fgL;
        r5 = r5.gCp;
        r15 = r5.gCB;
        r0 = r19;
        r5 = r0.fgL;
        r5 = r5.gCp;
        r0 = r5.gCC;
        r16 = r0;
        r0 = r19;
        r5 = r0.fgL;
        r5 = r5.gCr;
        r0 = r5.gBY;
        r17 = r0;
        r9 = r19;
        r10 = r8;
        r5 = r9.a(r10, r11, r12, r13, r14, r15, r16, r17, r18);
        r8 = new com.tencent.mm.booter.notification.NotificationItem;
        r0 = r18;
        r8.<init>(r4, r0, r5);
        r0 = r20;
        r8.gBK = r0;
        r4 = com.tencent.mm.j.f.eV(r18);
        r8.gBL = r4;
        r0 = r19;
        r4 = r0.fgL;
        r0 = r19;
        r0.a(r8, r4);
        r0 = r19;
        r4 = r0.fgL;
        r5 = -1;
        r4.gCv = r5;
        r5 = -1;
        r4.gCt = r5;
        r5 = -1;
        r4.gCu = r5;
        r5 = -1;
        r4.gCs = r5;
        goto L_0x046d;
    L_0x0719:
        r4 = 0;
        goto L_0x054e;
    L_0x071c:
        r10 = com.tencent.mm.j.f.eY(r18);
        if (r4 < 0) goto L_0x076c;
    L_0x0722:
        r13 = new android.content.Intent;
        r16 = com.tencent.mm.ui.LauncherUI.class;
        r0 = r16;
        r13.<init>(r11, r0);
        r11 = "nofification_type";
        r16 = "new_msg_nofification";
        r0 = r16;
        r13.putExtra(r11, r0);
        r11 = "Main_User";
        r0 = r18;
        r13.putExtra(r11, r0);
        r11 = "MainUI_User_Last_Msg_Type";
        r0 = r32;
        r13.putExtra(r11, r0);
        r11 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r13.addFlags(r11);
        r11 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r13.addFlags(r11);
        if (r12 == 0) goto L_0x0771;
    L_0x0752:
        r5 = "talkerCount";
        r11 = 1;
        r13.putExtra(r5, r11);
        if (r10 != 0) goto L_0x0768;
    L_0x075b:
        r5 = "Intro_Is_Muti_Talker";
        r10 = 0;
        r13.putExtra(r5, r10);
        r5 = "Intro_Bottle_unread_count";
        r13.putExtra(r5, r4);
    L_0x0768:
        r9.Ks = r13;
        goto L_0x059b;
    L_0x076c:
        r4 = com.tencent.mm.j.f.Ac();
        goto L_0x0722;
    L_0x0771:
        if (r5 < 0) goto L_0x078c;
    L_0x0773:
        r11 = 1;
        if (r5 > r11) goto L_0x0791;
    L_0x0776:
        if (r10 != 0) goto L_0x0791;
    L_0x0778:
        r10 = "Intro_Is_Muti_Talker";
        r11 = 0;
        r13.putExtra(r10, r11);
        r10 = "Intro_Bottle_unread_count";
        r13.putExtra(r10, r4);
    L_0x0785:
        r4 = "talkerCount";
        r13.putExtra(r4, r5);
        goto L_0x0768;
    L_0x078c:
        r5 = com.tencent.mm.j.f.zZ();
        goto L_0x0773;
    L_0x0791:
        r4 = "Intro_Is_Muti_Talker";
        r10 = 1;
        r13.putExtra(r4, r10);
        goto L_0x0785;
    L_0x0799:
        r4 = com.tencent.mm.j.f.Ac();
        goto L_0x05b4;
    L_0x079f:
        r4 = 0;
        r5 = android.text.TextUtils.isEmpty(r18);
        if (r5 == 0) goto L_0x07d7;
    L_0x07a6:
        r4 = 0;
    L_0x07a7:
        r5 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
        if (r5 == 0) goto L_0x07bb;
    L_0x07ad:
        r4 = com.tencent.mm.j.f.eX(r18);
        if (r4 == 0) goto L_0x086e;
    L_0x07b3:
        r4 = com.tencent.mm.R.l.dSY;
        r0 = r16;
        r4 = r0.getString(r4);
    L_0x07bb:
        r5 = com.tencent.mm.bw.b.chK();
        r4 = r5.WP(r4);
    L_0x07c3:
        r0 = r16;
        r1 = r31;
        r2 = r18;
        r3 = r32;
        r5 = com.tencent.mm.booter.notification.a.h.a(r0, r1, r2, r3);
        r9 = r5;
        r28 = r4;
        r4 = r5;
        r5 = r28;
        goto L_0x05d9;
    L_0x07d7:
        com.tencent.mm.y.as.Hm();
        r5 = com.tencent.mm.y.c.Ff();
        r0 = r18;
        r5 = r5.Xv(r0);
        if (r5 != 0) goto L_0x07e8;
    L_0x07e6:
        r4 = 0;
        goto L_0x07a7;
    L_0x07e8:
        r9 = 318767153; // 0x13000031 float:1.6155966E-27 double:1.574918993E-315;
        r0 = r32;
        if (r0 != r9) goto L_0x080b;
    L_0x07ef:
        r9 = android.text.TextUtils.isEmpty(r31);
        if (r9 != 0) goto L_0x080b;
    L_0x07f5:
        r4 = com.tencent.mm.plugin.biz.a.a.class;
        r4 = com.tencent.mm.kernel.g.h(r4);
        r4 = (com.tencent.mm.plugin.biz.a.a) r4;
        r0 = r31;
        r1 = r18;
        r4 = r4.bR(r0, r1);
        r9 = android.text.TextUtils.isEmpty(r4);
        if (r9 == 0) goto L_0x07a7;
    L_0x080b:
        r9 = com.tencent.mm.y.s.hn(r18);
        if (r9 == 0) goto L_0x0816;
    L_0x0811:
        r4 = r5.AW();
        goto L_0x07a7;
    L_0x0816:
        r9 = com.tencent.mm.storage.x.gB(r18);
        if (r9 == 0) goto L_0x0834;
    L_0x081c:
        r4 = com.tencent.mm.R.l.dMR;
        r9 = 1;
        r9 = new java.lang.Object[r9];
        r11 = 0;
        r5 = com.tencent.mm.booter.notification.a.h.b(r5);
        r9[r11] = r5;
        r0 = r16;
        r4 = r0.getString(r4, r9);
        r4 = r4.trim();
        goto L_0x07a7;
    L_0x0834:
        r9 = com.tencent.mm.j.f.eX(r18);
        if (r9 == 0) goto L_0x0858;
    L_0x083a:
        r9 = r5.field_nickname;
        r9 = com.tencent.mm.sdk.platformtools.bi.oN(r9);
        if (r9 == 0) goto L_0x0858;
    L_0x0842:
        com.tencent.mm.y.as.Hm();
        r5 = com.tencent.mm.y.c.Fo();
        r0 = r18;
        r5 = r5.gw(r0);
        r9 = com.tencent.mm.sdk.platformtools.bi.oN(r5);
        if (r9 != 0) goto L_0x07a7;
    L_0x0855:
        r4 = r5;
        goto L_0x07a7;
    L_0x0858:
        r9 = r5.AX();
        if (r9 == 0) goto L_0x07a7;
    L_0x085e:
        r9 = r5.AX();
        r9 = r9.length();
        if (r9 <= 0) goto L_0x07a7;
    L_0x0868:
        r4 = r5.AX();
        goto L_0x07a7;
    L_0x086e:
        r4 = com.tencent.mm.R.l.epO;
        r0 = r16;
        r4 = r0.getString(r4);
        goto L_0x07c3;
    L_0x0878:
        r4 = new java.lang.StringBuilder;
        r24 = " ";
        r0 = r24;
        r4.<init>(r0);
        r0 = r31;
        r4 = r4.append(r0);
        r4 = r4.toString();
        goto L_0x0616;
    L_0x088e:
        r4 = "";
        goto L_0x0616;
    L_0x0893:
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r14);
        if (r4 != 0) goto L_0x089d;
    L_0x0899:
        r10 = r13;
        r9 = r14;
        goto L_0x0623;
    L_0x089d:
        if (r22 == 0) goto L_0x0975;
    L_0x089f:
        r0 = r22;
        r0 = r0.field_bizChatId;
        r24 = r0;
        r26 = -1;
        r4 = (r24 > r26 ? 1 : (r24 == r26 ? 0 : -1));
        if (r4 == 0) goto L_0x0975;
    L_0x08ab:
        r4 = com.tencent.mm.af.f.eG(r18);
        if (r4 == 0) goto L_0x0975;
    L_0x08b1:
        r13 = 1;
        r4 = com.tencent.mm.af.y.Mn();
        r0 = r22;
        r0 = r0.field_bizChatId;
        r24 = r0;
        r0 = r24;
        r4 = r4.ag(r0);
        r14 = r4.Mz();
        if (r14 == 0) goto L_0x093b;
    L_0x08c8:
        r10 = r4.field_chatName;
        r10 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
        if (r10 == 0) goto L_0x091c;
    L_0x08d0:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r10 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r14 = com.tencent.mm.R.l.eFK;
        r10 = r10.getString(r14);
        r4 = r4.append(r10);
        r10 = ": ";
        r4 = r4.append(r10);
        r10 = com.tencent.mm.booter.notification.a.h.eB(r9);
        r4 = r4.append(r10);
        r4 = r4.toString();
    L_0x08f6:
        r10 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
        if (r10 == 0) goto L_0x0918;
    L_0x08fc:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r5);
        r10 = ": ";
        r4 = r4.append(r10);
        r9 = com.tencent.mm.booter.notification.a.h.eB(r9);
        r4 = r4.append(r9);
        r4 = r4.toString();
    L_0x0918:
        r10 = r13;
        r9 = r4;
        goto L_0x0623;
    L_0x091c:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r4 = r4.field_chatName;
        r4 = r10.append(r4);
        r10 = ": ";
        r4 = r4.append(r10);
        r10 = com.tencent.mm.booter.notification.a.h.eB(r9);
        r4 = r4.append(r10);
        r4 = r4.toString();
        goto L_0x08f6;
    L_0x093b:
        r4 = com.tencent.mm.af.y.Mp();
        r0 = r22;
        r14 = r0.field_bizChatUserId;
        r4 = r4.ca(r14);
        if (r4 == 0) goto L_0x0ab6;
    L_0x0949:
        r10 = r4.field_userName;
        r10 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
        if (r10 == 0) goto L_0x0956;
    L_0x0951:
        r4 = com.tencent.mm.booter.notification.a.h.eB(r9);
        goto L_0x08f6;
    L_0x0956:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r4 = r4.field_userName;
        r4 = r10.append(r4);
        r10 = ": ";
        r4 = r4.append(r10);
        r10 = com.tencent.mm.booter.notification.a.h.eB(r9);
        r4 = r4.append(r10);
        r4 = r4.toString();
        goto L_0x08f6;
    L_0x0975:
        if (r23 != 0) goto L_0x0996;
    L_0x0977:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r5);
        r10 = ": ";
        r4 = r4.append(r10);
        r9 = com.tencent.mm.booter.notification.a.h.eB(r9);
        r4 = r4.append(r9);
        r9 = r4.toString();
        r10 = r13;
        goto L_0x0623;
    L_0x0996:
        r4 = ":\n";
        r4 = r9.contains(r4);
        if (r4 == 0) goto L_0x09e4;
    L_0x099f:
        r10 = com.tencent.mm.y.bb.hT(r9);
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r4 = ":\n";
        r4 = r9.contains(r4);
        if (r4 == 0) goto L_0x09db;
    L_0x09b1:
        r4 = 0;
        r22 = ":\n";
        r0 = r22;
        r22 = r9.indexOf(r0);
        r0 = r22;
        r4 = r9.substring(r4, r0);
    L_0x09c1:
        r4 = r14.append(r4);
        r9 = ": ";
        r4 = r4.append(r9);
        r9 = com.tencent.mm.booter.notification.a.h.eB(r10);
        r4 = r4.append(r9);
        r9 = r4.toString();
        r10 = r13;
        goto L_0x0623;
    L_0x09db:
        r0 = r16;
        r1 = r18;
        r4 = com.tencent.mm.booter.notification.a.h.g(r0, r1, r9);
        goto L_0x09c1;
    L_0x09e4:
        r9 = com.tencent.mm.booter.notification.a.h.eB(r9);
        r10 = r13;
        goto L_0x0623;
    L_0x09eb:
        r4 = com.tencent.mm.R.l.ezr;
        r0 = r16;
        r4 = r0.getString(r4);
        goto L_0x0629;
    L_0x09f5:
        r4 = r9;
        goto L_0x0629;
    L_0x09f8:
        if (r23 != 0) goto L_0x0656;
    L_0x09fa:
        if (r10 == 0) goto L_0x0ab3;
    L_0x09fc:
        r4 = r9;
        goto L_0x0656;
    L_0x09ff:
        r5 = r15.gCp;
        r11 = r15.mContext;
        r10 = r15.gCt;
        r4 = r15.gCu;
        r9 = r15.gCv;
        if (r10 < 0) goto L_0x0a61;
    L_0x0a0b:
        if (r4 < 0) goto L_0x0a66;
    L_0x0a0d:
        r12 = 1;
        r10 = java.lang.Math.max(r12, r10);
        r12 = 1;
        r12 = java.lang.Math.max(r12, r4);
        if (r9 < 0) goto L_0x0a6b;
    L_0x0a19:
        r4 = r9;
    L_0x0a1a:
        r9 = 1;
        if (r10 != r9) goto L_0x0a70;
    L_0x0a1d:
        if (r4 <= 0) goto L_0x0a70;
    L_0x0a1f:
        r9 = r11.getResources();
        r10 = com.tencent.mm.R.j.duP;
        r12 = 1;
        r12 = new java.lang.Object[r12];
        r13 = 0;
        r14 = java.lang.Integer.valueOf(r4);
        r12[r13] = r14;
        r4 = r9.getQuantityString(r10, r4, r12);
    L_0x0a33:
        r9 = 0;
        r9 = com.tencent.mm.j.f.eZ(r9);
        if (r9 <= 0) goto L_0x0a51;
    L_0x0a3a:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = com.tencent.mm.R.l.euq;
        r10 = r11.getString(r10);
        r9 = r9.append(r10);
        r4 = r9.append(r4);
        r4 = r4.toString();
    L_0x0a51:
        r5.gCB = r4;
        r4 = com.tencent.mm.R.l.epO;
        r4 = r11.getString(r4);
        r5.mTitle = r4;
        if (r34 == 0) goto L_0x0a8c;
    L_0x0a5d:
        r9 = 0;
        r4 = r5;
        goto L_0x065b;
    L_0x0a61:
        r10 = com.tencent.mm.j.f.zZ();
        goto L_0x0a0b;
    L_0x0a66:
        r4 = com.tencent.mm.j.f.Ab();
        goto L_0x0a0d;
    L_0x0a6b:
        r4 = com.tencent.mm.j.f.Ac();
        goto L_0x0a1a;
    L_0x0a70:
        r4 = r11.getResources();
        r9 = com.tencent.mm.R.j.duR;
        r13 = 2;
        r13 = new java.lang.Object[r13];
        r14 = 0;
        r16 = java.lang.Integer.valueOf(r10);
        r13[r14] = r16;
        r14 = 1;
        r12 = java.lang.Integer.valueOf(r12);
        r13[r14] = r12;
        r4 = r4.getQuantityString(r9, r10, r13);
        goto L_0x0a33;
    L_0x0a8c:
        r4 = com.tencent.mm.R.l.ezs;
        r9 = r11.getString(r4);
        r4 = r5;
        goto L_0x065b;
    L_0x0a95:
        r4 = 0;
        r10 = -1;
        r0 = r18;
        r4 = com.tencent.mm.ac.b.a(r0, r4, r10);
        if (r4 != 0) goto L_0x0aa2;
    L_0x0a9f:
        r4 = 0;
        goto L_0x0699;
    L_0x0aa2:
        r4 = com.tencent.mm.booter.notification.a.a.b(r9, r4);
        goto L_0x0699;
    L_0x0aa8:
        r9 = r9.Ks;
        r13 = com.tencent.mm.booter.notification.a.d.a(r5, r4, r9);
        goto L_0x06c2;
    L_0x0ab0:
        r4 = 0;
        goto L_0x047d;
    L_0x0ab3:
        r4 = r11;
        goto L_0x0656;
    L_0x0ab6:
        r4 = r10;
        goto L_0x08f6;
    L_0x0ab9:
        r11 = r4;
        goto L_0x061f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.notification.b.a(com.tencent.mm.booter.notification.b, java.lang.String, java.lang.String, int, int, boolean):void");
    }

    public b(Context context) {
        this.context = context;
        this.talker = "";
        this.gBf = "";
        this.gBd = "";
        this.gBk = 0;
        this.gBj = false;
        this.gBg = null;
        this.gBm = new e();
        q.a(this);
        com.tencent.mm.modelvoice.e.a((am) this);
        com.tencent.mm.plugin.base.stub.b.a(this);
        com.tencent.mm.sdk.b.a.xmy.b(this.gBp);
        com.tencent.mm.sdk.b.a.xmy.b(this.gBo);
    }

    public final void eq(String str) {
        this.gBd = str;
    }

    public final String xe() {
        return this.gBd;
    }

    public final void aW(boolean z) {
        x.i("MicroMsg.MMNotification", "set isMainUI: %s, stack[%s]", Boolean.valueOf(z), bi.chl());
        this.gBh = z;
    }

    public final void cancelNotification(String str) {
        Object obj = 1;
        x.v("MicroMsg.MMNotification", "cancel notification talker:" + str + " last talker:" + this.gBe + "  curChattingTalker:" + this.gBd + " talker count:" + this.gBi);
        if (this.gBj) {
            if (!(this.gBe != null && this.gBe.equals(this.gBd) && this.gBi == 1)) {
                obj = null;
            }
            if (obj != null) {
                cancel();
                return;
            }
            as.Hm();
            ak XF = com.tencent.mm.y.c.Fk().XF(str);
            if (XF != null && XF.field_unReadCount != 0) {
                cancel();
            } else if (t.hy(s.hgU) == 0) {
                cancel();
            }
        }
    }

    public final void xf() {
        try {
            String string = ad.getContext().getSharedPreferences("notify_newfriend_prep", 0).getString("notify_newfriend_prep", null);
            if (string != null) {
                for (String Wo : string.split(",")) {
                    int Wo2 = bi.Wo(Wo);
                    if (Wo2 > 0) {
                        as.getNotification().cancel(Wo2);
                    }
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMNotification", e, "try cancel notification fail: %s", e.getMessage());
        }
    }

    public final void uq() {
        x.d("MicroMsg.MMNotification", "force cancelNotification");
        cancel();
    }

    private void cancel() {
        this.gBj = false;
        e.cancel();
    }

    public final void a(au auVar) {
        if (auVar != null) {
            if (auVar.field_isSend == 1) {
                x.w("MicroMsg.MMNotification", "notifyFirst is sender , msgid:%d ", Long.valueOf(auVar.field_msgSvrId));
                return;
            }
            com.tencent.mm.y.bb.b hW = bb.hW(auVar.gkD);
            if (hW == null || hW.scene != 1) {
                int d = f.d(auVar);
                this.fFE = auVar;
                this.talker = auVar.field_talker;
                String str = auVar.field_content;
                int type = auVar.getType();
                this.gBf = "";
                this.gBg = null;
                x.i("MicroMsg.MMNotification", "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s", this.talker, Long.valueOf(auVar.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(d), bi.Wz(str));
                if (this.gBl.a(this.talker, this.fFE, d, false)) {
                    this.gBn.sendMessageDelayed(a(this.talker, str, type, d, 0), 200);
                } else {
                    x.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                }
            }
        }
    }

    static Message a(String str, String str2, int i, int i2, int i3) {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("notification.show.talker", str);
        bundle.putString("notification.show.message.content", str2);
        bundle.putInt("notification.show.message.type", i);
        bundle.putInt("notification.show.tipsflag", i2);
        obtain.setData(bundle);
        obtain.what = i3;
        return obtain;
    }

    public final Looper getLooper() {
        return Looper.getMainLooper();
    }

    public final void y(List<au> list) {
        String str;
        int i;
        if (list == null || list.size() <= 0) {
            String str2 = "MicroMsg.MMNotification";
            str = "notifyOther newMsgList:%d :%s";
            Object[] objArr = new Object[2];
            if (list == null) {
                i = -1;
            } else {
                i = list.size();
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = bi.chl();
            x.w(str2, str, objArr);
            return;
        }
        cg cgVar;
        int size = list.size() - 1;
        i = 0;
        while (size >= 0) {
            cg cgVar2 = (au) list.get(size);
            int d = f.d(cgVar2);
            if (this.gBl.a(cgVar2.field_talker, cgVar2, d, false)) {
                int i2 = d;
                cgVar = cgVar2;
                i = i2;
                break;
            }
            size--;
            i = d;
        }
        cgVar = null;
        if (cgVar == null) {
            x.w("MicroMsg.MMNotification", "notifyOther msg == null");
            return;
        }
        this.gBf = "";
        this.talker = cgVar.field_talker;
        str = cgVar.field_content;
        size = cgVar.getType();
        this.fFE = cgVar;
        x.i("MicroMsg.MMNotification", "notifyOther talker:%s msgid:%d type:%d tipsFlag:%d content:%s", this.talker, Long.valueOf(cgVar.field_msgSvrId), Integer.valueOf(size), Integer.valueOf(i), bi.Wz(str));
        this.gBn.sendMessageDelayed(a(this.talker, str, size, i, 0), 200);
    }

    public final void er(String str) {
        CharSequence str2;
        Intent intent = new Intent(this.context, LauncherUI.class);
        intent.putExtra("Intro_Notify", true);
        intent.putExtra("Intro_Notify_User", this.talker);
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        intent.addFlags(67108864);
        if (!bi.oN(str2) && str2.startsWith("autoauth_errmsg_")) {
            str2 = str2.substring(16);
        }
        if (!bi.oN(str2) && str2.startsWith("<")) {
            Map y = bj.y(str2, "e");
            if (!(y == null || bi.oN((String) y.get(".e.Content")))) {
                str2 = (String) y.get(".e.Content");
            }
        }
        Notification notification = new Builder(this.context).setContentTitle(str2).setContentText(null).setContentIntent(PendingIntent.getActivity(this.context, 0, intent, SQLiteDatabase.CREATE_IF_NECESSARY)).getNotification();
        notification.icon = a.bYI();
        notification.flags = 16;
        a(notification, true);
    }

    public final void fl(int i) {
        Intent intent = new Intent(this.context, LauncherUI.class);
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        intent.addFlags(67108864);
        intent.putExtra("nofification_type", "update_nofification");
        intent.putExtra("show_update_dialog", true);
        intent.putExtra("update_type", i);
        Notification notification = new Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(R.l.dHe)).setContentText(this.context.getString(R.l.dGC)).setContentIntent(PendingIntent.getActivity(this.context, 0, intent, 0)).getNotification();
        notification.flags |= 16;
        a(34, notification, false);
    }

    @TargetApi(16)
    public final boolean xg() {
        boolean z = true;
        x.d("MicroMsg.MMNotification", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", ((RunningTaskInfo) ((ActivityManager) this.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName());
        if (MobileVerifyUI.class.getName().equals(((RunningTaskInfo) ((ActivityManager) this.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName())) {
            z = false;
        }
        if (z) {
            Notification build;
            Intent intent = new Intent(this.context, MobileVerifyUI.class);
            intent.addFlags(2);
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.addFlags(67108864);
            intent.putExtra("nofification_type", "no_reg_notification");
            PendingIntent activity = PendingIntent.getActivity(this.context, 36, intent, 1073741824);
            if (VERSION.SDK_INT >= 16) {
                Builder builder = new Builder(this.context);
                builder.setContentTitle(this.context.getString(R.l.dGB));
                builder.setSmallIcon(a.bYI());
                builder.setWhen(System.currentTimeMillis());
                builder.setContentIntent(activity);
                build = new BigTextStyle(builder).bigText(this.context.getString(R.l.evn)).build();
                build.defaults |= 1;
                build.flags |= 16;
            } else {
                build = new Builder(this.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.context.getString(R.l.dGB)).setContentText(this.context.getString(R.l.evn)).setContentIntent(activity).getNotification();
                build.icon = a.bYI();
                build.defaults |= 1;
                build.flags |= 16;
            }
            a(36, build, false);
        }
        return z;
    }

    public final void xh() {
        cancel(36);
    }

    public final void a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
        d.a("webview", new com.tencent.mm.platformtools.l.AnonymousClass1(str3, str4, bundle, str, str2, i), new com.tencent.mm.platformtools.l.AnonymousClass2());
    }

    public final Notification a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i2, String str4, PendingIntent pendingIntent2, int i3, String str5, PendingIntent pendingIntent3, String str6) {
        return a.gBQ.gBP.gBH.a(notification, i, 1, pendingIntent, str, str2, str3, bitmap, i2, str4, pendingIntent2, i3, str5, pendingIntent3, str6);
    }

    public final void n(int i, String str) {
        a.gBQ.n(i, str);
    }

    public final void xi() {
        a.gBQ;
        c.xi();
    }

    public final void fm(int i) {
        d.fp(i);
    }

    public final void v(String str, int i) {
        d.w(str, i);
    }

    public final void aX(boolean z) {
        d.aY(z);
    }

    public final void fn(int i) {
        a.gBQ;
        if (i != 0) {
            List<Integer> fq = com.tencent.mm.booter.notification.queue.b.xp().gBW.fq(i);
            if (!fq.isEmpty()) {
                android.support.v4.app.ag j = android.support.v4.app.ag.j(ad.getContext());
                for (Integer intValue : fq) {
                    com.tencent.mm.booter.notification.queue.b.xp().a(j, intValue.intValue());
                }
            }
        }
    }

    public final void notify(int i, Notification notification) {
        a(i, notification, true);
    }

    public final void a(int i, Notification notification, boolean z) {
        a.gBQ.a(new NotificationItem(i, notification, z));
    }

    public final int a(Notification notification, boolean z) {
        return a.gBQ.a(new NotificationItem(notification, z));
    }

    public final int b(Notification notification) {
        return a(notification, true);
    }

    public final void cancel(int i) {
        a.gBQ;
        com.tencent.mm.booter.notification.queue.b.xp().cancel(i);
    }

    public final Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return a(null, -1, 0, pendingIntent, str, str2, str3, bitmap, str4);
    }

    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        return a.gBQ.gBP.gBH.a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, str4);
    }
}

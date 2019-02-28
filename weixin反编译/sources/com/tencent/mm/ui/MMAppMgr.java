package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.LocationManager;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.os.Process;
import android.provider.Settings.Secure;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.R;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.bd.e;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.z;
import com.tencent.mm.f.a.cp;
import com.tencent.mm.f.a.fs;
import com.tencent.mm.f.a.ja;
import com.tencent.mm.f.a.l;
import com.tencent.mm.f.a.ne;
import com.tencent.mm.f.a.nz;
import com.tencent.mm.f.a.qs;
import com.tencent.mm.f.a.rf;
import com.tencent.mm.f.a.rs;
import com.tencent.mm.f.a.tx;
import com.tencent.mm.f.a.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.b.d;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bp;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Map;

public final class MMAppMgr {
    static StringBuffer xSp;
    private static long xSq;
    long hPZ;
    String xSr;
    public Receiver xSs;
    boolean xSt = false;
    boolean xSu = false;
    final al xSv = new al(new a() {
        public final boolean uG() {
            String by = bi.by(ad.getContext());
            if (by == null || !by.toLowerCase().startsWith(ad.getPackageName())) {
                x.i("MicroMsg.MMAppMgr", "onTimerExpired, kill tools process");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                ad.getContext().sendBroadcast(intent);
            } else {
                x.i("MicroMsg.MMAppMgr", "onTimerExpired, top activity belongs to mm, skip kill tools");
            }
            return false;
        }
    }, true);
    private final al xSw = new al(Looper.getMainLooper(), new a() {
        public final boolean uG() {
            if (MMAppMgr.this.xSu == MMAppMgr.this.xSt) {
                x.d("MicroMsg.MMAppMgr", "status not changed, cur=" + MMAppMgr.this.xSu);
                return true;
            } else if (as.Hf()) {
                return false;
            } else {
                MMAppMgr.this.xSu = MMAppMgr.this.xSt;
                BaseEvent.onForeground(MMAppMgr.this.xSu);
                com.tencent.mm.ai.a.bM(MMAppMgr.this.xSu);
                b lVar;
                if (MMAppMgr.this.xSu) {
                    x.w("MicroMsg.MMAppMgr", "[ACTIVATED MODE]");
                    WorkerProfile.uw();
                    as.CN().bF(true);
                    if (as.Hp() && g.Do().gRj && !as.Cz()) {
                        z zVar = z.gAC;
                        if (!zVar.hasInit) {
                            Map civ;
                            zVar.hasInit = true;
                            c fp = com.tencent.mm.y.c.c.IL().fp("100066");
                            if (fp.isValid()) {
                                civ = fp.civ();
                                zVar.gAO = t.getInt((String) civ.get("maxCacheCount"), 20);
                                zVar.gAP = t.getInt((String) civ.get("maxCacheHours"), 24);
                            }
                            fp = com.tencent.mm.y.c.c.IL().fp("100058");
                            if (fp.isValid()) {
                                civ = fp.civ();
                                zVar.gAQ = t.getInt((String) civ.get("cacheLogCount"), 30);
                                zVar.gAR = t.getInt((String) civ.get("maxCacheTime"), 10800);
                            }
                            x.i("MicroMsg.StayTimeReport", "initAbtestChattingArg appMaxCnt:%d, appMaxHour:%d, chattingMaxCnt:%d, chattingMaxSeconds:%d", Integer.valueOf(zVar.gAO), Integer.valueOf(zVar.gAP), Integer.valueOf(zVar.gAQ), Integer.valueOf(zVar.gAR));
                        }
                        f.bU(true);
                        q.Qj().ig(3);
                        as.CN().a(new j(), 0);
                        com.tencent.mm.blink.b.wv().f(new Runnable() {
                            public final void run() {
                                m.UM().run();
                                o.Ug().run();
                                com.tencent.mm.ap.o.PA().run();
                                an.bZH().run();
                                if (ak.a.hhy != null) {
                                    ak.a.hhy.GY();
                                }
                                com.tencent.mm.sdk.b.a.xmy.m(new qs());
                                as.Hm();
                                com.tencent.mm.y.c.Fe().b(null);
                            }
                        });
                        bp.HY().c(19, Integer.valueOf(1));
                        e SS = e.SS();
                        x.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
                        SS.hzw.lK(true);
                        com.tencent.mm.ap.o.PE().bF(true);
                        if (com.tencent.mm.pluginsdk.q.z.vjl != null) {
                            com.tencent.mm.pluginsdk.q.z.vjl.bEF();
                        }
                        lVar = new l();
                        lVar.foa.fob = true;
                        com.tencent.mm.sdk.b.a.xmy.m(lVar);
                        com.tencent.mm.modelstat.o.iF(4);
                        com.tencent.mm.modelstat.o.iF(3);
                        com.tencent.mm.modelstat.o.bX(true);
                        lVar = new rf();
                        lVar.fJN.fJO = true;
                        lVar.fJN.scene = 1;
                        com.tencent.mm.sdk.b.a.xmy.m(lVar);
                        lVar = new tx();
                        lVar.fNy.fql = 5;
                        com.tencent.mm.sdk.b.a.xmy.m(lVar);
                    }
                    as.CN().bE(false);
                    ad.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", false).commit();
                    if (MMAppMgr.this.xSv.cgx()) {
                        return true;
                    }
                    MMAppMgr.this.xSv.TN();
                    return true;
                }
                x.w("MicroMsg.MMAppMgr", "[DEACTIVATED MODE]");
                WorkerProfile.uw();
                MMAppMgr.this.hPZ = bi.Wz();
                MMAppMgr.this.xSr = "desktop";
                lVar = new l();
                lVar.foa.fob = false;
                com.tencent.mm.sdk.b.a.xmy.m(lVar);
                as.CN().bF(false);
                if (as.Hp()) {
                    g.Dr();
                    if (g.Do().gRj) {
                        boolean z;
                        com.tencent.mm.bm.a.TN(com.tencent.mm.bm.a.cdK());
                        Looper.myQueue().addIdleHandler(new IdleHandler() {
                            public final boolean queueIdle() {
                                if (g.CN().foreground) {
                                    x.w("MicroMsg.SpeexUploadCore", "skiped resume speex uploader, not foreground");
                                } else {
                                    x.d("MicroMsg.SpeexUploadCore", "now resume speex uploader");
                                    e.this.hzw.lK(false);
                                }
                                return false;
                            }
                        });
                        lVar = new ne();
                        lVar.fFX.state = 0;
                        com.tencent.mm.sdk.b.a.xmy.m(lVar);
                        com.tencent.mm.sdk.b.a.xmy.m(new rs());
                        lVar = new com.tencent.mm.f.a.e();
                        lVar.fnJ.fnK = false;
                        com.tencent.mm.sdk.b.a.xmy.m(lVar);
                        lVar = new nz();
                        lVar.fGL.ahf = false;
                        com.tencent.mm.sdk.b.a.xmy.m(lVar);
                        com.tencent.mm.ap.o.PE().bF(false);
                        x.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod]");
                        as.Hm();
                        Object obj = com.tencent.mm.y.c.Db().get(327808, null);
                        if (obj == null) {
                            z = true;
                        } else if (bi.oN(obj.toString())) {
                            z = true;
                        } else {
                            z = System.currentTimeMillis() - bi.Wp(obj.toString()) >= 604800000;
                        }
                        x.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod] needToStat:%s", String.valueOf(z));
                        if (z) {
                            try {
                                com.tencent.mm.plugin.report.service.g.pWK.k(11375, bi.oM(Secure.getString(ad.getContext().getContentResolver(), "default_input_method")));
                                as.Hm();
                                com.tencent.mm.y.c.Db().set(327808, Long.valueOf(System.currentTimeMillis()));
                            } catch (Exception e) {
                                x.e("MicroMsg.MMAppMgr", "[oneliang][inputMethodStat]exception:" + e.getMessage());
                            }
                        }
                        lVar = new cp();
                        lVar.frI.state = 0;
                        com.tencent.mm.sdk.b.a.xmy.m(lVar);
                        lVar = new tx();
                        lVar.fNy.fql = 3;
                        com.tencent.mm.sdk.b.a.xmy.m(lVar);
                        f.bU(false);
                        com.tencent.mm.modelstat.o.bX(false);
                    }
                }
                if (!MMAppMgr.this.xSv.cgx()) {
                    MMAppMgr.this.xSv.TN();
                }
                x.i("MicroMsg.MMAppMgr", "before kill tools, tools is running : %b", Boolean.valueOf(bi.bj(ad.getContext(), ad.getPackageName() + ":tools")));
                if (!bi.bj(ad.getContext(), ad.getPackageName() + ":tools")) {
                    return true;
                }
                MMAppMgr.this.xSv.K(60000, 60000);
                return true;
            }
        }
    }, false);

    /* renamed from: com.tencent.mm.ui.MMAppMgr$11 */
    static class AnonymousClass11 implements OnDismissListener {
        final /* synthetic */ OnClickListener tCm;

        AnonymousClass11(OnClickListener onClickListener) {
            this.tCm = onClickListener;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            af.VJ("show_wap_adviser");
            if (this.tCm != null) {
                this.tCm.onClick(dialogInterface, 0);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.MMAppMgr$13 */
    static class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ Context val$context;

        AnonymousClass13(Context context) {
            this.val$context = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.val$context.startActivity(new Intent("android.settings.APN_SETTINGS"));
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.MMAppMgr$9 */
    static class AnonymousClass9 implements OnClickListener {
        final /* synthetic */ int hJy;

        AnonymousClass9(int i) {
            this.hJy = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            as.Hm();
            com.tencent.mm.y.c.Db().set(65, Integer.valueOf(this.hJy + 1));
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class Receiver extends BroadcastReceiver {
        private MMAppMgr appMgr;

        public Receiver(MMAppMgr mMAppMgr) {
            this.appMgr = mMAppMgr;
        }

        private static boolean ak(Intent intent) {
            if (intent.getBooleanExtra("process_is_mm", false) && intent.getIntExtra("process_id", 0) != Process.myPid()) {
                return false;
            }
            return true;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && !as.Hf() && !as.Hh()) {
                String action = intent.getAction();
                if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(action)) {
                    if (ak(intent)) {
                        MMAppMgr.a(this.appMgr, intent, true);
                        this.appMgr.e(intent, true);
                        return;
                    }
                    x.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()));
                } else if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(action)) {
                    if (ak(intent)) {
                        com.tencent.mm.booter.o.xd();
                        MMAppMgr.a(this.appMgr, intent, false);
                        this.appMgr.e(intent, false);
                        if (MMAppMgr.xSp != null && MMAppMgr.xSp.length() > 800) {
                            new ag(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    MMAppMgr.cnQ();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    x.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()));
                } else if ("com.tencent.mm.ui.ACTION_ABTEST".equals(action)) {
                    action = intent.getStringExtra("content");
                    if (bi.oN(action)) {
                        x.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
                    } else {
                        if (MMAppMgr.xSp == null) {
                            MMAppMgr.xSp = new StringBuffer(800);
                        }
                        MMAppMgr.xSp.append(action);
                        x.i("MicroMsg.MMAppMgr", "cpan content: %s", action);
                    }
                    if (MMAppMgr.xSp != null && MMAppMgr.xSp.length() > 800) {
                        new ag(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                MMAppMgr.cnQ();
                            }
                        });
                    }
                } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE")) {
                    int intExtra;
                    if (intent.getBooleanExtra("intent_extra_is_silence_stat", false)) {
                        intExtra = intent.getIntExtra("intent_extra_opcode", 0);
                        x.d("MicroMsg.MMAppMgr", "silence_update_stat = " + intExtra);
                        if (as.Hp()) {
                            if (intExtra == 2) {
                                int intExtra2 = intent.getIntExtra("intent_extra_install_dialog_times", 0);
                                com.tencent.mm.plugin.report.service.g.pWK.h(11147, Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                            } else {
                                com.tencent.mm.plugin.report.service.g.pWK.h(11147, Integer.valueOf(intExtra));
                            }
                            if (intExtra == 4 && p.bZM() == 4) {
                                com.tencent.mm.pluginsdk.model.app.a bZm = com.tencent.mm.pluginsdk.model.app.a.bZm();
                                if (bZm != null) {
                                    bZm.bZo();
                                }
                            }
                        }
                    } else {
                        x.d("MicroMsg.MMAppMgr", "incremental_update = " + intent.getIntExtra("intent_extra_opcode", 0));
                        if (as.Hp()) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(10328, Integer.valueOf(intExtra));
                        }
                    }
                    long longExtra = intent.getLongExtra("intent_extra_flow_stat_upstream", 0);
                    long longExtra2 = intent.getLongExtra("intent_extra_flow_stat_downstream", 0);
                    boolean booleanExtra = intent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
                    if (!as.Hp()) {
                        return;
                    }
                    if (longExtra != 0 || longExtra2 != 0) {
                        x.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", Long.valueOf(longExtra), Long.valueOf(longExtra2), Boolean.valueOf(booleanExtra));
                        if (booleanExtra) {
                            n.B((int) longExtra2, (int) longExtra, 0);
                        } else {
                            n.C((int) longExtra2, (int) longExtra, 0);
                        }
                    }
                } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP")) {
                    MMAppMgr.b(context, true);
                } else if (intent.getAction().equals("MINIQB_OPEN_RET")) {
                    com.tencent.mm.pluginsdk.ui.tools.a.ae(intent);
                } else {
                    x.e("MicroMsg.MMAppMgr", "unknown broadcast action");
                }
            }
        }
    }

    static /* synthetic */ void a(MMAppMgr mMAppMgr, Intent intent, boolean z) {
        String stringExtra = intent.getStringExtra("classname");
        if (bi.oN(stringExtra)) {
            x.i("MicroMsg.MMAppMgr", "dealWithClickStream className is null, broadcast should set this intent flag");
            return;
        }
        stringExtra = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        com.tencent.mm.sdk.a.b.Vm(stringExtra);
        if (xSp == null) {
            xSp = new StringBuffer(800);
            xSq = bi.Wx();
            xSp.append("start:");
            xSp.append(bi.Wx());
            xSp.append("|");
        }
        if (z) {
            if ("desktop".equals(mMAppMgr.xSr)) {
                xSp.append("desktop:");
                xSp.append(bi.bB(mMAppMgr.hPZ) + 800);
                xSp.append("|");
            }
            mMAppMgr.hPZ = bi.Wz();
            mMAppMgr.xSr = stringExtra;
        } else {
            xSp.append(mMAppMgr.xSr + ":");
            xSp.append(bi.bB(mMAppMgr.hPZ));
            xSp.append("|");
        }
        b fVar = new com.tencent.mm.f.a.f();
        fVar.fnL.ahf = z;
        fVar.fnL.className = stringExtra;
        com.tencent.mm.sdk.b.a.xmy.m(fVar);
        x.i("MicroMsg.MMAppMgr", "dkact classname %s, isAcitvity %b", stringExtra, Boolean.valueOf(z));
    }

    public final void e(Intent intent, boolean z) {
        b neVar;
        String str;
        if (z) {
            com.tencent.mm.ac.m.JQ();
            neVar = new ne();
            neVar.fFX.state = 1;
            com.tencent.mm.sdk.b.a.xmy.m(neVar);
            neVar = new com.tencent.mm.f.a.e();
            neVar.fnJ.fnK = true;
            com.tencent.mm.sdk.b.a.xmy.m(neVar);
            neVar = new nz();
            neVar.fGL.ahf = true;
            com.tencent.mm.sdk.b.a.xmy.m(neVar);
            neVar = new cp();
            neVar.frI.state = 1;
            com.tencent.mm.sdk.b.a.xmy.m(neVar);
        }
        neVar = new fs();
        neVar.fvW.fob = z;
        com.tencent.mm.sdk.b.a.xmy.m(neVar);
        this.xSt = z;
        String stringExtra = intent.getStringExtra("classname");
        if (bi.oN(stringExtra)) {
            str = "";
        } else {
            str = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        }
        z zVar;
        if (z) {
            zVar = z.gAC;
            if (zVar.gAN == -1) {
                if (zVar.gAD.DE(3) == 0) {
                    zVar.gAD.setLong(1, t.Wx());
                }
                zVar.gAN = t.Wx();
                String str2 = "MicroMsg.StayTimeReport";
                String str3 = "onAppResume chatUser:%s, class:%s";
                Object[] objArr = new Object[2];
                objArr[0] = zVar.gAG == null ? "null" : zVar.gAG.gAT;
                objArr[1] = str;
                x.i(str2, str3, objArr);
                if (zVar.gAG != null) {
                    zVar.gAK = t.Wz();
                    if (str != null && str.contains("WebViewUI")) {
                        zVar.gAL = t.Wz();
                    }
                }
            }
        } else {
            zVar = z.gAC;
            if (zVar.gAN != -1) {
                stringExtra = ((String) zVar.gAD.get(2, "")) + zVar.gAN + "|" + t.Wx() + "#";
                zVar.gAD.set(2, stringExtra);
                int DE = zVar.gAD.DE(3) + 1;
                zVar.gAD.setInt(3, DE);
                x.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", Integer.valueOf(DE), Long.valueOf(zVar.gAN), Long.valueOf(r4));
                zVar.gAN = -1;
                if (t.bz(zVar.gAD.getLong(1, 0)) > 3600 * ((long) zVar.gAP) || DE > zVar.gAO) {
                    com.tencent.mm.plugin.report.service.g.pWK.k(13110, stringExtra);
                    x.i("MicroMsg.StayTimeReport", "report appStayTime:%s", stringExtra);
                    zVar.gAD.set(2, "");
                    zVar.gAD.setInt(3, 0);
                }
                if (zVar.gAG != null) {
                    a aVar = zVar.gAG;
                    aVar.time += t.bB(zVar.gAK) / 1000;
                    if (str != null && str.contains("WebViewUI")) {
                        aVar = zVar.gAG;
                        aVar.gAX = (int) (((long) aVar.gAX) + (t.bB(zVar.gAL) / 1000));
                    }
                    x.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", Long.valueOf(zVar.gAG.time));
                }
            }
        }
        this.xSw.K(800, 800);
    }

    public static void cnQ() {
        StringBuffer stringBuffer = new StringBuffer(800);
        if (xSp == null) {
            xSp = stringBuffer;
            xSq = bi.Wx();
            return;
        }
        String stringBuffer2 = xSp.toString();
        stringBuffer.append(YU(stringBuffer2));
        xSp = stringBuffer;
        x.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", stringBuffer2);
        com.tencent.mm.plugin.report.service.g.pWK.k(10508, "1," + xSq + "," + stringBuffer2);
        xSq = bi.Wx();
    }

    private static String YU(String str) {
        int i = 0;
        int length = str.length() - 1;
        while (length >= 0) {
            if (str.charAt(length) == '|') {
                i++;
            }
            if (i == 3) {
                break;
            }
            length--;
        }
        return str.substring(length + 1);
    }

    public static void cancelNotification(String str) {
        as.getNotification().cancelNotification(str);
    }

    public static void uq() {
        as.getNotification().uq();
    }

    public static void adx() {
        md(true);
    }

    public static void md(boolean z) {
        x.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), bi.chl(), Boolean.valueOf(z));
        d.n(2, 0, "");
        if (z) {
            Context context = ad.getContext();
            if (context != null) {
                context.stopService(new Intent(context, CoreService.class));
                context.stopService(new Intent(context, NotifyService.class));
                context.stopService(new Intent(context, CacheService.class));
                context.stopService(new Intent().setClassName(context, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"));
            }
        }
        com.tencent.mm.sdk.b.a.xmy.m(new w());
        b jaVar = new ja();
        jaVar.fAx.status = 0;
        jaVar.fAx.aAk = 2;
        com.tencent.mm.sdk.b.a.xmy.m(jaVar);
        cnQ();
        if (z) {
            as.fI(bi.chl().toString());
            g.Dr().releaseAll();
        }
        x.appenderClose();
        BaseEvent.onSingalCrash(0);
        com.tencent.mm.bo.a.e(ad.getContext(), "com.tencent.mm:recovery", "com.tencent.mm:support", "com.tencent.mm:tools", "com.tencent.mm:appbrand0", "com.tencent.mm:appbrand1", "com.tencent.mm:appbrand2", "com.tencent.mm:appbrand3", "com.tencent.mm:appbrand4");
        Process.killProcess(Process.myPid());
    }

    public static void ar(Context context) {
        b(context, true);
    }

    public static void b(Context context, boolean z) {
        g.Dr().gSp.gSK.aI(z);
        BaseEvent.onSingalCrash(0);
        MMNativeJpeg.Destroy();
        com.tencent.mm.booter.o.ut();
        if (!(as.CN() == null || as.CN().hoF == null)) {
            as.CN().hoF.bI(z);
        }
        Intent intent = new Intent().setClass(context, LauncherUI.class);
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        intent.putExtra("kill_service", z);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    public static void W(Activity activity) {
        com.tencent.mm.bl.d.b(activity, "whatsnew", ".ui.WhatsNewUI", new Intent(), 57005);
    }

    public static void fu(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ad.cgf(), 0);
        if (!sharedPreferences.getBoolean("Main_ShortCut", false)) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", context.getString(R.l.esX));
            intent.putExtra("duplicate", false);
            Parcelable intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(context.getPackageName(), ad.cge() + ".ui.LauncherUI"));
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, R.g.icon));
            intent.putExtra("shortcut_icon_resource_id", R.g.icon);
            intent.putExtra("shortcut_is_adaptive_icon", true);
            intent.putExtra("is_main_shortcut", true);
            com.tencent.mm.plugin.base.model.b.o(context, intent);
            Editor edit = sharedPreferences.edit();
            edit.putBoolean("Main_ShortCut", true);
            edit.commit();
        }
    }

    public static boolean a(final Activity activity, final OnClickListener onClickListener) {
        final SharedPreferences sharedPreferences = activity.getSharedPreferences(ad.cgf(), 0);
        boolean z = sharedPreferences.getBoolean("gprs_alert", true);
        com.tencent.mm.sdk.platformtools.f.xmU &= z;
        if (z) {
            View inflate = View.inflate(activity, R.i.dlC, null);
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.cnT);
            Dialog a = com.tencent.mm.ui.base.h.a((Context) activity, false, null, inflate, activity.getString(R.l.dUn), activity.getString(R.l.euJ), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (checkBox.isChecked()) {
                        Editor edit = sharedPreferences.edit();
                        edit.putBoolean("gprs_alert", false);
                        edit.commit();
                    }
                    com.tencent.mm.sdk.platformtools.f.xmU = false;
                    dialogInterface.dismiss();
                    MMAppMgr.fu(activity);
                    if (onClickListener != null) {
                        onClickListener.onClick(dialogInterface, i);
                    }
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    MMAppMgr.b(activity, true);
                }
            });
            if (a == null) {
                return false;
            }
            a.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    activity.onKeyDown(4, new KeyEvent(0, 4));
                }
            });
        }
        return z;
    }

    public static boolean a(Context context, int i, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z;
        View inflate = View.inflate(context, R.i.dpc, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.czo);
        checkBox.setText(context.getString(R.l.exW));
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(16385, Boolean.valueOf(!z));
            }
        });
        inflate.findViewById(R.h.czq).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.h.czp);
        switch (i) {
            case 1:
                textView.setText(R.l.exV);
                z = true;
                break;
            case 3:
                textView.setText(R.l.eyc);
                z = false;
                break;
            default:
                textView.setText(R.l.eyc);
                z = true;
                break;
        }
        if (!z) {
            return false;
        }
        i.a aVar = new i.a(context);
        aVar.ES(R.l.dGZ);
        aVar.mp(false);
        aVar.dk(inflate);
        aVar.EV(R.l.exZ).a(onClickListener);
        aVar.EW(R.l.exW).b(onClickListener2);
        aVar.ale().show();
        return true;
    }

    public static i as(final Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (ao.isWifi(context) && locationManager.isProviderEnabled("gps")) {
                return null;
            }
            as.Hm();
            Boolean bool = (Boolean) com.tencent.mm.y.c.Db().get(4105, Boolean.valueOf(false));
            if (bool != null && bool.booleanValue()) {
                return null;
            }
            View inflate = View.inflate(context, R.i.dmJ, null);
            ((CheckBox) inflate.findViewById(R.h.csM)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().set(4105, Boolean.valueOf(true));
                        return;
                    }
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(4105, Boolean.valueOf(false));
                }
            });
            OnClickListener anonymousClass7 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.MMAppMgr", e, "showLbsTipsAlert", new Object[0]);
                    }
                }
            };
            i.a aVar = new i.a(context);
            aVar.ES(R.l.exD);
            aVar.dk(inflate);
            aVar.EV(R.l.dGO).a(anonymousClass7);
            aVar.EW(R.l.dFF);
            i ale = aVar.ale();
            ale.show();
            return ale;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMAppMgr", e, "showLbsTipsAlert error", new Object[0]);
            return null;
        }
    }
}

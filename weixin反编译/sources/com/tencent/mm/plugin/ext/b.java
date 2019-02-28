package com.tencent.mm.plugin.ext;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a.er;
import com.tencent.mm.f.a.ez;
import com.tencent.mm.f.a.ff;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg;
import com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.protocal.c.ahr;
import com.tencent.mm.protocal.c.bta;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class b implements ap {
    private static HashMap<Integer, d> gyG;
    private static boolean mfs = false;
    com.tencent.mm.sdk.e.m.b lTI = new com.tencent.mm.sdk.e.m.b() {
        public final void a(int i, m mVar, Object obj) {
            if (obj == null || !(obj instanceof String)) {
                x.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            } else if (as.Hp()) {
                as.Hm();
                if (mVar == c.Ff()) {
                    b.this.eQ(false);
                }
            } else {
                x.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
            }
        }
    };
    private final long mfc = 1600;
    private t mfd;
    private bb mfe;
    private bk mff;
    private a mfg;
    private b mfh;
    private HashMap<String, Integer> mfi = new HashMap();
    private com.tencent.mm.plugin.messenger.foundation.a.a.c.a mfj = new com.tencent.mm.plugin.messenger.foundation.a.a.c.a() {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c r9, com.tencent.mm.plugin.messenger.foundation.a.a.c.c r10) {
            /*
            r8 = this;
            r0 = 0;
            if (r9 == 0) goto L_0x0009;
        L_0x0003:
            if (r10 == 0) goto L_0x0009;
        L_0x0005:
            r1 = r10.ouB;
            if (r1 != 0) goto L_0x0013;
        L_0x0009:
            r0 = "MicroMsg.SubCoreExt";
            r1 = "onMsgChange, wrong args";
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        L_0x0012:
            return;
        L_0x0013:
            r3 = com.tencent.mm.plugin.ext.b.this;
            monitor-enter(r3);
            r1 = com.tencent.mm.plugin.ext.b.aGi();	 Catch:{ all -> 0x002b }
            r1 = r1.ckD();	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x002e;
        L_0x0020:
            r0 = "MicroMsg.SubCoreExt";
            r1 = "onMsgChange onNotifyChange getValidOpenMsgListener cu == null";
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x002b }
            monitor-exit(r3);	 Catch:{ all -> 0x002b }
            goto L_0x0012;
        L_0x002b:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x002b }
            throw r0;
        L_0x002e:
            r2 = "MicroMsg.SubCoreExt";
            r4 = "onMsgChange onNotifyChange listener count = %s";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x002b }
            r6 = 0;
            r7 = r1.getCount();	 Catch:{ all -> 0x002b }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x002b }
            r5[r6] = r7;	 Catch:{ all -> 0x002b }
            com.tencent.mm.sdk.platformtools.x.d(r2, r4, r5);	 Catch:{ all -> 0x002b }
            r2 = r1.getCount();	 Catch:{ all -> 0x002b }
            if (r2 > 0) goto L_0x0059;
        L_0x004b:
            r1.close();	 Catch:{ all -> 0x002b }
            r0 = "MicroMsg.SubCoreExt";
            r1 = "onMsgChange onNotifyChange cu.getCount() <= 0";
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x002b }
            monitor-exit(r3);	 Catch:{ all -> 0x002b }
            goto L_0x0012;
        L_0x0059:
            r1.close();	 Catch:{ all -> 0x002b }
            r2 = r0;
        L_0x005d:
            r0 = r10.ouB;	 Catch:{ all -> 0x002b }
            r0 = r0.size();	 Catch:{ all -> 0x002b }
            if (r2 >= r0) goto L_0x0109;
        L_0x0065:
            r0 = r10.ouB;	 Catch:{ all -> 0x002b }
            r0 = r0.get(r2);	 Catch:{ all -> 0x002b }
            r0 = (com.tencent.mm.storage.au) r0;	 Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x00d1;
        L_0x006f:
            r1 = r0.field_isSend;	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x00d1;
        L_0x0073:
            r1 = r0.field_status;	 Catch:{ all -> 0x002b }
            r4 = 4;
            if (r1 == r4) goto L_0x00d1;
        L_0x0078:
            r1 = r0.getType();	 Catch:{ all -> 0x002b }
            r4 = 9999; // 0x270f float:1.4012E-41 double:4.94E-320;
            if (r1 == r4) goto L_0x00d1;
        L_0x0080:
            r1 = r0.getType();	 Catch:{ all -> 0x002b }
            r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
            if (r1 == r4) goto L_0x00d1;
        L_0x0088:
            r1 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r1 = com.tencent.mm.y.s.hr(r1);	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x00d1;
        L_0x0090:
            r1 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r1 = com.tencent.mm.y.s.hv(r1);	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x00d1;
        L_0x0098:
            r1 = com.tencent.mm.plugin.ext.b.this;	 Catch:{ all -> 0x002b }
            r1 = r1.mfi;	 Catch:{ all -> 0x002b }
            r4 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r1 = r1.get(r4);	 Catch:{ all -> 0x002b }
            r1 = (java.lang.Integer) r1;	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x00d5;
        L_0x00a8:
            r1 = com.tencent.mm.plugin.ext.b.this;	 Catch:{ all -> 0x002b }
            r1 = r1.mfi;	 Catch:{ all -> 0x002b }
            r4 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r5 = 1;
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x002b }
            r1.put(r4, r5);	 Catch:{ all -> 0x002b }
            r1 = "MicroMsg.SubCoreExt";
            r4 = "onMsgChange %s, %d";
            r5 = 2;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x002b }
            r6 = 0;
            r0 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r5[r6] = r0;	 Catch:{ all -> 0x002b }
            r0 = 1;
            r6 = 1;
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x002b }
            r5[r0] = r6;	 Catch:{ all -> 0x002b }
            com.tencent.mm.sdk.platformtools.x.d(r1, r4, r5);	 Catch:{ all -> 0x002b }
        L_0x00d1:
            r0 = r2 + 1;
            r2 = r0;
            goto L_0x005d;
        L_0x00d5:
            r4 = com.tencent.mm.plugin.ext.b.this;	 Catch:{ all -> 0x002b }
            r4 = r4.mfi;	 Catch:{ all -> 0x002b }
            r5 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r6 = r1.intValue();	 Catch:{ all -> 0x002b }
            r6 = r6 + 1;
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x002b }
            r4.put(r5, r6);	 Catch:{ all -> 0x002b }
            r4 = "MicroMsg.SubCoreExt";
            r5 = "onMsgChange %s, %d";
            r6 = 2;
            r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x002b }
            r7 = 0;
            r0 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r6[r7] = r0;	 Catch:{ all -> 0x002b }
            r0 = 1;
            r1 = r1.intValue();	 Catch:{ all -> 0x002b }
            r1 = r1 + 1;
            r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x002b }
            r6[r0] = r1;	 Catch:{ all -> 0x002b }
            com.tencent.mm.sdk.platformtools.x.d(r4, r5, r6);	 Catch:{ all -> 0x002b }
            goto L_0x00d1;
        L_0x0109:
            r0 = com.tencent.mm.plugin.ext.b.this;	 Catch:{ all -> 0x002b }
            r0 = r0.mfi;	 Catch:{ all -> 0x002b }
            r0 = r0.size();	 Catch:{ all -> 0x002b }
            if (r0 <= 0) goto L_0x011d;
        L_0x0115:
            r0 = com.tencent.mm.plugin.ext.b.this;	 Catch:{ all -> 0x002b }
            r0.aGn();	 Catch:{ all -> 0x002b }
        L_0x011a:
            monitor-exit(r3);	 Catch:{ all -> 0x002b }
            goto L_0x0012;
        L_0x011d:
            r0 = "MicroMsg.SubCoreExt";
            r1 = "notifyMsgUsers.size < 1";
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x002b }
            goto L_0x011a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.b.5.a(com.tencent.mm.plugin.messenger.foundation.a.a.c, com.tencent.mm.plugin.messenger.foundation.a.a.c$c):void");
        }
    };
    com.tencent.mm.pluginsdk.model.j.a mfk = new com.tencent.mm.pluginsdk.model.j.a() {
        public final void a(com.tencent.mm.pluginsdk.model.m mVar) {
            if (mVar != null) {
                ahr ahr;
                if (mVar.lSH == null) {
                    ahr = null;
                } else {
                    ahr = (ahr) mVar.lSH.hnR.hnY;
                }
                Iterator it = ahr.wvJ.iterator();
                int i = 0;
                while (it.hasNext()) {
                    bta bta = (bta) it.next();
                    x.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", mVar.vkf, bta.kyG, bta.xbh);
                    if (!(bi.oN(bta.kyG) || bi.oN(bta.xbh))) {
                        as.Hm();
                        com.tencent.mm.k.a Xt = c.Ff().Xt(bta.kyG);
                        if (Xt == null || ((int) Xt.gKO) <= 0) {
                            x.e("MicroMsg.SubCoreExt", "contact is null");
                        } else if (Xt.ciN()) {
                            x.w("MicroMsg.SubCoreExt", "isBizContact");
                        } else {
                            com.tencent.mm.pluginsdk.model.j.b RZ = j.RZ(bta.xbh);
                            if (!(RZ == null || bi.oN(RZ.vjZ))) {
                                x.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", mVar.vkf, RZ.vjZ);
                                b.aGj().a(new bj(mVar.vkf, bta.kyG, RZ.vjZ));
                                i = 1;
                            }
                        }
                    }
                }
                if (i != 0) {
                    b.this.aGn();
                }
            }
        }
    };
    private ag mfl = new ag(Looper.getMainLooper()) {
        @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140514", reviewer = 20, vComment = {EType.INTENTCHECK})
        public final void handleMessage(Message message) {
            if (ad.getContext() == null || !as.Hp()) {
                x.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
                return;
            }
            Cursor ckD = b.aGi().ckD();
            if (ckD == null) {
                x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
                return;
            }
            x.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", Integer.valueOf(ckD.getCount()));
            if (ckD.getCount() <= 0) {
                ckD.close();
                x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
                return;
            }
            try {
                if (ckD.moveToFirst()) {
                    HashMap hashMap = new HashMap();
                    synchronized (b.this) {
                        hashMap.putAll(b.this.mfi);
                        b.this.mfi.clear();
                    }
                    do {
                        LinkedList linkedList = new LinkedList();
                        ArrayList arrayList = new ArrayList();
                        if (hashMap.entrySet() == null) {
                            x.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
                            return;
                        }
                        ba baVar = new ba();
                        baVar.b(ckD);
                        if (bi.oN(baVar.field_appId) || bi.oN(baVar.field_packageName)) {
                            x.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", baVar.field_appId, baVar.field_packageName);
                        } else {
                            for (Entry entry : hashMap.entrySet()) {
                                String oM = bi.oM((String) entry.getKey());
                                Integer num = (Integer) entry.getValue();
                                as.Hm();
                                ak XF = c.Fk().XF(oM);
                                if (XF != null && !bi.oN(XF.field_username) && XF.field_unReadCount <= 0) {
                                    x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
                                } else if (!(s.hr(oM) || s.eX(oM) || s.gI(oM))) {
                                    bj bjVar;
                                    bk aGj = b.aGj();
                                    String str = baVar.field_appId;
                                    if (str == null || str.length() <= 0 || oM == null || oM.length() <= 0) {
                                        bjVar = null;
                                    } else {
                                        Cursor a = aGj.gLA.a("UserOpenIdInApp", null, "appId=? and username=? ", new String[]{bi.oL(str), bi.oL(oM)}, null, null, null, 2);
                                        if (a.moveToFirst()) {
                                            bjVar = new bj();
                                            bjVar.b(a);
                                            a.close();
                                        } else {
                                            x.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", str, oM);
                                            a.close();
                                            bjVar = null;
                                        }
                                    }
                                    if (bjVar == null || bi.oN(bjVar.field_openId) || bi.oN(bjVar.field_username)) {
                                        x.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
                                        Integer num2 = (Integer) b.this.mfi.get(oM);
                                        if (num2 == null) {
                                            b.this.mfi.put(oM, num);
                                        } else {
                                            b.this.mfi.put(oM, Integer.valueOf(num2.intValue() + num.intValue()));
                                        }
                                        linkedList.add(oM);
                                    } else {
                                        x.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", bjVar.field_username, bjVar.field_appId, bjVar.field_openId);
                                        arrayList.add(String.format("%s,%s,%s", new Object[]{bjVar.field_openId, num, Long.valueOf(System.currentTimeMillis() - 1600)}));
                                    }
                                }
                            }
                            if (linkedList.size() > 0) {
                                x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
                                b bVar = b.this;
                                String str2 = baVar.field_appId;
                                if (!bi.oN(str2) && linkedList.size() > 0) {
                                    j bZa = j.bZa();
                                    Context context = ad.getContext();
                                    com.tencent.mm.pluginsdk.model.j.a aVar = bVar.mfk;
                                    x.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
                                    if (!j.vjW) {
                                        bZa.bZb();
                                    }
                                    if (as.Hp() && context != null) {
                                        if (linkedList.size() == 0) {
                                            x.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
                                        } else {
                                            bZa.vjY = aVar;
                                            w mVar = new com.tencent.mm.pluginsdk.model.m(str2, linkedList);
                                            an.aRP();
                                            com.tencent.mm.pluginsdk.model.app.d.a(14, mVar);
                                        }
                                    }
                                }
                            }
                            if (arrayList.size() <= 0) {
                                ckD.close();
                                x.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
                                return;
                            }
                            if ((baVar.field_status == 1 ? 1 : null) == null) {
                                x.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", baVar.field_appId, baVar.field_packageName);
                            } else if (!(bi.oN(baVar.field_appId) || bi.oN(baVar.field_packageName))) {
                                x.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", baVar.field_appId, baVar.field_packageName);
                                final Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
                                intent.addCategory("com.tencent.mm.category." + baVar.field_packageName);
                                com.tencent.mm.compatible.a.a.a(12, new com.tencent.mm.compatible.a.a.a() {
                                    public final void run() {
                                        intent.setFlags(32);
                                    }
                                });
                                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "NEW_MESSAGE");
                                intent.putStringArrayListExtra("EXTRA_EXT_OPEN_USER_DATA", arrayList);
                                ad.getContext().sendBroadcast(intent);
                            }
                        }
                    } while (ckD.moveToNext());
                }
                ckD.close();
            } catch (Exception e) {
                x.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", e.getMessage());
                if (ckD != null) {
                    ckD.close();
                }
            }
        }
    };
    private LinkedList<String> mfm = new LinkedList();
    private final long mfn = 60;
    private ag mfo = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            try {
                if (b.this.mfm.size() > 0) {
                    Iterator it = b.this.mfm.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!"*".equals(str)) {
                            f aZ = g.aZ(str, false);
                            if (aZ == null) {
                                x.w("MicroMsg.SubCoreExt", "appInfo is null");
                            } else if (bi.oN(aZ.field_appId)) {
                                x.w("MicroMsg.SubCoreExt", "appId is null");
                            } else {
                                x.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", str, Integer.valueOf(aZ.field_appInfoFlag), aZ.field_appId);
                                ba Yj = b.aGi().Yj(aZ.field_appId);
                                if (Yj == null) {
                                    x.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", aZ.field_appId);
                                } else {
                                    if (g.i(aZ)) {
                                        if (Yj.field_status != 1) {
                                            Yj.field_status = 1;
                                        }
                                    } else if (Yj.field_status != 0) {
                                        Yj.field_status = 0;
                                    }
                                    bb aGi = b.aGi();
                                    if (bi.oN(aZ.field_appId) || Yj == null || bi.oN(Yj.field_appId)) {
                                        x.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
                                    } else {
                                        int update;
                                        ContentValues vP = Yj.vP();
                                        if (vP.size() > 0) {
                                            update = aGi.gLA.update("OpenMsgListener", vP, "appId=?", new String[]{bi.oL(r3)});
                                        } else {
                                            update = 0;
                                        }
                                        x.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", Yj.field_appId, Integer.valueOf(update));
                                    }
                                }
                            }
                        }
                    }
                    b.this.mfm.clear();
                }
            } catch (Exception e) {
                x.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", e.getMessage());
            }
        }
    };
    private com.tencent.mm.sdk.e.j.a mfp = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, l lVar) {
            if (!b.this.mfm.contains(str)) {
                b.this.mfm.add(str);
            }
            b.this.mfo.removeMessages(0);
            b.this.mfo.sendEmptyMessageDelayed(0, 60);
        }
    };
    private boolean mfq = true;
    private boolean mfr = false;

    public static class a extends com.tencent.mm.sdk.b.c<ez> {
        public a() {
            this.xmG = ez.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ez ezVar = (ez) bVar;
            if (!(ezVar instanceof ez)) {
                x.f("MicroMsg.SubCoreExt", "mismatched event");
                return false;
            } else if (ezVar.fuM == null) {
                x.e("MicroMsg.SubCoreExt", "revent.data is null");
                return false;
            } else {
                if (ezVar.fuM.fuh == 9 || ezVar.fuM.fuh == 13) {
                    ExtControlProviderMsg extControlProviderMsg = new ExtControlProviderMsg(ezVar.fuM.fnP, ezVar.fuM.fuh, ezVar.fuM.context);
                    ezVar.fuN.fui = extControlProviderMsg.query(ezVar.fuM.uri, null, null, ezVar.fuM.selectionArgs, null);
                } else if (ezVar.fuM.fuh == 3) {
                    ExtControlProviderEntry extControlProviderEntry = new ExtControlProviderEntry(ezVar.fuM.fnP, ezVar.fuM.fuh, ezVar.fuM.context);
                    ezVar.fuN.fui = extControlProviderEntry.query(ezVar.fuM.uri, null, null, ezVar.fuM.selectionArgs, null);
                } else if (ezVar.fuM.fuh == 29) {
                    ExtControlProviderVoiceControl extControlProviderVoiceControl = new ExtControlProviderVoiceControl(ezVar.fuM.fnP, ezVar.fuM.fuh, ezVar.fuM.context);
                    ezVar.fuN.fui = extControlProviderVoiceControl.query(ezVar.fuM.uri, null, null, ezVar.fuM.selectionArgs, null);
                    SharedPreferences cgg = ad.cgg();
                    if (!b.mfs) {
                        cgg.edit().putBoolean("hasCallVoiceControlApi", true).commit();
                        b.mfs = true;
                    }
                } else {
                    ExtControlProviderOpenApi extControlProviderOpenApi = new ExtControlProviderOpenApi(ezVar.fuM.fnP, ezVar.fuM.fuh, ezVar.fuM.context);
                    ezVar.fuN.fui = extControlProviderOpenApi.query(ezVar.fuM.uri, null, null, ezVar.fuM.selectionArgs, null);
                }
                return true;
            }
        }
    }

    public static class b extends com.tencent.mm.sdk.b.c<ff> {
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ff ffVar = (ff) bVar;
            if (ffVar.fvd == null) {
                x.e("MicroMsg.SubCoreExt", "StepCount revent.data is null");
            } else {
                x.i("MicroMsg.SubCoreExt", " action = " + ffVar.fvd.action);
                if (ffVar.fvd.action == 1) {
                    b.aGm();
                    x.d("MicroMsg.SubCoreExt", " sendBroadcast");
                    return true;
                }
            }
            return false;
        }

        public b() {
            super(0);
            this.xmG = ff.class.getName().hashCode();
        }
    }

    static {
        int yw = com.tencent.mm.compatible.e.m.yw();
        try {
            if (!Build.CPU_ABI.contains("armeabi")) {
                x.e("hakon SilkCodec", "x86 machines not supported.");
            } else if ((yw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                k.b("wechatvoicesilk_v7a", b.class.getClassLoader());
            } else if ((yw & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                k.b("wechatvoicesilk", b.class.getClassLoader());
            } else {
                x.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
            }
        } catch (Exception e) {
            x.e("hakon SilkCodec", "load library failed!");
        }
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return bb.gLy;
            }
        });
        gyG.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return bk.gLy;
            }
        });
    }

    public static b aGg() {
        as.Hg();
        b bVar = (b) bq.ib("plugin.ext");
        if (bVar != null) {
            return bVar;
        }
        Object bVar2 = new b();
        as.Hg().a("plugin.ext", bVar2);
        return bVar2;
    }

    public static t aGh() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aGg().mfd == null) {
            b aGg = aGg();
            as.Hm();
            aGg.mfd = new t(c.Fc());
        }
        return aGg().mfd;
    }

    public static bb aGi() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aGg().mfe == null) {
            b aGg = aGg();
            as.Hm();
            aGg.mfe = new bb(c.Fc());
        }
        return aGg().mfe;
    }

    public static bk aGj() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aGg().mff == null) {
            b aGg = aGg();
            as.Hm();
            aGg.mff = new bk(c.Fc());
        }
        return aGg().mff;
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void bt(boolean z) {
        aGk();
    }

    private static void aGk() {
        File file = new File(com.tencent.mm.kernel.g.Dq().gRT);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(com.tencent.mm.kernel.g.Dq().gRT + "image/ext/pcm");
        if (!file.exists()) {
            file.mkdirs();
        }
        x.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", com.tencent.mm.kernel.g.Dq().gRT, bi.chl());
    }

    public final void bs(boolean z) {
        com.tencent.mm.sdk.b.b erVar = new er();
        erVar.fuc.op = 1;
        if (!com.tencent.mm.sdk.b.a.xmy.m(erVar)) {
            x.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
        }
        j.bZa().bZb();
        as.Hm();
        c.Fh().a(this.mfj, null);
        if (this.mfg == null) {
            this.mfg = new a();
        }
        com.tencent.mm.sdk.b.a.xmy.b(this.mfg);
        if (this.mfh == null) {
            this.mfh = new b();
        }
        com.tencent.mm.sdk.b.a.xmy.b(this.mfh);
        i biT = an.biT();
        if (biT != null) {
            biT.c(this.mfp);
        }
        SharedPreferences cgg = ad.cgg();
        this.mfr = cgg.getBoolean("hasTryToInitVoiceControlData", false);
        mfs = cgg.getBoolean("hasCallVoiceControlApi", false);
        x.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(this.mfr), Boolean.valueOf(mfs));
        as.Hm();
        c.Ff().a(this.lTI);
        eQ(true);
        com.tencent.mm.plugin.ext.c.c.aGB();
        aGk();
    }

    public final void onAccountRelease() {
        if (this.mfg != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.mfg);
        }
        if (this.mfh != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.mfh);
        }
        i biT = an.biT();
        if (biT != null) {
            biT.j(this.mfp);
        }
        as.Hm();
        c.Fh().a(this.mfj);
        com.tencent.mm.sdk.b.b erVar = new er();
        erVar.fuc.op = 2;
        if (!com.tencent.mm.sdk.b.a.xmy.m(erVar)) {
            x.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
        }
        com.tencent.mm.pluginsdk.model.app.t bZa = j.bZa();
        if (as.Hp()) {
            j.vjW = false;
            an.aRP().b(14, bZa);
        }
        as.Hm();
        c.Ff().b(this.lTI);
        com.tencent.mm.plugin.ext.c.c.aGC();
    }

    public static String aGl() {
        return com.tencent.mm.kernel.g.Dq().gRT + "image/ext/pcm";
    }

    public static void aGm() {
        String str = (String) aGh().get(com.tencent.mm.storage.w.a.USERINFO_EXT_SPORT_PKGNAME_STRING, null);
        x.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = " + str);
        if (str != null) {
            for (String str2 : str.split(";")) {
                final Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_SET_SPORT_STEP");
                intent.setPackage(str2);
                com.tencent.mm.compatible.a.a.a(12, new com.tencent.mm.compatible.a.a.a() {
                    public final void run() {
                        intent.setFlags(32);
                    }
                });
                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
                ad.getContext().sendBroadcast(intent);
            }
        }
    }

    public final void ge(int i) {
    }

    public static com.tencent.mm.storage.x cN(long j) {
        if (!as.Hp() || j <= 0) {
            return null;
        }
        as.Hm();
        return c.Ff().fP(j);
    }

    public static void cO(long j) {
        if (j > 0) {
            try {
                as.Hm();
                if (c.Fh().dL(j)) {
                    as.Hm();
                    com.tencent.mm.plugin.messenger.foundation.a.a.c Fh = c.Fh();
                    as.Hm();
                    Fh.R(c.Fh().dI(j));
                    return;
                }
                x.e("MicroMsg.SubCoreExt", "msgId is out of range, " + j);
            } catch (Throwable e) {
                x.e("MicroMsg.SubCoreExt", e.getMessage());
                x.printErrStackTrace("MicroMsg.SubCoreExt", e, "", new Object[0]);
            }
        }
    }

    public final void aGn() {
        this.mfl.removeMessages(0);
        this.mfl.sendEmptyMessageDelayed(0, 1600);
    }

    private void eQ(boolean z) {
        if (!this.mfq) {
            return;
        }
        if (z && this.mfr) {
            x.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
        } else if (z || mfs) {
            x.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(z), Boolean.valueOf(this.mfr), Boolean.valueOf(mfs));
            this.mfq = false;
            as.Dt().g(new Runnable() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    r13 = this;
                    r7 = 0;
                    r12 = 1;
                    r0 = com.tencent.mm.j.g.Af();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "VoiceRecognizeSprSoMD5";
                    r1 = r0.getValue(r1);	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.j.g.Af();	 Catch:{ Exception -> 0x00e5 }
                    r2 = "VoiceRecognizeSprDataMD5";
                    r2 = r0.getValue(r2);	 Catch:{ Exception -> 0x00e5 }
                    if (r1 == 0) goto L_0x001c;
                L_0x001a:
                    if (r2 != 0) goto L_0x0034;
                L_0x001c:
                    r0 = "MicroMsg.SubCoreExt";
                    r3 = "error mMd5So:%s,  mMd5Data:%s";
                    r4 = 2;
                    r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00e5 }
                    r5 = 0;
                    r4[r5] = r1;	 Catch:{ Exception -> 0x00e5 }
                    r1 = 1;
                    r4[r1] = r2;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.plugin.ext.b.this;	 Catch:{ Exception -> 0x00e5 }
                    r0.mfq = true;	 Catch:{ Exception -> 0x00e5 }
                L_0x0033:
                    return;
                L_0x0034:
                    r0 = "/system/lib/";
                    r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x00e5 }
                    r4 = 24;
                    if (r3 < r4) goto L_0x0040;
                L_0x003d:
                    r0 = "/vendor/lib/";
                L_0x0040:
                    r3 = "MicroMsg.SubCoreExt";
                    r4 = "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s";
                    r5 = 3;
                    r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00e5 }
                    r6 = 0;
                    r5[r6] = r1;	 Catch:{ Exception -> 0x00e5 }
                    r6 = 1;
                    r5[r6] = r2;	 Catch:{ Exception -> 0x00e5 }
                    r6 = 2;
                    r5[r6] = r0;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r3 = com.qq.wx.voice.embed.recognizer.b.a.bgn;	 Catch:{ Exception -> 0x00e5 }
                    r6 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ Exception -> 0x00e5 }
                    r3 = r3.bgm;	 Catch:{ Exception -> 0x00e5 }
                    r8 = r3.d;	 Catch:{ Exception -> 0x00e5 }
                    if (r8 == 0) goto L_0x00f9;
                L_0x0065:
                    r0 = r7;
                L_0x0066:
                    r8 = com.tencent.mm.sdk.platformtools.ad.cgg();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "MicroMsg.SubCoreExt";
                    r2 = "checkFiles ret:%s,use time:%s";
                    r3 = 2;
                    r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e5 }
                    r6 = 0;
                    r9 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00e5 }
                    r3[r6] = r9;	 Catch:{ Exception -> 0x00e5 }
                    r6 = 1;
                    r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r4 = r10 - r4;
                    r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00e5 }
                    r3[r6] = r4;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 != 0) goto L_0x01d5;
                L_0x008c:
                    r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r3 = new java.util.LinkedList;	 Catch:{ Exception -> 0x00e5 }
                    r3.<init>();	 Catch:{ Exception -> 0x00e5 }
                    r0 = "tmessage";
                    r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
                    r0 = "officialaccounts";
                    r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
                    r0 = "helper_entry";
                    r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.y.as.Hm();	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.y.c.Fn();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "@t.qq.com";
                    r0 = r0.FE(r1);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 == 0) goto L_0x00bc;
                L_0x00b7:
                    r0 = r0.name;	 Catch:{ Exception -> 0x00e5 }
                    r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
                L_0x00bc:
                    r9 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00e5 }
                    r9.<init>();	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.y.as.Hm();	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.y.c.Ff();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "@all.contact.android";
                    r2 = 0;
                    r4 = 0;
                    r5 = 1;
                    r6 = 1;
                    r0 = r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 != 0) goto L_0x0107;
                L_0x00d5:
                    r0 = "MicroMsg.SubCoreExt";
                    r1 = "initLocalVoiceControl cu is null";
                    com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.plugin.ext.b.this;	 Catch:{ Exception -> 0x00e5 }
                    r0.mfq = true;	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x0033;
                L_0x00e5:
                    r0 = move-exception;
                    r1 = "MicroMsg.SubCoreExt";
                    r2 = "initLocalVoiceControl Exception:%s";
                    r3 = new java.lang.Object[r12];
                    r0 = r0.getMessage();
                    r3[r7] = r0;
                    com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
                    goto L_0x0033;
                L_0x00f9:
                    r8 = r3.bgt;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r8.checkFiles(r6, r0, r1, r2);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 < 0) goto L_0x0066;
                L_0x0101:
                    r0 = 1;
                    r3.d = r0;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r7;
                    goto L_0x0066;
                L_0x0107:
                    r1 = r0.moveToFirst();	 Catch:{ Exception -> 0x00e5 }
                    if (r1 == 0) goto L_0x012d;
                L_0x010d:
                    r1 = r0.isAfterLast();	 Catch:{ Exception -> 0x00e5 }
                    if (r1 != 0) goto L_0x012d;
                L_0x0113:
                    r1 = new com.tencent.mm.storage.f;	 Catch:{ Exception -> 0x00e5 }
                    r1.<init>();	 Catch:{ Exception -> 0x00e5 }
                    r1.b(r0);	 Catch:{ Exception -> 0x00e5 }
                    r2 = new com.qq.wx.voice.embed.recognizer.d;	 Catch:{ Exception -> 0x00e5 }
                    r3 = r1.field_username;	 Catch:{ Exception -> 0x00e5 }
                    r4 = r1.field_nickname;	 Catch:{ Exception -> 0x00e5 }
                    r1 = r1.field_conRemark;	 Catch:{ Exception -> 0x00e5 }
                    r2.<init>(r3, r4, r1);	 Catch:{ Exception -> 0x00e5 }
                    r9.add(r2);	 Catch:{ Exception -> 0x00e5 }
                    r0.moveToNext();	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x010d;
                L_0x012d:
                    r0.close();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "MicroMsg.SubCoreExt";
                    r2 = "init cusor,count:%s,use time:%s";
                    r3 = 2;
                    r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e5 }
                    r4 = 0;
                    r0 = r0.getCount();	 Catch:{ Exception -> 0x00e5 }
                    r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00e5 }
                    r3[r4] = r0;	 Catch:{ Exception -> 0x00e5 }
                    r0 = 1;
                    r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r4 = r4 - r10;
                    r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00e5 }
                    r3[r0] = r4;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Exception -> 0x00e5 }
                    r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.qq.wx.voice.embed.recognizer.b.a.bgn;	 Catch:{ Exception -> 0x00e5 }
                    r1 = r0.bgm;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r1.d;	 Catch:{ Exception -> 0x00e5 }
                    if (r0 != 0) goto L_0x01ab;
                L_0x015f:
                    r0 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
                L_0x0161:
                    if (r0 != 0) goto L_0x01c5;
                L_0x0163:
                    r1 = r8.edit();	 Catch:{ Exception -> 0x00e5 }
                    r4 = "hasInitVoiceControlData";
                    r5 = 1;
                    r1 = r1.putBoolean(r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r4 = "hasTryToInitVoiceControlData";
                    r5 = 1;
                    r1 = r1.putBoolean(r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r1.commit();	 Catch:{ Exception -> 0x00e5 }
                    r1 = com.tencent.mm.plugin.ext.b.this;	 Catch:{ Exception -> 0x00e5 }
                    r1.mfr = true;	 Catch:{ Exception -> 0x00e5 }
                L_0x017f:
                    r1 = "MicroMsg.SubCoreExt";
                    r4 = "init ret:%s,use time:%s";
                    r5 = 2;
                    r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00e5 }
                    r6 = 0;
                    r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00e5 }
                    r5[r6] = r0;	 Catch:{ Exception -> 0x00e5 }
                    r0 = 1;
                    r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r2 = r8 - r2;
                    r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x00e5 }
                    r5[r0] = r2;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.plugin.ext.b.this;	 Catch:{ Exception -> 0x00e5 }
                    r0.mfq = true;	 Catch:{ Exception -> 0x00e5 }
                L_0x01a4:
                    r0 = com.tencent.mm.plugin.ext.b.this;	 Catch:{ Exception -> 0x00e5 }
                    r0.mfq = true;	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x0033;
                L_0x01ab:
                    r0 = r1.e;	 Catch:{ Exception -> 0x00e5 }
                    if (r0 == 0) goto L_0x01b9;
                L_0x01af:
                    r0 = r1.bgt;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r0.update(r9);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 < 0) goto L_0x0161;
                L_0x01b7:
                    r0 = r7;
                    goto L_0x0161;
                L_0x01b9:
                    r0 = r1.bgt;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r0.init(r9);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 < 0) goto L_0x0161;
                L_0x01c1:
                    r0 = 1;
                    r1.e = r0;	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x01b7;
                L_0x01c5:
                    r1 = r8.edit();	 Catch:{ Exception -> 0x00e5 }
                    r4 = "hasInitVoiceControlData";
                    r5 = 0;
                    r1 = r1.putBoolean(r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r1.commit();	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x017f;
                L_0x01d5:
                    r0 = r8.edit();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "hasInitVoiceControlData";
                    r2 = 0;
                    r0 = r0.putBoolean(r1, r2);	 Catch:{ Exception -> 0x00e5 }
                    r1 = "hasTryToInitVoiceControlData";
                    r2 = 1;
                    r0 = r0.putBoolean(r1, r2);	 Catch:{ Exception -> 0x00e5 }
                    r0.commit();	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.plugin.ext.b.this;	 Catch:{ Exception -> 0x00e5 }
                    r0.mfr = true;	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x01a4;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.b.2.run():void");
                }
            }, 10000);
        }
    }
}

package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class i implements e {
    public ag mHandler = new ag();
    private boolean pbo = false;
    private boolean pbp = false;
    private int pbq = 10;
    private int pbr = 0;
    private String pbs = "";
    a pbt;
    private m pbu;
    public b pbv = new b();
    int pbw = 14400000;
    al pbx = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (g.Do().CF()) {
                long j;
                i.this.dg(5, 5);
                al alVar = i.this.pbx;
                i iVar = i.this;
                long biJ = (long) com.tencent.mm.plugin.offline.c.a.biJ();
                if (biJ <= 0) {
                    j = (long) iVar.pbw;
                } else {
                    x.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:" + biJ);
                    j = 1000 * biJ;
                }
                alVar.K(j, j);
            } else {
                long j2 = (long) i.this.pbw;
                i.this.pbx.K(j2, j2);
            }
            return false;
        }
    }, false);

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(i iVar, byte b) {
            this();
        }

        public final void run() {
            x.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
            i.this.di(6, 6);
        }
    }

    public interface a {
        void bhx();
    }

    public i() {
        long j = 1;
        try {
            com.tencent.mm.wallet_core.c.a.cCe();
            com.tencent.mm.wallet_core.c.a.init(ad.getContext());
        } catch (Exception e) {
            x.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", e);
        }
        g.Dr();
        g.Dp().gRu.a(385, (e) this);
        k.bhD();
        String uF = k.uF(196649);
        if (TextUtils.isEmpty(uF) || !com.tencent.mm.plugin.offline.c.a.xv(uF)) {
            x.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        } else {
            Object biv = com.tencent.mm.plugin.offline.c.a.biv();
            x.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is " + biv);
            long longValue = Long.valueOf(uF).longValue();
            if (TextUtils.isEmpty(biv)) {
                x.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
            } else {
                j = Long.valueOf(biv).longValue();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                x.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + currentTimeMillis + ";");
                j = longValue - (currentTimeMillis - j);
            }
        }
        x.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=" + j);
        j *= 1000;
        this.pbx.K(j, j);
    }

    public static int bhC() {
        k.bhD();
        String uF = k.uF(196617);
        com.tencent.mm.wallet_core.c.a.cCe();
        int abe = com.tencent.mm.wallet_core.c.a.abe(uF);
        x.i("MicroMsg.OfflineTokensMgr", "offline tokens count:" + abe);
        return abe;
    }

    public final void dg(int i, int i2) {
        if (ao.isNetworkConnected(ad.getContext()) && com.tencent.mm.plugin.offline.c.a.bin()) {
            x.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
            di(i, i2);
        }
    }

    public final boolean hh(boolean z) {
        if (!com.tencent.mm.plugin.offline.c.a.bin()) {
            x.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
            return false;
        } else if (bhC() < k.pbI) {
            x.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", Integer.valueOf(k.pbI));
            com.tencent.mm.wallet_core.c.a.cCe();
            int lastError = com.tencent.mm.wallet_core.c.a.getLastError();
            if (lastError != 0) {
                x.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + lastError + ", don't  doNetSceneToken");
                return false;
            }
            x.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
            if (z) {
                dh(2, 9);
            } else {
                dh(2, 2);
            }
            return true;
        } else if (com.tencent.mm.plugin.offline.c.a.biK()) {
            x.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
            if (z) {
                di(5, 9);
            } else {
                di(5, 5);
            }
            return true;
        } else if (com.tencent.mm.plugin.offline.c.a.biH()) {
            return false;
        } else {
            x.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
            if (z) {
                di(3, 9);
            } else {
                di(3, 3);
            }
            return true;
        }
    }

    public final void dh(int i, final int i2) {
        if (bhC() > 2) {
            this.mHandler.postDelayed(new Runnable(2) {
                public final void run() {
                    i.this.di(2, i2);
                }
            }, 3000);
        } else {
            di(2, i2);
        }
    }

    public final void di(int i, int i2) {
        int i3 = 0;
        if (!this.pbo) {
            this.pbo = true;
            k mVar = new m((System.currentTimeMillis() / 1000), i, i2);
            g.Dr();
            g.Dp().gRu.a(mVar, 0);
            boolean dg = com.tencent.mm.plugin.offline.c.a.dg(ad.getContext());
            boolean isNetworkConnected = ao.isNetworkConnected(ad.getContext());
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(4);
            objArr[1] = Integer.valueOf(dg ? 0 : 1);
            objArr[2] = Integer.valueOf(isNetworkConnected ? 1 : 0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(i);
            if (k.pbH) {
                i3 = 1;
            }
            objArr[5] = Integer.valueOf(i3);
            gVar.h(14163, objArr);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(isNetworkConnected ? 36 : 37);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(dg ? 38 : 39);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(k.pbH ? 40 : 41);
            arrayList.add(iDKey);
            IDKey iDKey2;
            if (i == 2) {
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(k.pbH ? 42 : 43);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(dg ? 44 : 45);
                arrayList.add(iDKey);
                iDKey2 = new IDKey();
                iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey2.SetValue(1);
                iDKey2.SetKey(isNetworkConnected ? 46 : 47);
                arrayList.add(iDKey2);
            } else if (i == 6) {
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(k.pbH ? 48 : 49);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(dg ? 50 : 51);
                arrayList.add(iDKey);
                iDKey2 = new IDKey();
                iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey2.SetValue(1);
                iDKey2.SetKey(isNetworkConnected ? 52 : 53);
                arrayList.add(iDKey2);
            } else if (i == 6) {
                IDKey iDKey3 = new IDKey();
                iDKey3.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
                iDKey3.SetValue(1);
                iDKey3.SetKey(dg ? 54 : 55);
                arrayList.add(iDKey3);
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(arrayList, true);
        }
    }

    public final void a(int r10, int r11, java.lang.String r12, com.tencent.mm.ad.k r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r3 = 135; // 0x87 float:1.89E-43 double:6.67E-322;
        r0 = 6;
        r8 = 2;
        r7 = 1;
        r6 = 0;
        r1 = r13 instanceof com.tencent.mm.plugin.offline.a.h;
        if (r1 != 0) goto L_0x000f;
    L_0x000a:
        r1 = r13 instanceof com.tencent.mm.plugin.offline.a.f;
        if (r1 != 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = r13 instanceof com.tencent.mm.plugin.offline.a.m;
        if (r2 == 0) goto L_0x0048;
    L_0x0018:
        r2 = new com.tencent.mars.smc.IDKey;
        r2.<init>();
        r2.SetID(r3);
        r4 = 1;
        r2.SetValue(r4);
        r2.SetKey(r8);
        r1.add(r2);
        if (r10 != 0) goto L_0x002f;
    L_0x002d:
        if (r11 == 0) goto L_0x0043;
    L_0x002f:
        r2 = new com.tencent.mars.smc.IDKey;
        r2.<init>();
        r2.SetID(r3);
        r4 = 1;
        r2.SetValue(r4);
        r3 = 3;
        r2.SetKey(r3);
        r1.add(r2);
    L_0x0043:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r2.a(r1, r7);
    L_0x0048:
        r1 = r13 instanceof com.tencent.mm.plugin.offline.a.f;
        if (r1 == 0) goto L_0x0081;
    L_0x004c:
        if (r10 != 0) goto L_0x0050;
    L_0x004e:
        if (r11 == 0) goto L_0x0052;
    L_0x0050:
        if (r10 == 0) goto L_0x0081;
    L_0x0052:
        r1 = "MicroMsg.OfflineTokensMgr";
        r2 = "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d";
        r3 = new java.lang.Object[r8];
        r4 = java.lang.Integer.valueOf(r10);
        r3[r6] = r4;
        r4 = java.lang.Integer.valueOf(r11);
        r3[r7] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        r1 = r9.pbu;
        if (r1 == 0) goto L_0x0081;
    L_0x006d:
        r1 = r9.pbu;
        r1 = r1.bhK();
        r2 = 0;
        r9.pbu = r2;
        if (r1 == 0) goto L_0x0081;
    L_0x0078:
        r1 = r9.pbt;
        if (r1 == 0) goto L_0x0081;
    L_0x007c:
        r1 = r9.pbt;
        r1.bhx();
    L_0x0081:
        if (r10 != 0) goto L_0x00d6;
    L_0x0083:
        if (r11 != 0) goto L_0x00d6;
    L_0x0085:
        r0 = r13 instanceof com.tencent.mm.plugin.offline.a.m;
        if (r0 == 0) goto L_0x00b9;
    L_0x0089:
        r9.pbr = r6;
        r9.pbo = r6;
        r0 = r9.mHandler;
        r1 = r9.pbv;
        r0.removeCallbacks(r1);
        r13 = (com.tencent.mm.plugin.offline.a.m) r13;
        r9.pbu = r13;
        r0 = r9.pbu;
        r0 = r0.pcu;
        com.tencent.mm.plugin.offline.k.bhD();
        r1 = 196617; // 0x30009 float:2.75519E-40 double:9.71417E-319;
        r1 = com.tencent.mm.plugin.offline.k.uF(r1);
        r2 = new com.tencent.mm.plugin.offline.a.f;
        r2.<init>(r0, r1);
        com.tencent.mm.kernel.g.Dr();
        r0 = com.tencent.mm.kernel.g.Dp();
        r0 = r0.gRu;
        r0.a(r2, r6);
        goto L_0x000e;
    L_0x00b9:
        r0 = r13 instanceof com.tencent.mm.plugin.offline.a.l;
        if (r0 == 0) goto L_0x00d0;
    L_0x00bd:
        r9.pbp = r6;
        r13 = (com.tencent.mm.plugin.offline.a.l) r13;
        r0 = r13.pbs;
        r9.pbs = r0;
        r0 = r9.pbt;
        if (r0 == 0) goto L_0x000e;
    L_0x00c9:
        r0 = r9.pbt;
        r0.bhx();
        goto L_0x000e;
    L_0x00d0:
        r0 = r13 instanceof com.tencent.mm.plugin.offline.a.f;
        if (r0 == 0) goto L_0x000e;
    L_0x00d4:
        goto L_0x000e;
    L_0x00d6:
        r1 = r13 instanceof com.tencent.mm.plugin.offline.a.m;
        if (r1 == 0) goto L_0x0126;
    L_0x00da:
        r1 = "MicroMsg.OfflineTokensMgr";
        r2 = "gettoken is failed!";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
        r1 = r9.pbr;
        r1 = r1 + 1;
        r9.pbr = r1;
        r9.pbo = r6;
        r1 = 411; // 0x19b float:5.76E-43 double:2.03E-321;
        if (r11 != r1) goto L_0x00fd;
    L_0x00ef:
        r0 = "MicroMsg.OfflineTokensMgr";
        r1 = "errcode is  411, do clearAllOfflineData";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        com.tencent.mm.plugin.offline.c.a.biy();
        goto L_0x000e;
    L_0x00fd:
        r1 = r9.pbr;
        r2 = r9.pbq;
        if (r1 >= r2) goto L_0x000e;
    L_0x0103:
        r1 = r9.mHandler;
        r2 = r9.pbv;
        r1.removeCallbacks(r2);
        r1 = r9.pbr;
        r1 = r1 + -1;
        if (r1 <= r0) goto L_0x0137;
    L_0x0110:
        r2 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r0 = (double) r0;
        r0 = java.lang.Math.pow(r2, r0);
        r0 = (int) r0;
        r1 = r9.mHandler;
        r2 = r9.pbv;
        r0 = r0 * 60;
        r0 = r0 * 1000;
        r4 = (long) r0;
        r1.postDelayed(r2, r4);
        goto L_0x000e;
    L_0x0126:
        r0 = r13 instanceof com.tencent.mm.plugin.offline.a.l;
        if (r0 == 0) goto L_0x012e;
    L_0x012a:
        r9.pbp = r6;
        goto L_0x000e;
    L_0x012e:
        r0 = r13 instanceof com.tencent.mm.plugin.offline.a.f;
        if (r0 == 0) goto L_0x000e;
    L_0x0132:
        r0 = 0;
        r9.pbu = r0;
        goto L_0x000e;
    L_0x0137:
        r0 = r1;
        goto L_0x0110;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.offline.i.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }
}

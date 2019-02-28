package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.f.a.cw;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.e;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.HashMap;

public final class d {
    private static int lQr = 0;
    public c lQm;
    private w lQn;
    HashMap<Long, al> lQo;
    HashMap<Long, al> lQp;
    HashMap<Long, Integer> lQq;
    j lQs = null;
    private Object lQt = new Object();

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ String lQy;
        final /* synthetic */ boolean lQz;

        AnonymousClass5(String str, boolean z) {
            this.lQy = str;
            this.lQz = z;
        }

        public final void run() {
            if (d.this.lQm == null) {
                d.this.lQm = new c();
                d.this.lQm.lVO = new a() {
                    public final void onServiceConnected() {
                        d.this.lQm.lVO = null;
                        e.aFj().ai(AnonymousClass5.this.lQy, AnonymousClass5.this.lQz);
                        synchronized (d.this.lQt) {
                            d.this.lQt.notify();
                        }
                    }
                };
                d.this.lQm.cy(ad.getContext());
                synchronized (d.this.lQt) {
                    try {
                        d.this.lQt.wait();
                    } catch (Throwable e) {
                        x.e("MicroMsg.exdevice.ExdeviceConnectManager", "mSyncLock.wait failed!!!, %s", e.getMessage());
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectManager", e, "", new Object[0]);
                    }
                }
                return;
            }
            e.aFj().ai(this.lQy, this.lQz);
        }

        public final String toString() {
            return super.toString() + "|ranging";
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$11 */
    class AnonymousClass11 extends a {
        AnonymousClass11(int i) {
            super(0);
        }

        public final void onServiceConnected() {
            x.d("MicroMsg.exdevice.ExdeviceConnectManager", "onServiceConnected");
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$2 */
    class AnonymousClass2 extends a {
        final /* synthetic */ j lQv;

        AnonymousClass2(j jVar) {
            this.lQv = jVar;
            super(0);
        }

        public final void onServiceConnected() {
            if (!u.aFt().lQh.a(this.lQv)) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$3 */
    class AnonymousClass3 extends a {
        final /* synthetic */ long kDp;
        final /* synthetic */ k lQw;

        AnonymousClass3(long j, k kVar) {
            this.kDp = j;
            this.lQw = kVar;
            super(0);
        }

        public final void onServiceConnected() {
            if (!u.aFt().lQh.a(this.kDp, this.lQw)) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.d$4 */
    class AnonymousClass4 extends a {
        final /* synthetic */ Runnable lQx;

        public AnonymousClass4(Runnable runnable) {
            this.lQx = runnable;
            super(0);
        }

        public final void onServiceConnected() {
            this.lQx.run();
        }
    }

    public d() {
        if (this.lQn == null) {
            this.lQn = new w() {
                public final void a(long j, int i, int i2, int i3, long j2) {
                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", b.cL(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    if (ad.getContext() == null) {
                        x.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
                        return;
                    }
                    if (4 == i2) {
                        u.aFs().cD(j);
                        long[] zK = com.tencent.mm.plugin.exdevice.h.a.zK("shut_down_device");
                        if (!(zK == null || zK.length == 0)) {
                            for (long j3 : zK) {
                                if (j3 == j) {
                                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", Long.valueOf(j3));
                                    d.co(j3);
                                    if (!com.tencent.mm.plugin.exdevice.h.a.A("shut_down_device", j3)) {
                                        x.e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
                                    }
                                }
                            }
                        }
                        if (d.this.lQq.get(Long.valueOf(j)) != null) {
                            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", d.this.lQq.get(Long.valueOf(j)));
                            com.tencent.mm.sdk.b.b cwVar = new cw();
                            com.tencent.mm.sdk.b.a.xmy.m(cwVar);
                            if (!(cwVar.frY.fhM && (((Integer) d.this.lQq.get(Long.valueOf(j))).intValue() & 1) == 1)) {
                                d.co(j);
                            }
                        } else {
                            d.co(j);
                        }
                    }
                    if (i != i2) {
                        com.tencent.mm.plugin.exdevice.h.b zL = ad.aER().zL(String.valueOf(j));
                        if (zL == null || bi.oN(zL.field_brandName)) {
                            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", Long.valueOf(j));
                            return;
                        }
                        f.a cA = u.aFs().cA(j);
                        if (cA != null) {
                            cA.ftb = i2;
                        } else {
                            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", Long.valueOf(j));
                        }
                        if (i2 == 2) {
                            x.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                            return;
                        }
                        ad.aFc();
                        e.e(zL.field_brandName, zL.field_url, i2, zL.field_deviceID);
                    }
                }
            };
        }
        this.lQo = new HashMap();
        this.lQp = new HashMap();
        this.lQq = new HashMap();
    }

    public static int aEz() {
        return lQr;
    }

    public final synchronized void ps(int i) {
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", Integer.valueOf(i));
        lQr = i;
    }

    public final synchronized void a(Long l, int i) {
        this.lQq.put(l, Integer.valueOf(i));
    }

    public final void a(String str, long j, int i) {
        a(str, j, i, false);
    }

    public final void a(String str, long j, int i, boolean z) {
        com.tencent.mm.plugin.exdevice.h.a.A("shut_down_device", j);
        final String str2;
        final long j2;
        final boolean z2;
        if (this.lQm == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
            this.lQm = new c();
            str2 = str;
            j2 = j;
            z2 = z;
            this.lQm.lVO = new a(i) {
                public final void onServiceConnected() {
                    d.this.lQm.lVO = null;
                    d.this.b(str2, j2, this.ftr, z2);
                }
            };
            this.lQm.cy(ad.getContext());
        } else if (this.lQm == null || this.lQm.lVP) {
            b(str, j, i, z);
        } else {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
            str2 = str;
            j2 = j;
            z2 = z;
            this.lQm.lVO = new a(i) {
                public final void onServiceConnected() {
                    d.this.lQm.lVO = null;
                    d.this.b(str2, j2, this.ftr, z2);
                }
            };
            this.lQm.cy(ad.getContext());
        }
    }

    public final void b(String str, long j, int i, boolean z) {
        boolean b;
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
        if (z) {
            b = b(str, j, i);
        } else if (as.CN().Ks() != 4) {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            b = false;
        } else {
            if (this.lQo.containsKey(Long.valueOf(j))) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", str, Long.valueOf(j), Integer.valueOf(i));
                al alVar = (al) this.lQo.get(Long.valueOf(j));
                alVar.TN();
                alVar.K(30000, 30000);
            } else {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", str, Long.valueOf(j), Integer.valueOf(i));
                final long j2 = j;
                final String str2 = str;
                final int i2 = i;
                al alVar2 = new al(Looper.getMainLooper(), new al.a() {
                    public final boolean uG() {
                        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", str2, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(u.aFs().cz(j2)));
                        if (u.aFs().cz(j2) != 2) {
                            ad.aFc();
                            e.bi(str2, 2);
                        }
                        d.this.lQo.remove(Long.valueOf(j2));
                        return false;
                    }
                }, false);
                alVar2.K(30000, 30000);
                this.lQo.put(Long.valueOf(j), alVar2);
            }
            if (u.aFt().lQh == null) {
                x.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", str, Long.valueOf(j), Integer.valueOf(i));
                b = false;
            } else {
                f.a cA = u.aFs().cA(j);
                if (cA == null) {
                    x.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", Long.valueOf(j));
                    b = false;
                } else {
                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", Integer.valueOf(cA.ftb));
                    if (!(cA.ftb == 2 || cA.ftb == 1)) {
                        u.aFt().lQh.a(j, i, this.lQn);
                    }
                    b = true;
                }
            }
        }
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", Boolean.valueOf(b));
    }

    public static void co(long j) {
        if (u.aFt().lQh != null) {
            boolean cG = u.aFt().lQh.cG(j);
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", Long.valueOf(j), Boolean.valueOf(cG));
        }
    }

    public final void aEA() {
        if (this.lQm != null && this.lQm.lVP) {
            try {
                ad.getContext().unbindService(this.lQm);
            } catch (Exception e) {
            }
        }
    }

    private synchronized boolean b(String str, long j, int i) {
        boolean z;
        int Ks = as.CN().Ks();
        if (Ks != 4 && Ks != 6) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            z = false;
        } else if (this.lQp.containsKey(Long.valueOf(j))) {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", str, Long.valueOf(j));
            z = false;
        } else {
            final long j2 = j;
            final String str2 = str;
            final int i2 = i;
            al alVar = new al(Looper.getMainLooper(), new al.a() {
                public final boolean uG() {
                    int cz = u.aFs().cz(j2);
                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", str2, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(cz));
                    d.co(j2);
                    d.this.lQp.remove(Long.valueOf(j2));
                    return false;
                }
            }, false);
            long aGf = b.aGf();
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", Long.valueOf(aGf));
            alVar.K(aGf, aGf);
            this.lQp.put(Long.valueOf(j), alVar);
            if (u.aFt().lQh != null) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", str, Long.valueOf(j));
                z = u.aFt().lQh.a(j, i, this.lQn);
            } else {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
                z = false;
            }
        }
        return z;
    }

    public static boolean eK(boolean z) {
        if (u.aFt().lQh != null) {
            long[] aFg = u.aFt().lQh.aFg();
            if (aFg == null || aFg.length <= 0) {
                x.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
                return false;
            }
            for (long j : aFg) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", Long.valueOf(j));
                com.tencent.mm.plugin.exdevice.h.b cK = ad.aER().cK(j);
                if (cK == null) {
                    x.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", Long.valueOf(j));
                } else if (z && (cK.field_closeStrategy & 1) == 0) {
                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", Long.valueOf(j));
                } else {
                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", Long.valueOf(j));
                    u.aFt().lQh.cG(j);
                }
            }
            return true;
        }
        x.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
        return false;
    }

    public final void a(final int i, j jVar) {
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", Integer.valueOf(i));
        if (jVar == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
            return;
        }
        this.lQs = jVar;
        if (this.lQm == null) {
            this.lQm = new c();
            this.lQm.lVO = new a(i) {
                public final void onServiceConnected() {
                    if (!u.aFt().lQh.b(i, d.this.lQs)) {
                        x.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
                    }
                }
            };
            this.lQm.cy(ad.getContext());
            return;
        }
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (u.aFt().lQh == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else if (!u.aFt().lQh.b(i, this.lQs)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
    }
}

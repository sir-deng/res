package com.tencent.mm.modelcdntran;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ad.c;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.protocal.c.jx;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class g implements ap {
    private b huQ = null;
    private c huR = null;
    private c huS;
    private long huT = 0;
    private ag huU = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message.what == 1 && g.this.huT != 0) {
                x.i("MicroMsg.SubCoreCdnTransport", "try get dns again scene[%d] lastGetDnsErrorTime[%d]  diff[%d]", Integer.valueOf(message.arg1), Long.valueOf(g.this.huT), Long.valueOf(bi.bA(g.this.huT)));
                com.tencent.mm.kernel.g.CN().a(new e(r0), 0);
            }
        }
    };
    private e huV = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            if (kVar instanceof e) {
                x.i("MicroMsg.SubCoreCdnTransport", "%d get cdn dns on scene end errType[%d] errCode[%d] errMsg[%s] lastGetDnsErrorTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(g.this.huT));
                if ("doScene failed".equals(str)) {
                    x.d("MicroMsg.SubCoreCdnTransport", "%d get cdn dns cache do nothing.", Integer.valueOf(hashCode()));
                    return;
                }
                com.tencent.mm.plugin.report.service.g.pWK.a(546, (long) (i + 10), 1, true);
                if (i == 0) {
                    if (g.this.huT > 0) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(546, 52, 1, true);
                        g.this.huT = 0;
                        return;
                    }
                    return;
                } else if (i == 4) {
                    return;
                } else {
                    if (g.this.huT == 0) {
                        int i3 = ((e) kVar).scene;
                        g.this.huT = bi.Wy();
                        g.this.huU.removeMessages(1);
                        g.this.huU.sendMessageDelayed(g.this.huU.obtainMessage(1, i3, 0), 30000);
                        com.tencent.mm.plugin.report.service.g.pWK.a(546, 50, 1, true);
                        return;
                    }
                    g.this.huT = 0;
                    com.tencent.mm.plugin.report.service.g.pWK.a(546, 51, 1, true);
                    return;
                }
            }
            x.w("MicroMsg.SubCoreCdnTransport", "get cdn dns on scene end but is not [NetSceneGetCdnDns]");
        }
    };

    public static g MM() {
        return (g) p.s(g.class);
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public static String MN() {
        com.tencent.mm.kernel.g.Do().CA();
        return com.tencent.mm.kernel.g.Dq().cachePath + "cdndnsinfo/";
    }

    public final void bt(boolean z) {
    }

    public static c MO() {
        return MM().huS;
    }

    public final void bs(boolean z) {
        onAccountRelease();
        com.tencent.mm.kernel.g.Do().CA();
        if (MM().huR == null) {
            MM().huR = new c();
            x.i("MicroMsg.SubCoreCdnTransport", "summersafecdn onAccountPostReset new CdnTransportService hash[%s]", Integer.valueOf(MM().huR.hashCode()));
        }
        File file = new File(MN());
        if (!file.exists()) {
            file.mkdir();
        }
        this.huS = new c() {
            public final void a(jx jxVar, jx jxVar2, jx jxVar3) {
                x.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + jxVar.toString() + " getCore().engine:" + g.MQ());
                if (g.MQ() != null) {
                    g.MQ().a(jxVar, jxVar2, jxVar3, null, null, null);
                    com.tencent.mm.kernel.g.Dt().F(new Runnable() {
                        public final void run() {
                            if (g.MP() != null) {
                                g.MP().bL(false);
                            }
                        }

                        public final String toString() {
                            return super.toString() + "|infoUpdate";
                        }
                    });
                }
            }
        };
        com.tencent.mm.kernel.g.CN().a(379, this.huV);
    }

    public static c MP() {
        if (MM().huR == null) {
            synchronized (g.class) {
                if (MM().huR == null) {
                    MM().huR = new c();
                }
            }
        }
        return MM().huR;
    }

    public static b MQ() {
        if (MM().huQ == null) {
            com.tencent.mm.kernel.g.Do();
            if (a.CE()) {
                MM().huQ = new b(com.tencent.mm.kernel.g.Dq().cachePath, MP());
            } else {
                x.v("MicroMsg.SubCoreCdnTransport", "hy: cdn temp path: %s", w.hbv + com.tencent.mm.a.g.s(("mm" + new Random().nextLong()).getBytes()) + "/");
                MM().huQ = new b(r0, MP());
            }
        }
        return MM().huQ;
    }

    public final void onAccountRelease() {
        this.huS = null;
        if (this.huQ != null) {
            b bVar = this.huQ;
            CdnLogic.setCallBack(null);
            bVar.htT = null;
            this.huQ = null;
        }
        if (this.huR != null) {
            e eVar = this.huR;
            if (com.tencent.mm.kernel.g.Do().CF()) {
                com.tencent.mm.kernel.g.Dq().Db().b(eVar);
            }
            eVar.hua.removeCallbacksAndMessages(null);
            com.tencent.mm.kernel.g.Dp().b(eVar.huc);
            com.tencent.mm.kernel.g.Dp().gRu.b(379, eVar);
            com.tencent.mm.sdk.b.a.xmy.c(eVar.hub);
            this.huR = null;
        }
        this.huT = 0;
        this.huU.removeCallbacksAndMessages(null);
        com.tencent.mm.kernel.g.CN().b(379, this.huV);
    }

    public final void MR() {
        hy(0);
    }

    public final void hy(int i) {
        this.huT = 0;
        this.huU.removeMessages(1);
        com.tencent.mm.kernel.g.CN().a(new e(i), 0);
    }
}

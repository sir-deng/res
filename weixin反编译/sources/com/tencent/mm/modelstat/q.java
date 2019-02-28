package com.tencent.mm.modelstat;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.cc.c;
import com.tencent.mm.cc.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.network.x;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;
import java.util.HashMap;

public class q implements ap {
    private static HashMap<Integer, d> gyG;
    private l hUC = new l();
    private h<m> hUD = new h(new c<m>() {
        public final /* synthetic */ Object get() {
            return new m(g.Dq().gRU);
        }
    });
    private x hUE = new x();
    private h<g> hUF = new h(new c<g>() {
        public final /* synthetic */ Object get() {
            return new g(w.hbv);
        }
    });
    private n huc = new a() {
        public final void eq(int i) {
            if (i == 4 || i == 6) {
                g.Dt().g(new Runnable() {
                    public final void run() {
                        if (g.Do().CF()) {
                            q.Tl().Tc();
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|onNetworkChange";
                    }
                }, 3000);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", Integer.valueOf(i));
                o.iF(2);
            }
        }
    };

    public static g Tl() {
        g.Do().CA();
        return (g) Tm().hUF.get();
    }

    private static q Tm() {
        return (q) p.s(q.class);
    }

    public static m Tn() {
        g.Do().CA();
        return (m) Tm().hUD.get();
    }

    public static void e(e eVar) {
        boolean z;
        String str = "MicroMsg.SubCoreStat";
        String str2 = "dknetstat setNetworkMoniter  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        if (eVar == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = bi.chl();
        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
        if (eVar != null) {
            eVar.a(Tm().hUC);
        }
    }

    public static void f(e eVar) {
        String str = "MicroMsg.SubCoreStat";
        String str2 = "setKVReportMonitor  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(eVar == null);
        objArr[1] = bi.chl();
        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
        if (eVar != null) {
            eVar.a(Tm().hUE);
        }
    }

    public final void onAccountRelease() {
        g.Dp().b(this.huc);
        com.tencent.mm.ad.d.c.b(Integer.valueOf(9998), this.hUC);
        this.hUC = new l();
        ak.a.hhw = null;
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return m.gLy;
            }
        });
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.ad.d.c.a(Integer.valueOf(9998), this.hUC);
        g.Dp().a(this.huc);
        ak.a.hhw = new ak.e() {
            public final void aV(int i, int i2) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), bi.chl());
                n.A(i, i2, 0);
            }
        };
    }

    public final void bt(boolean z) {
    }
}

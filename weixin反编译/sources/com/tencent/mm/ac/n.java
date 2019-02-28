package com.tencent.mm.ac;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.ac.d.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;
import com.tencent.mm.y.q;
import java.util.HashMap;

public class n implements ap {
    private static HashMap<Integer, d> gyG;
    private d hnA;
    private c hnB;
    private g hnC;
    private String hnD;
    private al hnE = new al(g.Dt().oFY.getLooper(), new a() {
        public final boolean uG() {
            if (!g.Do().CF() || n.JF() == null) {
                x.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", Boolean.valueOf(g.Do().CF()), n.JF());
            } else {
                if (((Boolean) g.Dq().Db().get(90113, Boolean.valueOf(false))).booleanValue()) {
                    n.Ka();
                    n.JZ();
                }
                g.Dq().Db().set(90113, Boolean.valueOf(false));
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|upAssetsHandler";
        }
    }, false);
    private i hnz;

    static /* synthetic */ void Ka() {
        try {
            Context context = ad.getContext();
            for (String str : d.hmI.keySet()) {
                int intValue = d.hmI.containsKey(str) ? ((Integer) d.hmI.get(str)).intValue() : 0;
                if (intValue != 0) {
                    x.d("MicroMsg.SubCoreAvatar", "updateAssetsAvatar user:%s ", str);
                    JF().e(str, com.tencent.mm.compatible.g.a.decodeResource(context.getResources(), intValue));
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.SubCoreAvatar", "exception:%s", bi.i(e));
        }
    }

    public static n JV() {
        return (n) p.s(n.class);
    }

    public static i JW() {
        g.Do().CA();
        if (JV().hnz == null) {
            JV().hnz = new i(g.Dq().gRU);
        }
        return JV().hnz;
    }

    public static d JF() {
        g.Do().CA();
        if (JV().hnA == null) {
            JV().hnA = new d();
        }
        return JV().hnA;
    }

    public static g JX() {
        g.Do().CA();
        if (JV().hnC == null) {
            JV().hnC = new g(g.Dq().gRU);
        }
        return JV().hnC;
    }

    public static c JY() {
        g.Do().CA();
        if (JV().hnB == null) {
            JV().hnB = new c();
        }
        return JV().hnB;
    }

    public final void onAccountRelease() {
        this.hnE.TN();
        if (JV().hnA != null) {
            d.reset();
        }
        e eVar = JV().hnB;
        if (eVar != null) {
            g.CN().b(123, eVar);
        }
        i iVar = JV().hnz;
        if (iVar != null) {
            iVar.hnl.clear();
        }
        if (this.hnD != null) {
            FileOp.mb(this.hnD);
            this.hnD = null;
        }
    }

    public final void ge(int i) {
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return i.gLy;
            }
        });
        gyG.put(Integer.valueOf("HDHEADIMGINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return g.gLy;
            }
        });
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void bs(boolean z) {
        FileOp.ml(g.Dq().gRT + "sfs");
        this.hnD = com.tencent.mm.plugin.f.a.aoL();
        FileOp.a(this.hnD, null, new Builder().setDBDirectory(g.Dq().cachePath + "sfs").setStoragePath(c.FF()).setName("avatar"));
        if (z) {
            x.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
            g.Dq().Db().set(90113, Boolean.valueOf(true));
            try {
                String FY = q.FY();
                d JF = JF();
                d.y(FY, false);
                d.y(FY, true);
                JF.d(FY, null);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SubCoreAvatar", e, "Failed to refresh avatar.", new Object[0]);
            }
        }
        this.hnE.K(10000, 10000);
    }

    static Context getContext() {
        return ad.getContext();
    }

    public final void bt(boolean z) {
        if (this.hnD != null) {
            FileOp.mb(this.hnD);
            this.hnD = com.tencent.mm.plugin.f.a.aoL();
            FileOp.a(this.hnD, null, new Builder().setDBDirectory(g.Dq().cachePath + "sfs").setStoragePath(c.FF()).setName("avatar"));
        }
    }

    public static boolean JZ() {
        if (bi.a((Boolean) g.Dq().Db().get(59, null), false)) {
            return true;
        }
        boolean z;
        JF();
        String x = d.x(q.FY(), false);
        if (FileOp.bO(x) || FileOp.bO(x + ".bm")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        x = q.FY();
        if (bi.oN(x)) {
            return false;
        }
        Bitmap jm = b.jm(c.Fp() + "user_" + com.tencent.mm.a.g.s(x.getBytes()) + ".png");
        if (jm == null || jm.isRecycled()) {
            return false;
        }
        return JF().e(x, jm);
    }
}

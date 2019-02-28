package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.bg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.b.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import java.util.HashMap;

public final class b implements ap {
    private static b sBS = null;
    private a sBT = new a();
    private d sBU = new d();
    private c sBV = new c();
    private com.tencent.mm.plugin.voip_cs.a.a sBW = new com.tencent.mm.plugin.voip_cs.a.a();
    private c sBX = new c<bg>() {
        {
            this.xmG = bg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z = true;
            bg bgVar = (bg) bVar;
            if (bgVar instanceof bg) {
                bg.a aVar = bgVar.fqq;
                if (!(b.bJD().sDa == 1 || b.bJD().sDa == 2)) {
                    z = false;
                }
                aVar.fds = z;
            }
            return false;
        }
    };

    private static b bJB() {
        if (sBS == null) {
            sBS = new b();
            as.Hg().a("plugin.voip_cs", sBS);
        }
        return sBS;
    }

    public static a bJC() {
        return bJB().sBT;
    }

    public static d bJD() {
        g.Do().CA();
        if (bJB().sBU == null) {
            bJB().sBU = new d();
        }
        return bJB().sBU;
    }

    public static c bJE() {
        return bJB().sBV;
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        x.d("MicroMsg.SubCoreVoipCS", "now account reset!");
        com.tencent.mm.sdk.b.a.xmy.b(this.sBW);
        com.tencent.mm.sdk.b.a.xmy.b(this.sBX);
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xmy.c(this.sBW);
        com.tencent.mm.sdk.b.a.xmy.c(this.sBX);
    }
}

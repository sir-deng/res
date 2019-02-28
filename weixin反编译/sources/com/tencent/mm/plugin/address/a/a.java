package com.tencent.mm.plugin.address.a;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.c;
import java.util.HashMap;

public final class a implements ap {
    private l iog = null;
    private com.tencent.mm.plugin.address.b.a.a ioh = null;
    private j ioi = new j();
    private k ioj = new k();

    public static a XN() {
        as.Hg();
        a aVar = (a) bq.ib("plugin.address");
        if (aVar != null) {
            return aVar;
        }
        x.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
        Object aVar2 = new a();
        as.Hg().a("plugin.address", aVar2);
        return aVar2;
    }

    public static com.tencent.mm.plugin.address.b.a.a XO() {
        g.Do().CA();
        if (XN().ioh == null) {
            XN().ioh = new com.tencent.mm.plugin.address.b.a.a();
        }
        return XN().ioh;
    }

    public static l XP() {
        g.Do().CA();
        if (XN().iog == null) {
            XN().iog = new l();
        }
        return XN().iog;
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.sdk.b.a.xmy.b(this.ioi);
        com.tencent.mm.sdk.b.a.xmy.b(this.ioj);
        l XP = XP();
        as.Hm();
        XP.path = c.FJ() + "addrmgr";
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xmy.c(this.ioi);
        com.tencent.mm.sdk.b.a.xmy.c(this.ioj);
    }
}

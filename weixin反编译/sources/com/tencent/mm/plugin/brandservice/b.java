package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.pa;
import com.tencent.mm.plugin.brandservice.a.l;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import java.util.HashMap;

public final class b implements ap {
    private a kKn;

    public static class a extends c<pa> {
        public a() {
            this.xmG = pa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            pa paVar = (pa) bVar;
            if (paVar instanceof pa) {
                if (!(paVar.fHL == null || bi.oN(paVar.fHL.fGc) || paVar.fHL.fHM == null)) {
                    as.CN().a(new l(paVar.fHL.fGc, paVar.fHL.fHM), 0);
                }
                return true;
            }
            x.f("MicroMsg.BrandService.SubCoreBrandService", "mismatched event");
            return false;
        }
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public final void bs(boolean z) {
        x.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
        if (this.kKn == null) {
            this.kKn = new a();
        }
        com.tencent.mm.sdk.b.a.xmy.b(this.kKn);
        h.a(new com.tencent.mm.plugin.brandservice.ui.a.d());
        h.a(new com.tencent.mm.plugin.brandservice.ui.a.b());
    }

    public final void onAccountRelease() {
        if (this.kKn != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.kKn);
        }
        h.qz(96);
        h.qz(4192);
    }
}

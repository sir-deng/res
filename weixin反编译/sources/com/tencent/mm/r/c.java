package com.tencent.mm.r;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import java.util.HashMap;

public final class c implements ap {
    private static c gNy;
    private a gNz;

    private c() {
        if (a.gNe == null) {
            a.gNe = new a();
        }
        this.gNz = a.gNe;
    }

    public final void onAccountRelease() {
        a aVar = this.gNz;
        aVar.gNg.clear();
        b bVar = aVar.gNf;
        x.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
        bVar.gNo.clear();
        bVar.gNq.clear();
        bVar.gNp.clear();
        bVar.gNr.clear();
        aVar.initialized = false;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        this.gNz.init();
    }

    public final void bt(boolean z) {
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public static a Bx() {
        g.Do().CA();
        if (gNy == null) {
            c cVar = new c();
            gNy = cVar;
            cVar.gNz.init();
        }
        return gNy.gNz;
    }
}

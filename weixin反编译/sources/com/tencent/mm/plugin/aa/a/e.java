package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a.h;
import com.tencent.mm.vending.c.b;

public final class e implements b<d> {
    protected d iiN;
    public final a iiO;

    public class a implements com.tencent.mm.vending.h.e<Void, Void> {
        public final /* synthetic */ Object call(Object obj) {
            d dVar = e.this.iiN;
            k hVar = new h();
            g.Dr();
            g.Dp().gRu.a(hVar, 0);
            dVar.iiC = com.tencent.mm.vending.g.g.cAO();
            return zLb;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object WM() {
        return this.iiN;
    }

    public e() {
        this(new d());
    }

    private e(d dVar) {
        this.iiO = new a();
        this.iiN = dVar;
    }

    public final d WQ() {
        return this.iiN;
    }
}

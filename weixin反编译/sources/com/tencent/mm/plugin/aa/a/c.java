package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a.j;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;

public final class c implements b<b> {
    protected b iiD;
    public final a iiE;

    public class a implements e<v, f<String, Integer, String, String, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            f fVar = (f) obj;
            b bVar = c.this.iiD;
            k jVar = new j((String) fVar.get(0), ((Integer) fVar.get(1)).intValue(), (String) fVar.get(2), (String) fVar.get(3), ((Integer) fVar.get(4)).intValue());
            g.Dr();
            g.Dp().gRu.a(jVar, 0);
            bVar.iiC = com.tencent.mm.vending.g.g.cAO();
            return null;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object WM() {
        return this.iiD;
    }

    public c() {
        this(new b());
    }

    private c(b bVar) {
        this.iiE = new a();
        this.iiD = bVar;
    }

    public final b WL() {
        return this.iiD;
    }
}

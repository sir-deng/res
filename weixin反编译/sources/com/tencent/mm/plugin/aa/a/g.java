package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;

public final class g implements b<f> {
    protected f iiR;
    public final a iiS;

    public class a implements e<c<String, String>, com.tencent.mm.vending.j.e<String, Long, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            f fVar = g.this.iiR;
            String str = (String) eVar.get(0);
            long longValue = ((Long) eVar.get(1)).longValue();
            int intValue = ((Integer) eVar.get(2)).intValue();
            String str2 = (String) eVar.get(3);
            if (fVar.iiQ) {
                x.e("MicroMsg.AAPayLogic", "aaPay, isPaying!");
            } else {
                k iVar = new i(str, longValue, intValue, str2);
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dp().gRu.a(iVar, 0);
                fVar.iiC = com.tencent.mm.vending.g.g.cAO();
                fVar.iiQ = true;
            }
            return null;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object WM() {
        return this.iiR;
    }

    public g() {
        this(new f());
    }

    private g(f fVar) {
        this.iiS = new a();
        this.iiR = fVar;
    }

    public final f WR() {
        return this.iiR;
    }
}

package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public final class j implements com.tencent.mm.vending.c.b<i> {
    protected i iiU;
    public final b iiV;
    public final a iiW;

    public class a implements e<Boolean, com.tencent.mm.vending.j.e<String, Integer, String, Long>> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            i iVar = j.this.iiU;
            String str = (String) eVar.get(0);
            int intValue = ((Integer) eVar.get(1)).intValue();
            String str2 = (String) eVar.get(2);
            long longValue = ((Long) eVar.get(3)).longValue();
            iVar.hnM = g.cAI();
            iVar.frh = longValue;
            if (bi.oN(str)) {
                iVar.hnM.cm(Boolean.valueOf(false));
            } else {
                k eVar2 = new com.tencent.mm.plugin.aa.a.a.e(str, intValue, str2);
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dp().gRu.a(eVar2, 0);
                x.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", str, Integer.valueOf(intValue));
                iVar.hnM = g.cAO();
            }
            return null;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public class b implements e<Boolean, d<String, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            d dVar = (d) obj;
            i iVar = j.this.iiU;
            String str = (String) dVar.get(0);
            int intValue = ((Integer) dVar.get(1)).intValue();
            String str2 = (String) dVar.get(2);
            iVar.hnM = g.cAI();
            if (bi.oN(str)) {
                iVar.hnM.cm(Boolean.valueOf(false));
            } else {
                k eVar = new com.tencent.mm.plugin.aa.a.a.e(str, intValue, str2);
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dp().gRu.a(eVar, 0);
                x.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", str, Integer.valueOf(intValue));
                iVar.hnM = g.cAO();
            }
            return null;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object WM() {
        return this.iiU;
    }

    public j() {
        this(new i());
    }

    private j(i iVar) {
        this.iiV = new b();
        this.iiW = new a();
        this.iiU = iVar;
    }

    public final i WU() {
        return this.iiU;
    }
}

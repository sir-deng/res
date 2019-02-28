package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.c.a.AnonymousClass1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import java.util.List;

public class b implements com.tencent.mm.vending.c.b<a> {
    protected a ijK;
    public final a ijL;

    public class a implements e<d<List, String, Boolean>, c<Boolean, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            int i;
            int i2 = 20;
            c cVar = (c) obj;
            a aVar = b.this.ijK;
            boolean booleanValue = ((Boolean) cVar.get(0)).booleanValue();
            int intValue = ((Integer) cVar.get(1)).intValue();
            if (!booleanValue || aVar.ijB <= 0) {
                i = 20;
            } else {
                i = aVar.ijB;
                aVar.ijB = 0;
                aVar.ijG = false;
            }
            if (aVar.ijH == intValue) {
                i2 = i;
            }
            aVar.ijH = intValue;
            x.i("MicroMsg.AAQueryListInteractor", "getNextAAQueryPage, currentPageOffset: %s, force: %s", Integer.valueOf(aVar.ijB), Boolean.valueOf(booleanValue));
            com.tencent.mm.vending.g.b cAI = g.cAI();
            cAI.cAH();
            (aVar.ijG ? new com.tencent.mm.plugin.aa.a.a.c(i2, aVar.ijB, intValue, aVar.ijC, aVar.ijD, aVar.ijE, aVar.ijF) : new com.tencent.mm.plugin.aa.a.a.c(i2, aVar.ijB, intValue)).Kb().g(new AnonymousClass1(cAI));
            return null;
        }

        public final String wE() {
            return "Vending.ANY";
        }
    }

    public final /* bridge */ /* synthetic */ Object WM() {
        return this.ijK;
    }

    public b() {
        this(new a());
    }

    private b(a aVar) {
        this.ijL = new a();
        this.ijK = aVar;
    }
}

package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class e extends i<com.tencent.tinker.a.a.e> {
    private a ApW = null;
    private com.tencent.tinker.a.a.i.e ApX = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cHr();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        return new com.tencent.tinker.a.a.e(eVar.dzH, aVar.b(eVar.Anz), aVar.b(eVar.AnA), aVar.b(eVar.AnB), aVar.b(eVar.AnC));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        a aVar = this.ApW;
        aVar.size++;
        return this.ApX.a(eVar);
    }

    public e(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.ApW = iVar2.Aof.AoL;
            this.ApX = iVar2.a(this.ApW);
        }
    }

    protected final a c(i iVar) {
        return iVar.Aof.AoL;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.Arh.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Arv.IS(i2);
        }
    }
}

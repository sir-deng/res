package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class j extends i<n> {
    private a Aqe = null;
    private e Aqf = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cHl();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        n nVar = (n) comparable;
        return new n(nVar.dzH, aVar.IW(nVar.Aou), aVar.IW(nVar.AnH), aVar.IV(nVar.Aov));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        n nVar = (n) comparable;
        a aVar = this.Aqe;
        aVar.size++;
        return this.Aqf.a(nVar);
    }

    public j(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Aqe = iVar2.Aof.AoE;
            this.Aqf = iVar2.a(this.Aqe);
        }
    }

    protected final a c(i iVar) {
        return iVar.Aof.AoE;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.AqZ.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.Arn.IS(i);
        }
    }
}

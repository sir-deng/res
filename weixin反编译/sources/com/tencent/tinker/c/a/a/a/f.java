package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class f extends i<com.tencent.tinker.a.a.f> {
    private a ApY = null;
    private e ApZ = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cHo();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.f fVar = (com.tencent.tinker.a.a.f) comparable;
        return new com.tencent.tinker.a.a.f(fVar.dzH, aVar.IW(fVar.AnH), fVar.AnE, aVar.IW(fVar.AnI), aVar.Ja(fVar.AnJ), aVar.IV(fVar.AnK), aVar.Je(fVar.AnL), aVar.Jg(fVar.AnM), aVar.Jf(fVar.AnN));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.f fVar = (com.tencent.tinker.a.a.f) comparable;
        a aVar = this.ApY;
        aVar.size++;
        return this.ApZ.a(fVar);
    }

    public f(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.ApY = iVar2.Aof.AoG;
            this.ApZ = iVar2.a(this.ApY);
        }
    }

    protected final a c(i iVar) {
        return iVar.Aof.AoG;
    }
}

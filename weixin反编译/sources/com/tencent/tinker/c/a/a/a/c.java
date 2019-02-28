package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.b;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;

public final class c extends i<b> {
    private a ApS = null;
    private e ApT = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cHt();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        b bVar = (b) comparable;
        int length = bVar.Ant.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = aVar.Jb(bVar.Ant[i]);
        }
        return new b(bVar.dzH, iArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        b bVar = (b) comparable;
        a aVar = this.ApS;
        aVar.size++;
        return this.ApT.a(bVar);
    }

    public c(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.c.a.c.c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.ApS = iVar2.Aof.AoK;
            this.ApT = iVar2.a(this.ApS);
        }
    }

    protected final a c(i iVar) {
        return iVar.Aof.AoK;
    }

    protected final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.Ard.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Arr.IS(i2);
        }
    }
}

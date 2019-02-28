package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;
import java.lang.reflect.Array;

public final class d extends i<com.tencent.tinker.a.a.d> {
    private a ApU = null;
    private e ApV = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cHv();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        int i;
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        int Jc = aVar.Jc(dVar.Anv);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.Anw.length, 2});
        for (i = 0; i < iArr.length; i++) {
            iArr[i][0] = aVar.IY(dVar.Anw[i][0]);
            iArr[i][1] = aVar.Jc(dVar.Anw[i][1]);
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.Anx.length, 2});
        for (i = 0; i < iArr2.length; i++) {
            iArr2[i][0] = aVar.IZ(dVar.Anx[i][0]);
            iArr2[i][1] = aVar.Jc(dVar.Anx[i][1]);
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.Any.length, 2});
        for (i = 0; i < iArr3.length; i++) {
            iArr3[i][0] = aVar.IZ(dVar.Any[i][0]);
            iArr3[i][1] = aVar.Jd(dVar.Any[i][1]);
        }
        return new com.tencent.tinker.a.a.d(dVar.dzH, Jc, iArr, iArr2, iArr3);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        a aVar = this.ApU;
        aVar.size++;
        return this.ApV.a(dVar);
    }

    public d(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.ApU = iVar2.Aof.AoR;
            this.ApV = iVar2.a(this.ApU);
        }
    }

    protected final a c(i iVar) {
        return iVar.Aof.AoR;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.Arf.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Art.IS(i2);
        }
    }
}

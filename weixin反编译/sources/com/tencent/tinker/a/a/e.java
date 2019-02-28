package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e extends com.tencent.tinker.a.a.t.a.a<e> {
    public a[] AnA;
    public b[] AnB;
    public b[] AnC;
    public a[] Anz;

    public static class a implements Comparable<a> {
        public int AnD;
        public int AnE;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            int fL = c.fL(this.AnD, aVar.AnD);
            return fL != 0 ? fL : c.fM(this.AnE, aVar.AnE);
        }

        public a(int i, int i2) {
            this.AnD = i;
            this.AnE = i2;
        }
    }

    public static class b implements Comparable<b> {
        public int AnE;
        public int AnF;
        public int AnG;

        public final /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            int fL = c.fL(this.AnF, bVar.AnF);
            if (fL != 0) {
                return fL;
            }
            fL = c.fM(this.AnE, bVar.AnE);
            return fL == 0 ? c.fM(this.AnG, bVar.AnG) : fL;
        }

        public b(int i, int i2, int i3) {
            this.AnF = i;
            this.AnE = i2;
            this.AnG = i3;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        e eVar = (e) obj;
        int a = c.a(this.Anz, eVar.Anz);
        if (a != 0) {
            return a;
        }
        a = c.a(this.AnA, eVar.AnA);
        if (a != 0) {
            return a;
        }
        a = c.a(this.AnB, eVar.AnB);
        return a == 0 ? c.a(this.AnC, eVar.AnC) : a;
    }

    public e(int i, a[] aVarArr, a[] aVarArr2, b[] bVarArr, b[] bVarArr2) {
        super(i);
        this.Anz = aVarArr;
        this.AnA = aVarArr2;
        this.AnB = bVarArr;
        this.AnC = bVarArr2;
    }
}

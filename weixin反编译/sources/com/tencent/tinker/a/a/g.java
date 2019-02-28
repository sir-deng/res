package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class g extends com.tencent.tinker.a.a.t.a.a<g> {
    public int AnO;
    public int AnP;
    public int AnQ;
    public int AnR;
    public short[] AnS;
    public b[] AnT;
    public a[] AnU;

    public static class a implements Comparable<a> {
        public int[] AnV;
        public int[] AnW;
        public int AnX;
        public int offset;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            int a = c.a(this.AnV, aVar.AnV);
            if (a != 0) {
                return a;
            }
            a = c.a(this.AnW, aVar.AnW);
            return a == 0 ? c.fM(this.AnX, aVar.AnX) : a;
        }

        public a(int[] iArr, int[] iArr2, int i, int i2) {
            this.AnV = iArr;
            this.AnW = iArr2;
            this.AnX = i;
            this.offset = i2;
        }
    }

    public static class b implements Comparable<b> {
        public int AnY;
        public int AnZ;
        public int Aoa;

        public final /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            int fM = c.fM(this.AnY, bVar.AnY);
            if (fM != 0) {
                return fM;
            }
            fM = c.fM(this.AnZ, bVar.AnZ);
            return fM == 0 ? c.fM(this.Aoa, bVar.Aoa) : fM;
        }

        public b(int i, int i2, int i3) {
            this.AnY = i;
            this.AnZ = i2;
            this.Aoa = i3;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int fM = c.fM(this.AnO, gVar.AnO);
        if (fM != 0) {
            return fM;
        }
        fM = c.fM(this.AnP, gVar.AnP);
        if (fM != 0) {
            return fM;
        }
        fM = c.fM(this.AnQ, gVar.AnQ);
        if (fM != 0) {
            return fM;
        }
        fM = c.fM(this.AnR, gVar.AnR);
        if (fM != 0) {
            return fM;
        }
        fM = c.a(this.AnS, gVar.AnS);
        if (fM != 0) {
            return fM;
        }
        fM = c.a(this.AnT, gVar.AnT);
        return fM == 0 ? c.a(this.AnU, gVar.AnU) : fM;
    }

    public g(int i, int i2, int i3, int i4, int i5, short[] sArr, b[] bVarArr, a[] aVarArr) {
        super(i);
        this.AnO = i2;
        this.AnP = i3;
        this.AnQ = i4;
        this.AnR = i5;
        this.AnS = sArr;
        this.AnT = bVarArr;
        this.AnU = aVarArr;
    }
}

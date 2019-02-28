package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class f extends a<f> {
    public int AnE;
    public int AnH;
    public int AnI;
    public int AnJ;
    public int AnK;
    public int AnL;
    public int AnM;
    public int AnN;

    public final /* synthetic */ int compareTo(Object obj) {
        f fVar = (f) obj;
        int fL = c.fL(this.AnH, fVar.AnH);
        if (fL != 0) {
            return fL;
        }
        fL = c.fM(this.AnE, fVar.AnE);
        if (fL != 0) {
            return fL;
        }
        fL = c.fL(this.AnI, fVar.AnI);
        if (fL != 0) {
            return fL;
        }
        fL = c.fM(this.AnJ, fVar.AnJ);
        if (fL != 0) {
            return fL;
        }
        fL = c.fL(this.AnK, fVar.AnK);
        if (fL != 0) {
            return fL;
        }
        fL = c.fM(this.AnL, fVar.AnL);
        if (fL != 0) {
            return fL;
        }
        fL = c.fM(this.AnM, fVar.AnM);
        return fL == 0 ? c.fM(this.AnN, fVar.AnN) : fL;
    }

    public f(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super(i);
        this.AnH = i2;
        this.AnE = i3;
        this.AnI = i4;
        this.AnJ = i5;
        this.AnK = i6;
        this.AnL = i7;
        this.AnM = i8;
        this.AnN = i9;
    }
}

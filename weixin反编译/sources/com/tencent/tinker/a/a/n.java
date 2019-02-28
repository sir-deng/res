package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class n extends a<n> {
    public int AnH;
    public int Aou;
    public int Aov;

    public final /* synthetic */ int compareTo(Object obj) {
        n nVar = (n) obj;
        if (this.Aou != nVar.Aou) {
            return c.fL(this.Aou, nVar.Aou);
        }
        return this.Aov != nVar.Aov ? c.fL(this.Aov, nVar.Aov) : c.fL(this.AnH, nVar.AnH);
    }

    public n(int i, int i2, int i3, int i4) {
        super(i);
        this.Aou = i2;
        this.AnH = i3;
        this.Aov = i4;
    }
}

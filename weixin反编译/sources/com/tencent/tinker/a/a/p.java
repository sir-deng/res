package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class p extends a<p> {
    public int Aou;
    public int Aov;
    public int Aow;

    public final /* synthetic */ int compareTo(Object obj) {
        p pVar = (p) obj;
        if (this.Aou != pVar.Aou) {
            return c.fL(this.Aou, pVar.Aou);
        }
        return this.Aov != pVar.Aov ? c.fL(this.Aov, pVar.Aov) : c.fL(this.Aow, pVar.Aow);
    }

    public p(int i, int i2, int i3, int i4) {
        super(i);
        this.Aou = i2;
        this.Aow = i3;
        this.Aov = i4;
    }
}

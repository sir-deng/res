package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class r extends a<r> {
    public int Aox;
    public int Aoy;
    public int Aoz;

    public final /* synthetic */ int compareTo(Object obj) {
        r rVar = (r) obj;
        int fL = c.fL(this.Aox, rVar.Aox);
        if (fL != 0) {
            return fL;
        }
        fL = c.fL(this.Aoy, rVar.Aoy);
        return fL == 0 ? c.fM(this.Aoz, rVar.Aoz) : fL;
    }

    public r(int i, int i2, int i3, int i4) {
        super(i);
        this.Aox = i2;
        this.Aoy = i3;
        this.Aoz = i4;
    }
}

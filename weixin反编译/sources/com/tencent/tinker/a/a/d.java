package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class d extends a<d> {
    public int Anv;
    public int[][] Anw;
    public int[][] Anx;
    public int[][] Any;

    public final /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        if (this.Anv != dVar.Anv) {
            return c.fL(this.Anv, dVar.Anv);
        }
        int length = this.Anw.length;
        int length2 = this.Anx.length;
        int length3 = this.Any.length;
        int length4 = dVar.Anw.length;
        int length5 = dVar.Anx.length;
        int length6 = dVar.Any.length;
        if (length != length4) {
            return c.fM(length, length4);
        }
        if (length2 != length5) {
            return c.fM(length2, length5);
        }
        if (length3 != length6) {
            return c.fM(length3, length6);
        }
        int i;
        for (length4 = 0; length4 < length; length4++) {
            length5 = this.Anw[length4][0];
            length6 = this.Anw[length4][1];
            i = dVar.Anw[length4][0];
            int i2 = dVar.Anw[length4][1];
            if (length5 != i) {
                return c.fL(length5, i);
            }
            if (length6 != i2) {
                return c.fM(length6, i2);
            }
        }
        for (length4 = 0; length4 < length2; length4++) {
            length = this.Anx[length4][0];
            length5 = this.Anx[length4][1];
            length6 = dVar.Anx[length4][0];
            i = dVar.Anx[length4][1];
            if (length != length6) {
                return c.fL(length, length6);
            }
            if (length5 != i) {
                return c.fM(length5, i);
            }
        }
        for (length4 = 0; length4 < length3; length4++) {
            length = this.Any[length4][0];
            length2 = this.Any[length4][1];
            length5 = dVar.Any[length4][0];
            length6 = dVar.Any[length4][1];
            if (length != length5) {
                return c.fL(length, length5);
            }
            if (length2 != length6) {
                return c.fM(length2, length6);
            }
        }
        return 0;
    }

    public d(int i, int i2, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i);
        this.Anv = i2;
        this.Anw = iArr;
        this.Anx = iArr2;
        this.Any = iArr3;
    }
}

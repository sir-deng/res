package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ayj extends a {
    public int npU;
    public String vUa;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vUa != null) {
                aVar.g(1, this.vUa);
            }
            aVar.fX(2, this.npU);
            return 0;
        } else if (i == 1) {
            if (this.vUa != null) {
                h = e.a.a.b.b.a.h(1, this.vUa) + 0;
            } else {
                h = 0;
            }
            return h + e.a.a.a.fU(2, this.npU);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayj ayj = (ayj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayj.vUa = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ayj.npU = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class atm extends a {
    public int nlX;
    public String npV;
    public String npW;
    public int vNL;
    public long vNT;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.npW != null) {
                aVar.g(1, this.npW);
            }
            if (this.npV != null) {
                aVar.g(2, this.npV);
            }
            aVar.fX(3, this.vNL);
            aVar.fX(4, this.nlX);
            aVar.S(5, this.vNT);
            return 0;
        } else if (i == 1) {
            if (this.npW != null) {
                h = e.a.a.b.b.a.h(1, this.npW) + 0;
            } else {
                h = 0;
            }
            if (this.npV != null) {
                h += e.a.a.b.b.a.h(2, this.npV);
            }
            return ((h + e.a.a.a.fU(3, this.vNL)) + e.a.a.a.fU(4, this.nlX)) + e.a.a.a.R(5, this.vNT);
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
            atm atm = (atm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atm.npW = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    atm.npV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    atm.vNL = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    atm.nlX = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    atm.vNT = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

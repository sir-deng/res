package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public class bdg extends a {
    public int npC;
    public String vTX;
    public long wPS;
    public int wPT;
    public boolean wPU;
    public boolean wPV;
    public int wPW;
    public boolean wPX;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vTX != null) {
                aVar.g(1, this.vTX);
            }
            aVar.S(2, this.wPS);
            aVar.fX(3, this.wPT);
            aVar.am(4, this.wPU);
            aVar.am(5, this.wPV);
            aVar.fX(6, this.wPW);
            aVar.fX(7, this.npC);
            aVar.am(8, this.wPX);
            return 0;
        } else if (i == 1) {
            if (this.vTX != null) {
                h = e.a.a.b.b.a.h(1, this.vTX) + 0;
            } else {
                h = 0;
            }
            return ((((((h + e.a.a.a.R(2, this.wPS)) + e.a.a.a.fU(3, this.wPT)) + (e.a.a.b.b.a.dX(4) + 1)) + (e.a.a.b.b.a.dX(5) + 1)) + e.a.a.a.fU(6, this.wPW)) + e.a.a.a.fU(7, this.npC)) + (e.a.a.b.b.a.dX(8) + 1);
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
            bdg bdg = (bdg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdg.vTX = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bdg.wPS = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    bdg.wPT = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bdg.wPU = aVar3.cKv();
                    return 0;
                case 5:
                    bdg.wPV = aVar3.cKv();
                    return 0;
                case 6:
                    bdg.wPW = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bdg.npC = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bdg.wPX = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

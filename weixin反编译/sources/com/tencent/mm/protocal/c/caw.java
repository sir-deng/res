package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class caw extends a {
    public int kyA;
    public int kzz;
    public String npV;
    public int pgR;
    public String vNR;
    public int wGf;
    public int xgX;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.npV != null) {
                aVar.g(1, this.npV);
            }
            aVar.fX(2, this.kzz);
            aVar.fX(3, this.kyA);
            aVar.fX(4, this.pgR);
            aVar.fX(5, this.wGf);
            if (this.vNR != null) {
                aVar.g(6, this.vNR);
            }
            aVar.fX(7, this.xgX);
            return 0;
        } else if (i == 1) {
            if (this.npV != null) {
                h = e.a.a.b.b.a.h(1, this.npV) + 0;
            } else {
                h = 0;
            }
            h = (((h + e.a.a.a.fU(2, this.kzz)) + e.a.a.a.fU(3, this.kyA)) + e.a.a.a.fU(4, this.pgR)) + e.a.a.a.fU(5, this.wGf);
            if (this.vNR != null) {
                h += e.a.a.b.b.a.h(6, this.vNR);
            }
            return h + e.a.a.a.fU(7, this.xgX);
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
            caw caw = (caw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    caw.npV = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    caw.kzz = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    caw.kyA = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    caw.pgR = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    caw.wGf = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    caw.vNR = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    caw.xgX = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

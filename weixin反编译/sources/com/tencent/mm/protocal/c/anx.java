package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class anx extends a {
    public int kyA;
    public int wBF;
    public b wBG;
    public int wBH;
    public int wBI;
    public int wgo;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wBF);
            if (this.wBG != null) {
                aVar.b(2, this.wBG);
            }
            aVar.fX(3, this.wBH);
            aVar.fX(4, this.wgo);
            aVar.fX(5, this.kyA);
            aVar.fX(6, this.wBI);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wBF) + 0;
            if (this.wBG != null) {
                fU += e.a.a.a.a(2, this.wBG);
            }
            return (((fU + e.a.a.a.fU(3, this.wBH)) + e.a.a.a.fU(4, this.wgo)) + e.a.a.a.fU(5, this.kyA)) + e.a.a.a.fU(6, this.wBI);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            anx anx = (anx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    anx.wBF = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    anx.wBG = aVar3.cKw();
                    return 0;
                case 3:
                    anx.wBH = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    anx.wgo = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    anx.kyA = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    anx.wBI = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class uc extends a {
    public int wiC;
    public String wiD;
    public String wiE;
    public String wiQ;
    public String wiR;
    public int wiS;
    public int wiT;
    public String wiU;
    public String wiV;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wiC);
            if (this.wiD != null) {
                aVar.g(2, this.wiD);
            }
            if (this.wiQ != null) {
                aVar.g(3, this.wiQ);
            }
            if (this.wiR != null) {
                aVar.g(4, this.wiR);
            }
            aVar.fX(5, this.wiS);
            aVar.fX(6, this.wiT);
            if (this.wiU != null) {
                aVar.g(7, this.wiU);
            }
            if (this.wiE != null) {
                aVar.g(8, this.wiE);
            }
            if (this.wiV != null) {
                aVar.g(9, this.wiV);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wiC) + 0;
            if (this.wiD != null) {
                fU += e.a.a.b.b.a.h(2, this.wiD);
            }
            if (this.wiQ != null) {
                fU += e.a.a.b.b.a.h(3, this.wiQ);
            }
            if (this.wiR != null) {
                fU += e.a.a.b.b.a.h(4, this.wiR);
            }
            fU = (fU + e.a.a.a.fU(5, this.wiS)) + e.a.a.a.fU(6, this.wiT);
            if (this.wiU != null) {
                fU += e.a.a.b.b.a.h(7, this.wiU);
            }
            if (this.wiE != null) {
                fU += e.a.a.b.b.a.h(8, this.wiE);
            }
            if (this.wiV != null) {
                return fU + e.a.a.b.b.a.h(9, this.wiV);
            }
            return fU;
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
            uc ucVar = (uc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ucVar.wiC = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    ucVar.wiD = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ucVar.wiQ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ucVar.wiR = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ucVar.wiS = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    ucVar.wiT = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    ucVar.wiU = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    ucVar.wiE = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    ucVar.wiV = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class atu extends a {
    public int wBF;
    public int wIA;
    public int wIB;
    public int wIC;
    public int wID;
    public int wIE;
    public int wIz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wBF);
            aVar.fX(2, this.wIz);
            aVar.fX(3, this.wIA);
            aVar.fX(4, this.wIB);
            aVar.fX(5, this.wIC);
            aVar.fX(6, this.wID);
            aVar.fX(7, this.wIE);
            return 0;
        } else if (i == 1) {
            return ((((((e.a.a.a.fU(1, this.wBF) + 0) + e.a.a.a.fU(2, this.wIz)) + e.a.a.a.fU(3, this.wIA)) + e.a.a.a.fU(4, this.wIB)) + e.a.a.a.fU(5, this.wIC)) + e.a.a.a.fU(6, this.wID)) + e.a.a.a.fU(7, this.wIE);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                atu atu = (atu) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        atu.wBF = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        atu.wIz = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        atu.wIA = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        atu.wIB = aVar3.AEQ.rz();
                        return 0;
                    case 5:
                        atu.wIC = aVar3.AEQ.rz();
                        return 0;
                    case 6:
                        atu.wID = aVar3.AEQ.rz();
                        return 0;
                    case 7:
                        atu.wIE = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

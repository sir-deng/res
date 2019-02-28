package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bs extends a {
    public int kzz;
    public int vNB;
    public int vNC;
    public int vND;
    public int vNE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vNB);
            aVar.fX(2, this.kzz);
            aVar.fX(3, this.vNC);
            aVar.fX(4, this.vND);
            aVar.fX(5, this.vNE);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.fU(1, this.vNB) + 0) + e.a.a.a.fU(2, this.kzz)) + e.a.a.a.fU(3, this.vNC)) + e.a.a.a.fU(4, this.vND)) + e.a.a.a.fU(5, this.vNE);
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
                bs bsVar = (bs) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bsVar.vNB = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        bsVar.kzz = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        bsVar.vNC = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        bsVar.vND = aVar3.AEQ.rz();
                        return 0;
                    case 5:
                        bsVar.vNE = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class gq extends a {
    public int vRR;
    public int vSw;
    public int vSx;
    public int vSy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vRR);
            aVar.fX(2, this.vSw);
            aVar.fX(3, this.vSx);
            aVar.fX(4, this.vSy);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fU(1, this.vRR) + 0) + e.a.a.a.fU(2, this.vSw)) + e.a.a.a.fU(3, this.vSx)) + e.a.a.a.fU(4, this.vSy);
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
                gq gqVar = (gq) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        gqVar.vRR = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        gqVar.vSw = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        gqVar.vSx = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        gqVar.vSy = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

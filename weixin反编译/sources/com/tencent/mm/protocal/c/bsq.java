package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bsq extends a {
    public int vPs;
    public int vPt;
    public int vPu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vPs);
            aVar.fX(2, this.vPt);
            aVar.fX(3, this.vPu);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fU(1, this.vPs) + 0) + e.a.a.a.fU(2, this.vPt)) + e.a.a.a.fU(3, this.vPu);
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
                bsq bsq = (bsq) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bsq.vPs = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        bsq.vPt = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        bsq.vPu = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

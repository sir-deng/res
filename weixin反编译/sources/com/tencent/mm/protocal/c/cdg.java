package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class cdg extends a {
    public int xiC;
    public int xiD;
    public int xiE;
    public int xiF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.xiC);
            aVar.fX(2, this.xiD);
            aVar.fX(3, this.xiE);
            aVar.fX(4, this.xiF);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fU(1, this.xiC) + 0) + e.a.a.a.fU(2, this.xiD)) + e.a.a.a.fU(3, this.xiE)) + e.a.a.a.fU(4, this.xiF);
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
                cdg cdg = (cdg) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cdg.xiC = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        cdg.xiD = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        cdg.xiE = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        cdg.xiF = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

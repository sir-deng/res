package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class cax extends a {
    public int vQL;
    public int wGg;
    public long xgC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vQL);
            aVar.fX(2, this.wGg);
            aVar.S(3, this.xgC);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fU(1, this.vQL) + 0) + e.a.a.a.fU(2, this.wGg)) + e.a.a.a.R(3, this.xgC);
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
                cax cax = (cax) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cax.vQL = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        cax.wGg = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        cax.xgC = aVar3.AEQ.rA();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

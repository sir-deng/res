package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aty extends a {
    public int wIJ;
    public long wIK;
    public long wIL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wIJ);
            aVar.S(2, this.wIK);
            aVar.S(3, this.wIL);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fU(1, this.wIJ) + 0) + e.a.a.a.R(2, this.wIK)) + e.a.a.a.R(3, this.wIL);
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
                aty aty = (aty) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        aty.wIJ = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        aty.wIK = aVar3.AEQ.rA();
                        return 0;
                    case 3:
                        aty.wIL = aVar3.AEQ.rA();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

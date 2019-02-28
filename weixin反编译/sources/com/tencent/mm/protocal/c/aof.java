package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aof extends a {
    public int pWg;
    public int wBQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.pWg);
            aVar.fX(2, this.wBQ);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.fU(1, this.pWg) + 0) + e.a.a.a.fU(2, this.wBQ);
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
                aof aof = (aof) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        aof.pWg = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        aof.wBQ = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

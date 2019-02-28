package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bpc extends a {
    public long wYr;
    public long wYs;
    public int wYt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.wYr);
            aVar.S(2, this.wYs);
            aVar.fX(3, this.wYt);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.R(1, this.wYr) + 0) + e.a.a.a.R(2, this.wYs)) + e.a.a.a.fU(3, this.wYt);
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
                bpc bpc = (bpc) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bpc.wYr = aVar3.AEQ.rA();
                        return 0;
                    case 2:
                        bpc.wYs = aVar3.AEQ.rA();
                        return 0;
                    case 3:
                        bpc.wYt = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

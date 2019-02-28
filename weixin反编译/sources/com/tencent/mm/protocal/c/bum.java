package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bum extends a {
    public int vPv;
    public int vPw;
    public int vPx;
    public int vPy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vPv);
            aVar.fX(2, this.vPw);
            aVar.fX(3, this.vPx);
            aVar.fX(4, this.vPy);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fU(1, this.vPv) + 0) + e.a.a.a.fU(2, this.vPw)) + e.a.a.a.fU(3, this.vPx)) + e.a.a.a.fU(4, this.vPy);
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
                bum bum = (bum) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bum.vPv = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        bum.vPw = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        bum.vPx = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        bum.vPy = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

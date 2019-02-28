package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class blo extends a {
    public int vNC;
    public int wVu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vNC);
            aVar.fX(2, this.wVu);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.fU(1, this.vNC) + 0) + e.a.a.a.fU(2, this.wVu);
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
                blo blo = (blo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        blo.vNC = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        blo.wVu = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

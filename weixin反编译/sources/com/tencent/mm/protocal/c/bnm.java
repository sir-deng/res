package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bnm extends a {
    public int wXy;
    public boolean wXz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wXy);
            aVar.am(2, this.wXz);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.fU(1, this.wXy) + 0) + (e.a.a.b.b.a.dX(2) + 1);
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
                bnm bnm = (bnm) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bnm.wXy = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        bnm.wXz = aVar3.cKv();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

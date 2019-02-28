package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class arc extends a {
    public int nph;
    public int vON;
    public int wEL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vON);
            aVar.fX(2, this.nph);
            aVar.fX(3, this.wEL);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fU(1, this.vON) + 0) + e.a.a.a.fU(2, this.nph)) + e.a.a.a.fU(3, this.wEL);
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
                arc arc = (arc) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        arc.vON = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        arc.nph = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        arc.wEL = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

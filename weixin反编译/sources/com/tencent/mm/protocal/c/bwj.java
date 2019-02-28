package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bwj extends a {
    public int xem;
    public int xen;
    public int xeo;
    public int xep;
    public int xeq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.xem);
            aVar.fX(2, this.xen);
            aVar.fX(3, this.xeo);
            aVar.fX(4, this.xep);
            aVar.fX(5, this.xeq);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.fU(1, this.xem) + 0) + e.a.a.a.fU(2, this.xen)) + e.a.a.a.fU(3, this.xeo)) + e.a.a.a.fU(4, this.xep)) + e.a.a.a.fU(5, this.xeq);
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
                bwj bwj = (bwj) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bwj.xem = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        bwj.xen = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        bwj.xeo = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        bwj.xep = aVar3.AEQ.rz();
                        return 0;
                    case 5:
                        bwj.xeq = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

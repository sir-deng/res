package com.tencent.mm.bw;

import com.tencent.mm.bp.a;

public final class c extends a {
    public int hna;
    public int size;
    public int xte;
    public int xtf;
    public int xtg;
    public int xth = -1;
    public int xti;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.xte);
            aVar.fX(2, this.xtf);
            aVar.fX(3, this.xtg);
            aVar.fX(41, this.xth);
            aVar.fX(5, this.xti);
            aVar.fX(6, this.hna);
            aVar.fX(7, this.size);
            return 0;
        } else if (i == 1) {
            return ((((((e.a.a.a.fU(1, this.xte) + 0) + e.a.a.a.fU(2, this.xtf)) + e.a.a.a.fU(3, this.xtg)) + e.a.a.a.fU(41, this.xth)) + e.a.a.a.fU(5, this.xti)) + e.a.a.a.fU(6, this.hna)) + e.a.a.a.fU(7, this.size);
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
                c cVar = (c) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cVar.xte = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        cVar.xtf = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        cVar.xtg = aVar3.AEQ.rz();
                        return 0;
                    case 5:
                        cVar.xti = aVar3.AEQ.rz();
                        return 0;
                    case 6:
                        cVar.hna = aVar3.AEQ.rz();
                        return 0;
                    case 7:
                        cVar.size = aVar3.AEQ.rz();
                        return 0;
                    case 41:
                        cVar.xth = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

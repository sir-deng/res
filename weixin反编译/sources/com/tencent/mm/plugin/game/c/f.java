package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class f extends a {
    public int nlm;
    public int nln;
    public int nlo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.nlm);
            aVar.fX(2, this.nln);
            aVar.fX(3, this.nlo);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fU(1, this.nlm) + 0) + e.a.a.a.fU(2, this.nln)) + e.a.a.a.fU(3, this.nlo);
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
                f fVar = (f) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        fVar.nlm = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        fVar.nln = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        fVar.nlo = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

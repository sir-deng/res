package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class rn extends a {
    public int wgn;
    public int wgo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wgn);
            aVar.fX(2, this.wgo);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.fU(1, this.wgn) + 0) + e.a.a.a.fU(2, this.wgo);
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
                rn rnVar = (rn) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        rnVar.wgn = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        rnVar.wgo = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class bpl extends a {
    public b vWf;
    public int vWg;
    public int wYG;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(7, this.wYG);
            if (this.vWf != null) {
                aVar.b(8, this.vWf);
            }
            aVar.fX(9, this.vWg);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(7, this.wYG) + 0;
            if (this.vWf != null) {
                fU += e.a.a.a.a(8, this.vWf);
            }
            return fU + e.a.a.a.fU(9, this.vWg);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpl bpl = (bpl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 7:
                    bpl.wYG = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bpl.vWf = aVar3.cKw();
                    return 0;
                case 9:
                    bpl.vWg = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

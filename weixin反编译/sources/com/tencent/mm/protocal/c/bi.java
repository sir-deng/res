package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class bi extends a {
    public int vNn;
    public b vNo;
    public long vNp;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vNn);
            if (this.vNo != null) {
                aVar.b(2, this.vNo);
            }
            aVar.S(3, this.vNp);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vNn) + 0;
            if (this.vNo != null) {
                fU += e.a.a.a.a(2, this.vNo);
            }
            return fU + e.a.a.a.R(3, this.vNp);
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
            bi biVar = (bi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    biVar.vNn = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    biVar.vNo = aVar3.cKw();
                    return 0;
                case 3:
                    biVar.vNp = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

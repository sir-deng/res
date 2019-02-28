package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class d extends a {
    public int count;
    public int quA;
    public int vIM;
    public b vIV;
    public int vIW;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIV == null) {
                throw new e.a.a.b("Not all required fields were included: value");
            }
            aVar.fX(1, this.vIM);
            if (this.vIV != null) {
                aVar.b(2, this.vIV);
            }
            aVar.fX(3, this.vIW);
            aVar.fX(4, this.quA);
            aVar.fX(5, this.count);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vIM) + 0;
            if (this.vIV != null) {
                fU += e.a.a.a.a(2, this.vIV);
            }
            return ((fU + e.a.a.a.fU(3, this.vIW)) + e.a.a.a.fU(4, this.quA)) + e.a.a.a.fU(5, this.count);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.vIV != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: value");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.vIM = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    dVar.vIV = aVar3.cKw();
                    return 0;
                case 3:
                    dVar.vIW = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    dVar.quA = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    dVar.count = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

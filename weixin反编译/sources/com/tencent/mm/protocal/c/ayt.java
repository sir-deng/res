package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ayt extends a {
    public int wMm;
    public int wMn;
    public String wMo;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wMm);
            aVar.fX(2, this.wMn);
            if (this.wMo != null) {
                aVar.g(3, this.wMo);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.wMm) + 0) + e.a.a.a.fU(2, this.wMn);
            if (this.wMo != null) {
                return fU + e.a.a.b.b.a.h(3, this.wMo);
            }
            return fU;
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
            ayt ayt = (ayt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayt.wMm = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    ayt.wMn = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ayt.wMo = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

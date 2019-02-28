package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aoi extends a {
    public int wBU;
    public String wBV;
    public int wnV;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wBU);
            if (this.wBV != null) {
                aVar.g(2, this.wBV);
            }
            aVar.fX(3, this.wnV);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wBU) + 0;
            if (this.wBV != null) {
                fU += e.a.a.b.b.a.h(2, this.wBV);
            }
            return fU + e.a.a.a.fU(3, this.wnV);
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
            aoi aoi = (aoi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aoi.wBU = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    aoi.wBV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aoi.wnV = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

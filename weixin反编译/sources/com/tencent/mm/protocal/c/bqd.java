package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bqd extends a {
    public int vQL;
    public int wYU;
    public String wYX;
    public String wYY;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wYU);
            if (this.wYX != null) {
                aVar.g(2, this.wYX);
            }
            aVar.fX(3, this.vQL);
            if (this.wYY != null) {
                aVar.g(4, this.wYY);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wYU) + 0;
            if (this.wYX != null) {
                fU += e.a.a.b.b.a.h(2, this.wYX);
            }
            fU += e.a.a.a.fU(3, this.vQL);
            if (this.wYY != null) {
                return fU + e.a.a.b.b.a.h(4, this.wYY);
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
            bqd bqd = (bqd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqd.wYU = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bqd.wYX = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bqd.vQL = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bqd.wYY = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

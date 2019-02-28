package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class brr extends a {
    public int vPs;
    public int vPt;
    public int vQL;
    public String wgY;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vQL);
            aVar.fX(2, this.vPt);
            aVar.fX(3, this.vPs);
            if (this.wgY != null) {
                aVar.g(4, this.wgY);
            }
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.vQL) + 0) + e.a.a.a.fU(2, this.vPt)) + e.a.a.a.fU(3, this.vPs);
            if (this.wgY != null) {
                return fU + e.a.a.b.b.a.h(4, this.wgY);
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
            brr brr = (brr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    brr.vQL = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    brr.vPt = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    brr.vPs = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    brr.wgY = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

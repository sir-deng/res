package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class cdf extends a {
    public String wZx;
    public String xhO;
    public String xiA;
    public int xiB;
    public int xiy;
    public int xiz;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.xiy);
            aVar.fX(2, this.xiz);
            if (this.wZx != null) {
                aVar.g(3, this.wZx);
            }
            if (this.xiA != null) {
                aVar.g(4, this.xiA);
            }
            if (this.xhO != null) {
                aVar.g(5, this.xhO);
            }
            aVar.fX(6, this.xiB);
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.xiy) + 0) + e.a.a.a.fU(2, this.xiz);
            if (this.wZx != null) {
                fU += e.a.a.b.b.a.h(3, this.wZx);
            }
            if (this.xiA != null) {
                fU += e.a.a.b.b.a.h(4, this.xiA);
            }
            if (this.xhO != null) {
                fU += e.a.a.b.b.a.h(5, this.xhO);
            }
            return fU + e.a.a.a.fU(6, this.xiB);
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
            cdf cdf = (cdf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdf.xiy = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    cdf.xiz = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    cdf.wZx = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cdf.xiA = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    cdf.xhO = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    cdf.xiB = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

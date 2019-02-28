package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ccc extends a {
    public int sfa;
    public int vTR;
    public int wAn;
    public int wDL;
    public int wDM;
    public String wDN;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wAn);
            aVar.fX(2, this.vTR);
            aVar.fX(3, this.sfa);
            if (this.wDN != null) {
                aVar.g(4, this.wDN);
            }
            aVar.fX(5, this.wDM);
            aVar.fX(6, this.wDL);
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.wAn) + 0) + e.a.a.a.fU(2, this.vTR)) + e.a.a.a.fU(3, this.sfa);
            if (this.wDN != null) {
                fU += e.a.a.b.b.a.h(4, this.wDN);
            }
            return (fU + e.a.a.a.fU(5, this.wDM)) + e.a.a.a.fU(6, this.wDL);
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
            ccc ccc = (ccc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccc.wAn = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    ccc.vTR = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ccc.sfa = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    ccc.wDN = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ccc.wDM = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    ccc.wDL = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class atr extends a {
    public String kyG;
    public String kzN;
    public int lTO;
    public String vSE;
    public String wIf;
    public String weS;
    public int wnJ;
    public int wzN;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.lTO);
            if (this.kzN != null) {
                aVar.g(2, this.kzN);
            }
            if (this.vSE != null) {
                aVar.g(3, this.vSE);
            }
            if (this.weS != null) {
                aVar.g(4, this.weS);
            }
            if (this.kyG != null) {
                aVar.g(5, this.kyG);
            }
            aVar.fX(6, this.wzN);
            aVar.fX(7, this.wnJ);
            if (this.wIf != null) {
                aVar.g(8, this.wIf);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.lTO) + 0;
            if (this.kzN != null) {
                fU += e.a.a.b.b.a.h(2, this.kzN);
            }
            if (this.vSE != null) {
                fU += e.a.a.b.b.a.h(3, this.vSE);
            }
            if (this.weS != null) {
                fU += e.a.a.b.b.a.h(4, this.weS);
            }
            if (this.kyG != null) {
                fU += e.a.a.b.b.a.h(5, this.kyG);
            }
            fU = (fU + e.a.a.a.fU(6, this.wzN)) + e.a.a.a.fU(7, this.wnJ);
            if (this.wIf != null) {
                return fU + e.a.a.b.b.a.h(8, this.wIf);
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
            atr atr = (atr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atr.lTO = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    atr.kzN = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    atr.vSE = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    atr.weS = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    atr.kyG = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    atr.wzN = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    atr.wnJ = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    atr.wIf = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

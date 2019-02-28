package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class vi extends a {
    public int kyY;
    public int vNB;
    public int vNC;
    public int vND;
    public int vNE;
    public String vNI;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vNB);
            aVar.fX(2, this.kyY);
            if (this.vNI != null) {
                aVar.g(3, this.vNI);
            }
            aVar.fX(4, this.vNC);
            aVar.fX(5, this.vND);
            aVar.fX(6, this.vNE);
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.vNB) + 0) + e.a.a.a.fU(2, this.kyY);
            if (this.vNI != null) {
                fU += e.a.a.b.b.a.h(3, this.vNI);
            }
            return ((fU + e.a.a.a.fU(4, this.vNC)) + e.a.a.a.fU(5, this.vND)) + e.a.a.a.fU(6, this.vNE);
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
            vi viVar = (vi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    viVar.vNB = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    viVar.kyY = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    viVar.vNI = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    viVar.vNC = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    viVar.vND = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    viVar.vNE = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

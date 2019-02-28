package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class kz extends a {
    public String vZB;
    public String vZC;
    public int vZD;
    public int vZE;
    public int vZF;
    public int vZG;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vZB != null) {
                aVar.g(1, this.vZB);
            }
            if (this.vZC != null) {
                aVar.g(2, this.vZC);
            }
            aVar.fX(3, this.vZD);
            aVar.fX(4, this.vZE);
            aVar.fX(5, this.vZF);
            aVar.fX(6, this.vZG);
            return 0;
        } else if (i == 1) {
            if (this.vZB != null) {
                h = e.a.a.b.b.a.h(1, this.vZB) + 0;
            } else {
                h = 0;
            }
            if (this.vZC != null) {
                h += e.a.a.b.b.a.h(2, this.vZC);
            }
            return (((h + e.a.a.a.fU(3, this.vZD)) + e.a.a.a.fU(4, this.vZE)) + e.a.a.a.fU(5, this.vZF)) + e.a.a.a.fU(6, this.vZG);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            kz kzVar = (kz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kzVar.vZB = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    kzVar.vZC = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    kzVar.vZD = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    kzVar.vZE = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    kzVar.vZF = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    kzVar.vZG = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

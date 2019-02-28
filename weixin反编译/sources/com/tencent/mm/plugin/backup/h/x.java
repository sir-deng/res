package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class x extends a {
    public b kyn;
    public String kzD;
    public int kzE;
    public int kzF;
    public int kzG;
    public int kzH;
    public int kzI;
    public int kzJ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kzD == null) {
                throw new e.a.a.b("Not all required fields were included: DataID");
            }
            if (this.kzD != null) {
                aVar.g(1, this.kzD);
            }
            aVar.fX(2, this.kzE);
            aVar.fX(3, this.kzF);
            aVar.fX(4, this.kzG);
            aVar.fX(5, this.kzH);
            aVar.fX(6, this.kzI);
            if (this.kyn != null) {
                aVar.b(7, this.kyn);
            }
            aVar.fX(8, this.kzJ);
            return 0;
        } else if (i == 1) {
            if (this.kzD != null) {
                h = e.a.a.b.b.a.h(1, this.kzD) + 0;
            } else {
                h = 0;
            }
            h = ((((h + e.a.a.a.fU(2, this.kzE)) + e.a.a.a.fU(3, this.kzF)) + e.a.a.a.fU(4, this.kzG)) + e.a.a.a.fU(5, this.kzH)) + e.a.a.a.fU(6, this.kzI);
            if (this.kyn != null) {
                h += e.a.a.a.a(7, this.kyn);
            }
            return h + e.a.a.a.fU(8, this.kzJ);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.kzD != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: DataID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            x xVar = (x) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xVar.kzD = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    xVar.kzE = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    xVar.kzF = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    xVar.kzG = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    xVar.kzH = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    xVar.kzI = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    xVar.kyn = aVar3.cKw();
                    return 0;
                case 8:
                    xVar.kzJ = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

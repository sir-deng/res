package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bne extends a {
    public int cPf;
    public int hQn;
    public String ruy;
    public String wXf;
    public String wXg;
    public int wXh;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.hQn);
            if (this.wXf != null) {
                aVar.g(2, this.wXf);
            }
            if (this.wXg != null) {
                aVar.g(3, this.wXg);
            }
            aVar.fX(4, this.cPf);
            if (this.ruy != null) {
                aVar.g(5, this.ruy);
            }
            aVar.fX(6, this.wXh);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.hQn) + 0;
            if (this.wXf != null) {
                fU += e.a.a.b.b.a.h(2, this.wXf);
            }
            if (this.wXg != null) {
                fU += e.a.a.b.b.a.h(3, this.wXg);
            }
            fU += e.a.a.a.fU(4, this.cPf);
            if (this.ruy != null) {
                fU += e.a.a.b.b.a.h(5, this.ruy);
            }
            return fU + e.a.a.a.fU(6, this.wXh);
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
            bne bne = (bne) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bne.hQn = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bne.wXf = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bne.wXg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bne.cPf = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bne.ruy = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bne.wXh = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

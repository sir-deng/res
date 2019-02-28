package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aus extends a {
    public int vVz;
    public int wJr;
    public String wJs;
    public String wJu;
    public int wdO;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vVz);
            if (this.wJu != null) {
                aVar.g(3, this.wJu);
            }
            aVar.fX(4, this.wJr);
            aVar.fX(5, this.wdO);
            if (this.wJs != null) {
                aVar.g(6, this.wJs);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vVz) + 0;
            if (this.wJu != null) {
                fU += e.a.a.b.b.a.h(3, this.wJu);
            }
            fU = (fU + e.a.a.a.fU(4, this.wJr)) + e.a.a.a.fU(5, this.wdO);
            if (this.wJs != null) {
                return fU + e.a.a.b.b.a.h(6, this.wJs);
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
            aus aus = (aus) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aus.vVz = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    aus.wJu = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aus.wJr = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aus.wdO = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    aus.wJs = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

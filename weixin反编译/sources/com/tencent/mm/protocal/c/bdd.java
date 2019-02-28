package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class bdd extends a {
    public int kzz;
    public int lUo;
    public int wMK;
    public String wPP;
    public b wfV;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wPP != null) {
                aVar.g(1, this.wPP);
            }
            aVar.fX(2, this.kzz);
            aVar.fX(3, this.lUo);
            aVar.fX(4, this.wMK);
            if (this.wfV == null) {
                return 0;
            }
            aVar.b(5, this.wfV);
            return 0;
        } else if (i == 1) {
            if (this.wPP != null) {
                h = e.a.a.b.b.a.h(1, this.wPP) + 0;
            } else {
                h = 0;
            }
            h = ((h + e.a.a.a.fU(2, this.kzz)) + e.a.a.a.fU(3, this.lUo)) + e.a.a.a.fU(4, this.wMK);
            if (this.wfV != null) {
                h += e.a.a.a.a(5, this.wfV);
            }
            return h;
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
            bdd bdd = (bdd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdd.wPP = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bdd.kzz = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bdd.lUo = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bdd.wMK = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bdd.wfV = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

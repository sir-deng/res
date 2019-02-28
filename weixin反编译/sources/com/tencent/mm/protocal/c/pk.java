package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class pk extends a {
    public int kyY;
    public int vNL;
    public long vNT;
    public String wfk;
    public int wfl;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vNL);
            if (this.wfk != null) {
                aVar.g(2, this.wfk);
            }
            aVar.fX(3, this.kyY);
            aVar.fX(4, this.wfl);
            aVar.S(5, this.vNT);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vNL) + 0;
            if (this.wfk != null) {
                fU += e.a.a.b.b.a.h(2, this.wfk);
            }
            return ((fU + e.a.a.a.fU(3, this.kyY)) + e.a.a.a.fU(4, this.wfl)) + e.a.a.a.R(5, this.vNT);
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
            pk pkVar = (pk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pkVar.vNL = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    pkVar.wfk = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    pkVar.kyY = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    pkVar.wfl = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    pkVar.vNT = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

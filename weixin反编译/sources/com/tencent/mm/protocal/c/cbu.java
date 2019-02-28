package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class cbu extends a {
    public String frM;
    public String url;
    public int vVl;
    public int xhL;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.xhL);
            aVar.fX(2, this.vVl);
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            if (this.frM != null) {
                aVar.g(4, this.frM);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.xhL) + 0) + e.a.a.a.fU(2, this.vVl);
            if (this.url != null) {
                fU += e.a.a.b.b.a.h(3, this.url);
            }
            if (this.frM != null) {
                return fU + e.a.a.b.b.a.h(4, this.frM);
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
            cbu cbu = (cbu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbu.xhL = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    cbu.vVl = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    cbu.url = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cbu.frM = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

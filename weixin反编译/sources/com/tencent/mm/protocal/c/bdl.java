package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bdl extends a {
    public String kzl;
    public int qDJ;
    public String vUW;
    public String vUX;
    public String vUY;
    public String vUZ;
    public int wQa;
    public int wQb;
    public String wQc;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kzl != null) {
                aVar.g(1, this.kzl);
            }
            aVar.fX(2, this.wQa);
            if (this.vUW != null) {
                aVar.g(3, this.vUW);
            }
            if (this.vUX != null) {
                aVar.g(4, this.vUX);
            }
            aVar.fX(5, this.qDJ);
            aVar.fX(6, this.wQb);
            if (this.vUY != null) {
                aVar.g(7, this.vUY);
            }
            if (this.vUZ != null) {
                aVar.g(8, this.vUZ);
            }
            if (this.wQc == null) {
                return 0;
            }
            aVar.g(9, this.wQc);
            return 0;
        } else if (i == 1) {
            if (this.kzl != null) {
                h = e.a.a.b.b.a.h(1, this.kzl) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.wQa);
            if (this.vUW != null) {
                h += e.a.a.b.b.a.h(3, this.vUW);
            }
            if (this.vUX != null) {
                h += e.a.a.b.b.a.h(4, this.vUX);
            }
            h = (h + e.a.a.a.fU(5, this.qDJ)) + e.a.a.a.fU(6, this.wQb);
            if (this.vUY != null) {
                h += e.a.a.b.b.a.h(7, this.vUY);
            }
            if (this.vUZ != null) {
                h += e.a.a.b.b.a.h(8, this.vUZ);
            }
            if (this.wQc != null) {
                h += e.a.a.b.b.a.h(9, this.wQc);
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
            bdl bdl = (bdl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdl.kzl = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bdl.wQa = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bdl.vUW = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bdl.vUX = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bdl.qDJ = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bdl.wQb = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bdl.vUY = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bdl.vUZ = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    bdl.wQc = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

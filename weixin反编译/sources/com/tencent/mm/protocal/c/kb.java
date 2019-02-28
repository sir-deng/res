package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class kb extends a {
    public String vRN;
    public String vXJ;
    public int vXK;
    public String vXL;
    public String vXM;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vXJ != null) {
                aVar.g(1, this.vXJ);
            }
            aVar.fX(2, this.vXK);
            if (this.vXL != null) {
                aVar.g(3, this.vXL);
            }
            if (this.vRN != null) {
                aVar.g(4, this.vRN);
            }
            if (this.vXM == null) {
                return 0;
            }
            aVar.g(5, this.vXM);
            return 0;
        } else if (i == 1) {
            if (this.vXJ != null) {
                h = e.a.a.b.b.a.h(1, this.vXJ) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.vXK);
            if (this.vXL != null) {
                h += e.a.a.b.b.a.h(3, this.vXL);
            }
            if (this.vRN != null) {
                h += e.a.a.b.b.a.h(4, this.vRN);
            }
            if (this.vXM != null) {
                h += e.a.a.b.b.a.h(5, this.vXM);
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
            kb kbVar = (kb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kbVar.vXJ = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    kbVar.vXK = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    kbVar.vXL = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    kbVar.vRN = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    kbVar.vXM = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

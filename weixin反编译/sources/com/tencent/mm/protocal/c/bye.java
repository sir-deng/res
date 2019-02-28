package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bye extends a {
    public String fpg;
    public String nMr;
    public String nkL;
    public int vNC;
    public String vPI;
    public String wMx;
    public String xfD;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg != null) {
                aVar.g(1, this.fpg);
            }
            if (this.wMx != null) {
                aVar.g(2, this.wMx);
            }
            if (this.nMr != null) {
                aVar.g(3, this.nMr);
            }
            if (this.nkL != null) {
                aVar.g(4, this.nkL);
            }
            if (this.xfD != null) {
                aVar.g(5, this.xfD);
            }
            aVar.fX(6, this.vNC);
            if (this.vPI == null) {
                return 0;
            }
            aVar.g(7, this.vPI);
            return 0;
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            if (this.wMx != null) {
                h += e.a.a.b.b.a.h(2, this.wMx);
            }
            if (this.nMr != null) {
                h += e.a.a.b.b.a.h(3, this.nMr);
            }
            if (this.nkL != null) {
                h += e.a.a.b.b.a.h(4, this.nkL);
            }
            if (this.xfD != null) {
                h += e.a.a.b.b.a.h(5, this.xfD);
            }
            h += e.a.a.a.fU(6, this.vNC);
            if (this.vPI != null) {
                h += e.a.a.b.b.a.h(7, this.vPI);
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
            bye bye = (bye) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bye.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bye.wMx = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bye.nMr = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bye.nkL = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bye.xfD = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bye.vNC = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bye.vPI = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

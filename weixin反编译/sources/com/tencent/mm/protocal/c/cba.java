package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class cba extends a {
    public b vPr;
    public int wgA;
    public String xgB;
    public boolean xhd;
    public boolean xhe;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xgB == null) {
                throw new e.a.a.b("Not all required fields were included: Talker");
            }
            if (this.xgB != null) {
                aVar.g(1, this.xgB);
            }
            aVar.fX(2, this.wgA);
            if (this.vPr != null) {
                aVar.b(3, this.vPr);
            }
            aVar.am(4, this.xhd);
            aVar.am(5, this.xhe);
            return 0;
        } else if (i == 1) {
            if (this.xgB != null) {
                h = e.a.a.b.b.a.h(1, this.xgB) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.wgA);
            if (this.vPr != null) {
                h += e.a.a.a.a(3, this.vPr);
            }
            return (h + (e.a.a.b.b.a.dX(4) + 1)) + (e.a.a.b.b.a.dX(5) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.xgB != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: Talker");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cba cba = (cba) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cba.xgB = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cba.wgA = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    cba.vPr = aVar3.cKw();
                    return 0;
                case 4:
                    cba.xhd = aVar3.cKv();
                    return 0;
                case 5:
                    cba.xhe = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class cbo extends a {
    public boolean xhA;
    public int xhB;
    public int xhC;
    public String xhz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xhz != null) {
                aVar.g(1, this.xhz);
            }
            aVar.am(2, this.xhA);
            aVar.fX(3, this.xhB);
            aVar.fX(4, this.xhC);
            return 0;
        } else if (i == 1) {
            if (this.xhz != null) {
                h = e.a.a.b.b.a.h(1, this.xhz) + 0;
            } else {
                h = 0;
            }
            return ((h + (e.a.a.b.b.a.dX(2) + 1)) + e.a.a.a.fU(3, this.xhB)) + e.a.a.a.fU(4, this.xhC);
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
            cbo cbo = (cbo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbo.xhz = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cbo.xhA = aVar3.cKv();
                    return 0;
                case 3:
                    cbo.xhB = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    cbo.xhC = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

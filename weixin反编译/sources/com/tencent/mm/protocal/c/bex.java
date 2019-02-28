package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bex extends a {
    public int kyA;
    public String wMI;
    public String wMJ;
    public String wtR;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wtR != null) {
                aVar.g(1, this.wtR);
            }
            if (this.wMJ != null) {
                aVar.g(2, this.wMJ);
            }
            aVar.fX(3, this.kyA);
            if (this.wMI == null) {
                return 0;
            }
            aVar.g(4, this.wMI);
            return 0;
        } else if (i == 1) {
            if (this.wtR != null) {
                h = e.a.a.b.b.a.h(1, this.wtR) + 0;
            } else {
                h = 0;
            }
            if (this.wMJ != null) {
                h += e.a.a.b.b.a.h(2, this.wMJ);
            }
            h += e.a.a.a.fU(3, this.kyA);
            if (this.wMI != null) {
                h += e.a.a.b.b.a.h(4, this.wMI);
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
            bex bex = (bex) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bex.wtR = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bex.wMJ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bex.kyA = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bex.wMI = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

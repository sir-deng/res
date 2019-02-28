package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class sq extends a {
    public String nlA;
    public int vRY;
    public String whp;
    public String whq;
    public int whr;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.whq != null) {
                aVar.g(1, this.whq);
            }
            aVar.fX(2, this.vRY);
            aVar.fX(3, this.whr);
            if (this.nlA != null) {
                aVar.g(4, this.nlA);
            }
            if (this.whp == null) {
                return 0;
            }
            aVar.g(5, this.whp);
            return 0;
        } else if (i == 1) {
            if (this.whq != null) {
                h = e.a.a.b.b.a.h(1, this.whq) + 0;
            } else {
                h = 0;
            }
            h = (h + e.a.a.a.fU(2, this.vRY)) + e.a.a.a.fU(3, this.whr);
            if (this.nlA != null) {
                h += e.a.a.b.b.a.h(4, this.nlA);
            }
            if (this.whp != null) {
                h += e.a.a.b.b.a.h(5, this.whp);
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
            sq sqVar = (sq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sqVar.whq = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    sqVar.vRY = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    sqVar.whr = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    sqVar.nlA = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    sqVar.whp = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

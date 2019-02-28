package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class atc extends a {
    public String vPp;
    public double wHr;
    public long wHs;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPp == null) {
                throw new b("Not all required fields were included: Username");
            }
            if (this.vPp != null) {
                aVar.g(1, this.vPp);
            }
            aVar.b(2, this.wHr);
            aVar.S(3, this.wHs);
            return 0;
        } else if (i == 1) {
            if (this.vPp != null) {
                h = e.a.a.b.b.a.h(1, this.vPp) + 0;
            } else {
                h = 0;
            }
            return (h + (e.a.a.b.b.a.dX(2) + 8)) + e.a.a.a.R(3, this.wHs);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.vPp != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Username");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atc atc = (atc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atc.vPp = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    atc.wHr = aVar3.AEQ.readDouble();
                    return 0;
                case 3:
                    atc.wHs = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

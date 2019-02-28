package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class bzz extends a {
    public String lTZ;
    public String vPp;
    public boolean xgA;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPp == null) {
                throw new b("Not all required fields were included: Username");
            } else if (this.lTZ == null) {
                throw new b("Not all required fields were included: Language");
            } else {
                if (this.vPp != null) {
                    aVar.g(1, this.vPp);
                }
                if (this.lTZ != null) {
                    aVar.g(2, this.lTZ);
                }
                aVar.am(3, this.xgA);
                return 0;
            }
        } else if (i == 1) {
            if (this.vPp != null) {
                h = e.a.a.b.b.a.h(1, this.vPp) + 0;
            } else {
                h = 0;
            }
            if (this.lTZ != null) {
                h += e.a.a.b.b.a.h(2, this.lTZ);
            }
            return h + (e.a.a.b.b.a.dX(3) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.vPp == null) {
                throw new b("Not all required fields were included: Username");
            } else if (this.lTZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Language");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzz bzz = (bzz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzz.vPp = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bzz.lTZ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bzz.xgA = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

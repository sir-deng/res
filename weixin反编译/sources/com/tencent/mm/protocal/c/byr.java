package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class byr extends a {
    public b xfM;
    public b xfN;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfM != null) {
                aVar.b(1, this.xfM);
            }
            if (this.xfN == null) {
                return 0;
            }
            aVar.b(2, this.xfN);
            return 0;
        } else if (i == 1) {
            if (this.xfM != null) {
                a = e.a.a.a.a(1, this.xfM) + 0;
            } else {
                a = 0;
            }
            if (this.xfN != null) {
                a += e.a.a.a.a(2, this.xfN);
            }
            return a;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byr byr = (byr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    byr.xfM = aVar3.cKw();
                    return 0;
                case 2:
                    byr.xfN = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

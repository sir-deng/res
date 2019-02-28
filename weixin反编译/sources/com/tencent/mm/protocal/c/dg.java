package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class dg extends a {
    public b vPd;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPd == null) {
                throw new e.a.a.b("Not all required fields were included: Cookies");
            } else if (this.vPd == null) {
                return 0;
            } else {
                aVar.b(1, this.vPd);
                return 0;
            }
        } else if (i == 1) {
            if (this.vPd != null) {
                a = e.a.a.a.a(1, this.vPd) + 0;
            } else {
                a = 0;
            }
            return a;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cKx();
                }
            }
            if (this.vPd != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: Cookies");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dg dgVar = (dg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dgVar.vPd = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

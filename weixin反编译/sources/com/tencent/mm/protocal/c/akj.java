package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class akj extends a {
    public b vRQ;
    public b vRS;
    public b wyn;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vRS != null) {
                aVar.b(1, this.vRS);
            }
            if (this.vRQ != null) {
                aVar.b(2, this.vRQ);
            }
            if (this.wyn == null) {
                return 0;
            }
            aVar.b(3, this.wyn);
            return 0;
        } else if (i == 1) {
            if (this.vRS != null) {
                a = e.a.a.a.a(1, this.vRS) + 0;
            } else {
                a = 0;
            }
            if (this.vRQ != null) {
                a += e.a.a.a.a(2, this.vRQ);
            }
            if (this.wyn != null) {
                a += e.a.a.a.a(3, this.wyn);
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
            akj akj = (akj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    akj.vRS = aVar3.cKw();
                    return 0;
                case 2:
                    akj.vRQ = aVar3.cKw();
                    return 0;
                case 3:
                    akj.wyn = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

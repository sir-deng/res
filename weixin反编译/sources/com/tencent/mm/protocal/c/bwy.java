package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bwy extends a {
    public boolean xeE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).am(1, this.xeE);
            return 0;
        } else if (i == 1) {
            return (e.a.a.b.b.a.dX(1) + 1) + 0;
        } else {
            if (i == 2) {
                e.a.a.a.a aVar = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
                bwy bwy = (bwy) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bwy.xeE = aVar2.cKv();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

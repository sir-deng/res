package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bla extends a {
    public long wUL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).S(1, this.wUL);
            return 0;
        } else if (i == 1) {
            return e.a.a.a.R(1, this.wUL) + 0;
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
                bla bla = (bla) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bla.wUL = aVar2.AEQ.rA();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

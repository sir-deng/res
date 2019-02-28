package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class als extends a {
    public int key;
    public int length;
    public long wzE;
    public int wzF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.key);
            aVar.S(2, this.wzE);
            aVar.fX(3, this.length);
            aVar.fX(4, this.wzF);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fU(1, this.key) + 0) + e.a.a.a.R(2, this.wzE)) + e.a.a.a.fU(3, this.length)) + e.a.a.a.fU(4, this.wzF);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                als als = (als) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        als.key = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        als.wzE = aVar3.AEQ.rA();
                        return 0;
                    case 3:
                        als.length = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        als.wzF = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

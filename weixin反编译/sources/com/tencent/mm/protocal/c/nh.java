package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class nh extends a {
    public int vNB;
    public int vQL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vNB);
            aVar.fX(2, this.vQL);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.fU(1, this.vNB) + 0) + e.a.a.a.fU(2, this.vQL);
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
                nh nhVar = (nh) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        nhVar.vNB = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        nhVar.vQL = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

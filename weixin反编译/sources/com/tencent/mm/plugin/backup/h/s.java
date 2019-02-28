package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;

public final class s extends a {
    public long kyU;
    public long kzr;
    public long kzs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.kyU);
            aVar.S(2, this.kzr);
            aVar.S(3, this.kzs);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.R(1, this.kyU) + 0) + e.a.a.a.R(2, this.kzr)) + e.a.a.a.R(3, this.kzs);
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
                s sVar = (s) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        sVar.kyU = aVar3.AEQ.rA();
                        return 0;
                    case 2:
                        sVar.kzr = aVar3.AEQ.rA();
                        return 0;
                    case 3:
                        sVar.kzs = aVar3.AEQ.rA();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

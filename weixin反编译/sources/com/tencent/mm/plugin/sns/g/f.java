package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bp.a;

public final class f extends a {
    public int rgU;
    public long rgW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.rgW);
            aVar.fX(2, this.rgU);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.R(1, this.rgW) + 0) + e.a.a.a.fU(2, this.rgU);
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
                f fVar = (f) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        fVar.rgW = aVar3.AEQ.rA();
                        return 0;
                    case 2:
                        fVar.rgU = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

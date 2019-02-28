package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class cak extends a {
    public String xgB;
    public int xgN;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xgB == null) {
                throw new b("Not all required fields were included: Talker");
            }
            if (this.xgB != null) {
                aVar.g(1, this.xgB);
            }
            aVar.fX(2, this.xgN);
            return 0;
        } else if (i == 1) {
            if (this.xgB != null) {
                h = e.a.a.b.b.a.h(1, this.xgB) + 0;
            } else {
                h = 0;
            }
            return h + e.a.a.a.fU(2, this.xgN);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.xgB != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Talker");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cak cak = (cak) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cak.xgB = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cak.xgN = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class bzm extends a {
    public b kyn;
    public long xgr;

    protected final int a(int i, Object... objArr) {
        int R;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.xgr);
            if (this.kyn != null) {
                aVar.b(2, this.kyn);
            }
            return 0;
        } else if (i == 1) {
            R = e.a.a.a.R(1, this.xgr) + 0;
            if (this.kyn != null) {
                return R + e.a.a.a.a(2, this.kyn);
            }
            return R;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzm bzm = (bzm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzm.xgr = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    bzm.kyn = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

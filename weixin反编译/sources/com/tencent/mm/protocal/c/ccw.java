package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class ccw extends a {
    public b vTY;
    public String wXQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wXQ != null) {
                aVar.g(1, this.wXQ);
            }
            if (this.vTY == null) {
                return 0;
            }
            aVar.b(2, this.vTY);
            return 0;
        } else if (i == 1) {
            if (this.wXQ != null) {
                h = e.a.a.b.b.a.h(1, this.wXQ) + 0;
            } else {
                h = 0;
            }
            if (this.vTY != null) {
                h += e.a.a.a.a(2, this.vTY);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccw ccw = (ccw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccw.wXQ = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ccw.vTY = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

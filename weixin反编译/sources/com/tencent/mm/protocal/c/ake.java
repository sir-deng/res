package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ake extends a {
    public String kyJ;
    public String vQr;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQr != null) {
                aVar.g(1, this.vQr);
            }
            if (this.kyJ == null) {
                return 0;
            }
            aVar.g(2, this.kyJ);
            return 0;
        } else if (i == 1) {
            if (this.vQr != null) {
                h = e.a.a.b.b.a.h(1, this.vQr) + 0;
            } else {
                h = 0;
            }
            if (this.kyJ != null) {
                h += e.a.a.b.b.a.h(2, this.kyJ);
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
            ake ake = (ake) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ake.vQr = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ake.kyJ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

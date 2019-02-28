package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class wl extends a {
    public String text;
    public int wnE;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.text != null) {
                aVar.g(1, this.text);
            }
            aVar.fX(2, this.wnE);
            return 0;
        } else if (i == 1) {
            if (this.text != null) {
                h = e.a.a.b.b.a.h(1, this.text) + 0;
            } else {
                h = 0;
            }
            return h + e.a.a.a.fU(2, this.wnE);
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
            wl wlVar = (wl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wlVar.text = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    wlVar.wnE = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

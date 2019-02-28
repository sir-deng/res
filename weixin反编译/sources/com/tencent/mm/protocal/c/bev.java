package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bev extends a {
    public String nkW;
    public int pgR;
    public String vQr;
    public String wfU;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkW != null) {
                aVar.g(1, this.nkW);
            }
            if (this.wfU != null) {
                aVar.g(2, this.wfU);
            }
            if (this.vQr != null) {
                aVar.g(3, this.vQr);
            }
            aVar.fX(4, this.pgR);
            return 0;
        } else if (i == 1) {
            if (this.nkW != null) {
                h = e.a.a.b.b.a.h(1, this.nkW) + 0;
            } else {
                h = 0;
            }
            if (this.wfU != null) {
                h += e.a.a.b.b.a.h(2, this.wfU);
            }
            if (this.vQr != null) {
                h += e.a.a.b.b.a.h(3, this.vQr);
            }
            return h + e.a.a.a.fU(4, this.pgR);
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
            bev bev = (bev) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bev.nkW = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bev.wfU = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bev.vQr = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bev.pgR = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

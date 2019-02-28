package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ald extends a {
    public int kzt;
    public String nkW;
    public String nlE;
    public String wgP;
    public String whT;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.whT != null) {
                aVar.g(1, this.whT);
            }
            aVar.fX(2, this.kzt);
            if (this.wgP != null) {
                aVar.g(3, this.wgP);
            }
            if (this.nlE != null) {
                aVar.g(4, this.nlE);
            }
            if (this.nkW == null) {
                return 0;
            }
            aVar.g(5, this.nkW);
            return 0;
        } else if (i == 1) {
            if (this.whT != null) {
                h = e.a.a.b.b.a.h(1, this.whT) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.kzt);
            if (this.wgP != null) {
                h += e.a.a.b.b.a.h(3, this.wgP);
            }
            if (this.nlE != null) {
                h += e.a.a.b.b.a.h(4, this.nlE);
            }
            if (this.nkW != null) {
                h += e.a.a.b.b.a.h(5, this.nkW);
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
            ald ald = (ald) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ald.whT = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ald.kzt = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ald.wgP = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ald.nlE = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ald.nkW = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

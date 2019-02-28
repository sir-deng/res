package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class dz extends a {
    public String nkM;
    public String nkN;
    public String nlr;
    public int npU;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkM != null) {
                aVar.g(1, this.nkM);
            }
            if (this.nkN != null) {
                aVar.g(2, this.nkN);
            }
            aVar.fX(3, this.npU);
            if (this.nlr == null) {
                return 0;
            }
            aVar.g(4, this.nlr);
            return 0;
        } else if (i == 1) {
            if (this.nkM != null) {
                h = e.a.a.b.b.a.h(1, this.nkM) + 0;
            } else {
                h = 0;
            }
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(2, this.nkN);
            }
            h += e.a.a.a.fU(3, this.npU);
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(4, this.nlr);
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
            dz dzVar = (dz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dzVar.nkM = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    dzVar.nkN = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    dzVar.npU = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    dzVar.nlr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

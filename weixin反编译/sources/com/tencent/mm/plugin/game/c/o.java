package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class o extends a {
    public String nkL;
    public String nkN;
    public String nkW;
    public String nlG;
    public int nlH;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlG != null) {
                aVar.g(1, this.nlG);
            }
            if (this.nkW != null) {
                aVar.g(2, this.nkW);
            }
            if (this.nkL != null) {
                aVar.g(3, this.nkL);
            }
            if (this.nkN != null) {
                aVar.g(4, this.nkN);
            }
            aVar.fX(5, this.nlH);
            return 0;
        } else if (i == 1) {
            if (this.nlG != null) {
                h = e.a.a.b.b.a.h(1, this.nlG) + 0;
            } else {
                h = 0;
            }
            if (this.nkW != null) {
                h += e.a.a.b.b.a.h(2, this.nkW);
            }
            if (this.nkL != null) {
                h += e.a.a.b.b.a.h(3, this.nkL);
            }
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(4, this.nkN);
            }
            return h + e.a.a.a.fU(5, this.nlH);
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
            o oVar = (o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oVar.nlG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    oVar.nkW = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    oVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    oVar.nkN = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    oVar.nlH = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

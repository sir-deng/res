package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class co extends a {
    public String fpg;
    public String nkL;
    public String nkM;
    public String nkN;
    public String nlr;
    public String noE;
    public String noR;
    public String noS;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.noE != null) {
                aVar.g(1, this.noE);
            }
            if (this.noR != null) {
                aVar.g(2, this.noR);
            }
            if (this.fpg != null) {
                aVar.g(3, this.fpg);
            }
            if (this.nkL != null) {
                aVar.g(4, this.nkL);
            }
            if (this.noS != null) {
                aVar.g(5, this.noS);
            }
            if (this.nkN != null) {
                aVar.g(6, this.nkN);
            }
            if (this.nkM != null) {
                aVar.g(7, this.nkM);
            }
            if (this.nlr == null) {
                return 0;
            }
            aVar.g(8, this.nlr);
            return 0;
        } else if (i == 1) {
            if (this.noE != null) {
                h = e.a.a.b.b.a.h(1, this.noE) + 0;
            } else {
                h = 0;
            }
            if (this.noR != null) {
                h += e.a.a.b.b.a.h(2, this.noR);
            }
            if (this.fpg != null) {
                h += e.a.a.b.b.a.h(3, this.fpg);
            }
            if (this.nkL != null) {
                h += e.a.a.b.b.a.h(4, this.nkL);
            }
            if (this.noS != null) {
                h += e.a.a.b.b.a.h(5, this.noS);
            }
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(6, this.nkN);
            }
            if (this.nkM != null) {
                h += e.a.a.b.b.a.h(7, this.nkM);
            }
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(8, this.nlr);
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
            co coVar = (co) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    coVar.noE = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    coVar.noR = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    coVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    coVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    coVar.noS = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    coVar.nkN = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    coVar.nkM = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    coVar.nlr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

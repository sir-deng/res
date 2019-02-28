package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class dp extends a {
    public String fpg;
    public String nkL;
    public String nkN;
    public String nlA;
    public String nlr;
    public String npI;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg != null) {
                aVar.g(1, this.fpg);
            }
            if (this.nkL != null) {
                aVar.g(2, this.nkL);
            }
            if (this.nlA != null) {
                aVar.g(3, this.nlA);
            }
            if (this.nkN != null) {
                aVar.g(4, this.nkN);
            }
            if (this.nlr != null) {
                aVar.g(5, this.nlr);
            }
            if (this.npI == null) {
                return 0;
            }
            aVar.g(6, this.npI);
            return 0;
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            if (this.nkL != null) {
                h += e.a.a.b.b.a.h(2, this.nkL);
            }
            if (this.nlA != null) {
                h += e.a.a.b.b.a.h(3, this.nlA);
            }
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(4, this.nkN);
            }
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(5, this.nlr);
            }
            if (this.npI != null) {
                h += e.a.a.b.b.a.h(6, this.npI);
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
            dp dpVar = (dp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dpVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    dpVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    dpVar.nlA = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    dpVar.nkN = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    dpVar.nlr = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    dpVar.npI = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

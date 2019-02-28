package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class l extends a {
    public String fpg;
    public String nkL;
    public String nkN;
    public String nlA;
    public String nlr;
    public int nlw;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlA == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nkN == null) {
                throw new b("Not all required fields were included: JumpUrl");
            } else {
                if (this.nlA != null) {
                    aVar.g(1, this.nlA);
                }
                if (this.fpg != null) {
                    aVar.g(2, this.fpg);
                }
                if (this.nkL != null) {
                    aVar.g(3, this.nkL);
                }
                if (this.nkN != null) {
                    aVar.g(4, this.nkN);
                }
                aVar.fX(5, this.nlw);
                if (this.nlr == null) {
                    return 0;
                }
                aVar.g(6, this.nlr);
                return 0;
            }
        } else if (i == 1) {
            if (this.nlA != null) {
                h = e.a.a.b.b.a.h(1, this.nlA) + 0;
            } else {
                h = 0;
            }
            if (this.fpg != null) {
                h += e.a.a.b.b.a.h(2, this.fpg);
            }
            if (this.nkL != null) {
                h += e.a.a.b.b.a.h(3, this.nkL);
            }
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(4, this.nkN);
            }
            h += e.a.a.a.fU(5, this.nlw);
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(6, this.nlr);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.nlA == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nkN != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: JumpUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.nlA = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    lVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    lVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    lVar.nkN = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    lVar.nlw = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    lVar.nlr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

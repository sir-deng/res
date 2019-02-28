package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class eg extends a {
    public String fpg;
    public String nkM;
    public String nkN;
    public String nlI;
    public String noE;
    public String noP;
    public String noS;
    public String npY;
    public String npZ;
    public int nqa;
    public String nqb;
    public String nqc;
    public String nqd;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.fpg != null) {
                aVar.g(1, this.fpg);
            }
            if (this.noS != null) {
                aVar.g(2, this.noS);
            }
            if (this.npY != null) {
                aVar.g(3, this.npY);
            }
            if (this.npZ != null) {
                aVar.g(4, this.npZ);
            }
            if (this.nkM != null) {
                aVar.g(5, this.nkM);
            }
            if (this.noE != null) {
                aVar.g(6, this.noE);
            }
            aVar.fX(7, this.nqa);
            if (this.nkN != null) {
                aVar.g(8, this.nkN);
            }
            if (this.nlI != null) {
                aVar.g(9, this.nlI);
            }
            if (this.nqb != null) {
                aVar.g(10, this.nqb);
            }
            if (this.nqc != null) {
                aVar.g(11, this.nqc);
            }
            if (this.noP != null) {
                aVar.g(12, this.noP);
            }
            if (this.nqd == null) {
                return 0;
            }
            aVar.g(13, this.nqd);
            return 0;
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            if (this.noS != null) {
                h += e.a.a.b.b.a.h(2, this.noS);
            }
            if (this.npY != null) {
                h += e.a.a.b.b.a.h(3, this.npY);
            }
            if (this.npZ != null) {
                h += e.a.a.b.b.a.h(4, this.npZ);
            }
            if (this.nkM != null) {
                h += e.a.a.b.b.a.h(5, this.nkM);
            }
            if (this.noE != null) {
                h += e.a.a.b.b.a.h(6, this.noE);
            }
            h += e.a.a.a.fU(7, this.nqa);
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(8, this.nkN);
            }
            if (this.nlI != null) {
                h += e.a.a.b.b.a.h(9, this.nlI);
            }
            if (this.nqb != null) {
                h += e.a.a.b.b.a.h(10, this.nqb);
            }
            if (this.nqc != null) {
                h += e.a.a.b.b.a.h(11, this.nqc);
            }
            if (this.noP != null) {
                h += e.a.a.b.b.a.h(12, this.noP);
            }
            if (this.nqd != null) {
                h += e.a.a.b.b.a.h(13, this.nqd);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.fpg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            eg egVar = (eg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    egVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    egVar.noS = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    egVar.npY = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    egVar.npZ = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    egVar.nkM = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    egVar.noE = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    egVar.nqa = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    egVar.nkN = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    egVar.nlI = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    egVar.nqb = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    egVar.nqc = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    egVar.noP = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    egVar.nqd = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

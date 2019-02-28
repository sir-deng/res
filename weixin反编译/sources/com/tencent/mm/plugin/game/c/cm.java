package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class cm extends a {
    public String fpg;
    public String nkL;
    public String nkM;
    public String nkN;
    public int noO;
    public String noP;
    public boolean noQ;

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
            if (this.nkM != null) {
                aVar.g(3, this.nkM);
            }
            aVar.fX(4, this.noO);
            if (this.nkN != null) {
                aVar.g(6, this.nkN);
            }
            if (this.noP != null) {
                aVar.g(7, this.noP);
            }
            aVar.am(8, this.noQ);
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
            if (this.nkM != null) {
                h += e.a.a.b.b.a.h(3, this.nkM);
            }
            h += e.a.a.a.fU(4, this.noO);
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(6, this.nkN);
            }
            if (this.noP != null) {
                h += e.a.a.b.b.a.h(7, this.noP);
            }
            return h + (e.a.a.b.b.a.dX(8) + 1);
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
            cm cmVar = (cm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cmVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cmVar.nkM = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cmVar.noO = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    cmVar.nkN = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    cmVar.noP = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    cmVar.noQ = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

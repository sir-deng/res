package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class cbj extends a {
    public String bhd;
    public String lUI;
    public String lUJ;
    public String pka;
    public String rlx;
    public String skF;
    public String skG;
    public String skH;
    public String skL;
    public String skM;
    public String ttO;
    public String ttP;
    public String ttQ;
    public String ttR;
    public long ttS;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ttO != null) {
                aVar.g(1, this.ttO);
            }
            if (this.ttP != null) {
                aVar.g(2, this.ttP);
            }
            if (this.ttQ != null) {
                aVar.g(3, this.ttQ);
            }
            if (this.ttR != null) {
                aVar.g(4, this.ttR);
            }
            aVar.S(5, this.ttS);
            if (this.skL != null) {
                aVar.g(6, this.skL);
            }
            if (this.lUI != null) {
                aVar.g(7, this.lUI);
            }
            if (this.lUJ != null) {
                aVar.g(8, this.lUJ);
            }
            if (this.rlx != null) {
                aVar.g(9, this.rlx);
            }
            if (this.skF != null) {
                aVar.g(10, this.skF);
            }
            if (this.skG != null) {
                aVar.g(11, this.skG);
            }
            if (this.skH != null) {
                aVar.g(12, this.skH);
            }
            if (this.bhd != null) {
                aVar.g(13, this.bhd);
            }
            if (this.pka != null) {
                aVar.g(14, this.pka);
            }
            if (this.skM == null) {
                return 0;
            }
            aVar.g(15, this.skM);
            return 0;
        } else if (i == 1) {
            if (this.ttO != null) {
                h = e.a.a.b.b.a.h(1, this.ttO) + 0;
            } else {
                h = 0;
            }
            if (this.ttP != null) {
                h += e.a.a.b.b.a.h(2, this.ttP);
            }
            if (this.ttQ != null) {
                h += e.a.a.b.b.a.h(3, this.ttQ);
            }
            if (this.ttR != null) {
                h += e.a.a.b.b.a.h(4, this.ttR);
            }
            h += e.a.a.a.R(5, this.ttS);
            if (this.skL != null) {
                h += e.a.a.b.b.a.h(6, this.skL);
            }
            if (this.lUI != null) {
                h += e.a.a.b.b.a.h(7, this.lUI);
            }
            if (this.lUJ != null) {
                h += e.a.a.b.b.a.h(8, this.lUJ);
            }
            if (this.rlx != null) {
                h += e.a.a.b.b.a.h(9, this.rlx);
            }
            if (this.skF != null) {
                h += e.a.a.b.b.a.h(10, this.skF);
            }
            if (this.skG != null) {
                h += e.a.a.b.b.a.h(11, this.skG);
            }
            if (this.skH != null) {
                h += e.a.a.b.b.a.h(12, this.skH);
            }
            if (this.bhd != null) {
                h += e.a.a.b.b.a.h(13, this.bhd);
            }
            if (this.pka != null) {
                h += e.a.a.b.b.a.h(14, this.pka);
            }
            if (this.skM != null) {
                h += e.a.a.b.b.a.h(15, this.skM);
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
            cbj cbj = (cbj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbj.ttO = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cbj.ttP = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cbj.ttQ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cbj.ttR = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    cbj.ttS = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    cbj.skL = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    cbj.lUI = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    cbj.lUJ = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    cbj.rlx = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    cbj.skF = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    cbj.skG = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    cbj.skH = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    cbj.bhd = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    cbj.pka = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    cbj.skM = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

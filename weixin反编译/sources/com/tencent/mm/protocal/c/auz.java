package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class auz extends a {
    public String nkU;
    public int nlb;
    public String nlq;
    public String noG;
    public String vML;
    public String vMN;
    public String vTQ;
    public int vTR;
    public String wJB;
    public String wJC;
    public String wJD;
    public String wJE;
    public String wJF;
    public String wJG;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkU != null) {
                aVar.g(1, this.nkU);
            }
            if (this.noG != null) {
                aVar.g(2, this.noG);
            }
            if (this.wJB != null) {
                aVar.g(3, this.wJB);
            }
            if (this.vML != null) {
                aVar.g(4, this.vML);
            }
            if (this.nlq != null) {
                aVar.g(5, this.nlq);
            }
            aVar.fX(6, this.vTR);
            if (this.wJC != null) {
                aVar.g(7, this.wJC);
            }
            if (this.vMN != null) {
                aVar.g(8, this.vMN);
            }
            if (this.vTQ != null) {
                aVar.g(9, this.vTQ);
            }
            if (this.wJD != null) {
                aVar.g(10, this.wJD);
            }
            if (this.wJE != null) {
                aVar.g(11, this.wJE);
            }
            if (this.wJF != null) {
                aVar.g(12, this.wJF);
            }
            if (this.wJG != null) {
                aVar.g(13, this.wJG);
            }
            aVar.fX(14, this.nlb);
            return 0;
        } else if (i == 1) {
            if (this.nkU != null) {
                h = e.a.a.b.b.a.h(1, this.nkU) + 0;
            } else {
                h = 0;
            }
            if (this.noG != null) {
                h += e.a.a.b.b.a.h(2, this.noG);
            }
            if (this.wJB != null) {
                h += e.a.a.b.b.a.h(3, this.wJB);
            }
            if (this.vML != null) {
                h += e.a.a.b.b.a.h(4, this.vML);
            }
            if (this.nlq != null) {
                h += e.a.a.b.b.a.h(5, this.nlq);
            }
            h += e.a.a.a.fU(6, this.vTR);
            if (this.wJC != null) {
                h += e.a.a.b.b.a.h(7, this.wJC);
            }
            if (this.vMN != null) {
                h += e.a.a.b.b.a.h(8, this.vMN);
            }
            if (this.vTQ != null) {
                h += e.a.a.b.b.a.h(9, this.vTQ);
            }
            if (this.wJD != null) {
                h += e.a.a.b.b.a.h(10, this.wJD);
            }
            if (this.wJE != null) {
                h += e.a.a.b.b.a.h(11, this.wJE);
            }
            if (this.wJF != null) {
                h += e.a.a.b.b.a.h(12, this.wJF);
            }
            if (this.wJG != null) {
                h += e.a.a.b.b.a.h(13, this.wJG);
            }
            return h + e.a.a.a.fU(14, this.nlb);
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
            auz auz = (auz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    auz.nkU = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    auz.noG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    auz.wJB = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    auz.vML = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    auz.nlq = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    auz.vTR = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    auz.wJC = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    auz.vMN = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    auz.vTQ = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    auz.wJD = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    auz.wJE = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    auz.wJF = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    auz.wJG = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    auz.nlb = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class hl extends a {
    public String nkW;
    public String nlV;
    public int nlb;
    public String vMN;
    public String vMO;
    public String vPF;
    public String vPL;
    public String vPN;
    public String vTI;
    public String vTJ;
    public String vTK;
    public String vTL;
    public String vTM;
    public String vTN;
    public String vTO;
    public String vTP;
    public String vTQ;
    public int vTR;
    public int vTS;
    public String vTT;
    public String vTU;
    public String vTV;
    public long vTW;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlV != null) {
                aVar.g(1, this.nlV);
            }
            if (this.nkW != null) {
                aVar.g(2, this.nkW);
            }
            if (this.vPF != null) {
                aVar.g(3, this.vPF);
            }
            if (this.vTI != null) {
                aVar.g(4, this.vTI);
            }
            if (this.vTJ != null) {
                aVar.g(5, this.vTJ);
            }
            if (this.vTK != null) {
                aVar.g(6, this.vTK);
            }
            if (this.vTL != null) {
                aVar.g(7, this.vTL);
            }
            if (this.vTM != null) {
                aVar.g(8, this.vTM);
            }
            if (this.vTN != null) {
                aVar.g(9, this.vTN);
            }
            if (this.vTO != null) {
                aVar.g(10, this.vTO);
            }
            if (this.vTP != null) {
                aVar.g(11, this.vTP);
            }
            if (this.vMN != null) {
                aVar.g(12, this.vMN);
            }
            if (this.vTQ != null) {
                aVar.g(13, this.vTQ);
            }
            if (this.vPL != null) {
                aVar.g(14, this.vPL);
            }
            if (this.vPN != null) {
                aVar.g(15, this.vPN);
            }
            aVar.fX(16, this.nlb);
            aVar.fX(17, this.vTR);
            aVar.fX(18, this.vTS);
            if (this.vTT != null) {
                aVar.g(19, this.vTT);
            }
            if (this.vTU != null) {
                aVar.g(20, this.vTU);
            }
            if (this.vTV != null) {
                aVar.g(21, this.vTV);
            }
            if (this.vMO != null) {
                aVar.g(22, this.vMO);
            }
            aVar.S(23, this.vTW);
            return 0;
        } else if (i == 1) {
            if (this.nlV != null) {
                h = e.a.a.b.b.a.h(1, this.nlV) + 0;
            } else {
                h = 0;
            }
            if (this.nkW != null) {
                h += e.a.a.b.b.a.h(2, this.nkW);
            }
            if (this.vPF != null) {
                h += e.a.a.b.b.a.h(3, this.vPF);
            }
            if (this.vTI != null) {
                h += e.a.a.b.b.a.h(4, this.vTI);
            }
            if (this.vTJ != null) {
                h += e.a.a.b.b.a.h(5, this.vTJ);
            }
            if (this.vTK != null) {
                h += e.a.a.b.b.a.h(6, this.vTK);
            }
            if (this.vTL != null) {
                h += e.a.a.b.b.a.h(7, this.vTL);
            }
            if (this.vTM != null) {
                h += e.a.a.b.b.a.h(8, this.vTM);
            }
            if (this.vTN != null) {
                h += e.a.a.b.b.a.h(9, this.vTN);
            }
            if (this.vTO != null) {
                h += e.a.a.b.b.a.h(10, this.vTO);
            }
            if (this.vTP != null) {
                h += e.a.a.b.b.a.h(11, this.vTP);
            }
            if (this.vMN != null) {
                h += e.a.a.b.b.a.h(12, this.vMN);
            }
            if (this.vTQ != null) {
                h += e.a.a.b.b.a.h(13, this.vTQ);
            }
            if (this.vPL != null) {
                h += e.a.a.b.b.a.h(14, this.vPL);
            }
            if (this.vPN != null) {
                h += e.a.a.b.b.a.h(15, this.vPN);
            }
            h = ((h + e.a.a.a.fU(16, this.nlb)) + e.a.a.a.fU(17, this.vTR)) + e.a.a.a.fU(18, this.vTS);
            if (this.vTT != null) {
                h += e.a.a.b.b.a.h(19, this.vTT);
            }
            if (this.vTU != null) {
                h += e.a.a.b.b.a.h(20, this.vTU);
            }
            if (this.vTV != null) {
                h += e.a.a.b.b.a.h(21, this.vTV);
            }
            if (this.vMO != null) {
                h += e.a.a.b.b.a.h(22, this.vMO);
            }
            return h + e.a.a.a.R(23, this.vTW);
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
            hl hlVar = (hl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hlVar.nlV = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    hlVar.nkW = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    hlVar.vPF = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    hlVar.vTI = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    hlVar.vTJ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    hlVar.vTK = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    hlVar.vTL = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    hlVar.vTM = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    hlVar.vTN = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    hlVar.vTO = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    hlVar.vTP = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    hlVar.vMN = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    hlVar.vTQ = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    hlVar.vPL = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    hlVar.vPN = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    hlVar.nlb = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    hlVar.vTR = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    hlVar.vTS = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    hlVar.vTT = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    hlVar.vTU = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    hlVar.vTV = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    hlVar.vMO = aVar3.AEQ.readString();
                    return 0;
                case 23:
                    hlVar.vTW = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

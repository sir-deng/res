package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bbu extends a {
    public String nkU;
    public String nlN;
    public int nlb;
    public String noG;
    public String vMJ;
    public String vMK;
    public String vML;
    public String vMM;
    public String vMN;
    public String vMO;
    public cdw vMP;
    public String vPL;
    public int wHY;
    public String wOJ;
    public String wOK;
    public int wOL;
    public LinkedList<bet> wOM = new LinkedList();
    public String wON;
    public String wOO;
    public String wOP;
    public String wOQ;
    public String wOR;
    public String wOS;
    public String wOT;
    public int wOU;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkU != null) {
                aVar.g(1, this.nkU);
            }
            if (this.noG != null) {
                aVar.g(2, this.noG);
            }
            if (this.vML != null) {
                aVar.g(3, this.vML);
            }
            if (this.wOJ != null) {
                aVar.g(4, this.wOJ);
            }
            if (this.vMK != null) {
                aVar.g(5, this.vMK);
            }
            if (this.vMJ != null) {
                aVar.g(6, this.vMJ);
            }
            if (this.wOK != null) {
                aVar.g(7, this.wOK);
            }
            aVar.fX(8, this.wOL);
            aVar.d(9, 8, this.wOM);
            if (this.vMM != null) {
                aVar.g(10, this.vMM);
            }
            if (this.wON != null) {
                aVar.g(11, this.wON);
            }
            if (this.wOO != null) {
                aVar.g(12, this.wOO);
            }
            aVar.fX(13, this.wHY);
            if (this.vPL != null) {
                aVar.g(14, this.vPL);
            }
            if (this.nlN != null) {
                aVar.g(15, this.nlN);
            }
            if (this.vMN != null) {
                aVar.g(16, this.vMN);
            }
            if (this.wOP != null) {
                aVar.g(17, this.wOP);
            }
            if (this.wOQ != null) {
                aVar.g(18, this.wOQ);
            }
            if (this.vMO != null) {
                aVar.g(19, this.vMO);
            }
            if (this.wOR != null) {
                aVar.g(20, this.wOR);
            }
            if (this.wOS != null) {
                aVar.g(21, this.wOS);
            }
            if (this.vMP != null) {
                aVar.fZ(22, this.vMP.bkL());
                this.vMP.a(aVar);
            }
            if (this.wOT != null) {
                aVar.g(23, this.wOT);
            }
            aVar.fX(24, this.wOU);
            aVar.fX(25, this.nlb);
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
            if (this.vML != null) {
                h += e.a.a.b.b.a.h(3, this.vML);
            }
            if (this.wOJ != null) {
                h += e.a.a.b.b.a.h(4, this.wOJ);
            }
            if (this.vMK != null) {
                h += e.a.a.b.b.a.h(5, this.vMK);
            }
            if (this.vMJ != null) {
                h += e.a.a.b.b.a.h(6, this.vMJ);
            }
            if (this.wOK != null) {
                h += e.a.a.b.b.a.h(7, this.wOK);
            }
            h = (h + e.a.a.a.fU(8, this.wOL)) + e.a.a.a.c(9, 8, this.wOM);
            if (this.vMM != null) {
                h += e.a.a.b.b.a.h(10, this.vMM);
            }
            if (this.wON != null) {
                h += e.a.a.b.b.a.h(11, this.wON);
            }
            if (this.wOO != null) {
                h += e.a.a.b.b.a.h(12, this.wOO);
            }
            h += e.a.a.a.fU(13, this.wHY);
            if (this.vPL != null) {
                h += e.a.a.b.b.a.h(14, this.vPL);
            }
            if (this.nlN != null) {
                h += e.a.a.b.b.a.h(15, this.nlN);
            }
            if (this.vMN != null) {
                h += e.a.a.b.b.a.h(16, this.vMN);
            }
            if (this.wOP != null) {
                h += e.a.a.b.b.a.h(17, this.wOP);
            }
            if (this.wOQ != null) {
                h += e.a.a.b.b.a.h(18, this.wOQ);
            }
            if (this.vMO != null) {
                h += e.a.a.b.b.a.h(19, this.vMO);
            }
            if (this.wOR != null) {
                h += e.a.a.b.b.a.h(20, this.wOR);
            }
            if (this.wOS != null) {
                h += e.a.a.b.b.a.h(21, this.wOS);
            }
            if (this.vMP != null) {
                h += e.a.a.a.fW(22, this.vMP.bkL());
            }
            if (this.wOT != null) {
                h += e.a.a.b.b.a.h(23, this.wOT);
            }
            return (h + e.a.a.a.fU(24, this.wOU)) + e.a.a.a.fU(25, this.nlb);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wOM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            bbu bbu = (bbu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a bet;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bbu.nkU = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bbu.noG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bbu.vML = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bbu.wOJ = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bbu.vMK = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bbu.vMJ = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bbu.wOK = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bbu.wOL = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bbu.wOM.add(bet);
                    }
                    return 0;
                case 10:
                    bbu.vMM = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    bbu.wON = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    bbu.wOO = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    bbu.wHY = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    bbu.vPL = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    bbu.nlN = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    bbu.vMN = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    bbu.wOP = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    bbu.wOQ = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    bbu.vMO = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    bbu.wOR = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    bbu.wOS = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new cdw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bbu.vMP = bet;
                    }
                    return 0;
                case 23:
                    bbu.wOT = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    bbu.wOU = aVar3.AEQ.rz();
                    return 0;
                case 25:
                    bbu.nlb = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

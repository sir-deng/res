package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class st extends a {
    public int kzy;
    public String nlA;
    public String vPI;
    public int whA;
    public int whB;
    public LinkedList<bet> whC = new LinkedList();
    public String whD;
    public int whE;
    public String whF;
    public String whG;
    public String whH;
    public String whI;
    public String whJ;
    public int whK;
    public LinkedList<awi> whL = new LinkedList();
    public String whM;
    public String whN;
    public String whO;
    public ss whP;
    public aya whQ;
    public String whv;
    public String whw;
    public String whx;
    public String why;
    public int whz;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPI != null) {
                aVar.g(1, this.vPI);
            }
            if (this.nlA != null) {
                aVar.g(2, this.nlA);
            }
            if (this.whv != null) {
                aVar.g(3, this.whv);
            }
            if (this.whw != null) {
                aVar.g(4, this.whw);
            }
            if (this.whx != null) {
                aVar.g(5, this.whx);
            }
            if (this.why != null) {
                aVar.g(6, this.why);
            }
            aVar.fX(7, this.whz);
            aVar.fX(8, this.whA);
            aVar.fX(9, this.whB);
            aVar.d(10, 8, this.whC);
            if (this.whD != null) {
                aVar.g(11, this.whD);
            }
            aVar.fX(12, this.whE);
            if (this.whF != null) {
                aVar.g(13, this.whF);
            }
            if (this.whG != null) {
                aVar.g(14, this.whG);
            }
            if (this.whH != null) {
                aVar.g(15, this.whH);
            }
            if (this.whI != null) {
                aVar.g(16, this.whI);
            }
            if (this.whJ != null) {
                aVar.g(17, this.whJ);
            }
            aVar.fX(18, this.whK);
            aVar.d(19, 8, this.whL);
            aVar.fX(20, this.kzy);
            if (this.whM != null) {
                aVar.g(21, this.whM);
            }
            if (this.whN != null) {
                aVar.g(22, this.whN);
            }
            if (this.whO != null) {
                aVar.g(23, this.whO);
            }
            if (this.whP != null) {
                aVar.fZ(24, this.whP.bkL());
                this.whP.a(aVar);
            }
            if (this.whQ == null) {
                return 0;
            }
            aVar.fZ(25, this.whQ.bkL());
            this.whQ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vPI != null) {
                h = e.a.a.b.b.a.h(1, this.vPI) + 0;
            } else {
                h = 0;
            }
            if (this.nlA != null) {
                h += e.a.a.b.b.a.h(2, this.nlA);
            }
            if (this.whv != null) {
                h += e.a.a.b.b.a.h(3, this.whv);
            }
            if (this.whw != null) {
                h += e.a.a.b.b.a.h(4, this.whw);
            }
            if (this.whx != null) {
                h += e.a.a.b.b.a.h(5, this.whx);
            }
            if (this.why != null) {
                h += e.a.a.b.b.a.h(6, this.why);
            }
            h = (((h + e.a.a.a.fU(7, this.whz)) + e.a.a.a.fU(8, this.whA)) + e.a.a.a.fU(9, this.whB)) + e.a.a.a.c(10, 8, this.whC);
            if (this.whD != null) {
                h += e.a.a.b.b.a.h(11, this.whD);
            }
            h += e.a.a.a.fU(12, this.whE);
            if (this.whF != null) {
                h += e.a.a.b.b.a.h(13, this.whF);
            }
            if (this.whG != null) {
                h += e.a.a.b.b.a.h(14, this.whG);
            }
            if (this.whH != null) {
                h += e.a.a.b.b.a.h(15, this.whH);
            }
            if (this.whI != null) {
                h += e.a.a.b.b.a.h(16, this.whI);
            }
            if (this.whJ != null) {
                h += e.a.a.b.b.a.h(17, this.whJ);
            }
            h = ((h + e.a.a.a.fU(18, this.whK)) + e.a.a.a.c(19, 8, this.whL)) + e.a.a.a.fU(20, this.kzy);
            if (this.whM != null) {
                h += e.a.a.b.b.a.h(21, this.whM);
            }
            if (this.whN != null) {
                h += e.a.a.b.b.a.h(22, this.whN);
            }
            if (this.whO != null) {
                h += e.a.a.b.b.a.h(23, this.whO);
            }
            if (this.whP != null) {
                h += e.a.a.a.fW(24, this.whP.bkL());
            }
            if (this.whQ != null) {
                h += e.a.a.a.fW(25, this.whQ.bkL());
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.whC.clear();
            this.whL.clear();
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
            st stVar = (st) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a bet;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    stVar.vPI = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    stVar.nlA = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    stVar.whv = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    stVar.whw = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    stVar.whx = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    stVar.why = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    stVar.whz = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    stVar.whA = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    stVar.whB = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        stVar.whC.add(bet);
                    }
                    return 0;
                case 11:
                    stVar.whD = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    stVar.whE = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    stVar.whF = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    stVar.whG = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    stVar.whH = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    stVar.whI = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    stVar.whJ = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    stVar.whK = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new awi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        stVar.whL.add(bet);
                    }
                    return 0;
                case 20:
                    stVar.kzy = aVar3.AEQ.rz();
                    return 0;
                case 21:
                    stVar.whM = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    stVar.whN = aVar3.AEQ.readString();
                    return 0;
                case 23:
                    stVar.whO = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new ss();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        stVar.whP = bet;
                    }
                    return 0;
                case 25:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new aya();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        stVar.whQ = bet;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

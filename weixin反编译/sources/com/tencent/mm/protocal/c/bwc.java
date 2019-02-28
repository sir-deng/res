package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bwc extends bek {
    public int vQF;
    public LinkedList<buv> vQG = new LinkedList();
    public int wNd;
    public int wil;
    public long wim;
    public int xcA;
    public int xcB;
    public int xcC;
    public int xcD;
    public int xcE;
    public int xcF;
    public int xcG;
    public int xcH;
    public int xcI;
    public int xcJ;
    public int xcK;
    public int xcL;
    public int xcM;
    public bwd xco;
    public int xcp;
    public int xcq;
    public int xcr;
    public int xcs;
    public int xcx;
    public LinkedList<bwe> xcy = new LinkedList();
    public int xcz;
    public int xdv;
    public int xdw;
    public int xdx;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            aVar.fX(2, this.wil);
            aVar.fX(3, this.vQF);
            aVar.d(4, 8, this.vQG);
            aVar.S(5, this.wim);
            aVar.fX(6, this.wNd);
            if (this.xco != null) {
                aVar.fZ(7, this.xco.bkL());
                this.xco.a(aVar);
            }
            aVar.fX(8, this.xcx);
            aVar.d(9, 8, this.xcy);
            aVar.fX(10, this.xcz);
            aVar.fX(11, this.xcA);
            aVar.fX(12, this.xcB);
            aVar.fX(13, this.xcC);
            aVar.fX(14, this.xdv);
            aVar.fX(15, this.xcD);
            aVar.fX(16, this.xcE);
            aVar.fX(17, this.xcp);
            aVar.fX(18, this.xcF);
            aVar.fX(19, this.xcG);
            aVar.fX(20, this.xcq);
            aVar.fX(21, this.xcH);
            aVar.fX(22, this.xcI);
            aVar.fX(23, this.xcJ);
            aVar.fX(24, this.xdw);
            aVar.fX(25, this.xcK);
            aVar.fX(26, this.xdx);
            aVar.fX(27, this.xcr);
            aVar.fX(28, this.xcs);
            aVar.fX(29, this.xcL);
            aVar.fX(30, this.xcM);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((((fW + e.a.a.a.fU(2, this.wil)) + e.a.a.a.fU(3, this.vQF)) + e.a.a.a.c(4, 8, this.vQG)) + e.a.a.a.R(5, this.wim)) + e.a.a.a.fU(6, this.wNd);
            if (this.xco != null) {
                fW += e.a.a.a.fW(7, this.xco.bkL());
            }
            return ((((((((((((((((((((((fW + e.a.a.a.fU(8, this.xcx)) + e.a.a.a.c(9, 8, this.xcy)) + e.a.a.a.fU(10, this.xcz)) + e.a.a.a.fU(11, this.xcA)) + e.a.a.a.fU(12, this.xcB)) + e.a.a.a.fU(13, this.xcC)) + e.a.a.a.fU(14, this.xdv)) + e.a.a.a.fU(15, this.xcD)) + e.a.a.a.fU(16, this.xcE)) + e.a.a.a.fU(17, this.xcp)) + e.a.a.a.fU(18, this.xcF)) + e.a.a.a.fU(19, this.xcG)) + e.a.a.a.fU(20, this.xcq)) + e.a.a.a.fU(21, this.xcH)) + e.a.a.a.fU(22, this.xcI)) + e.a.a.a.fU(23, this.xcJ)) + e.a.a.a.fU(24, this.xdw)) + e.a.a.a.fU(25, this.xcK)) + e.a.a.a.fU(26, this.xdx)) + e.a.a.a.fU(27, this.xcr)) + e.a.a.a.fU(28, this.xcs)) + e.a.a.a.fU(29, this.xcL)) + e.a.a.a.fU(30, this.xcM);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vQG.clear();
            this.xcy.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bwc bwc = (bwc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            com.tencent.mm.bp.a fiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bwc.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bwc.wil = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bwc.vQF = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new buv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bwc.vQG.add(fiVar);
                    }
                    return 0;
                case 5:
                    bwc.wim = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    bwc.wNd = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bwd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bwc.xco = fiVar;
                    }
                    return 0;
                case 8:
                    bwc.xcx = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bwe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bwc.xcy.add(fiVar);
                    }
                    return 0;
                case 10:
                    bwc.xcz = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    bwc.xcA = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bwc.xcB = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    bwc.xcC = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    bwc.xdv = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    bwc.xcD = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    bwc.xcE = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    bwc.xcp = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    bwc.xcF = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    bwc.xcG = aVar3.AEQ.rz();
                    return 0;
                case 20:
                    bwc.xcq = aVar3.AEQ.rz();
                    return 0;
                case 21:
                    bwc.xcH = aVar3.AEQ.rz();
                    return 0;
                case 22:
                    bwc.xcI = aVar3.AEQ.rz();
                    return 0;
                case 23:
                    bwc.xcJ = aVar3.AEQ.rz();
                    return 0;
                case 24:
                    bwc.xdw = aVar3.AEQ.rz();
                    return 0;
                case 25:
                    bwc.xcK = aVar3.AEQ.rz();
                    return 0;
                case 26:
                    bwc.xdx = aVar3.AEQ.rz();
                    return 0;
                case 27:
                    bwc.xcr = aVar3.AEQ.rz();
                    return 0;
                case 28:
                    bwc.xcs = aVar3.AEQ.rz();
                    return 0;
                case 29:
                    bwc.xcL = aVar3.AEQ.rz();
                    return 0;
                case 30:
                    bwc.xcM = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

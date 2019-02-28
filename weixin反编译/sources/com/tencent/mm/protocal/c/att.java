package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class att extends bek {
    public String kyG;
    public int kyY;
    public int lTO;
    public String lTQ;
    public String vKL;
    public String vMe;
    public int vMh;
    public String vMk;
    public String vMl;
    public int vMm;
    public String vMn;
    public String vPY;
    public bjx vQb;
    public int vQg;
    public akv vTh;
    public ir vTi;
    public atk vTj;
    public jx vZH;
    public jx vZI;
    public jx vZJ;
    public String wIq;
    public int wIr;
    public String wIs;
    public int wIt;
    public ayk wIu;
    public int wIv;
    public String wIw;
    public String wIx;
    public bgt wIy;
    public String wuU;
    public bes wuX;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            aVar.fX(2, this.lTO);
            if (this.vKL != null) {
                aVar.g(3, this.vKL);
            }
            if (this.vMk != null) {
                aVar.g(4, this.vMk);
            }
            if (this.vMl != null) {
                aVar.g(5, this.vMl);
            }
            if (this.wIq != null) {
                aVar.g(6, this.wIq);
            }
            if (this.vMe != null) {
                aVar.g(7, this.vMe);
            }
            aVar.fX(8, this.vMm);
            aVar.fX(9, this.wIr);
            if (this.wIs != null) {
                aVar.g(10, this.wIs);
            }
            if (this.vTi != null) {
                aVar.fZ(14, this.vTi.bkL());
                this.vTi.a(aVar);
            }
            if (this.vMn != null) {
                aVar.g(15, this.vMn);
            }
            if (this.kyG != null) {
                aVar.g(16, this.kyG);
            }
            aVar.fX(17, this.kyY);
            if (this.vTj != null) {
                aVar.fZ(18, this.vTj.bkL());
                this.vTj.a(aVar);
            }
            aVar.fX(19, this.wIt);
            aVar.fX(20, this.vMh);
            if (this.vPY != null) {
                aVar.g(21, this.vPY);
            }
            if (this.wIu != null) {
                aVar.fZ(22, this.wIu.bkL());
                this.wIu.a(aVar);
            }
            if (this.lTQ != null) {
                aVar.g(23, this.lTQ);
            }
            aVar.fX(24, this.wIv);
            if (this.vTh != null) {
                aVar.fZ(25, this.vTh.bkL());
                this.vTh.a(aVar);
            }
            if (this.wIw != null) {
                aVar.g(26, this.wIw);
            }
            if (this.vZH != null) {
                aVar.fZ(27, this.vZH.bkL());
                this.vZH.a(aVar);
            }
            if (this.wIx != null) {
                aVar.g(28, this.wIx);
            }
            if (this.wuU != null) {
                aVar.g(29, this.wuU);
            }
            if (this.wuX != null) {
                aVar.fZ(30, this.wuX.bkL());
                this.wuX.a(aVar);
            }
            if (this.vQb != null) {
                aVar.fZ(31, this.vQb.bkL());
                this.vQb.a(aVar);
            }
            if (this.vZI != null) {
                aVar.fZ(32, this.vZI.bkL());
                this.vZI.a(aVar);
            }
            if (this.vZJ != null) {
                aVar.fZ(33, this.vZJ.bkL());
                this.vZJ.a(aVar);
            }
            if (this.wIy != null) {
                aVar.fZ(34, this.wIy.bkL());
                this.wIy.a(aVar);
            }
            aVar.fX(35, this.vQg);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.lTO);
            if (this.vKL != null) {
                fW += e.a.a.b.b.a.h(3, this.vKL);
            }
            if (this.vMk != null) {
                fW += e.a.a.b.b.a.h(4, this.vMk);
            }
            if (this.vMl != null) {
                fW += e.a.a.b.b.a.h(5, this.vMl);
            }
            if (this.wIq != null) {
                fW += e.a.a.b.b.a.h(6, this.wIq);
            }
            if (this.vMe != null) {
                fW += e.a.a.b.b.a.h(7, this.vMe);
            }
            fW = (fW + e.a.a.a.fU(8, this.vMm)) + e.a.a.a.fU(9, this.wIr);
            if (this.wIs != null) {
                fW += e.a.a.b.b.a.h(10, this.wIs);
            }
            if (this.vTi != null) {
                fW += e.a.a.a.fW(14, this.vTi.bkL());
            }
            if (this.vMn != null) {
                fW += e.a.a.b.b.a.h(15, this.vMn);
            }
            if (this.kyG != null) {
                fW += e.a.a.b.b.a.h(16, this.kyG);
            }
            fW += e.a.a.a.fU(17, this.kyY);
            if (this.vTj != null) {
                fW += e.a.a.a.fW(18, this.vTj.bkL());
            }
            fW = (fW + e.a.a.a.fU(19, this.wIt)) + e.a.a.a.fU(20, this.vMh);
            if (this.vPY != null) {
                fW += e.a.a.b.b.a.h(21, this.vPY);
            }
            if (this.wIu != null) {
                fW += e.a.a.a.fW(22, this.wIu.bkL());
            }
            if (this.lTQ != null) {
                fW += e.a.a.b.b.a.h(23, this.lTQ);
            }
            fW += e.a.a.a.fU(24, this.wIv);
            if (this.vTh != null) {
                fW += e.a.a.a.fW(25, this.vTh.bkL());
            }
            if (this.wIw != null) {
                fW += e.a.a.b.b.a.h(26, this.wIw);
            }
            if (this.vZH != null) {
                fW += e.a.a.a.fW(27, this.vZH.bkL());
            }
            if (this.wIx != null) {
                fW += e.a.a.b.b.a.h(28, this.wIx);
            }
            if (this.wuU != null) {
                fW += e.a.a.b.b.a.h(29, this.wuU);
            }
            if (this.wuX != null) {
                fW += e.a.a.a.fW(30, this.wuX.bkL());
            }
            if (this.vQb != null) {
                fW += e.a.a.a.fW(31, this.vQb.bkL());
            }
            if (this.vZI != null) {
                fW += e.a.a.a.fW(32, this.vZI.bkL());
            }
            if (this.vZJ != null) {
                fW += e.a.a.a.fW(33, this.vZJ.bkL());
            }
            if (this.wIy != null) {
                fW += e.a.a.a.fW(34, this.wIy.bkL());
            }
            return fW + e.a.a.a.fU(35, this.vQg);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            att att = (att) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
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
                        att.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    att.lTO = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    att.vKL = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    att.vMk = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    att.vMl = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    att.wIq = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    att.vMe = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    att.vMm = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    att.wIr = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    att.wIs = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ir();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        att.vTi = fiVar;
                    }
                    return 0;
                case 15:
                    att.vMn = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    att.kyG = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    att.kyY = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new atk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        att.vTj = fiVar;
                    }
                    return 0;
                case 19:
                    att.wIt = aVar3.AEQ.rz();
                    return 0;
                case 20:
                    att.vMh = aVar3.AEQ.rz();
                    return 0;
                case 21:
                    att.vPY = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ayk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        att.wIu = fiVar;
                    }
                    return 0;
                case 23:
                    att.lTQ = aVar3.AEQ.readString();
                    return 0;
                case 24:
                    att.wIv = aVar3.AEQ.rz();
                    return 0;
                case 25:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new akv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        att.vTh = fiVar;
                    }
                    return 0;
                case 26:
                    att.wIw = aVar3.AEQ.readString();
                    return 0;
                case 27:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new jx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        att.vZH = fiVar;
                    }
                    return 0;
                case 28:
                    att.wIx = aVar3.AEQ.readString();
                    return 0;
                case 29:
                    att.wuU = aVar3.AEQ.readString();
                    return 0;
                case 30:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        att.wuX = fiVar;
                    }
                    return 0;
                case 31:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bjx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        att.vQb = fiVar;
                    }
                    return 0;
                case 32:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new jx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        att.vZI = fiVar;
                    }
                    return 0;
                case 33:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new jx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        att.vZJ = fiVar;
                    }
                    return 0;
                case 34:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bgt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        att.wIy = fiVar;
                    }
                    return 0;
                case 35:
                    att.vQg = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

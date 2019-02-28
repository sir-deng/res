package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aiq extends bek {
    public String fpg;
    public String nMr;
    public String nkL;
    public String wwB;
    public String wwC;
    public String wwD;
    public String wwE;
    public String wwF;
    public String wwG;
    public byj wwH;
    public String wwI;
    public String wwJ;
    public String wwK;
    public String wwL;
    public String wwM;
    public int wwo;
    public LinkedList<byd> wwp = new LinkedList();

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
            if (this.wwB != null) {
                aVar.g(2, this.wwB);
            }
            if (this.nMr != null) {
                aVar.g(3, this.nMr);
            }
            if (this.fpg != null) {
                aVar.g(4, this.fpg);
            }
            if (this.nkL != null) {
                aVar.g(5, this.nkL);
            }
            if (this.wwC != null) {
                aVar.g(6, this.wwC);
            }
            if (this.wwD != null) {
                aVar.g(7, this.wwD);
            }
            if (this.wwE != null) {
                aVar.g(8, this.wwE);
            }
            if (this.wwF != null) {
                aVar.g(9, this.wwF);
            }
            if (this.wwG != null) {
                aVar.g(10, this.wwG);
            }
            if (this.wwH != null) {
                aVar.fZ(11, this.wwH.bkL());
                this.wwH.a(aVar);
            }
            if (this.wwI != null) {
                aVar.g(12, this.wwI);
            }
            if (this.wwJ != null) {
                aVar.g(13, this.wwJ);
            }
            if (this.wwK != null) {
                aVar.g(14, this.wwK);
            }
            if (this.wwL != null) {
                aVar.g(15, this.wwL);
            }
            if (this.wwM != null) {
                aVar.g(16, this.wwM);
            }
            aVar.fX(17, this.wwo);
            aVar.d(18, 8, this.wwp);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wwB != null) {
                fW += e.a.a.b.b.a.h(2, this.wwB);
            }
            if (this.nMr != null) {
                fW += e.a.a.b.b.a.h(3, this.nMr);
            }
            if (this.fpg != null) {
                fW += e.a.a.b.b.a.h(4, this.fpg);
            }
            if (this.nkL != null) {
                fW += e.a.a.b.b.a.h(5, this.nkL);
            }
            if (this.wwC != null) {
                fW += e.a.a.b.b.a.h(6, this.wwC);
            }
            if (this.wwD != null) {
                fW += e.a.a.b.b.a.h(7, this.wwD);
            }
            if (this.wwE != null) {
                fW += e.a.a.b.b.a.h(8, this.wwE);
            }
            if (this.wwF != null) {
                fW += e.a.a.b.b.a.h(9, this.wwF);
            }
            if (this.wwG != null) {
                fW += e.a.a.b.b.a.h(10, this.wwG);
            }
            if (this.wwH != null) {
                fW += e.a.a.a.fW(11, this.wwH.bkL());
            }
            if (this.wwI != null) {
                fW += e.a.a.b.b.a.h(12, this.wwI);
            }
            if (this.wwJ != null) {
                fW += e.a.a.b.b.a.h(13, this.wwJ);
            }
            if (this.wwK != null) {
                fW += e.a.a.b.b.a.h(14, this.wwK);
            }
            if (this.wwL != null) {
                fW += e.a.a.b.b.a.h(15, this.wwL);
            }
            if (this.wwM != null) {
                fW += e.a.a.b.b.a.h(16, this.wwM);
            }
            return (fW + e.a.a.a.fU(17, this.wwo)) + e.a.a.a.c(18, 8, this.wwp);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wwp.clear();
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
            aiq aiq = (aiq) objArr[1];
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
                        aiq.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    aiq.wwB = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aiq.nMr = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aiq.fpg = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aiq.nkL = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aiq.wwC = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    aiq.wwD = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    aiq.wwE = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    aiq.wwF = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    aiq.wwG = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new byj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aiq.wwH = fiVar;
                    }
                    return 0;
                case 12:
                    aiq.wwI = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    aiq.wwJ = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    aiq.wwK = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    aiq.wwL = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    aiq.wwM = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    aiq.wwo = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new byd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aiq.wwp.add(fiVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

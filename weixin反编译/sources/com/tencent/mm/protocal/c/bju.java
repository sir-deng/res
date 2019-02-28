package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bju extends bek {
    public String fsK;
    public String hea;
    public String title;
    public String wIV;
    public ed wSE;
    public int wTF;
    public ec wTG;
    public String wTH;
    public LinkedList<ee> wTI = new LinkedList();
    public String wTJ;
    public String wTK;
    public ef wTL;
    public LinkedList<ef> wTM = new LinkedList();
    public bui wTN;

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
            if (this.wSE != null) {
                aVar.fZ(2, this.wSE.bkL());
                this.wSE.a(aVar);
            }
            aVar.fX(3, this.wTF);
            if (this.wTG != null) {
                aVar.fZ(4, this.wTG.bkL());
                this.wTG.a(aVar);
            }
            if (this.title != null) {
                aVar.g(5, this.title);
            }
            if (this.wIV != null) {
                aVar.g(6, this.wIV);
            }
            if (this.hea != null) {
                aVar.g(7, this.hea);
            }
            if (this.wTH != null) {
                aVar.g(8, this.wTH);
            }
            aVar.d(9, 8, this.wTI);
            if (this.wTJ != null) {
                aVar.g(10, this.wTJ);
            }
            if (this.wTK != null) {
                aVar.g(11, this.wTK);
            }
            if (this.wTL != null) {
                aVar.fZ(12, this.wTL.bkL());
                this.wTL.a(aVar);
            }
            aVar.d(13, 8, this.wTM);
            if (this.fsK != null) {
                aVar.g(14, this.fsK);
            }
            if (this.wTN == null) {
                return 0;
            }
            aVar.fZ(15, this.wTN.bkL());
            this.wTN.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wSE != null) {
                fW += e.a.a.a.fW(2, this.wSE.bkL());
            }
            fW += e.a.a.a.fU(3, this.wTF);
            if (this.wTG != null) {
                fW += e.a.a.a.fW(4, this.wTG.bkL());
            }
            if (this.title != null) {
                fW += e.a.a.b.b.a.h(5, this.title);
            }
            if (this.wIV != null) {
                fW += e.a.a.b.b.a.h(6, this.wIV);
            }
            if (this.hea != null) {
                fW += e.a.a.b.b.a.h(7, this.hea);
            }
            if (this.wTH != null) {
                fW += e.a.a.b.b.a.h(8, this.wTH);
            }
            fW += e.a.a.a.c(9, 8, this.wTI);
            if (this.wTJ != null) {
                fW += e.a.a.b.b.a.h(10, this.wTJ);
            }
            if (this.wTK != null) {
                fW += e.a.a.b.b.a.h(11, this.wTK);
            }
            if (this.wTL != null) {
                fW += e.a.a.a.fW(12, this.wTL.bkL());
            }
            fW += e.a.a.a.c(13, 8, this.wTM);
            if (this.fsK != null) {
                fW += e.a.a.b.b.a.h(14, this.fsK);
            }
            if (this.wTN != null) {
                fW += e.a.a.a.fW(15, this.wTN.bkL());
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wTI.clear();
            this.wTM.clear();
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
            bju bju = (bju) objArr[1];
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
                        bju.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ed();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bju.wSE = fiVar;
                    }
                    return 0;
                case 3:
                    bju.wTF = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ec();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bju.wTG = fiVar;
                    }
                    return 0;
                case 5:
                    bju.title = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bju.wIV = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bju.hea = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bju.wTH = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ee();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bju.wTI.add(fiVar);
                    }
                    return 0;
                case 10:
                    bju.wTJ = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    bju.wTK = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ef();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bju.wTL = fiVar;
                    }
                    return 0;
                case 13:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ef();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bju.wTM.add(fiVar);
                    }
                    return 0;
                case 14:
                    bju.fsK = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bui();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bju.wTN = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

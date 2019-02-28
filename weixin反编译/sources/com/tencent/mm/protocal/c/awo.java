package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class awo extends bea {
    public String nkY;
    public String nlV;
    public String noG;
    public av vXW;
    public String wKH;
    public String wKI;
    public String wKJ;
    public String wKK;
    public String wKL;
    public String wdk;
    public String wdl;
    public String wdm;
    public String wdn;
    public String wov;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.nlV != null) {
                aVar.g(2, this.nlV);
            }
            if (this.wKH != null) {
                aVar.g(3, this.wKH);
            }
            if (this.wov != null) {
                aVar.g(4, this.wov);
            }
            if (this.wdk != null) {
                aVar.g(5, this.wdk);
            }
            if (this.wKI != null) {
                aVar.g(6, this.wKI);
            }
            if (this.wdl != null) {
                aVar.g(7, this.wdl);
            }
            if (this.wdm != null) {
                aVar.g(8, this.wdm);
            }
            if (this.wdn != null) {
                aVar.g(9, this.wdn);
            }
            if (this.wKJ != null) {
                aVar.g(10, this.wKJ);
            }
            if (this.vXW != null) {
                aVar.fZ(11, this.vXW.bkL());
                this.vXW.a(aVar);
            }
            if (this.wKK != null) {
                aVar.g(12, this.wKK);
            }
            if (this.nkY != null) {
                aVar.g(13, this.nkY);
            }
            if (this.noG != null) {
                aVar.g(14, this.noG);
            }
            if (this.wKL == null) {
                return 0;
            }
            aVar.g(15, this.wKL);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nlV != null) {
                fW += e.a.a.b.b.a.h(2, this.nlV);
            }
            if (this.wKH != null) {
                fW += e.a.a.b.b.a.h(3, this.wKH);
            }
            if (this.wov != null) {
                fW += e.a.a.b.b.a.h(4, this.wov);
            }
            if (this.wdk != null) {
                fW += e.a.a.b.b.a.h(5, this.wdk);
            }
            if (this.wKI != null) {
                fW += e.a.a.b.b.a.h(6, this.wKI);
            }
            if (this.wdl != null) {
                fW += e.a.a.b.b.a.h(7, this.wdl);
            }
            if (this.wdm != null) {
                fW += e.a.a.b.b.a.h(8, this.wdm);
            }
            if (this.wdn != null) {
                fW += e.a.a.b.b.a.h(9, this.wdn);
            }
            if (this.wKJ != null) {
                fW += e.a.a.b.b.a.h(10, this.wKJ);
            }
            if (this.vXW != null) {
                fW += e.a.a.a.fW(11, this.vXW.bkL());
            }
            if (this.wKK != null) {
                fW += e.a.a.b.b.a.h(12, this.wKK);
            }
            if (this.nkY != null) {
                fW += e.a.a.b.b.a.h(13, this.nkY);
            }
            if (this.noG != null) {
                fW += e.a.a.b.b.a.h(14, this.noG);
            }
            if (this.wKL != null) {
                fW += e.a.a.b.b.a.h(15, this.wKL);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            awo awo = (awo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        awo.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    awo.nlV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    awo.wKH = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    awo.wov = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    awo.wdk = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    awo.wKI = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    awo.wdl = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    awo.wdm = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    awo.wdn = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    awo.wKJ = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new av();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        awo.vXW = fhVar;
                    }
                    return 0;
                case 12:
                    awo.wKK = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    awo.nkY = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    awo.noG = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    awo.wKL = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

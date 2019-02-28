package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class aom extends bea {
    public String nlV;
    public ccc wBZ;
    public cdd wCa;
    public ccy wCb;
    public cds wCc;
    public cdc wCd;
    public cde wCe;
    public int wCf;
    public int wuK;

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
            if (this.wBZ != null) {
                aVar.fZ(3, this.wBZ.bkL());
                this.wBZ.a(aVar);
            }
            aVar.fX(4, this.wuK);
            if (this.wCa != null) {
                aVar.fZ(5, this.wCa.bkL());
                this.wCa.a(aVar);
            }
            if (this.wCb != null) {
                aVar.fZ(6, this.wCb.bkL());
                this.wCb.a(aVar);
            }
            if (this.wCc != null) {
                aVar.fZ(7, this.wCc.bkL());
                this.wCc.a(aVar);
            }
            if (this.wCd != null) {
                aVar.fZ(8, this.wCd.bkL());
                this.wCd.a(aVar);
            }
            if (this.wCe != null) {
                aVar.fZ(9, this.wCe.bkL());
                this.wCe.a(aVar);
            }
            aVar.fX(10, this.wCf);
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
            if (this.wBZ != null) {
                fW += e.a.a.a.fW(3, this.wBZ.bkL());
            }
            fW += e.a.a.a.fU(4, this.wuK);
            if (this.wCa != null) {
                fW += e.a.a.a.fW(5, this.wCa.bkL());
            }
            if (this.wCb != null) {
                fW += e.a.a.a.fW(6, this.wCb.bkL());
            }
            if (this.wCc != null) {
                fW += e.a.a.a.fW(7, this.wCc.bkL());
            }
            if (this.wCd != null) {
                fW += e.a.a.a.fW(8, this.wCd.bkL());
            }
            if (this.wCe != null) {
                fW += e.a.a.a.fW(9, this.wCe.bkL());
            }
            return fW + e.a.a.a.fU(10, this.wCf);
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
            aom aom = (aom) objArr[1];
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
                        aom.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    aom.nlV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new ccc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aom.wBZ = fhVar;
                    }
                    return 0;
                case 4:
                    aom.wuK = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new cdd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aom.wCa = fhVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new ccy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aom.wCb = fhVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new cds();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aom.wCc = fhVar;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new cdc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aom.wCd = fhVar;
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new cde();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aom.wCe = fhVar;
                    }
                    return 0;
                case 10:
                    aom.wCf = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

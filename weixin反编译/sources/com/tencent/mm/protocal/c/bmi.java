package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bmi extends bea {
    public int kzz;
    public String nlV;
    public String vNF;
    public String vPF;
    public int vPs;
    public int vPt;
    public bes vQW;
    public int wFl;
    public int wFm;
    public int wGH;
    public bqf wMg;
    public int wWg;
    public int wWh;
    public int wdO;
    public String wgY;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vQW == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.kzz);
            aVar.fX(3, this.vPt);
            aVar.fX(4, this.vPs);
            if (this.vQW != null) {
                aVar.fZ(5, this.vQW.bkL());
                this.vQW.a(aVar);
            }
            if (this.vNF != null) {
                aVar.g(6, this.vNF);
            }
            aVar.fX(7, this.wFl);
            aVar.fX(8, this.wFm);
            if (this.vPF != null) {
                aVar.g(9, this.vPF);
            }
            aVar.fX(10, this.wWg);
            aVar.fX(11, this.wdO);
            if (this.wMg != null) {
                aVar.fZ(12, this.wMg.bkL());
                this.wMg.a(aVar);
            }
            if (this.nlV != null) {
                aVar.g(13, this.nlV);
            }
            aVar.fX(14, this.wGH);
            if (this.wgY != null) {
                aVar.g(15, this.wgY);
            }
            aVar.fX(16, this.wWh);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((fW + e.a.a.a.fU(2, this.kzz)) + e.a.a.a.fU(3, this.vPt)) + e.a.a.a.fU(4, this.vPs);
            if (this.vQW != null) {
                fW += e.a.a.a.fW(5, this.vQW.bkL());
            }
            if (this.vNF != null) {
                fW += e.a.a.b.b.a.h(6, this.vNF);
            }
            fW = (fW + e.a.a.a.fU(7, this.wFl)) + e.a.a.a.fU(8, this.wFm);
            if (this.vPF != null) {
                fW += e.a.a.b.b.a.h(9, this.vPF);
            }
            fW = (fW + e.a.a.a.fU(10, this.wWg)) + e.a.a.a.fU(11, this.wdO);
            if (this.wMg != null) {
                fW += e.a.a.a.fW(12, this.wMg.bkL());
            }
            if (this.nlV != null) {
                fW += e.a.a.b.b.a.h(13, this.nlV);
            }
            fW += e.a.a.a.fU(14, this.wGH);
            if (this.wgY != null) {
                fW += e.a.a.b.b.a.h(15, this.wgY);
            }
            return fW + e.a.a.a.fU(16, this.wWh);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vQW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmi bmi = (bmi) objArr[1];
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
                        bmi.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bmi.kzz = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bmi.vPt = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bmi.vPs = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bmi.vQW = fhVar;
                    }
                    return 0;
                case 6:
                    bmi.vNF = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bmi.wFl = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bmi.wFm = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bmi.vPF = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    bmi.wWg = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    bmi.wdO = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bqf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bmi.wMg = fhVar;
                    }
                    return 0;
                case 13:
                    bmi.nlV = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    bmi.wGH = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    bmi.wgY = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    bmi.wWh = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

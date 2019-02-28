package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class azc extends a {
    public int kyA;
    public int kzz;
    public String nkW;
    public String phv;
    public int sfa;
    public int wMF;
    public LinkedList<anz> wMG = new LinkedList();
    public int wMH;
    public String wMI;
    public String wMJ;
    public int wMK;
    public String wML;
    public int wMM;
    public LinkedList<rl> wMN = new LinkedList();
    public String whH;
    public String wtR;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wMF);
            aVar.d(2, 8, this.wMG);
            aVar.fX(3, this.kyA);
            aVar.fX(4, this.wMH);
            if (this.whH != null) {
                aVar.g(5, this.whH);
            }
            if (this.wtR != null) {
                aVar.g(6, this.wtR);
            }
            if (this.wMI != null) {
                aVar.g(7, this.wMI);
            }
            if (this.wMJ != null) {
                aVar.g(8, this.wMJ);
            }
            aVar.fX(9, this.kzz);
            if (this.nkW != null) {
                aVar.g(10, this.nkW);
            }
            if (this.phv != null) {
                aVar.g(11, this.phv);
            }
            aVar.fX(12, this.wMK);
            aVar.fX(13, this.sfa);
            if (this.wML != null) {
                aVar.g(14, this.wML);
            }
            aVar.fX(15, this.wMM);
            aVar.d(16, 8, this.wMN);
            return 0;
        } else if (i == 1) {
            fU = (((e.a.a.a.fU(1, this.wMF) + 0) + e.a.a.a.c(2, 8, this.wMG)) + e.a.a.a.fU(3, this.kyA)) + e.a.a.a.fU(4, this.wMH);
            if (this.whH != null) {
                fU += e.a.a.b.b.a.h(5, this.whH);
            }
            if (this.wtR != null) {
                fU += e.a.a.b.b.a.h(6, this.wtR);
            }
            if (this.wMI != null) {
                fU += e.a.a.b.b.a.h(7, this.wMI);
            }
            if (this.wMJ != null) {
                fU += e.a.a.b.b.a.h(8, this.wMJ);
            }
            fU += e.a.a.a.fU(9, this.kzz);
            if (this.nkW != null) {
                fU += e.a.a.b.b.a.h(10, this.nkW);
            }
            if (this.phv != null) {
                fU += e.a.a.b.b.a.h(11, this.phv);
            }
            fU = (fU + e.a.a.a.fU(12, this.wMK)) + e.a.a.a.fU(13, this.sfa);
            if (this.wML != null) {
                fU += e.a.a.b.b.a.h(14, this.wML);
            }
            return (fU + e.a.a.a.fU(15, this.wMM)) + e.a.a.a.c(16, 8, this.wMN);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wMG.clear();
            this.wMN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azc azc = (azc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a anz;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    azc.wMF = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        anz = new anz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = anz.a(aVar4, anz, a.a(aVar4))) {
                        }
                        azc.wMG.add(anz);
                    }
                    return 0;
                case 3:
                    azc.kyA = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    azc.wMH = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    azc.whH = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    azc.wtR = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    azc.wMI = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    azc.wMJ = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    azc.kzz = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    azc.nkW = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    azc.phv = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    azc.wMK = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    azc.sfa = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    azc.wML = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    azc.wMM = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        anz = new rl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = anz.a(aVar4, anz, a.a(aVar4))) {
                        }
                        azc.wMN.add(anz);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

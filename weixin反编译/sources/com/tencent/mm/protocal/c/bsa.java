package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bsa extends bea {
    public String kyG;
    public int vQC;
    public String vSS;
    public LinkedList<ars> wCM = new LinkedList();
    public int wZQ;
    public int wZR;
    public LinkedList<aps> wZS = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.kyG != null) {
                aVar.g(2, this.kyG);
            }
            aVar.fX(3, this.vQC);
            if (this.vSS != null) {
                aVar.g(4, this.vSS);
            }
            aVar.fX(5, this.wZQ);
            aVar.d(6, 8, this.wCM);
            aVar.fX(7, this.wZR);
            aVar.d(8, 8, this.wZS);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.kyG != null) {
                fW += e.a.a.b.b.a.h(2, this.kyG);
            }
            fW += e.a.a.a.fU(3, this.vQC);
            if (this.vSS != null) {
                fW += e.a.a.b.b.a.h(4, this.vSS);
            }
            return (((fW + e.a.a.a.fU(5, this.wZQ)) + e.a.a.a.c(6, 8, this.wCM)) + e.a.a.a.fU(7, this.wZR)) + e.a.a.a.c(8, 8, this.wZS);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wCM.clear();
            this.wZS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            bsa bsa = (bsa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
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
                        bsa.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bsa.kyG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bsa.vQC = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bsa.vSS = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bsa.wZQ = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new ars();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bsa.wCM.add(fhVar);
                    }
                    return 0;
                case 7:
                    bsa.wZR = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new aps();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bsa.wZS.add(fhVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bwo extends bea {
    public int wWF;
    public int wWG;
    public int wWH;
    public int wWI;
    public int wWJ;
    public LinkedList<Integer> wWK = new LinkedList();
    public int wWL;
    public int wWM;
    public LinkedList<Integer> wWN = new LinkedList();
    public int wWO;
    public int wWP;
    public int wdO;
    public int wil;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.wil);
            aVar.fX(3, this.wWF);
            aVar.fX(4, this.wdO);
            aVar.fX(5, this.wWG);
            aVar.fX(6, this.wWH);
            aVar.fX(7, this.wWI);
            aVar.fX(8, this.wWJ);
            aVar.c(9, this.wWK);
            aVar.fX(10, this.wWL);
            aVar.fX(11, this.wWM);
            aVar.c(12, this.wWN);
            aVar.fX(13, this.wWO);
            aVar.fX(14, this.wWP);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            return ((((((((((((fW + e.a.a.a.fU(2, this.wil)) + e.a.a.a.fU(3, this.wWF)) + e.a.a.a.fU(4, this.wdO)) + e.a.a.a.fU(5, this.wWG)) + e.a.a.a.fU(6, this.wWH)) + e.a.a.a.fU(7, this.wWI)) + e.a.a.a.fU(8, this.wWJ)) + e.a.a.a.b(9, this.wWK)) + e.a.a.a.fU(10, this.wWL)) + e.a.a.a.fU(11, this.wWM)) + e.a.a.a.b(12, this.wWN)) + e.a.a.a.fU(13, this.wWO)) + e.a.a.a.fU(14, this.wWP);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wWK.clear();
            this.wWN.clear();
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
            bwo bwo = (bwo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bwo.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bwo.wil = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bwo.wWF = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bwo.wdO = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bwo.wWG = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bwo.wWH = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bwo.wWI = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bwo.wWJ = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bwo.wWK = new e.a.a.a.a(aVar3.cKw().oz, unknownTagHandler).cKt();
                    return 0;
                case 10:
                    bwo.wWL = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    bwo.wWM = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bwo.wWN = new e.a.a.a.a(aVar3.cKw().oz, unknownTagHandler).cKt();
                    return 0;
                case 13:
                    bwo.wWO = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    bwo.wWP = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

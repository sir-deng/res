package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bub extends bea {
    public int vQC;
    public bes wCD;
    public String wuV;
    public int xbH;
    public LinkedList<btz> xbI = new LinkedList();
    public int xbJ;
    public LinkedList<Integer> xbK = new LinkedList();
    public int xbL;
    public LinkedList<bua> xbM = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.vQC);
            aVar.fX(3, this.xbH);
            aVar.d(4, 8, this.xbI);
            if (this.wuV != null) {
                aVar.g(5, this.wuV);
            }
            aVar.fX(6, this.xbJ);
            aVar.c(7, this.xbK);
            aVar.fX(8, this.xbL);
            aVar.d(9, 8, this.xbM);
            if (this.wCD == null) {
                return 0;
            }
            aVar.fZ(10, this.wCD.bkL());
            this.wCD.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((fW + e.a.a.a.fU(2, this.vQC)) + e.a.a.a.fU(3, this.xbH)) + e.a.a.a.c(4, 8, this.xbI);
            if (this.wuV != null) {
                fW += e.a.a.b.b.a.h(5, this.wuV);
            }
            fW = (((fW + e.a.a.a.fU(6, this.xbJ)) + e.a.a.a.b(7, this.xbK)) + e.a.a.a.fU(8, this.xbL)) + e.a.a.a.c(9, 8, this.xbM);
            if (this.wCD != null) {
                fW += e.a.a.a.fW(10, this.wCD.bkL());
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xbI.clear();
            this.xbK.clear();
            this.xbM.clear();
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
            bub bub = (bub) objArr[1];
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
                        bub.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bub.vQC = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bub.xbH = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new btz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bub.xbI.add(fhVar);
                    }
                    return 0;
                case 5:
                    bub.wuV = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bub.xbJ = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bub.xbK = new e.a.a.a.a(aVar3.cKw().oz, unknownTagHandler).cKt();
                    return 0;
                case 8:
                    bub.xbL = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bua();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bub.xbM.add(fhVar);
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bub.wCD = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

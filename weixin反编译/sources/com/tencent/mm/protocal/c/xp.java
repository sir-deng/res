package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class xp extends bea {
    public String kyG;
    public int sfa;
    public int vKI;
    public int vNC;
    public bes vPZ;
    public int wcr;
    public int wcs;
    public bet woA;
    public bet woB;
    public bet woC;
    public bet woD;
    public String woE;
    public int woF;
    public String woG;
    public bes woH;
    public int woI;
    public int woJ;
    public String woK;
    public int woL;
    public String woM;
    public int woN;
    public bes woO;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.vKI);
            if (this.vPZ != null) {
                aVar.fZ(3, this.vPZ.bkL());
                this.vPZ.a(aVar);
            }
            if (this.woA != null) {
                aVar.fZ(4, this.woA.bkL());
                this.woA.a(aVar);
            }
            if (this.woB != null) {
                aVar.fZ(5, this.woB.bkL());
                this.woB.a(aVar);
            }
            if (this.woC != null) {
                aVar.fZ(6, this.woC.bkL());
                this.woC.a(aVar);
            }
            if (this.woD != null) {
                aVar.fZ(7, this.woD.bkL());
                this.woD.a(aVar);
            }
            if (this.woE != null) {
                aVar.g(8, this.woE);
            }
            aVar.fX(9, this.woF);
            aVar.fX(10, this.sfa);
            if (this.kyG != null) {
                aVar.g(11, this.kyG);
            }
            if (this.woG != null) {
                aVar.g(12, this.woG);
            }
            if (this.woH != null) {
                aVar.fZ(13, this.woH.bkL());
                this.woH.a(aVar);
            }
            aVar.fX(14, this.woI);
            aVar.fX(15, this.woJ);
            aVar.fX(16, this.vNC);
            if (this.woK != null) {
                aVar.g(17, this.woK);
            }
            aVar.fX(18, this.wcr);
            aVar.fX(19, this.wcs);
            aVar.fX(20, this.woL);
            if (this.woM != null) {
                aVar.g(21, this.woM);
            }
            aVar.fX(22, this.woN);
            if (this.woO == null) {
                return 0;
            }
            aVar.fZ(23, this.woO.bkL());
            this.woO.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.vKI);
            if (this.vPZ != null) {
                fW += e.a.a.a.fW(3, this.vPZ.bkL());
            }
            if (this.woA != null) {
                fW += e.a.a.a.fW(4, this.woA.bkL());
            }
            if (this.woB != null) {
                fW += e.a.a.a.fW(5, this.woB.bkL());
            }
            if (this.woC != null) {
                fW += e.a.a.a.fW(6, this.woC.bkL());
            }
            if (this.woD != null) {
                fW += e.a.a.a.fW(7, this.woD.bkL());
            }
            if (this.woE != null) {
                fW += e.a.a.b.b.a.h(8, this.woE);
            }
            fW = (fW + e.a.a.a.fU(9, this.woF)) + e.a.a.a.fU(10, this.sfa);
            if (this.kyG != null) {
                fW += e.a.a.b.b.a.h(11, this.kyG);
            }
            if (this.woG != null) {
                fW += e.a.a.b.b.a.h(12, this.woG);
            }
            if (this.woH != null) {
                fW += e.a.a.a.fW(13, this.woH.bkL());
            }
            fW = ((fW + e.a.a.a.fU(14, this.woI)) + e.a.a.a.fU(15, this.woJ)) + e.a.a.a.fU(16, this.vNC);
            if (this.woK != null) {
                fW += e.a.a.b.b.a.h(17, this.woK);
            }
            fW = ((fW + e.a.a.a.fU(18, this.wcr)) + e.a.a.a.fU(19, this.wcs)) + e.a.a.a.fU(20, this.woL);
            if (this.woM != null) {
                fW += e.a.a.b.b.a.h(21, this.woM);
            }
            fW += e.a.a.a.fU(22, this.woN);
            if (this.woO != null) {
                fW += e.a.a.a.fW(23, this.woO.bkL());
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
            xp xpVar = (xp) objArr[1];
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
                        xpVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    xpVar.vKI = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        xpVar.vPZ = fhVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        xpVar.woA = fhVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        xpVar.woB = fhVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        xpVar.woC = fhVar;
                    }
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        xpVar.woD = fhVar;
                    }
                    return 0;
                case 8:
                    xpVar.woE = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    xpVar.woF = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    xpVar.sfa = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    xpVar.kyG = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    xpVar.woG = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        xpVar.woH = fhVar;
                    }
                    return 0;
                case 14:
                    xpVar.woI = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    xpVar.woJ = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    xpVar.vNC = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    xpVar.woK = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    xpVar.wcr = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    xpVar.wcs = aVar3.AEQ.rz();
                    return 0;
                case 20:
                    xpVar.woL = aVar3.AEQ.rz();
                    return 0;
                case 21:
                    xpVar.woM = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    xpVar.woN = aVar3.AEQ.rz();
                    return 0;
                case 23:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        xpVar.woO = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

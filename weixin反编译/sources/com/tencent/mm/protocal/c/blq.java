package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class blq extends bea {
    public String vNF;
    public bes wCD;
    public int wFm;
    public LinkedList<bla> wFs = new LinkedList();
    public LinkedList<bet> wFx = new LinkedList();
    public blp wFy;
    public int wHZ;
    public bqf wMg;
    public bes wUN;
    public int wUW;
    public LinkedList<bet> wUX = new LinkedList();
    public String wVA;
    public kl wVB;
    public int wVC;
    public LinkedList<arc> wVD = new LinkedList();
    public bkq wVE;
    public long wVa;
    public int wVb;
    public LinkedList<bet> wVc = new LinkedList();
    public int wVd;
    public blu wVf;
    public int wVv;
    public int wVw;
    public int wVx;
    public blo wVy;
    public bes wVz;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wUN == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wUN != null) {
                aVar.fZ(2, this.wUN.bkL());
                this.wUN.a(aVar);
            }
            aVar.fX(3, this.wUW);
            aVar.d(4, 8, this.wUX);
            aVar.fX(5, this.wVv);
            aVar.fX(6, this.wFm);
            if (this.vNF != null) {
                aVar.g(7, this.vNF);
            }
            aVar.fX(8, this.wVw);
            aVar.fX(9, this.wHZ);
            aVar.d(10, 8, this.wFs);
            aVar.fX(11, this.wVx);
            aVar.S(12, this.wVa);
            aVar.fX(13, this.wVb);
            aVar.d(14, 8, this.wVc);
            if (this.wMg != null) {
                aVar.fZ(15, this.wMg.bkL());
                this.wMg.a(aVar);
            }
            aVar.fX(16, this.wVd);
            aVar.d(17, 8, this.wFx);
            if (this.wVy != null) {
                aVar.fZ(18, this.wVy.bkL());
                this.wVy.a(aVar);
            }
            if (this.wFy != null) {
                aVar.fZ(19, this.wFy.bkL());
                this.wFy.a(aVar);
            }
            if (this.wVf != null) {
                aVar.fZ(20, this.wVf.bkL());
                this.wVf.a(aVar);
            }
            if (this.wVz != null) {
                aVar.fZ(21, this.wVz.bkL());
                this.wVz.a(aVar);
            }
            if (this.wVA != null) {
                aVar.g(22, this.wVA);
            }
            if (this.wVB != null) {
                aVar.fZ(23, this.wVB.bkL());
                this.wVB.a(aVar);
            }
            aVar.fX(24, this.wVC);
            aVar.d(25, 8, this.wVD);
            if (this.wVE != null) {
                aVar.fZ(26, this.wVE.bkL());
                this.wVE.a(aVar);
            }
            if (this.wCD == null) {
                return 0;
            }
            aVar.fZ(27, this.wCD.bkL());
            this.wCD.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wUN != null) {
                fW += e.a.a.a.fW(2, this.wUN.bkL());
            }
            fW = (((fW + e.a.a.a.fU(3, this.wUW)) + e.a.a.a.c(4, 8, this.wUX)) + e.a.a.a.fU(5, this.wVv)) + e.a.a.a.fU(6, this.wFm);
            if (this.vNF != null) {
                fW += e.a.a.b.b.a.h(7, this.vNF);
            }
            fW = ((((((fW + e.a.a.a.fU(8, this.wVw)) + e.a.a.a.fU(9, this.wHZ)) + e.a.a.a.c(10, 8, this.wFs)) + e.a.a.a.fU(11, this.wVx)) + e.a.a.a.R(12, this.wVa)) + e.a.a.a.fU(13, this.wVb)) + e.a.a.a.c(14, 8, this.wVc);
            if (this.wMg != null) {
                fW += e.a.a.a.fW(15, this.wMg.bkL());
            }
            fW = (fW + e.a.a.a.fU(16, this.wVd)) + e.a.a.a.c(17, 8, this.wFx);
            if (this.wVy != null) {
                fW += e.a.a.a.fW(18, this.wVy.bkL());
            }
            if (this.wFy != null) {
                fW += e.a.a.a.fW(19, this.wFy.bkL());
            }
            if (this.wVf != null) {
                fW += e.a.a.a.fW(20, this.wVf.bkL());
            }
            if (this.wVz != null) {
                fW += e.a.a.a.fW(21, this.wVz.bkL());
            }
            if (this.wVA != null) {
                fW += e.a.a.b.b.a.h(22, this.wVA);
            }
            if (this.wVB != null) {
                fW += e.a.a.a.fW(23, this.wVB.bkL());
            }
            fW = (fW + e.a.a.a.fU(24, this.wVC)) + e.a.a.a.c(25, 8, this.wVD);
            if (this.wVE != null) {
                fW += e.a.a.a.fW(26, this.wVE.bkL());
            }
            if (this.wCD != null) {
                fW += e.a.a.a.fW(27, this.wCD.bkL());
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wUX.clear();
            this.wFs.clear();
            this.wVc.clear();
            this.wFx.clear();
            this.wVD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wUN != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ObjectDesc");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            blq blq = (blq) objArr[1];
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
                        blq.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wUN = fhVar;
                    }
                    return 0;
                case 3:
                    blq.wUW = aVar3.AEQ.rz();
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
                        blq.wUX.add(fhVar);
                    }
                    return 0;
                case 5:
                    blq.wVv = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    blq.wFm = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    blq.vNF = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    blq.wVw = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    blq.wHZ = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bla();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wFs.add(fhVar);
                    }
                    return 0;
                case 11:
                    blq.wVx = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    blq.wVa = aVar3.AEQ.rA();
                    return 0;
                case 13:
                    blq.wVb = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wVc.add(fhVar);
                    }
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bqf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wMg = fhVar;
                    }
                    return 0;
                case 16:
                    blq.wVd = aVar3.AEQ.rz();
                    return 0;
                case 17:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wFx.add(fhVar);
                    }
                    return 0;
                case 18:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new blo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wVy = fhVar;
                    }
                    return 0;
                case 19:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new blp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wFy = fhVar;
                    }
                    return 0;
                case 20:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new blu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wVf = fhVar;
                    }
                    return 0;
                case 21:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wVz = fhVar;
                    }
                    return 0;
                case 22:
                    blq.wVA = aVar3.AEQ.readString();
                    return 0;
                case 23:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new kl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wVB = fhVar;
                    }
                    return 0;
                case 24:
                    blq.wVC = aVar3.AEQ.rz();
                    return 0;
                case 25:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new arc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wVD.add(fhVar);
                    }
                    return 0;
                case 26:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bkq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wVE = fhVar;
                    }
                    return 0;
                case 27:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        blq.wCD = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

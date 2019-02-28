package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class buk extends bea {
    public String kyG;
    public int vPv;
    public int vPy;
    public int vSa;
    public int vUN;
    public String wZM;
    public int wZN;
    public int wZO;
    public bes weD;
    public int xbR;
    public int xbS;
    public LinkedList<bet> xbT = new LinkedList();
    public LinkedList<bes> xbU = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.weD == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.kyG != null) {
                aVar.g(2, this.kyG);
            }
            if (this.weD != null) {
                aVar.fZ(3, this.weD.bkL());
                this.weD.a(aVar);
            }
            aVar.fX(4, this.vUN);
            if (this.wZM != null) {
                aVar.g(5, this.wZM);
            }
            aVar.fX(6, this.vSa);
            aVar.fX(7, this.wZN);
            aVar.fX(8, this.vPy);
            aVar.fX(9, this.wZO);
            aVar.fX(10, this.vPv);
            aVar.fX(11, this.xbR);
            aVar.fX(12, this.xbS);
            aVar.d(13, 8, this.xbT);
            aVar.d(14, 8, this.xbU);
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
            if (this.weD != null) {
                fW += e.a.a.a.fW(3, this.weD.bkL());
            }
            fW += e.a.a.a.fU(4, this.vUN);
            if (this.wZM != null) {
                fW += e.a.a.b.b.a.h(5, this.wZM);
            }
            return ((((((((fW + e.a.a.a.fU(6, this.vSa)) + e.a.a.a.fU(7, this.wZN)) + e.a.a.a.fU(8, this.vPy)) + e.a.a.a.fU(9, this.wZO)) + e.a.a.a.fU(10, this.vPv)) + e.a.a.a.fU(11, this.xbR)) + e.a.a.a.fU(12, this.xbS)) + e.a.a.a.c(13, 8, this.xbT)) + e.a.a.a.c(14, 8, this.xbU);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xbT.clear();
            this.xbU.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.weD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            buk buk = (buk) objArr[1];
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
                        buk.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    buk.kyG = aVar3.AEQ.readString();
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
                        buk.weD = fhVar;
                    }
                    return 0;
                case 4:
                    buk.vUN = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    buk.wZM = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    buk.vSa = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    buk.wZN = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    buk.vPy = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    buk.wZO = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    buk.vPv = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    buk.xbR = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    buk.xbS = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        buk.xbT.add(fhVar);
                    }
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        buk.xbU.add(fhVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

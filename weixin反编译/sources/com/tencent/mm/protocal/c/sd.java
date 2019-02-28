package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class sd extends bea {
    public String lTZ;
    public int vQC;
    public String vQq;
    public String vSE;
    public bes vSZ;
    public String vTg;
    public String wgL;
    public String wgM;
    public int wgN;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vSZ == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vSZ != null) {
                aVar.fZ(2, this.vSZ.bkL());
                this.vSZ.a(aVar);
            }
            aVar.fX(3, this.vQC);
            if (this.vSE != null) {
                aVar.g(4, this.vSE);
            }
            if (this.lTZ != null) {
                aVar.g(5, this.lTZ);
            }
            if (this.vTg != null) {
                aVar.g(6, this.vTg);
            }
            if (this.wgL != null) {
                aVar.g(7, this.wgL);
            }
            if (this.vQq != null) {
                aVar.g(8, this.vQq);
            }
            if (this.wgM != null) {
                aVar.g(9, this.wgM);
            }
            aVar.fX(10, this.wgN);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vSZ != null) {
                fW += e.a.a.a.fW(2, this.vSZ.bkL());
            }
            fW += e.a.a.a.fU(3, this.vQC);
            if (this.vSE != null) {
                fW += e.a.a.b.b.a.h(4, this.vSE);
            }
            if (this.lTZ != null) {
                fW += e.a.a.b.b.a.h(5, this.lTZ);
            }
            if (this.vTg != null) {
                fW += e.a.a.b.b.a.h(6, this.vTg);
            }
            if (this.wgL != null) {
                fW += e.a.a.b.b.a.h(7, this.wgL);
            }
            if (this.vQq != null) {
                fW += e.a.a.b.b.a.h(8, this.vQq);
            }
            if (this.wgM != null) {
                fW += e.a.a.b.b.a.h(9, this.wgM);
            }
            return fW + e.a.a.a.fU(10, this.wgN);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vSZ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: RandomEncryKey");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sd sdVar = (sd) objArr[1];
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
                        sdVar.wQE = fhVar;
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
                        sdVar.vSZ = fhVar;
                    }
                    return 0;
                case 3:
                    sdVar.vQC = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    sdVar.vSE = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    sdVar.lTZ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    sdVar.vTg = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    sdVar.wgL = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    sdVar.vQq = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    sdVar.wgM = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    sdVar.wgN = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

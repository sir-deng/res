package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class agu extends bea {
    public String kzN;
    public String lTZ;
    public String vQq;
    public bes vSZ;
    public String wuR;
    public String wuS;
    public String wuT;
    public String wuU;
    public String wuV;
    public int wuW;

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
            if (this.wuR != null) {
                aVar.g(3, this.wuR);
            }
            if (this.wuS != null) {
                aVar.g(4, this.wuS);
            }
            if (this.kzN != null) {
                aVar.g(5, this.kzN);
            }
            if (this.wuT != null) {
                aVar.g(6, this.wuT);
            }
            if (this.wuU != null) {
                aVar.g(7, this.wuU);
            }
            if (this.wuV != null) {
                aVar.g(8, this.wuV);
            }
            aVar.fX(9, this.wuW);
            if (this.lTZ != null) {
                aVar.g(10, this.lTZ);
            }
            if (this.vQq == null) {
                return 0;
            }
            aVar.g(11, this.vQq);
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
            if (this.wuR != null) {
                fW += e.a.a.b.b.a.h(3, this.wuR);
            }
            if (this.wuS != null) {
                fW += e.a.a.b.b.a.h(4, this.wuS);
            }
            if (this.kzN != null) {
                fW += e.a.a.b.b.a.h(5, this.kzN);
            }
            if (this.wuT != null) {
                fW += e.a.a.b.b.a.h(6, this.wuT);
            }
            if (this.wuU != null) {
                fW += e.a.a.b.b.a.h(7, this.wuU);
            }
            if (this.wuV != null) {
                fW += e.a.a.b.b.a.h(8, this.wuV);
            }
            fW += e.a.a.a.fU(9, this.wuW);
            if (this.lTZ != null) {
                fW += e.a.a.b.b.a.h(10, this.lTZ);
            }
            if (this.vQq != null) {
                fW += e.a.a.b.b.a.h(11, this.vQq);
            }
            return fW;
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
            agu agu = (agu) objArr[1];
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
                        agu.wQE = fhVar;
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
                        agu.vSZ = fhVar;
                    }
                    return 0;
                case 3:
                    agu.wuR = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    agu.wuS = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    agu.kzN = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    agu.wuT = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    agu.wuU = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    agu.wuV = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    agu.wuW = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    agu.lTZ = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    agu.vQq = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

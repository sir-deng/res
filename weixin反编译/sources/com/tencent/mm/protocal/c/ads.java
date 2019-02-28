package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ads extends bea {
    public int sfa;
    public int vQC;
    public aot wfE;
    public String wnX;
    public bes wsT;
    public int wsU;
    public int wsV;
    public LinkedList<ayd> wsW = new LinkedList();
    public int wsX;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wfE == null) {
                throw new b("Not all required fields were included: Loc");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.vQC);
            aVar.fX(3, this.sfa);
            if (this.wsT != null) {
                aVar.fZ(4, this.wsT.bkL());
                this.wsT.a(aVar);
            }
            if (this.wfE != null) {
                aVar.fZ(5, this.wfE.bkL());
                this.wfE.a(aVar);
            }
            if (this.wnX != null) {
                aVar.g(6, this.wnX);
            }
            aVar.fX(7, this.wsU);
            aVar.fX(8, this.wsV);
            aVar.d(11, 8, this.wsW);
            aVar.fX(12, this.wsX);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.vQC)) + e.a.a.a.fU(3, this.sfa);
            if (this.wsT != null) {
                fW += e.a.a.a.fW(4, this.wsT.bkL());
            }
            if (this.wfE != null) {
                fW += e.a.a.a.fW(5, this.wfE.bkL());
            }
            if (this.wnX != null) {
                fW += e.a.a.b.b.a.h(6, this.wnX);
            }
            return (((fW + e.a.a.a.fU(7, this.wsU)) + e.a.a.a.fU(8, this.wsV)) + e.a.a.a.c(11, 8, this.wsW)) + e.a.a.a.fU(12, this.wsX);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wsW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wfE != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Loc");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ads ads = (ads) objArr[1];
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
                        ads.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    ads.vQC = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ads.sfa = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ads.wsT = fhVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new aot();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ads.wfE = fhVar;
                    }
                    return 0;
                case 6:
                    ads.wnX = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    ads.wsU = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    ads.wsV = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new ayd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ads.wsW.add(fhVar);
                    }
                    return 0;
                case 12:
                    ads.wsX = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aiv extends bea {
    public String kyG;
    public int sfa;
    public bes vPZ;
    public bes woH;
    public String wwQ;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vPZ == null) {
                throw new b("Not all required fields were included: A2Key");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vPZ != null) {
                aVar.fZ(2, this.vPZ.bkL());
                this.vPZ.a(aVar);
            }
            if (this.kyG != null) {
                aVar.g(3, this.kyG);
            }
            aVar.fX(4, this.sfa);
            if (this.wwQ != null) {
                aVar.g(5, this.wwQ);
            }
            if (this.woH == null) {
                return 0;
            }
            aVar.fZ(6, this.woH.bkL());
            this.woH.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vPZ != null) {
                fW += e.a.a.a.fW(2, this.vPZ.bkL());
            }
            if (this.kyG != null) {
                fW += e.a.a.b.b.a.h(3, this.kyG);
            }
            fW += e.a.a.a.fU(4, this.sfa);
            if (this.wwQ != null) {
                fW += e.a.a.b.b.a.h(5, this.wwQ);
            }
            if (this.woH != null) {
                fW += e.a.a.a.fW(6, this.woH.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vPZ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: A2Key");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aiv aiv = (aiv) objArr[1];
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
                        aiv.wQE = fhVar;
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
                        aiv.vPZ = fhVar;
                    }
                    return 0;
                case 3:
                    aiv.kyG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aiv.sfa = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aiv.wwQ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aiv.woH = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

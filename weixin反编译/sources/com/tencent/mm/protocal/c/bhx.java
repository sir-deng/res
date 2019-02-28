package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bhx extends bea {
    public String noL;
    public int sfa;
    public int wSJ;
    public aot wfE;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wfE == null) {
                throw new b("Not all required fields were included: Loc");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wfE != null) {
                aVar.fZ(2, this.wfE.bkL());
                this.wfE.a(aVar);
            }
            aVar.fX(3, this.wSJ);
            aVar.fX(4, this.sfa);
            if (this.noL == null) {
                return 0;
            }
            aVar.g(5, this.noL);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wfE != null) {
                fW += e.a.a.a.fW(2, this.wfE.bkL());
            }
            fW = (fW + e.a.a.a.fU(3, this.wSJ)) + e.a.a.a.fU(4, this.sfa);
            if (this.noL != null) {
                fW += e.a.a.b.b.a.h(5, this.noL);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bhx bhx = (bhx) objArr[1];
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
                        bhx.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new aot();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bhx.wfE = fhVar;
                    }
                    return 0;
                case 3:
                    bhx.wSJ = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bhx.sfa = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bhx.noL = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

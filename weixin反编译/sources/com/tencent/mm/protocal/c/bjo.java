package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bjo extends bea {
    public int kyA;
    public int sfa;
    public LinkedList<Integer> vRW = new LinkedList();
    public String wTy;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wTy != null) {
                aVar.g(2, this.wTy);
            }
            aVar.fX(3, this.sfa);
            aVar.fX(4, this.kyA);
            aVar.c(5, this.vRW);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wTy != null) {
                fW += e.a.a.b.b.a.h(2, this.wTy);
            }
            return ((fW + e.a.a.a.fU(3, this.sfa)) + e.a.a.a.fU(4, this.kyA)) + e.a.a.a.b(5, this.vRW);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vRW.clear();
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
            bjo bjo = (bjo) objArr[1];
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
                        bjo.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bjo.wTy = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bjo.sfa = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bjo.kyA = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bjo.vRW = new e.a.a.a.a(aVar3.cKw().oz, unknownTagHandler).cKt();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

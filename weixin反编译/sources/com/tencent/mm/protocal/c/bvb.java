package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bvb extends bea {
    public long wMR;
    public int wMS;
    public long wim;
    public int woI;
    public long xcP;
    public String xcQ;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.wMS);
            aVar.S(3, this.xcP);
            aVar.S(4, this.wim);
            if (this.xcQ != null) {
                aVar.g(5, this.xcQ);
            }
            aVar.S(6, this.wMR);
            aVar.fX(7, this.woI);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((fW + e.a.a.a.fU(2, this.wMS)) + e.a.a.a.R(3, this.xcP)) + e.a.a.a.R(4, this.wim);
            if (this.xcQ != null) {
                fW += e.a.a.b.b.a.h(5, this.xcQ);
            }
            return (fW + e.a.a.a.R(6, this.wMR)) + e.a.a.a.fU(7, this.woI);
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
            bvb bvb = (bvb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bvb.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bvb.wMS = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bvb.xcP = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    bvb.wim = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    bvb.xcQ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bvb.wMR = aVar3.AEQ.rA();
                    return 0;
                case 7:
                    bvb.woI = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ady extends bea {
    public int nne;
    public int sfa;
    public String wgY;
    public int wtk;
    public LinkedList<ars> wtl = new LinkedList();
    public int wtm;
    public LinkedList<aps> wtn = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.nne);
            if (this.wgY != null) {
                aVar.g(3, this.wgY);
            }
            aVar.fX(4, this.wtk);
            aVar.d(5, 8, this.wtl);
            aVar.fX(6, this.wtm);
            aVar.d(7, 8, this.wtn);
            aVar.fX(8, this.sfa);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.nne);
            if (this.wgY != null) {
                fW += e.a.a.b.b.a.h(3, this.wgY);
            }
            return ((((fW + e.a.a.a.fU(4, this.wtk)) + e.a.a.a.c(5, 8, this.wtl)) + e.a.a.a.fU(6, this.wtm)) + e.a.a.a.c(7, 8, this.wtn)) + e.a.a.a.fU(8, this.sfa);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtl.clear();
            this.wtn.clear();
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
            ady ady = (ady) objArr[1];
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
                        ady.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    ady.nne = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ady.wgY = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ady.wtk = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new ars();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ady.wtl.add(fhVar);
                    }
                    return 0;
                case 6:
                    ady.wtm = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new aps();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ady.wtn.add(fhVar);
                    }
                    return 0;
                case 8:
                    ady.sfa = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class qd extends bea {
    public int lfj;
    public int sfa;
    public LinkedList<qm> vNu = new LinkedList();
    public String wfN;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.lfj);
            aVar.d(3, 8, this.vNu);
            if (this.wfN != null) {
                aVar.g(4, this.wfN);
            }
            aVar.fX(5, this.sfa);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.lfj)) + e.a.a.a.c(3, 8, this.vNu);
            if (this.wfN != null) {
                fW += e.a.a.b.b.a.h(4, this.wfN);
            }
            return fW + e.a.a.a.fU(5, this.sfa);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vNu.clear();
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
            qd qdVar = (qd) objArr[1];
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
                        qdVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    qdVar.lfj = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new qm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        qdVar.vNu.add(fhVar);
                    }
                    return 0;
                case 4:
                    qdVar.wfN = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    qdVar.sfa = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

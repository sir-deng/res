package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class asi extends bea {
    public int sfa;
    public int vNB;
    public LinkedList<ask> vSf = new LinkedList();
    public int wGM;
    public LinkedList<ash> wGN = new LinkedList();
    public int wGO;
    public String wGP;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.vNB);
            aVar.fX(3, this.wGM);
            aVar.d(4, 8, this.wGN);
            aVar.fX(5, this.wGO);
            aVar.d(6, 8, this.vSf);
            if (this.wGP != null) {
                aVar.g(7, this.wGP);
            }
            aVar.fX(8, this.sfa);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((((fW + e.a.a.a.fU(2, this.vNB)) + e.a.a.a.fU(3, this.wGM)) + e.a.a.a.c(4, 8, this.wGN)) + e.a.a.a.fU(5, this.wGO)) + e.a.a.a.c(6, 8, this.vSf);
            if (this.wGP != null) {
                fW += e.a.a.b.b.a.h(7, this.wGP);
            }
            return fW + e.a.a.a.fU(8, this.sfa);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wGN.clear();
            this.vSf.clear();
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
            asi asi = (asi) objArr[1];
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
                        asi.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    asi.vNB = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    asi.wGM = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new ash();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        asi.wGN.add(fhVar);
                    }
                    return 0;
                case 5:
                    asi.wGO = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new ask();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        asi.vSf.add(fhVar);
                    }
                    return 0;
                case 7:
                    asi.wGP = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    asi.sfa = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

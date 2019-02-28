package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class f extends bea {
    public int scene;
    public String title;
    public String vJJ;
    public int vJL;
    public long vJM;
    public LinkedList<String> vJN = new LinkedList();
    public av vJO;
    public long vJP;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.vJL);
            aVar.S(3, this.vJM);
            if (this.title != null) {
                aVar.g(4, this.title);
            }
            aVar.d(5, 1, this.vJN);
            aVar.fX(6, this.scene);
            if (this.vJJ != null) {
                aVar.g(7, this.vJJ);
            }
            if (this.vJO != null) {
                aVar.fZ(8, this.vJO.bkL());
                this.vJO.a(aVar);
            }
            aVar.S(9, this.vJP);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.vJL)) + e.a.a.a.R(3, this.vJM);
            if (this.title != null) {
                fW += e.a.a.b.b.a.h(4, this.title);
            }
            fW = (fW + e.a.a.a.c(5, 1, this.vJN)) + e.a.a.a.fU(6, this.scene);
            if (this.vJJ != null) {
                fW += e.a.a.b.b.a.h(7, this.vJJ);
            }
            if (this.vJO != null) {
                fW += e.a.a.a.fW(8, this.vJO.bkL());
            }
            return fW + e.a.a.a.R(9, this.vJP);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vJN.clear();
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
            f fVar = (f) objArr[1];
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
                        fVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    fVar.vJL = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    fVar.vJM = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    fVar.title = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    fVar.vJN.add(aVar3.AEQ.readString());
                    return 0;
                case 6:
                    fVar.scene = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    fVar.vJJ = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new av();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        fVar.vJO = fhVar;
                    }
                    return 0;
                case 9:
                    fVar.vJP = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

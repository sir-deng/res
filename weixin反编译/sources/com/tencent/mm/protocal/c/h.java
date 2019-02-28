package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class h extends bea {
    public int scene;
    public String title;
    public String vJJ;
    public LinkedList<j> vJN = new LinkedList();
    public av vJO;
    public long vJP;
    public long vJR;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            aVar.S(3, this.vJR);
            aVar.d(5, 8, this.vJN);
            aVar.fX(7, this.scene);
            if (this.vJJ != null) {
                aVar.g(8, this.vJJ);
            }
            if (this.vJO != null) {
                aVar.fZ(9, this.vJO.bkL());
                this.vJO.a(aVar);
            }
            aVar.S(10, this.vJP);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.title != null) {
                fW += e.a.a.b.b.a.h(2, this.title);
            }
            fW = ((fW + e.a.a.a.R(3, this.vJR)) + e.a.a.a.c(5, 8, this.vJN)) + e.a.a.a.fU(7, this.scene);
            if (this.vJJ != null) {
                fW += e.a.a.b.b.a.h(8, this.vJJ);
            }
            if (this.vJO != null) {
                fW += e.a.a.a.fW(9, this.vJO.bkL());
            }
            return fW + e.a.a.a.R(10, this.vJP);
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
            h hVar = (h) objArr[1];
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
                        hVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    hVar.title = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    hVar.vJR = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new j();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        hVar.vJN.add(fhVar);
                    }
                    return 0;
                case 7:
                    hVar.scene = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    hVar.vJJ = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new av();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        hVar.vJO = fhVar;
                    }
                    return 0;
                case 10:
                    hVar.vJP = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

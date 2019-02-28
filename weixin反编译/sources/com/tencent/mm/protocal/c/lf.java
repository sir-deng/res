package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class lf extends bea {
    public int fDM;
    public int oeK;
    public int pPM;
    public String pQS;
    public String pQT;
    public String vOg;
    public String vOh;
    public String waN;
    public String waO;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vOg != null) {
                aVar.g(2, this.vOg);
            }
            if (this.vOh != null) {
                aVar.g(3, this.vOh);
            }
            aVar.fX(4, this.oeK);
            if (this.pQT != null) {
                aVar.g(5, this.pQT);
            }
            if (this.pQS != null) {
                aVar.g(6, this.pQS);
            }
            aVar.fX(7, this.fDM);
            aVar.fX(8, this.pPM);
            if (this.waN != null) {
                aVar.g(9, this.waN);
            }
            if (this.waO == null) {
                return 0;
            }
            aVar.g(10, this.waO);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vOg != null) {
                fW += e.a.a.b.b.a.h(2, this.vOg);
            }
            if (this.vOh != null) {
                fW += e.a.a.b.b.a.h(3, this.vOh);
            }
            fW += e.a.a.a.fU(4, this.oeK);
            if (this.pQT != null) {
                fW += e.a.a.b.b.a.h(5, this.pQT);
            }
            if (this.pQS != null) {
                fW += e.a.a.b.b.a.h(6, this.pQS);
            }
            fW = (fW + e.a.a.a.fU(7, this.fDM)) + e.a.a.a.fU(8, this.pPM);
            if (this.waN != null) {
                fW += e.a.a.b.b.a.h(9, this.waN);
            }
            if (this.waO != null) {
                fW += e.a.a.b.b.a.h(10, this.waO);
            }
            return fW;
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
            lf lfVar = (lf) objArr[1];
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
                        lfVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    lfVar.vOg = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    lfVar.vOh = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    lfVar.oeK = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    lfVar.pQT = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    lfVar.pQS = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    lfVar.fDM = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    lfVar.pPM = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    lfVar.waN = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    lfVar.waO = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

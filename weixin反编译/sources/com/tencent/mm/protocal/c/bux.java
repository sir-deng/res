package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bux extends bea {
    public String wNo;
    public int wdO;
    public int wil;
    public long wim;
    public bwi xci;
    public bwi xcj;
    public long xcm;
    public int xcv;
    public int xcw;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wNo != null) {
                aVar.g(2, this.wNo);
            }
            aVar.fX(3, this.wil);
            aVar.fX(4, this.xcv);
            if (this.xci != null) {
                aVar.fZ(5, this.xci.bkL());
                this.xci.a(aVar);
            }
            if (this.xcj != null) {
                aVar.fZ(6, this.xcj.bkL());
                this.xcj.a(aVar);
            }
            aVar.S(7, this.wim);
            aVar.fX(8, this.wdO);
            aVar.S(9, this.xcm);
            aVar.fX(10, this.xcw);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wNo != null) {
                fW += e.a.a.b.b.a.h(2, this.wNo);
            }
            fW = (fW + e.a.a.a.fU(3, this.wil)) + e.a.a.a.fU(4, this.xcv);
            if (this.xci != null) {
                fW += e.a.a.a.fW(5, this.xci.bkL());
            }
            if (this.xcj != null) {
                fW += e.a.a.a.fW(6, this.xcj.bkL());
            }
            return (((fW + e.a.a.a.R(7, this.wim)) + e.a.a.a.fU(8, this.wdO)) + e.a.a.a.R(9, this.xcm)) + e.a.a.a.fU(10, this.xcw);
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
            bux bux = (bux) objArr[1];
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
                        bux.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bux.wNo = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bux.wil = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bux.xcv = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bwi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bux.xci = fhVar;
                    }
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bwi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bux.xcj = fhVar;
                    }
                    return 0;
                case 7:
                    bux.wim = aVar3.AEQ.rA();
                    return 0;
                case 8:
                    bux.wdO = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bux.xcm = aVar3.AEQ.rA();
                    return 0;
                case 10:
                    bux.xcw = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

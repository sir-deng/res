package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aun extends bek {
    public int bMF;
    public String kRA;
    public int kRz;
    public apr wJd;
    public int wJe;
    public int wJf;
    public int wJg;
    public LinkedList<ro> wJh = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            aVar.fX(2, this.kRz);
            if (this.kRA != null) {
                aVar.g(3, this.kRA);
            }
            aVar.fX(4, this.bMF);
            aVar.fX(5, this.wJe);
            aVar.fX(6, this.wJf);
            aVar.fX(7, this.wJg);
            aVar.d(8, 8, this.wJh);
            if (this.wJd == null) {
                return 0;
            }
            aVar.fZ(9, this.wJd.bkL());
            this.wJd.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.kRz);
            if (this.kRA != null) {
                fW += e.a.a.b.b.a.h(3, this.kRA);
            }
            fW = ((((fW + e.a.a.a.fU(4, this.bMF)) + e.a.a.a.fU(5, this.wJe)) + e.a.a.a.fU(6, this.wJf)) + e.a.a.a.fU(7, this.wJg)) + e.a.a.a.c(8, 8, this.wJh);
            if (this.wJd != null) {
                fW += e.a.a.a.fW(9, this.wJd.bkL());
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wJh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aun aun = (aun) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            com.tencent.mm.bp.a fiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aun.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    aun.kRz = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    aun.kRA = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aun.bMF = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aun.wJe = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    aun.wJf = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    aun.wJg = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ro();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aun.wJh.add(fiVar);
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new apr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aun.wJd = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

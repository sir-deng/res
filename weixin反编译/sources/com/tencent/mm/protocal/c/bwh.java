package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bwh extends bek {
    public int wNd;
    public int wil;
    public long wim;
    public LinkedList<buv> xcY = new LinkedList();
    public int xef;
    public LinkedList<buv> xeg = new LinkedList();
    public int xeh;
    public LinkedList<buv> xei = new LinkedList();
    public int xej;
    public int xek;
    public int xel;

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
            aVar.fX(2, this.wil);
            aVar.fX(3, this.xef);
            aVar.d(4, 8, this.xeg);
            aVar.fX(5, this.xeh);
            aVar.d(6, 8, this.xei);
            aVar.S(7, this.wim);
            aVar.fX(8, this.wNd);
            aVar.fX(9, this.xej);
            aVar.d(10, 8, this.xcY);
            aVar.fX(11, this.xek);
            aVar.fX(12, this.xel);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            return ((((((((((fW + e.a.a.a.fU(2, this.wil)) + e.a.a.a.fU(3, this.xef)) + e.a.a.a.c(4, 8, this.xeg)) + e.a.a.a.fU(5, this.xeh)) + e.a.a.a.c(6, 8, this.xei)) + e.a.a.a.R(7, this.wim)) + e.a.a.a.fU(8, this.wNd)) + e.a.a.a.fU(9, this.xej)) + e.a.a.a.c(10, 8, this.xcY)) + e.a.a.a.fU(11, this.xek)) + e.a.a.a.fU(12, this.xel);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xeg.clear();
            this.xei.clear();
            this.xcY.clear();
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
            bwh bwh = (bwh) objArr[1];
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
                        bwh.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bwh.wil = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bwh.xef = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new buv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bwh.xeg.add(fiVar);
                    }
                    return 0;
                case 5:
                    bwh.xeh = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new buv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bwh.xei.add(fiVar);
                    }
                    return 0;
                case 7:
                    bwh.wim = aVar3.AEQ.rA();
                    return 0;
                case 8:
                    bwh.wNd = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bwh.xej = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new buv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bwh.xcY.add(fiVar);
                    }
                    return 0;
                case 11:
                    bwh.xek = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    bwh.xel = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

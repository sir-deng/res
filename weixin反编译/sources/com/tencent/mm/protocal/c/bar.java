package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bar extends bek {
    public int bMF;
    public int fLQ;
    public String kRA;
    public int kRz;
    public String wNw;
    public String wOc;
    public String wOd;
    public String wOe;
    public String wOf;
    public int wOg;
    public LinkedList<ro> wOh = new LinkedList();
    public int wOi;
    public LinkedList<ro> wOj = new LinkedList();
    public ro wOk;
    public LinkedList<ro> wOl = new LinkedList();
    public ro wOm;
    public arq wOn;
    public String wOo;
    public int wOp;
    public String wOq;
    public int wOr;
    public boolean wOs;
    public int wer;

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
            if (this.wOd != null) {
                aVar.g(5, this.wOd);
            }
            if (this.wOe != null) {
                aVar.g(6, this.wOe);
            }
            if (this.wOf != null) {
                aVar.g(7, this.wOf);
            }
            aVar.fX(8, this.wOg);
            aVar.d(9, 8, this.wOh);
            aVar.fX(10, this.fLQ);
            aVar.fX(11, this.wOi);
            aVar.d(12, 8, this.wOj);
            if (this.wNw != null) {
                aVar.g(13, this.wNw);
            }
            if (this.wOk != null) {
                aVar.fZ(14, this.wOk.bkL());
                this.wOk.a(aVar);
            }
            aVar.d(15, 8, this.wOl);
            if (this.wOm != null) {
                aVar.fZ(16, this.wOm.bkL());
                this.wOm.a(aVar);
            }
            if (this.wOn != null) {
                aVar.fZ(17, this.wOn.bkL());
                this.wOn.a(aVar);
            }
            if (this.wOo != null) {
                aVar.g(18, this.wOo);
            }
            aVar.fX(19, this.wOp);
            if (this.wOq != null) {
                aVar.g(20, this.wOq);
            }
            if (this.wOc != null) {
                aVar.g(21, this.wOc);
            }
            aVar.fX(22, this.wOr);
            aVar.am(23, this.wOs);
            aVar.fX(24, this.wer);
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
            fW += e.a.a.a.fU(4, this.bMF);
            if (this.wOd != null) {
                fW += e.a.a.b.b.a.h(5, this.wOd);
            }
            if (this.wOe != null) {
                fW += e.a.a.b.b.a.h(6, this.wOe);
            }
            if (this.wOf != null) {
                fW += e.a.a.b.b.a.h(7, this.wOf);
            }
            fW = ((((fW + e.a.a.a.fU(8, this.wOg)) + e.a.a.a.c(9, 8, this.wOh)) + e.a.a.a.fU(10, this.fLQ)) + e.a.a.a.fU(11, this.wOi)) + e.a.a.a.c(12, 8, this.wOj);
            if (this.wNw != null) {
                fW += e.a.a.b.b.a.h(13, this.wNw);
            }
            if (this.wOk != null) {
                fW += e.a.a.a.fW(14, this.wOk.bkL());
            }
            fW += e.a.a.a.c(15, 8, this.wOl);
            if (this.wOm != null) {
                fW += e.a.a.a.fW(16, this.wOm.bkL());
            }
            if (this.wOn != null) {
                fW += e.a.a.a.fW(17, this.wOn.bkL());
            }
            if (this.wOo != null) {
                fW += e.a.a.b.b.a.h(18, this.wOo);
            }
            fW += e.a.a.a.fU(19, this.wOp);
            if (this.wOq != null) {
                fW += e.a.a.b.b.a.h(20, this.wOq);
            }
            if (this.wOc != null) {
                fW += e.a.a.b.b.a.h(21, this.wOc);
            }
            return ((fW + e.a.a.a.fU(22, this.wOr)) + (e.a.a.b.b.a.dX(23) + 1)) + e.a.a.a.fU(24, this.wer);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wOh.clear();
            this.wOj.clear();
            this.wOl.clear();
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
            bar bar = (bar) objArr[1];
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
                        bar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bar.kRz = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bar.kRA = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bar.bMF = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bar.wOd = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bar.wOe = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bar.wOf = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bar.wOg = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ro();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bar.wOh.add(fiVar);
                    }
                    return 0;
                case 10:
                    bar.fLQ = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    bar.wOi = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ro();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bar.wOj.add(fiVar);
                    }
                    return 0;
                case 13:
                    bar.wNw = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ro();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bar.wOk = fiVar;
                    }
                    return 0;
                case 15:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ro();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bar.wOl.add(fiVar);
                    }
                    return 0;
                case 16:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ro();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bar.wOm = fiVar;
                    }
                    return 0;
                case 17:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new arq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bar.wOn = fiVar;
                    }
                    return 0;
                case 18:
                    bar.wOo = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    bar.wOp = aVar3.AEQ.rz();
                    return 0;
                case 20:
                    bar.wOq = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    bar.wOc = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    bar.wOr = aVar3.AEQ.rz();
                    return 0;
                case 23:
                    bar.wOs = aVar3.cKv();
                    return 0;
                case 24:
                    bar.wer = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

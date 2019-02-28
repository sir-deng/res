package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class he extends bek {
    public String fsK;
    public int vMj;
    public String vPp;
    public bjx vQb;
    public String vQc;
    public int vQg;
    public int vTc;
    public String vTd;
    public String vTe;
    public int vTf;
    public String vTg;
    public akv vTh;
    public ir vTi;
    public atk vTj;
    public String vTk;
    public int vTl;
    public bew vTm;
    public String vTn;
    public String vTo;
    public String vTp;
    public String vTq;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            if (this.fsK != null) {
                aVar.g(2, this.fsK);
            }
            if (this.vTe != null) {
                aVar.g(3, this.vTe);
            }
            aVar.fX(4, this.vTf);
            if (this.vTg != null) {
                aVar.g(5, this.vTg);
            }
            if (this.vPp != null) {
                aVar.g(6, this.vPp);
            }
            if (this.vTh != null) {
                aVar.fZ(7, this.vTh.bkL());
                this.vTh.a(aVar);
            }
            if (this.vTi != null) {
                aVar.fZ(8, this.vTi.bkL());
                this.vTi.a(aVar);
            }
            if (this.vTj != null) {
                aVar.fZ(9, this.vTj.bkL());
                this.vTj.a(aVar);
            }
            if (this.vQc != null) {
                aVar.g(10, this.vQc);
            }
            aVar.fX(11, this.vMj);
            if (this.vTk != null) {
                aVar.g(12, this.vTk);
            }
            aVar.fX(13, this.vTl);
            if (this.vTm != null) {
                aVar.fZ(14, this.vTm.bkL());
                this.vTm.a(aVar);
            }
            if (this.vTn != null) {
                aVar.g(15, this.vTn);
            }
            if (this.vTo != null) {
                aVar.g(16, this.vTo);
            }
            if (this.vQb != null) {
                aVar.fZ(17, this.vQb.bkL());
                this.vQb.a(aVar);
            }
            aVar.fX(18, this.vQg);
            if (this.vTp != null) {
                aVar.g(19, this.vTp);
            }
            if (this.vTq != null) {
                aVar.g(20, this.vTq);
            }
            aVar.fX(21, this.vTc);
            if (this.vTd == null) {
                return 0;
            }
            aVar.g(22, this.vTd);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.fsK != null) {
                fW += e.a.a.b.b.a.h(2, this.fsK);
            }
            if (this.vTe != null) {
                fW += e.a.a.b.b.a.h(3, this.vTe);
            }
            fW += e.a.a.a.fU(4, this.vTf);
            if (this.vTg != null) {
                fW += e.a.a.b.b.a.h(5, this.vTg);
            }
            if (this.vPp != null) {
                fW += e.a.a.b.b.a.h(6, this.vPp);
            }
            if (this.vTh != null) {
                fW += e.a.a.a.fW(7, this.vTh.bkL());
            }
            if (this.vTi != null) {
                fW += e.a.a.a.fW(8, this.vTi.bkL());
            }
            if (this.vTj != null) {
                fW += e.a.a.a.fW(9, this.vTj.bkL());
            }
            if (this.vQc != null) {
                fW += e.a.a.b.b.a.h(10, this.vQc);
            }
            fW += e.a.a.a.fU(11, this.vMj);
            if (this.vTk != null) {
                fW += e.a.a.b.b.a.h(12, this.vTk);
            }
            fW += e.a.a.a.fU(13, this.vTl);
            if (this.vTm != null) {
                fW += e.a.a.a.fW(14, this.vTm.bkL());
            }
            if (this.vTn != null) {
                fW += e.a.a.b.b.a.h(15, this.vTn);
            }
            if (this.vTo != null) {
                fW += e.a.a.b.b.a.h(16, this.vTo);
            }
            if (this.vQb != null) {
                fW += e.a.a.a.fW(17, this.vQb.bkL());
            }
            fW += e.a.a.a.fU(18, this.vQg);
            if (this.vTp != null) {
                fW += e.a.a.b.b.a.h(19, this.vTp);
            }
            if (this.vTq != null) {
                fW += e.a.a.b.b.a.h(20, this.vTq);
            }
            fW += e.a.a.a.fU(21, this.vTc);
            if (this.vTd != null) {
                fW += e.a.a.b.b.a.h(22, this.vTd);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            he heVar = (he) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
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
                        heVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    heVar.fsK = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    heVar.vTe = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    heVar.vTf = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    heVar.vTg = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    heVar.vPp = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new akv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        heVar.vTh = fiVar;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new ir();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        heVar.vTi = fiVar;
                    }
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new atk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        heVar.vTj = fiVar;
                    }
                    return 0;
                case 10:
                    heVar.vQc = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    heVar.vMj = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    heVar.vTk = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    heVar.vTl = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bew();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        heVar.vTm = fiVar;
                    }
                    return 0;
                case 15:
                    heVar.vTn = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    heVar.vTo = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bjx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        heVar.vQb = fiVar;
                    }
                    return 0;
                case 18:
                    heVar.vQg = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    heVar.vTp = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    heVar.vTq = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    heVar.vTc = aVar3.AEQ.rz();
                    return 0;
                case 22:
                    heVar.vTd = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

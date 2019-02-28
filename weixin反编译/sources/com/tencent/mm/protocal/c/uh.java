package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class uh extends bek {
    public int fMy;
    public int fMz;
    public int frq;
    public int lot;
    public String lou;
    public String oeH;
    public int oeK;
    public int oeM;
    public String oeN;
    public String oeO;
    public String oeP;
    public int oeQ;
    public String ohP;
    public bcj wjc;

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
            aVar.fX(2, this.lot);
            if (this.lou != null) {
                aVar.g(3, this.lou);
            }
            aVar.fX(4, this.frq);
            if (this.oeH != null) {
                aVar.g(5, this.oeH);
            }
            aVar.fX(6, this.fMy);
            aVar.fX(7, this.fMz);
            if (this.ohP != null) {
                aVar.g(8, this.ohP);
            }
            aVar.fX(9, this.oeK);
            if (this.wjc != null) {
                aVar.fZ(10, this.wjc.bkL());
                this.wjc.a(aVar);
            }
            aVar.fX(11, this.oeM);
            if (this.oeN != null) {
                aVar.g(12, this.oeN);
            }
            if (this.oeO != null) {
                aVar.g(13, this.oeO);
            }
            if (this.oeP != null) {
                aVar.g(14, this.oeP);
            }
            aVar.fX(15, this.oeQ);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.lot);
            if (this.lou != null) {
                fW += e.a.a.b.b.a.h(3, this.lou);
            }
            fW += e.a.a.a.fU(4, this.frq);
            if (this.oeH != null) {
                fW += e.a.a.b.b.a.h(5, this.oeH);
            }
            fW = (fW + e.a.a.a.fU(6, this.fMy)) + e.a.a.a.fU(7, this.fMz);
            if (this.ohP != null) {
                fW += e.a.a.b.b.a.h(8, this.ohP);
            }
            fW += e.a.a.a.fU(9, this.oeK);
            if (this.wjc != null) {
                fW += e.a.a.a.fW(10, this.wjc.bkL());
            }
            fW += e.a.a.a.fU(11, this.oeM);
            if (this.oeN != null) {
                fW += e.a.a.b.b.a.h(12, this.oeN);
            }
            if (this.oeO != null) {
                fW += e.a.a.b.b.a.h(13, this.oeO);
            }
            if (this.oeP != null) {
                fW += e.a.a.b.b.a.h(14, this.oeP);
            }
            return fW + e.a.a.a.fU(15, this.oeQ);
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
            uh uhVar = (uh) objArr[1];
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
                        uhVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    uhVar.lot = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    uhVar.lou = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    uhVar.frq = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    uhVar.oeH = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    uhVar.fMy = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    uhVar.fMz = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    uhVar.ohP = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    uhVar.oeK = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bcj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        uhVar.wjc = fiVar;
                    }
                    return 0;
                case 11:
                    uhVar.oeM = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    uhVar.oeN = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    uhVar.oeO = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    uhVar.oeP = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    uhVar.oeQ = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

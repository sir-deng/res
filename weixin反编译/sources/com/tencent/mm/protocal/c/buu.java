package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class buu extends bek {
    public int wil;
    public long wim;
    public int xch;
    public int xcn;
    public bwd xco;
    public int xcp;
    public int xcq;
    public int xcr;
    public int xcs;

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
            aVar.fX(2, this.wil);
            aVar.S(3, this.wim);
            aVar.fX(4, this.xcn);
            if (this.xco != null) {
                aVar.fZ(5, this.xco.bkL());
                this.xco.a(aVar);
            }
            aVar.fX(6, this.xch);
            aVar.fX(7, this.xcp);
            aVar.fX(8, this.xcq);
            aVar.fX(9, this.xcr);
            aVar.fX(10, this.xcs);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((fW + e.a.a.a.fU(2, this.wil)) + e.a.a.a.R(3, this.wim)) + e.a.a.a.fU(4, this.xcn);
            if (this.xco != null) {
                fW += e.a.a.a.fW(5, this.xco.bkL());
            }
            return ((((fW + e.a.a.a.fU(6, this.xch)) + e.a.a.a.fU(7, this.xcp)) + e.a.a.a.fU(8, this.xcq)) + e.a.a.a.fU(9, this.xcr)) + e.a.a.a.fU(10, this.xcs);
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
            buu buu = (buu) objArr[1];
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
                        buu.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    buu.wil = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    buu.wim = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    buu.xcn = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bwd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        buu.xco = fiVar;
                    }
                    return 0;
                case 6:
                    buu.xch = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    buu.xcp = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    buu.xcq = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    buu.xcr = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    buu.xcs = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

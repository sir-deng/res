package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bkz extends bek {
    public int kzz;
    public int vPs;
    public int vPt;
    public bes vQW;
    public String wUJ;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vQW == null) {
                throw new b("Not all required fields were included: Buffer");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                aVar.fX(2, this.vPt);
                aVar.fX(3, this.vPs);
                if (this.vQW != null) {
                    aVar.fZ(4, this.vQW.bkL());
                    this.vQW.a(aVar);
                }
                if (this.wUJ != null) {
                    aVar.g(5, this.wUJ);
                }
                aVar.fX(6, this.kzz);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.vPt)) + e.a.a.a.fU(3, this.vPs);
            if (this.vQW != null) {
                fW += e.a.a.a.fW(4, this.vQW.bkL());
            }
            if (this.wUJ != null) {
                fW += e.a.a.b.b.a.h(5, this.wUJ);
            }
            return fW + e.a.a.a.fU(6, this.kzz);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.vQW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Buffer");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkz bkz = (bkz) objArr[1];
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
                        bkz.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bkz.vPt = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bkz.vPs = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bkz.vQW = fiVar;
                    }
                    return 0;
                case 5:
                    bkz.wUJ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bkz.kzz = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

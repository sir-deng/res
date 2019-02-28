package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ru extends bek {
    public int vNL;
    public long vNT;
    public int vPs;
    public int vPt;
    public bes weD;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.weD == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.wRa != null) {
                    aVar.fZ(1, this.wRa.bkL());
                    this.wRa.a(aVar);
                }
                aVar.fX(2, this.vNL);
                aVar.fX(3, this.vPs);
                aVar.fX(4, this.vPt);
                if (this.weD != null) {
                    aVar.fZ(5, this.weD.bkL());
                    this.weD.a(aVar);
                }
                aVar.S(6, this.vNT);
                return 0;
            }
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((fW + e.a.a.a.fU(2, this.vNL)) + e.a.a.a.fU(3, this.vPs)) + e.a.a.a.fU(4, this.vPt);
            if (this.weD != null) {
                fW += e.a.a.a.fW(5, this.weD.bkL());
            }
            return fW + e.a.a.a.R(6, this.vNT);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.weD != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ru ruVar = (ru) objArr[1];
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
                        ruVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    ruVar.vNL = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ruVar.vPs = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    ruVar.vPt = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ruVar.weD = fiVar;
                    }
                    return 0;
                case 6:
                    ruVar.vNT = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

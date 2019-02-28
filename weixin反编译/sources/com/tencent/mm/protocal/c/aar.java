package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aar extends bek {
    public LinkedList<String> kOi = new LinkedList();
    public int kOk;
    public int kOl;
    public int kOm;

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
            aVar.d(2, 1, this.kOi);
            aVar.fX(3, this.kOk);
            aVar.fX(4, this.kOl);
            aVar.fX(5, this.kOm);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            return (((fW + e.a.a.a.c(2, 1, this.kOi)) + e.a.a.a.fU(3, this.kOk)) + e.a.a.a.fU(4, this.kOl)) + e.a.a.a.fU(5, this.kOm);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kOi.clear();
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
            aar aar = (aar) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fiVar = new fi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    aar.kOi.add(aVar3.AEQ.readString());
                    return 0;
                case 3:
                    aar.kOk = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aar.kOl = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aar.kOm = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

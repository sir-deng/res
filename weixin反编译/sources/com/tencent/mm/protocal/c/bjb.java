package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bjb extends bek {
    public int kyA;
    public String pke;
    public int vQL;
    public LinkedList<biz> wTa = new LinkedList();
    public int wTb;

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
            aVar.fX(2, this.kyA);
            aVar.d(3, 8, this.wTa);
            if (this.pke != null) {
                aVar.g(4, this.pke);
            }
            aVar.fX(5, this.wTb);
            aVar.fX(6, this.vQL);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.kyA)) + e.a.a.a.c(3, 8, this.wTa);
            if (this.pke != null) {
                fW += e.a.a.b.b.a.h(4, this.pke);
            }
            return (fW + e.a.a.a.fU(5, this.wTb)) + e.a.a.a.fU(6, this.vQL);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wTa.clear();
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
            bjb bjb = (bjb) objArr[1];
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
                        bjb.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bjb.kyA = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new biz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bjb.wTa.add(fiVar);
                    }
                    return 0;
                case 4:
                    bjb.pke = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bjb.wTb = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bjb.vQL = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

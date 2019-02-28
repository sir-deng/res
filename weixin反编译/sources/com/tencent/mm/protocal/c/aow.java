package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aow extends bek {
    public int raD;
    public int wCE;
    public int wCF;
    public int wCG;
    public int wrp;
    public LinkedList<aor> wrq = new LinkedList();

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
            aVar.fX(2, this.wrp);
            aVar.d(3, 8, this.wrq);
            aVar.fX(4, this.raD);
            aVar.fX(5, this.wCE);
            aVar.fX(6, this.wCF);
            aVar.fX(7, this.wCG);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            return (((((fW + e.a.a.a.fU(2, this.wrp)) + e.a.a.a.c(3, 8, this.wrq)) + e.a.a.a.fU(4, this.raD)) + e.a.a.a.fU(5, this.wCE)) + e.a.a.a.fU(6, this.wCF)) + e.a.a.a.fU(7, this.wCG);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wrq.clear();
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
            aow aow = (aow) objArr[1];
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
                        aow.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    aow.wrp = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new aor();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aow.wrq.add(fiVar);
                    }
                    return 0;
                case 4:
                    aow.raD = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aow.wCE = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    aow.wCF = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    aow.wCG = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

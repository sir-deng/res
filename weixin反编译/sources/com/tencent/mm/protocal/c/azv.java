package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class azv extends bea {
    public long wMR;
    public long wMU;
    public String wNo;
    public int wNp;
    public int wNq;
    public int wil;
    public long wim;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wNo == null) {
                throw new b("Not all required fields were included: FromUsername");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wNo != null) {
                aVar.g(2, this.wNo);
            }
            aVar.fX(3, this.wil);
            aVar.S(4, this.wim);
            aVar.S(5, this.wMR);
            aVar.fX(6, this.wNp);
            aVar.S(7, this.wMU);
            aVar.fX(8, this.wNq);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wNo != null) {
                fW += e.a.a.b.b.a.h(2, this.wNo);
            }
            return (((((fW + e.a.a.a.fU(3, this.wil)) + e.a.a.a.R(4, this.wim)) + e.a.a.a.R(5, this.wMR)) + e.a.a.a.fU(6, this.wNp)) + e.a.a.a.R(7, this.wMU)) + e.a.a.a.fU(8, this.wNq);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wNo != null) {
                return 0;
            }
            throw new b("Not all required fields were included: FromUsername");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azv azv = (azv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        azv.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    azv.wNo = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    azv.wil = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    azv.wim = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    azv.wMR = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    azv.wNp = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    azv.wMU = aVar3.AEQ.rA();
                    return 0;
                case 8:
                    azv.wNq = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

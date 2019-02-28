package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bgj extends bea {
    public int vKI;
    public bes vOw;
    public int wSa;
    public bet wzM;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wzM == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.vOw == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.wzM != null) {
                    aVar.fZ(2, this.wzM.bkL());
                    this.wzM.a(aVar);
                }
                aVar.fX(3, this.vKI);
                aVar.fX(4, this.wSa);
                if (this.vOw == null) {
                    return 0;
                }
                aVar.fZ(5, this.vOw.bkL());
                this.vOw.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wzM != null) {
                fW += e.a.a.a.fW(2, this.wzM.bkL());
            }
            fW = (fW + e.a.a.a.fU(3, this.vKI)) + e.a.a.a.fU(4, this.wSa);
            if (this.vOw != null) {
                fW += e.a.a.a.fW(5, this.vOw.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wzM == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.vOw != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bgj bgj = (bgj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bgj.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bgj.wzM = fhVar;
                    }
                    return 0;
                case 3:
                    bgj.vKI = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bgj.wSa = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bgj.vOw = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

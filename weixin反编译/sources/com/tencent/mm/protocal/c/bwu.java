package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bwu extends bea {
    public int vYD;
    public bes vYE;
    public String wNo;
    public int wil;
    public long wim;
    public long xcm;
    public bvs xeC;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vYE == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.xeC == null) {
                throw new b("Not all required fields were included: OpLog");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.wNo != null) {
                    aVar.g(2, this.wNo);
                }
                aVar.fX(3, this.wil);
                if (this.vYE != null) {
                    aVar.fZ(4, this.vYE.bkL());
                    this.vYE.a(aVar);
                }
                if (this.xeC != null) {
                    aVar.fZ(5, this.xeC.bkL());
                    this.xeC.a(aVar);
                }
                aVar.S(6, this.wim);
                aVar.fX(7, this.vYD);
                aVar.S(8, this.xcm);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wNo != null) {
                fW += e.a.a.b.b.a.h(2, this.wNo);
            }
            fW += e.a.a.a.fU(3, this.wil);
            if (this.vYE != null) {
                fW += e.a.a.a.fW(4, this.vYE.bkL());
            }
            if (this.xeC != null) {
                fW += e.a.a.a.fW(5, this.xeC.bkL());
            }
            return ((fW + e.a.a.a.R(6, this.wim)) + e.a.a.a.fU(7, this.vYD)) + e.a.a.a.R(8, this.xcm);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vYE == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.xeC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: OpLog");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bwu bwu = (bwu) objArr[1];
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
                        bwu.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bwu.wNo = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bwu.wil = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bwu.vYE = fhVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bvs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bwu.xeC = fhVar;
                    }
                    return 0;
                case 6:
                    bwu.wim = aVar3.AEQ.rA();
                    return 0;
                case 7:
                    bwu.vYD = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bwu.xcm = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

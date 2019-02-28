package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bcw extends bea {
    public bes vSZ;
    public String wPD;
    public String wPE;
    public String wqc;
    public long wqd;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.S(2, this.wqd);
            if (this.wPD != null) {
                aVar.g(3, this.wPD);
            }
            if (this.wPE != null) {
                aVar.g(4, this.wPE);
            }
            if (this.wqc != null) {
                aVar.g(5, this.wqc);
            }
            if (this.vSZ == null) {
                return 0;
            }
            aVar.fZ(6, this.vSZ.bkL());
            this.vSZ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.R(2, this.wqd);
            if (this.wPD != null) {
                fW += e.a.a.b.b.a.h(3, this.wPD);
            }
            if (this.wPE != null) {
                fW += e.a.a.b.b.a.h(4, this.wPE);
            }
            if (this.wqc != null) {
                fW += e.a.a.b.b.a.h(5, this.wqc);
            }
            if (this.vSZ != null) {
                fW += e.a.a.a.fW(6, this.vSZ.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bcw bcw = (bcw) objArr[1];
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
                        bcw.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bcw.wqd = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    bcw.wPD = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bcw.wPE = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bcw.wqc = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bcw.vSZ = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

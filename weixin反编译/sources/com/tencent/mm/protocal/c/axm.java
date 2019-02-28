package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class axm extends bea {
    public int vKK;
    public int vXP;
    public av vXW;
    public String wLC;
    public String wLD;
    public b wLE;
    public int wLF;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wLC != null) {
                aVar.g(2, this.wLC);
            }
            if (this.wLD != null) {
                aVar.g(3, this.wLD);
            }
            if (this.wLE != null) {
                aVar.b(4, this.wLE);
            }
            aVar.fX(5, this.vXP);
            aVar.fX(6, this.vKK);
            aVar.fX(7, this.wLF);
            if (this.vXW == null) {
                return 0;
            }
            aVar.fZ(8, this.vXW.bkL());
            this.vXW.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wLC != null) {
                fW += e.a.a.b.b.a.h(2, this.wLC);
            }
            if (this.wLD != null) {
                fW += e.a.a.b.b.a.h(3, this.wLD);
            }
            if (this.wLE != null) {
                fW += e.a.a.a.a(4, this.wLE);
            }
            fW = ((fW + e.a.a.a.fU(5, this.vXP)) + e.a.a.a.fU(6, this.vKK)) + e.a.a.a.fU(7, this.wLF);
            if (this.vXW != null) {
                fW += e.a.a.a.fW(8, this.vXW.bkL());
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
            axm axm = (axm) objArr[1];
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
                        axm.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    axm.wLC = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    axm.wLD = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    axm.wLE = aVar3.cKw();
                    return 0;
                case 5:
                    axm.vXP = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    axm.vKK = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    axm.wLF = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new av();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        axm.vXW = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

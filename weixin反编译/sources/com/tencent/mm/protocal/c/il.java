package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class il extends bea {
    public int vKK;
    public String vKL;
    public String vTX;
    public apm vVh;
    public bfc vVi;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vTX != null) {
                aVar.g(2, this.vTX);
            }
            if (this.vVh != null) {
                aVar.fZ(3, this.vVh.bkL());
                this.vVh.a(aVar);
            }
            if (this.vVi != null) {
                aVar.fZ(4, this.vVi.bkL());
                this.vVi.a(aVar);
            }
            aVar.fX(5, this.vKK);
            if (this.vKL == null) {
                return 0;
            }
            aVar.g(6, this.vKL);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vTX != null) {
                fW += e.a.a.b.b.a.h(2, this.vTX);
            }
            if (this.vVh != null) {
                fW += e.a.a.a.fW(3, this.vVh.bkL());
            }
            if (this.vVi != null) {
                fW += e.a.a.a.fW(4, this.vVi.bkL());
            }
            fW += e.a.a.a.fU(5, this.vKK);
            if (this.vKL != null) {
                fW += e.a.a.b.b.a.h(6, this.vKL);
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
            il ilVar = (il) objArr[1];
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
                        ilVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    ilVar.vTX = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new apm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ilVar.vVh = fhVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bfc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ilVar.vVi = fhVar;
                    }
                    return 0;
                case 5:
                    ilVar.vKK = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    ilVar.vKL = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

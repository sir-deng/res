package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class adi extends bea {
    public String mJV;
    public String mJW;
    public String mJX;
    public String vKL;
    public rk vLc;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.mJV != null) {
                aVar.g(2, this.mJV);
            }
            if (this.mJW != null) {
                aVar.g(3, this.mJW);
            }
            if (this.mJX != null) {
                aVar.g(4, this.mJX);
            }
            if (this.vKL != null) {
                aVar.g(5, this.vKL);
            }
            if (this.vLc == null) {
                return 0;
            }
            aVar.fZ(6, this.vLc.bkL());
            this.vLc.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.mJV != null) {
                fW += e.a.a.b.b.a.h(2, this.mJV);
            }
            if (this.mJW != null) {
                fW += e.a.a.b.b.a.h(3, this.mJW);
            }
            if (this.mJX != null) {
                fW += e.a.a.b.b.a.h(4, this.mJX);
            }
            if (this.vKL != null) {
                fW += e.a.a.b.b.a.h(5, this.vKL);
            }
            if (this.vLc != null) {
                fW += e.a.a.a.fW(6, this.vLc.bkL());
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
            adi adi = (adi) objArr[1];
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
                        adi.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    adi.mJV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    adi.mJW = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    adi.mJX = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    adi.vKL = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new rk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        adi.vLc = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class afd extends bea {
    public String fqu;
    public String fsK;
    public String mJV;
    public String mJW;
    public String mJX;
    public String vKL;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.fqu != null) {
                aVar.g(2, this.fqu);
            }
            if (this.mJV != null) {
                aVar.g(3, this.mJV);
            }
            if (this.mJW != null) {
                aVar.g(4, this.mJW);
            }
            if (this.mJX != null) {
                aVar.g(5, this.mJX);
            }
            if (this.fsK != null) {
                aVar.g(6, this.fsK);
            }
            if (this.vKL == null) {
                return 0;
            }
            aVar.g(7, this.vKL);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.fqu != null) {
                fW += e.a.a.b.b.a.h(2, this.fqu);
            }
            if (this.mJV != null) {
                fW += e.a.a.b.b.a.h(3, this.mJV);
            }
            if (this.mJW != null) {
                fW += e.a.a.b.b.a.h(4, this.mJW);
            }
            if (this.mJX != null) {
                fW += e.a.a.b.b.a.h(5, this.mJX);
            }
            if (this.fsK != null) {
                fW += e.a.a.b.b.a.h(6, this.fsK);
            }
            if (this.vKL != null) {
                fW += e.a.a.b.b.a.h(7, this.vKL);
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
            afd afd = (afd) objArr[1];
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
                        afd.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    afd.fqu = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    afd.mJV = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    afd.mJW = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    afd.mJX = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    afd.fsK = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    afd.vKL = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

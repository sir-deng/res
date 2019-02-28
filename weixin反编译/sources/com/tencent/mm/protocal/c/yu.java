package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class yu extends bea {
    public String appId;
    public String fry;
    public String mLc;
    public String mLd;
    public String mLe;
    public String sign;
    public String vKL;
    public int vKM;
    public cq wpM;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.appId != null) {
                aVar.g(2, this.appId);
            }
            if (this.mLc != null) {
                aVar.g(3, this.mLc);
            }
            if (this.mLd != null) {
                aVar.g(4, this.mLd);
            }
            if (this.mLe != null) {
                aVar.g(5, this.mLe);
            }
            if (this.fry != null) {
                aVar.g(6, this.fry);
            }
            if (this.sign != null) {
                aVar.g(7, this.sign);
            }
            if (this.wpM != null) {
                aVar.fZ(8, this.wpM.bkL());
                this.wpM.a(aVar);
            }
            if (this.vKL != null) {
                aVar.g(9, this.vKL);
            }
            aVar.fX(10, this.vKM);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.appId != null) {
                fW += e.a.a.b.b.a.h(2, this.appId);
            }
            if (this.mLc != null) {
                fW += e.a.a.b.b.a.h(3, this.mLc);
            }
            if (this.mLd != null) {
                fW += e.a.a.b.b.a.h(4, this.mLd);
            }
            if (this.mLe != null) {
                fW += e.a.a.b.b.a.h(5, this.mLe);
            }
            if (this.fry != null) {
                fW += e.a.a.b.b.a.h(6, this.fry);
            }
            if (this.sign != null) {
                fW += e.a.a.b.b.a.h(7, this.sign);
            }
            if (this.wpM != null) {
                fW += e.a.a.a.fW(8, this.wpM.bkL());
            }
            if (this.vKL != null) {
                fW += e.a.a.b.b.a.h(9, this.vKL);
            }
            return fW + e.a.a.a.fU(10, this.vKM);
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
            yu yuVar = (yu) objArr[1];
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
                        yuVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    yuVar.appId = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    yuVar.mLc = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    yuVar.mLd = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    yuVar.mLe = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    yuVar.fry = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    yuVar.sign = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new cq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        yuVar.wpM = fhVar;
                    }
                    return 0;
                case 9:
                    yuVar.vKL = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    yuVar.vKM = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

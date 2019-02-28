package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ja extends bek {
    public String fxT;
    public String kRA;
    public int kRz;
    public String vOg;
    public String vOh;
    public String vOi;
    public String vVM;
    public String vVT;
    public bjv vVU;
    public String vVV;
    public String vVW;
    public int vVX;
    public int vVY;
    public int vVZ;
    public bpk vWa;
    public String vWb;
    public int vWc;
    public int vWd;
    public int vWe;
    public b vWf;
    public int vWg;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            aVar.fX(2, this.kRz);
            if (this.kRA != null) {
                aVar.g(3, this.kRA);
            }
            if (this.fxT != null) {
                aVar.g(4, this.fxT);
            }
            if (this.vVT != null) {
                aVar.g(5, this.vVT);
            }
            if (this.vVU != null) {
                aVar.fZ(6, this.vVU.bkL());
                this.vVU.a(aVar);
            }
            if (this.vOg != null) {
                aVar.g(7, this.vOg);
            }
            if (this.vOi != null) {
                aVar.g(8, this.vOi);
            }
            if (this.vVV != null) {
                aVar.g(9, this.vVV);
            }
            if (this.vVW != null) {
                aVar.g(10, this.vVW);
            }
            aVar.fX(11, this.vVX);
            if (this.vOh != null) {
                aVar.g(12, this.vOh);
            }
            if (this.vVM != null) {
                aVar.g(13, this.vVM);
            }
            aVar.fX(14, this.vVY);
            aVar.fX(15, this.vVZ);
            if (this.vWa != null) {
                aVar.fZ(16, this.vWa.bkL());
                this.vWa.a(aVar);
            }
            if (this.vWb != null) {
                aVar.g(17, this.vWb);
            }
            aVar.fX(18, this.vWc);
            aVar.fX(19, this.vWd);
            aVar.fX(20, this.vWe);
            if (this.vWf != null) {
                aVar.b(21, this.vWf);
            }
            aVar.fX(22, this.vWg);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.kRz);
            if (this.kRA != null) {
                fW += e.a.a.b.b.a.h(3, this.kRA);
            }
            if (this.fxT != null) {
                fW += e.a.a.b.b.a.h(4, this.fxT);
            }
            if (this.vVT != null) {
                fW += e.a.a.b.b.a.h(5, this.vVT);
            }
            if (this.vVU != null) {
                fW += e.a.a.a.fW(6, this.vVU.bkL());
            }
            if (this.vOg != null) {
                fW += e.a.a.b.b.a.h(7, this.vOg);
            }
            if (this.vOi != null) {
                fW += e.a.a.b.b.a.h(8, this.vOi);
            }
            if (this.vVV != null) {
                fW += e.a.a.b.b.a.h(9, this.vVV);
            }
            if (this.vVW != null) {
                fW += e.a.a.b.b.a.h(10, this.vVW);
            }
            fW += e.a.a.a.fU(11, this.vVX);
            if (this.vOh != null) {
                fW += e.a.a.b.b.a.h(12, this.vOh);
            }
            if (this.vVM != null) {
                fW += e.a.a.b.b.a.h(13, this.vVM);
            }
            fW = (fW + e.a.a.a.fU(14, this.vVY)) + e.a.a.a.fU(15, this.vVZ);
            if (this.vWa != null) {
                fW += e.a.a.a.fW(16, this.vWa.bkL());
            }
            if (this.vWb != null) {
                fW += e.a.a.b.b.a.h(17, this.vWb);
            }
            fW = ((fW + e.a.a.a.fU(18, this.vWc)) + e.a.a.a.fU(19, this.vWd)) + e.a.a.a.fU(20, this.vWe);
            if (this.vWf != null) {
                fW += e.a.a.a.a(21, this.vWf);
            }
            return fW + e.a.a.a.fU(22, this.vWg);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wRa != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ja jaVar = (ja) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
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
                        jaVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    jaVar.kRz = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    jaVar.kRA = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    jaVar.fxT = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    jaVar.vVT = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bjv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        jaVar.vVU = fiVar;
                    }
                    return 0;
                case 7:
                    jaVar.vOg = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    jaVar.vOi = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    jaVar.vVV = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    jaVar.vVW = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    jaVar.vVX = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    jaVar.vOh = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    jaVar.vVM = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    jaVar.vVY = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    jaVar.vVZ = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bpk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        jaVar.vWa = fiVar;
                    }
                    return 0;
                case 17:
                    jaVar.vWb = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    jaVar.vWc = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    jaVar.vWd = aVar3.AEQ.rz();
                    return 0;
                case 20:
                    jaVar.vWe = aVar3.AEQ.rz();
                    return 0;
                case 21:
                    jaVar.vWf = aVar3.cKw();
                    return 0;
                case 22:
                    jaVar.vWg = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

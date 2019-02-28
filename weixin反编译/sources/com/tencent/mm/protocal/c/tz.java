package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class tz extends bek {
    public uc wiG;
    public tw wiH;
    public tx wiI;
    public String wiJ;
    public int wiK;
    public int wiL;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            if (this.wiG != null) {
                aVar.fZ(2, this.wiG.bkL());
                this.wiG.a(aVar);
            }
            if (this.wiH != null) {
                aVar.fZ(3, this.wiH.bkL());
                this.wiH.a(aVar);
            }
            if (this.wiI != null) {
                aVar.fZ(4, this.wiI.bkL());
                this.wiI.a(aVar);
            }
            if (this.wiJ != null) {
                aVar.g(5, this.wiJ);
            }
            aVar.fX(6, this.wiK);
            aVar.fX(7, this.wiL);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wiG != null) {
                fW += e.a.a.a.fW(2, this.wiG.bkL());
            }
            if (this.wiH != null) {
                fW += e.a.a.a.fW(3, this.wiH.bkL());
            }
            if (this.wiI != null) {
                fW += e.a.a.a.fW(4, this.wiI.bkL());
            }
            if (this.wiJ != null) {
                fW += e.a.a.b.b.a.h(5, this.wiJ);
            }
            return (fW + e.a.a.a.fU(6, this.wiK)) + e.a.a.a.fU(7, this.wiL);
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
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            tz tzVar = (tz) objArr[1];
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
                        tzVar.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new uc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        tzVar.wiG = fiVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new tw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        tzVar.wiH = fiVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new tx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        tzVar.wiI = fiVar;
                    }
                    return 0;
                case 5:
                    tzVar.wiJ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    tzVar.wiK = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    tzVar.wiL = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

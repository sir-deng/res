package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class avf extends bek {
    public String kRA;
    public int kRz;
    public String vSB;
    public aym vSC;
    public avy vSD;
    public String wJN;
    public String wJS;

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
            aVar.fX(2, this.kRz);
            if (this.kRA != null) {
                aVar.g(3, this.kRA);
            }
            if (this.wJN != null) {
                aVar.g(4, this.wJN);
            }
            if (this.vSB != null) {
                aVar.g(5, this.vSB);
            }
            if (this.wJS != null) {
                aVar.g(6, this.wJS);
            }
            if (this.vSC != null) {
                aVar.fZ(7, this.vSC.bkL());
                this.vSC.a(aVar);
            }
            if (this.vSD == null) {
                return 0;
            }
            aVar.fZ(8, this.vSD.bkL());
            this.vSD.a(aVar);
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
            if (this.wJN != null) {
                fW += e.a.a.b.b.a.h(4, this.wJN);
            }
            if (this.vSB != null) {
                fW += e.a.a.b.b.a.h(5, this.vSB);
            }
            if (this.wJS != null) {
                fW += e.a.a.b.b.a.h(6, this.wJS);
            }
            if (this.vSC != null) {
                fW += e.a.a.a.fW(7, this.vSC.bkL());
            }
            if (this.vSD != null) {
                fW += e.a.a.a.fW(8, this.vSD.bkL());
            }
            return fW;
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
            avf avf = (avf) objArr[1];
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
                        avf.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    avf.kRz = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    avf.kRA = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    avf.wJN = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    avf.vSB = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    avf.wJS = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new aym();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        avf.vSC = fiVar;
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new avy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        avf.vSD = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

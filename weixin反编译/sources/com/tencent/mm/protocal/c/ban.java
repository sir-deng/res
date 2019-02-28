package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ban extends bek {
    public String kPA;
    public String kRA;
    public int kRz;
    public String pff;
    public String pfg;
    public String wNT;
    public String wNU;
    public kc wNV;
    public String wNW;
    public String wNX;
    public bpr wNY;

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
            if (this.wNT != null) {
                aVar.g(4, this.wNT);
            }
            if (this.kPA != null) {
                aVar.g(5, this.kPA);
            }
            if (this.wNU != null) {
                aVar.g(6, this.wNU);
            }
            if (this.wNV != null) {
                aVar.fZ(7, this.wNV.bkL());
                this.wNV.a(aVar);
            }
            if (this.wNW != null) {
                aVar.g(8, this.wNW);
            }
            if (this.pfg != null) {
                aVar.g(9, this.pfg);
            }
            if (this.pff != null) {
                aVar.g(10, this.pff);
            }
            if (this.wNX != null) {
                aVar.g(11, this.wNX);
            }
            if (this.wNY == null) {
                return 0;
            }
            aVar.fZ(12, this.wNY.bkL());
            this.wNY.a(aVar);
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
            if (this.wNT != null) {
                fW += e.a.a.b.b.a.h(4, this.wNT);
            }
            if (this.kPA != null) {
                fW += e.a.a.b.b.a.h(5, this.kPA);
            }
            if (this.wNU != null) {
                fW += e.a.a.b.b.a.h(6, this.wNU);
            }
            if (this.wNV != null) {
                fW += e.a.a.a.fW(7, this.wNV.bkL());
            }
            if (this.wNW != null) {
                fW += e.a.a.b.b.a.h(8, this.wNW);
            }
            if (this.pfg != null) {
                fW += e.a.a.b.b.a.h(9, this.pfg);
            }
            if (this.pff != null) {
                fW += e.a.a.b.b.a.h(10, this.pff);
            }
            if (this.wNX != null) {
                fW += e.a.a.b.b.a.h(11, this.wNX);
            }
            if (this.wNY != null) {
                fW += e.a.a.a.fW(12, this.wNY.bkL());
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
            ban ban = (ban) objArr[1];
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
                        ban.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    ban.kRz = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ban.kRA = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ban.wNT = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ban.kPA = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    ban.wNU = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new kc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ban.wNV = fiVar;
                    }
                    return 0;
                case 8:
                    ban.wNW = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    ban.pfg = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    ban.pff = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    ban.wNX = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new bpr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ban.wNY = fiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

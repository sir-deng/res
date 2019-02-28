package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class brl extends bek {
    public String kyG;
    public String nlV;
    public int pgR;
    public int vPs;
    public int vPt;
    public int vPu;
    public String wZy;
    public String wgu;

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
            if (this.nlV != null) {
                aVar.g(2, this.nlV);
            }
            if (this.wgu != null) {
                aVar.g(3, this.wgu);
            }
            if (this.wZy != null) {
                aVar.g(4, this.wZy);
            }
            if (this.kyG != null) {
                aVar.g(5, this.kyG);
            }
            aVar.fX(6, this.vPs);
            aVar.fX(7, this.vPt);
            aVar.fX(8, this.vPu);
            aVar.fX(9, this.pgR);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nlV != null) {
                fW += e.a.a.b.b.a.h(2, this.nlV);
            }
            if (this.wgu != null) {
                fW += e.a.a.b.b.a.h(3, this.wgu);
            }
            if (this.wZy != null) {
                fW += e.a.a.b.b.a.h(4, this.wZy);
            }
            if (this.kyG != null) {
                fW += e.a.a.b.b.a.h(5, this.kyG);
            }
            return (((fW + e.a.a.a.fU(6, this.vPs)) + e.a.a.a.fU(7, this.vPt)) + e.a.a.a.fU(8, this.vPu)) + e.a.a.a.fU(9, this.pgR);
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
            brl brl = (brl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fiVar = new fi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        brl.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    brl.nlV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    brl.wgu = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    brl.wZy = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    brl.kyG = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    brl.vPs = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    brl.vPt = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    brl.vPu = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    brl.pgR = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

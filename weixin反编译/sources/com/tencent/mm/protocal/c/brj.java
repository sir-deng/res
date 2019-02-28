package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class brj extends bek {
    public String wGr;
    public int wqT;
    public int wqU;
    public int wqV;
    public int wqW;
    public String wqX;
    public int wqY;

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
            if (this.wGr != null) {
                aVar.g(2, this.wGr);
            }
            if (this.wqX != null) {
                aVar.g(3, this.wqX);
            }
            aVar.fX(4, this.wqW);
            aVar.fX(5, this.wqT);
            aVar.fX(6, this.wqU);
            aVar.fX(7, this.wqV);
            aVar.fX(8, this.wqY);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wGr != null) {
                fW += e.a.a.b.b.a.h(2, this.wGr);
            }
            if (this.wqX != null) {
                fW += e.a.a.b.b.a.h(3, this.wqX);
            }
            return ((((fW + e.a.a.a.fU(4, this.wqW)) + e.a.a.a.fU(5, this.wqT)) + e.a.a.a.fU(6, this.wqU)) + e.a.a.a.fU(7, this.wqV)) + e.a.a.a.fU(8, this.wqY);
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
            brj brj = (brj) objArr[1];
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
                        brj.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    brj.wGr = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    brj.wqX = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    brj.wqW = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    brj.wqT = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    brj.wqU = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    brj.wqV = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    brj.wqY = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

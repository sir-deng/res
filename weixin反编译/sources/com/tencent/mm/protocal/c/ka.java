package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ka extends bek {
    public String npV;
    public String npW;
    public int pgR;
    public long vNT;
    public String vXE;
    public String vXI;
    public String vXt;

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
            if (this.vXt != null) {
                aVar.g(3, this.vXt);
            }
            if (this.npW != null) {
                aVar.g(4, this.npW);
            }
            if (this.npV != null) {
                aVar.g(5, this.npV);
            }
            aVar.fX(9, this.pgR);
            aVar.S(10, this.vNT);
            if (this.vXE != null) {
                aVar.g(11, this.vXE);
            }
            if (this.vXI == null) {
                return 0;
            }
            aVar.g(12, this.vXI);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vXt != null) {
                fW += e.a.a.b.b.a.h(3, this.vXt);
            }
            if (this.npW != null) {
                fW += e.a.a.b.b.a.h(4, this.npW);
            }
            if (this.npV != null) {
                fW += e.a.a.b.b.a.h(5, this.npV);
            }
            fW = (fW + e.a.a.a.fU(9, this.pgR)) + e.a.a.a.R(10, this.vNT);
            if (this.vXE != null) {
                fW += e.a.a.b.b.a.h(11, this.vXE);
            }
            if (this.vXI != null) {
                fW += e.a.a.b.b.a.h(12, this.vXI);
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
            ka kaVar = (ka) objArr[1];
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
                        kaVar.wRa = fiVar;
                    }
                    return 0;
                case 3:
                    kaVar.vXt = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    kaVar.npW = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    kaVar.npV = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    kaVar.pgR = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    kaVar.vNT = aVar3.AEQ.rA();
                    return 0;
                case 11:
                    kaVar.vXE = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    kaVar.vXI = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

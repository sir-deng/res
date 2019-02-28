package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bgw extends bek {
    public int kzz;
    public String nlV;
    public String npV;
    public String npW;
    public int pgR;
    public int vNL;
    public long vNT;
    public String vOL;
    public String vXE;

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
            if (this.npW != null) {
                aVar.g(3, this.npW);
            }
            if (this.npV != null) {
                aVar.g(4, this.npV);
            }
            aVar.fX(5, this.vNL);
            if (this.vOL != null) {
                aVar.g(6, this.vOL);
            }
            aVar.fX(7, this.pgR);
            aVar.fX(8, this.kzz);
            aVar.S(9, this.vNT);
            if (this.vXE == null) {
                return 0;
            }
            aVar.g(10, this.vXE);
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
            if (this.npW != null) {
                fW += e.a.a.b.b.a.h(3, this.npW);
            }
            if (this.npV != null) {
                fW += e.a.a.b.b.a.h(4, this.npV);
            }
            fW += e.a.a.a.fU(5, this.vNL);
            if (this.vOL != null) {
                fW += e.a.a.b.b.a.h(6, this.vOL);
            }
            fW = ((fW + e.a.a.a.fU(7, this.pgR)) + e.a.a.a.fU(8, this.kzz)) + e.a.a.a.R(9, this.vNT);
            if (this.vXE != null) {
                fW += e.a.a.b.b.a.h(10, this.vXE);
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
            bgw bgw = (bgw) objArr[1];
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
                        bgw.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    bgw.nlV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bgw.npW = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bgw.npV = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bgw.vNL = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bgw.vOL = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bgw.pgR = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bgw.kzz = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bgw.vNT = aVar3.AEQ.rA();
                    return 0;
                case 10:
                    bgw.vXE = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

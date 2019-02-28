package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class azm extends bea {
    public String npV;
    public String npW;
    public long wMR;
    public int wMS;
    public String wMT;
    public int wNa;
    public int wNb;
    public int wNc;
    public int wdO;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.npW != null) {
                aVar.g(2, this.npW);
            }
            if (this.wMT != null) {
                aVar.g(3, this.wMT);
            }
            aVar.fX(4, this.wdO);
            aVar.S(5, this.wMR);
            aVar.fX(6, this.wMS);
            if (this.npV != null) {
                aVar.g(7, this.npV);
            }
            aVar.fX(8, this.wNb);
            aVar.fX(9, this.wNa);
            aVar.fX(10, this.wNc);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.npW != null) {
                fW += e.a.a.b.b.a.h(2, this.npW);
            }
            if (this.wMT != null) {
                fW += e.a.a.b.b.a.h(3, this.wMT);
            }
            fW = ((fW + e.a.a.a.fU(4, this.wdO)) + e.a.a.a.R(5, this.wMR)) + e.a.a.a.fU(6, this.wMS);
            if (this.npV != null) {
                fW += e.a.a.b.b.a.h(7, this.npV);
            }
            return ((fW + e.a.a.a.fU(8, this.wNb)) + e.a.a.a.fU(9, this.wNa)) + e.a.a.a.fU(10, this.wNc);
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
            azm azm = (azm) objArr[1];
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
                        azm.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    azm.npW = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    azm.wMT = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    azm.wdO = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    azm.wMR = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    azm.wMS = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    azm.npV = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    azm.wNb = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    azm.wNa = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    azm.wNc = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

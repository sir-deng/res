package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bep extends bea {
    public String npV;
    public String npW;
    public int pgR;
    public String vOL;
    public int wRe;
    public int wRf;
    public int wRg;
    public long wRh;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vOL != null) {
                aVar.g(2, this.vOL);
            }
            aVar.fX(3, this.wRe);
            aVar.fX(4, this.pgR);
            aVar.fX(5, this.wRf);
            if (this.npW != null) {
                aVar.g(6, this.npW);
            }
            if (this.npV != null) {
                aVar.g(7, this.npV);
            }
            aVar.fX(8, this.wRg);
            aVar.S(9, this.wRh);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vOL != null) {
                fW += e.a.a.b.b.a.h(2, this.vOL);
            }
            fW = ((fW + e.a.a.a.fU(3, this.wRe)) + e.a.a.a.fU(4, this.pgR)) + e.a.a.a.fU(5, this.wRf);
            if (this.npW != null) {
                fW += e.a.a.b.b.a.h(6, this.npW);
            }
            if (this.npV != null) {
                fW += e.a.a.b.b.a.h(7, this.npV);
            }
            return (fW + e.a.a.a.fU(8, this.wRg)) + e.a.a.a.R(9, this.wRh);
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
            bep bep = (bep) objArr[1];
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
                        bep.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bep.vOL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bep.wRe = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bep.pgR = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bep.wRf = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bep.npW = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bep.npV = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bep.wRg = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bep.wRh = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

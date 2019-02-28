package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bng extends bea {
    public String npV;
    public String npW;
    public String vOL;
    public int wXj;
    public int wXk;
    public LinkedList<bni> wXl = new LinkedList();
    public bnf wXm;
    public int wXn;
    public LinkedList<bnf> wXo = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.wXj);
            if (this.npW != null) {
                aVar.g(3, this.npW);
            }
            if (this.npV != null) {
                aVar.g(4, this.npV);
            }
            if (this.vOL != null) {
                aVar.g(5, this.vOL);
            }
            aVar.fX(6, this.wXk);
            aVar.d(7, 8, this.wXl);
            if (this.wXm != null) {
                aVar.fZ(8, this.wXm.bkL());
                this.wXm.a(aVar);
            }
            aVar.fX(9, this.wXn);
            aVar.d(10, 8, this.wXo);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.wXj);
            if (this.npW != null) {
                fW += e.a.a.b.b.a.h(3, this.npW);
            }
            if (this.npV != null) {
                fW += e.a.a.b.b.a.h(4, this.npV);
            }
            if (this.vOL != null) {
                fW += e.a.a.b.b.a.h(5, this.vOL);
            }
            fW = (fW + e.a.a.a.fU(6, this.wXk)) + e.a.a.a.c(7, 8, this.wXl);
            if (this.wXm != null) {
                fW += e.a.a.a.fW(8, this.wXm.bkL());
            }
            return (fW + e.a.a.a.fU(9, this.wXn)) + e.a.a.a.c(10, 8, this.wXo);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wXl.clear();
            this.wXo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            bng bng = (bng) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            com.tencent.mm.bp.a fhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bng.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bng.wXj = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bng.npW = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bng.npV = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bng.vOL = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bng.wXk = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bni();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bng.wXl.add(fhVar);
                    }
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bnf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bng.wXm = fhVar;
                    }
                    return 0;
                case 9:
                    bng.wXn = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bnf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bng.wXo.add(fhVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

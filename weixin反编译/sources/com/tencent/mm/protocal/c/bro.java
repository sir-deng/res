package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bro extends bea {
    public int blZ;
    public String ffG;
    public String fsb;
    public String hea;
    public String wRB;
    public int wZA;
    public String wZB;
    public int wZC;
    public String wZD;
    public LinkedList<bmy> wZE = new LinkedList();
    public int wZF;
    public int wZG;
    public int wZz;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.ffG != null) {
                aVar.g(2, this.ffG);
            }
            if (this.fsb != null) {
                aVar.g(3, this.fsb);
            }
            aVar.fX(4, this.wZz);
            aVar.fX(5, this.wZA);
            aVar.fX(6, this.blZ);
            if (this.wZB != null) {
                aVar.g(7, this.wZB);
            }
            if (this.wRB != null) {
                aVar.g(8, this.wRB);
            }
            if (this.hea != null) {
                aVar.g(9, this.hea);
            }
            aVar.fX(10, this.wZC);
            if (this.wZD != null) {
                aVar.g(11, this.wZD);
            }
            aVar.d(12, 8, this.wZE);
            aVar.fX(13, this.wZF);
            aVar.fX(14, this.wZG);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.ffG != null) {
                fW += e.a.a.b.b.a.h(2, this.ffG);
            }
            if (this.fsb != null) {
                fW += e.a.a.b.b.a.h(3, this.fsb);
            }
            fW = ((fW + e.a.a.a.fU(4, this.wZz)) + e.a.a.a.fU(5, this.wZA)) + e.a.a.a.fU(6, this.blZ);
            if (this.wZB != null) {
                fW += e.a.a.b.b.a.h(7, this.wZB);
            }
            if (this.wRB != null) {
                fW += e.a.a.b.b.a.h(8, this.wRB);
            }
            if (this.hea != null) {
                fW += e.a.a.b.b.a.h(9, this.hea);
            }
            fW += e.a.a.a.fU(10, this.wZC);
            if (this.wZD != null) {
                fW += e.a.a.b.b.a.h(11, this.wZD);
            }
            return ((fW + e.a.a.a.c(12, 8, this.wZE)) + e.a.a.a.fU(13, this.wZF)) + e.a.a.a.fU(14, this.wZG);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wZE.clear();
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
            bro bro = (bro) objArr[1];
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
                        bro.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bro.ffG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bro.fsb = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bro.wZz = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bro.wZA = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bro.blZ = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bro.wZB = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bro.wRB = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    bro.hea = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    bro.wZC = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    bro.wZD = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bmy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bro.wZE.add(fhVar);
                    }
                    return 0;
                case 13:
                    bro.wZF = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    bro.wZG = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

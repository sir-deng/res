package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ave extends bea {
    public int fDt;
    public String pff;
    public String sOP;
    public String vSA;
    public String vSz;
    public String wJP;
    public String wJQ;
    public int wJR;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vSz != null) {
                aVar.g(2, this.vSz);
            }
            if (this.vSA != null) {
                aVar.g(3, this.vSA);
            }
            if (this.wJP != null) {
                aVar.g(4, this.wJP);
            }
            if (this.wJQ != null) {
                aVar.g(5, this.wJQ);
            }
            if (this.sOP != null) {
                aVar.g(6, this.sOP);
            }
            if (this.pff != null) {
                aVar.g(7, this.pff);
            }
            aVar.fX(8, this.fDt);
            aVar.fX(9, this.wJR);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vSz != null) {
                fW += e.a.a.b.b.a.h(2, this.vSz);
            }
            if (this.vSA != null) {
                fW += e.a.a.b.b.a.h(3, this.vSA);
            }
            if (this.wJP != null) {
                fW += e.a.a.b.b.a.h(4, this.wJP);
            }
            if (this.wJQ != null) {
                fW += e.a.a.b.b.a.h(5, this.wJQ);
            }
            if (this.sOP != null) {
                fW += e.a.a.b.b.a.h(6, this.sOP);
            }
            if (this.pff != null) {
                fW += e.a.a.b.b.a.h(7, this.pff);
            }
            return (fW + e.a.a.a.fU(8, this.fDt)) + e.a.a.a.fU(9, this.wJR);
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
            ave ave = (ave) objArr[1];
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
                        ave.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    ave.vSz = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ave.vSA = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ave.wJP = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ave.wJQ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    ave.sOP = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    ave.pff = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    ave.fDt = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    ave.wJR = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

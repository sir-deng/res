package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class hb extends bea {
    public int vQC;
    public int vSK;
    public String vSL;
    public String vSM;
    public String vSN;
    public String vSO;
    public String vSP;
    public String vSQ;
    public String vSR;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.vQC);
            aVar.fX(3, this.vSK);
            if (this.vSL != null) {
                aVar.g(4, this.vSL);
            }
            if (this.vSM != null) {
                aVar.g(5, this.vSM);
            }
            if (this.vSN != null) {
                aVar.g(6, this.vSN);
            }
            if (this.vSO != null) {
                aVar.g(7, this.vSO);
            }
            if (this.vSP != null) {
                aVar.g(8, this.vSP);
            }
            if (this.vSQ != null) {
                aVar.g(9, this.vSQ);
            }
            if (this.vSR == null) {
                return 0;
            }
            aVar.g(10, this.vSR);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.vQC)) + e.a.a.a.fU(3, this.vSK);
            if (this.vSL != null) {
                fW += e.a.a.b.b.a.h(4, this.vSL);
            }
            if (this.vSM != null) {
                fW += e.a.a.b.b.a.h(5, this.vSM);
            }
            if (this.vSN != null) {
                fW += e.a.a.b.b.a.h(6, this.vSN);
            }
            if (this.vSO != null) {
                fW += e.a.a.b.b.a.h(7, this.vSO);
            }
            if (this.vSP != null) {
                fW += e.a.a.b.b.a.h(8, this.vSP);
            }
            if (this.vSQ != null) {
                fW += e.a.a.b.b.a.h(9, this.vSQ);
            }
            if (this.vSR != null) {
                fW += e.a.a.b.b.a.h(10, this.vSR);
            }
            return fW;
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
            hb hbVar = (hb) objArr[1];
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
                        hbVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    hbVar.vQC = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    hbVar.vSK = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    hbVar.vSL = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    hbVar.vSM = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    hbVar.vSN = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    hbVar.vSO = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    hbVar.vSP = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    hbVar.vSQ = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    hbVar.vSR = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

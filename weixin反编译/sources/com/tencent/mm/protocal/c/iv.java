package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class iv extends bea {
    public int fDM;
    public int oeK;
    public int pPM;
    public String pPN;
    public String pPO;
    public String pQW;
    public String pQZ;
    public String vOk;
    public String vVJ;
    public int vVK;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.oeK);
            aVar.fX(3, this.fDM);
            aVar.fX(4, this.pPM);
            if (this.vVJ != null) {
                aVar.g(5, this.vVJ);
            }
            if (this.pQW != null) {
                aVar.g(6, this.pQW);
            }
            if (this.pPN != null) {
                aVar.g(7, this.pPN);
            }
            if (this.pQZ != null) {
                aVar.g(8, this.pQZ);
            }
            if (this.vOk != null) {
                aVar.g(9, this.vOk);
            }
            if (this.pPO != null) {
                aVar.g(10, this.pPO);
            }
            aVar.fX(11, this.vVK);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((fW + e.a.a.a.fU(2, this.oeK)) + e.a.a.a.fU(3, this.fDM)) + e.a.a.a.fU(4, this.pPM);
            if (this.vVJ != null) {
                fW += e.a.a.b.b.a.h(5, this.vVJ);
            }
            if (this.pQW != null) {
                fW += e.a.a.b.b.a.h(6, this.pQW);
            }
            if (this.pPN != null) {
                fW += e.a.a.b.b.a.h(7, this.pPN);
            }
            if (this.pQZ != null) {
                fW += e.a.a.b.b.a.h(8, this.pQZ);
            }
            if (this.vOk != null) {
                fW += e.a.a.b.b.a.h(9, this.vOk);
            }
            if (this.pPO != null) {
                fW += e.a.a.b.b.a.h(10, this.pPO);
            }
            return fW + e.a.a.a.fU(11, this.vVK);
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
            iv ivVar = (iv) objArr[1];
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
                        ivVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    ivVar.oeK = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ivVar.fDM = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    ivVar.pPM = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    ivVar.vVJ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    ivVar.pQW = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    ivVar.pPN = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    ivVar.pQZ = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    ivVar.vOk = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    ivVar.pPO = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    ivVar.vVK = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

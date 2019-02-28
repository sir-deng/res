package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class xk extends bea {
    public String nlV;
    public String nqb;
    public String nqi;
    public int sfa;
    public int vKK;
    public String vSO;
    public av vXW;
    public String wcy;
    public String wdk;
    public String wdl;
    public String wdm;
    public String wdn;
    public String wou;
    public String wox;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.nlV != null) {
                aVar.g(2, this.nlV);
            }
            if (this.wdk != null) {
                aVar.g(3, this.wdk);
            }
            if (this.vSO != null) {
                aVar.g(4, this.vSO);
            }
            if (this.wdl != null) {
                aVar.g(5, this.wdl);
            }
            if (this.wdm != null) {
                aVar.g(6, this.wdm);
            }
            if (this.wdn != null) {
                aVar.g(7, this.wdn);
            }
            if (this.wcy != null) {
                aVar.g(8, this.wcy);
            }
            if (this.wou != null) {
                aVar.g(9, this.wou);
            }
            aVar.fX(10, this.vKK);
            if (this.nqi != null) {
                aVar.g(11, this.nqi);
            }
            if (this.nqb != null) {
                aVar.g(12, this.nqb);
            }
            if (this.wox != null) {
                aVar.g(13, this.wox);
            }
            if (this.vXW != null) {
                aVar.fZ(14, this.vXW.bkL());
                this.vXW.a(aVar);
            }
            aVar.fX(15, this.sfa);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.nlV != null) {
                fW += e.a.a.b.b.a.h(2, this.nlV);
            }
            if (this.wdk != null) {
                fW += e.a.a.b.b.a.h(3, this.wdk);
            }
            if (this.vSO != null) {
                fW += e.a.a.b.b.a.h(4, this.vSO);
            }
            if (this.wdl != null) {
                fW += e.a.a.b.b.a.h(5, this.wdl);
            }
            if (this.wdm != null) {
                fW += e.a.a.b.b.a.h(6, this.wdm);
            }
            if (this.wdn != null) {
                fW += e.a.a.b.b.a.h(7, this.wdn);
            }
            if (this.wcy != null) {
                fW += e.a.a.b.b.a.h(8, this.wcy);
            }
            if (this.wou != null) {
                fW += e.a.a.b.b.a.h(9, this.wou);
            }
            fW += e.a.a.a.fU(10, this.vKK);
            if (this.nqi != null) {
                fW += e.a.a.b.b.a.h(11, this.nqi);
            }
            if (this.nqb != null) {
                fW += e.a.a.b.b.a.h(12, this.nqb);
            }
            if (this.wox != null) {
                fW += e.a.a.b.b.a.h(13, this.wox);
            }
            if (this.vXW != null) {
                fW += e.a.a.a.fW(14, this.vXW.bkL());
            }
            return fW + e.a.a.a.fU(15, this.sfa);
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
            xk xkVar = (xk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
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
                        xkVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    xkVar.nlV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    xkVar.wdk = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    xkVar.vSO = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    xkVar.wdl = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    xkVar.wdm = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    xkVar.wdn = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    xkVar.wcy = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    xkVar.wou = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    xkVar.vKK = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    xkVar.nqi = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    xkVar.nqb = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    xkVar.wox = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new av();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        xkVar.vXW = fhVar;
                    }
                    return 0;
                case 15:
                    xkVar.sfa = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

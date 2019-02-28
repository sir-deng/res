package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class nz extends bea {
    public String kyG;
    public String nlV;
    public String nqe;
    public String rYp;
    public String rYq;
    public int vNG;
    public String vSO;
    public av vXW;
    public String wcy;
    public int wdD;
    public int wdE;
    public String wdk;
    public String wdl;
    public String wdm;
    public String wdn;
    public int wdo;
    public int wdq;
    public String wdr;

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
            aVar.fX(9, this.wdo);
            if (this.vXW != null) {
                aVar.fZ(10, this.vXW.bkL());
                this.vXW.a(aVar);
            }
            if (this.kyG != null) {
                aVar.g(11, this.kyG);
            }
            if (this.nqe != null) {
                aVar.g(12, this.nqe);
            }
            aVar.fX(13, this.vNG);
            aVar.fX(14, this.wdD);
            if (this.rYp != null) {
                aVar.g(15, this.rYp);
            }
            if (this.rYq != null) {
                aVar.g(16, this.rYq);
            }
            aVar.fX(17, this.wdE);
            aVar.fX(18, this.wdq);
            if (this.wdr == null) {
                return 0;
            }
            aVar.g(19, this.wdr);
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
            fW += e.a.a.a.fU(9, this.wdo);
            if (this.vXW != null) {
                fW += e.a.a.a.fW(10, this.vXW.bkL());
            }
            if (this.kyG != null) {
                fW += e.a.a.b.b.a.h(11, this.kyG);
            }
            if (this.nqe != null) {
                fW += e.a.a.b.b.a.h(12, this.nqe);
            }
            fW = (fW + e.a.a.a.fU(13, this.vNG)) + e.a.a.a.fU(14, this.wdD);
            if (this.rYp != null) {
                fW += e.a.a.b.b.a.h(15, this.rYp);
            }
            if (this.rYq != null) {
                fW += e.a.a.b.b.a.h(16, this.rYq);
            }
            fW = (fW + e.a.a.a.fU(17, this.wdE)) + e.a.a.a.fU(18, this.wdq);
            if (this.wdr != null) {
                fW += e.a.a.b.b.a.h(19, this.wdr);
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
            nz nzVar = (nz) objArr[1];
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
                        nzVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    nzVar.nlV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    nzVar.wdk = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    nzVar.vSO = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    nzVar.wdl = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    nzVar.wdm = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    nzVar.wdn = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    nzVar.wcy = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    nzVar.wdo = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new av();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        nzVar.vXW = fhVar;
                    }
                    return 0;
                case 11:
                    nzVar.kyG = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    nzVar.nqe = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    nzVar.vNG = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    nzVar.wdD = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    nzVar.rYp = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    nzVar.rYq = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    nzVar.wdE = aVar3.AEQ.rz();
                    return 0;
                case 18:
                    nzVar.wdq = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    nzVar.wdr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

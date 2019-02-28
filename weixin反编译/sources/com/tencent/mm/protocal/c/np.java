package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class np extends bea {
    public String kyG;
    public String nlV;
    public String nqe;
    public int vNG;
    public String vSO;
    public av vXW;
    public String wcy;
    public String wdk;
    public String wdl;
    public String wdm;
    public String wdn;
    public int wdo;
    public String wdp;
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
            if (this.wdp != null) {
                aVar.g(11, this.wdp);
            }
            if (this.kyG != null) {
                aVar.g(12, this.kyG);
            }
            if (this.nqe != null) {
                aVar.g(13, this.nqe);
            }
            aVar.fX(14, this.vNG);
            aVar.fX(15, this.wdq);
            if (this.wdr == null) {
                return 0;
            }
            aVar.g(16, this.wdr);
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
            if (this.wdp != null) {
                fW += e.a.a.b.b.a.h(11, this.wdp);
            }
            if (this.kyG != null) {
                fW += e.a.a.b.b.a.h(12, this.kyG);
            }
            if (this.nqe != null) {
                fW += e.a.a.b.b.a.h(13, this.nqe);
            }
            fW = (fW + e.a.a.a.fU(14, this.vNG)) + e.a.a.a.fU(15, this.wdq);
            if (this.wdr != null) {
                fW += e.a.a.b.b.a.h(16, this.wdr);
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
            np npVar = (np) objArr[1];
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
                        npVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    npVar.nlV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    npVar.wdk = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    npVar.vSO = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    npVar.wdl = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    npVar.wdm = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    npVar.wdn = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    npVar.wcy = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    npVar.wdo = aVar3.AEQ.rz();
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
                        npVar.vXW = fhVar;
                    }
                    return 0;
                case 11:
                    npVar.wdp = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    npVar.kyG = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    npVar.nqe = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    npVar.vNG = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    npVar.wdq = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    npVar.wdr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

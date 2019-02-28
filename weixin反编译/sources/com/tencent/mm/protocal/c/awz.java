package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class awz extends bea {
    public String nlV;
    public String nqi;
    public int vKK;
    public String vSO;
    public String wcy;
    public String wdk;
    public String wdl;
    public String wdm;
    public String wdn;
    public String wou;

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
            if (this.nqi == null) {
                return 0;
            }
            aVar.g(11, this.nqi);
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
            awz awz = (awz) objArr[1];
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
                        awz.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    awz.nlV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    awz.wdk = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    awz.vSO = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    awz.wdl = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    awz.wdm = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    awz.wdn = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    awz.wcy = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    awz.wou = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    awz.vKK = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    awz.nqi = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

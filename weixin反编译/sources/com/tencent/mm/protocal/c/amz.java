package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class amz extends bea {
    public String nlE;
    public String nlV;
    public LinkedList<String> wAl = new LinkedList();
    public int wAn;
    public cda wAo;
    public int wAq;
    public String wAr;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.nlV != null) {
                aVar.g(2, this.nlV);
            }
            aVar.d(3, 1, this.wAl);
            aVar.fX(4, this.wAq);
            if (this.nlE != null) {
                aVar.g(5, this.nlE);
            }
            if (this.wAr != null) {
                aVar.g(6, this.wAr);
            }
            aVar.fX(7, this.wAn);
            if (this.wAo == null) {
                return 0;
            }
            aVar.fZ(8, this.wAo.bkL());
            this.wAo.a(aVar);
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
            fW = (fW + e.a.a.a.c(3, 1, this.wAl)) + e.a.a.a.fU(4, this.wAq);
            if (this.nlE != null) {
                fW += e.a.a.b.b.a.h(5, this.nlE);
            }
            if (this.wAr != null) {
                fW += e.a.a.b.b.a.h(6, this.wAr);
            }
            fW += e.a.a.a.fU(7, this.wAn);
            if (this.wAo != null) {
                fW += e.a.a.a.fW(8, this.wAo.bkL());
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wAl.clear();
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
            amz amz = (amz) objArr[1];
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
                        amz.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    amz.nlV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    amz.wAl.add(aVar3.AEQ.readString());
                    return 0;
                case 4:
                    amz.wAq = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    amz.nlE = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    amz.wAr = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    amz.wAn = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new cda();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        amz.wAo = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class anb extends bea {
    public b kyn;
    public String nlV;
    public int wAm;
    public int wAn;
    public cda wAo;
    public String wAv;

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
            if (this.kyn != null) {
                aVar.b(3, this.kyn);
            }
            if (this.wAv != null) {
                aVar.g(4, this.wAv);
            }
            aVar.fX(5, this.wAm);
            aVar.fX(6, this.wAn);
            if (this.wAo == null) {
                return 0;
            }
            aVar.fZ(7, this.wAo.bkL());
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
            if (this.kyn != null) {
                fW += e.a.a.a.a(3, this.kyn);
            }
            if (this.wAv != null) {
                fW += e.a.a.b.b.a.h(4, this.wAv);
            }
            fW = (fW + e.a.a.a.fU(5, this.wAm)) + e.a.a.a.fU(6, this.wAn);
            if (this.wAo != null) {
                fW += e.a.a.a.fW(7, this.wAo.bkL());
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
            anb anb = (anb) objArr[1];
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
                        anb.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    anb.nlV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    anb.kyn = aVar3.cKw();
                    return 0;
                case 4:
                    anb.wAv = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    anb.wAm = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    anb.wAn = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new cda();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        anb.wAo = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

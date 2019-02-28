package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class abn extends bea {
    public LinkedList<bet> vSd = new LinkedList();
    public int wri;
    public int wrj;
    public LinkedList<bet> wrk = new LinkedList();
    public int wrl;
    public LinkedList<bet> wrm = new LinkedList();
    public int wrn;
    public bet wro;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.wri);
            aVar.d(3, 8, this.vSd);
            aVar.fX(4, this.wrj);
            aVar.d(5, 8, this.wrk);
            aVar.fX(6, this.wrl);
            aVar.d(7, 8, this.wrm);
            aVar.fX(8, this.wrn);
            if (this.wro == null) {
                return 0;
            }
            aVar.fZ(9, this.wro.bkL());
            this.wro.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((((((fW + e.a.a.a.fU(2, this.wri)) + e.a.a.a.c(3, 8, this.vSd)) + e.a.a.a.fU(4, this.wrj)) + e.a.a.a.c(5, 8, this.wrk)) + e.a.a.a.fU(6, this.wrl)) + e.a.a.a.c(7, 8, this.wrm)) + e.a.a.a.fU(8, this.wrn);
            if (this.wro != null) {
                fW += e.a.a.a.fW(9, this.wro.bkL());
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vSd.clear();
            this.wrk.clear();
            this.wrm.clear();
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
            abn abn = (abn) objArr[1];
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
                        abn.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    abn.wri = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        abn.vSd.add(fhVar);
                    }
                    return 0;
                case 4:
                    abn.wrj = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        abn.wrk.add(fhVar);
                    }
                    return 0;
                case 6:
                    abn.wrl = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        abn.wrm.add(fhVar);
                    }
                    return 0;
                case 8:
                    abn.wrn = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        abn.wro = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bji extends bea {
    public int fHR;
    public LinkedList<bjk> hfI = new LinkedList();
    public bmz vLw;
    public int wTr;
    public String wTs;
    public bjs wTt;
    public String wqy;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.wTr);
            aVar.d(3, 8, this.hfI);
            if (this.wTs != null) {
                aVar.g(4, this.wTs);
            }
            if (this.wqy != null) {
                aVar.g(5, this.wqy);
            }
            if (this.wTt != null) {
                aVar.fZ(6, this.wTt.bkL());
                this.wTt.a(aVar);
            }
            aVar.fX(7, this.fHR);
            if (this.vLw == null) {
                return 0;
            }
            aVar.fZ(8, this.vLw.bkL());
            this.vLw.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.wTr)) + e.a.a.a.c(3, 8, this.hfI);
            if (this.wTs != null) {
                fW += e.a.a.b.b.a.h(4, this.wTs);
            }
            if (this.wqy != null) {
                fW += e.a.a.b.b.a.h(5, this.wqy);
            }
            if (this.wTt != null) {
                fW += e.a.a.a.fW(6, this.wTt.bkL());
            }
            fW += e.a.a.a.fU(7, this.fHR);
            if (this.vLw != null) {
                fW += e.a.a.a.fW(8, this.vLw.bkL());
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.hfI.clear();
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
            bji bji = (bji) objArr[1];
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
                        bji.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bji.wTr = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bjk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bji.hfI.add(fhVar);
                    }
                    return 0;
                case 4:
                    bji.wTs = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bji.wqy = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bjs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bji.wTt = fhVar;
                    }
                    return 0;
                case 7:
                    bji.fHR = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bmz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bji.vLw = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

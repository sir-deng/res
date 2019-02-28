package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bvv extends bea {
    public bes vQW;
    public int wNd;
    public int wil;
    public long wim;
    public int xdj;
    public int xdk;
    public int xdl;
    public int xdm;
    public int xdn;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vQW == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.wil);
            aVar.S(3, this.wim);
            aVar.fX(4, this.wNd);
            aVar.fX(5, this.xdj);
            aVar.fX(6, this.xdk);
            aVar.fX(7, this.xdl);
            aVar.fX(8, this.xdm);
            aVar.fX(9, this.xdn);
            if (this.vQW == null) {
                return 0;
            }
            aVar.fZ(10, this.vQW.bkL());
            this.vQW.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (((((((fW + e.a.a.a.fU(2, this.wil)) + e.a.a.a.R(3, this.wim)) + e.a.a.a.fU(4, this.wNd)) + e.a.a.a.fU(5, this.xdj)) + e.a.a.a.fU(6, this.xdk)) + e.a.a.a.fU(7, this.xdl)) + e.a.a.a.fU(8, this.xdm)) + e.a.a.a.fU(9, this.xdn);
            if (this.vQW != null) {
                fW += e.a.a.a.fW(10, this.vQW.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vQW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvv bvv = (bvv) objArr[1];
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
                        bvv.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bvv.wil = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bvv.wim = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    bvv.wNd = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bvv.xdj = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bvv.xdk = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bvv.xdl = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bvv.xdm = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bvv.xdn = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bvv.vQW = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

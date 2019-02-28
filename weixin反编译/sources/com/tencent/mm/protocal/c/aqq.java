package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class aqq extends bea {
    public String hxh;
    public String kyK;
    public String lTY;
    public String lTZ;
    public int nnd;
    public int vKK;
    public ff vQn;
    public String vQo;
    public int vQp;
    public String vQq;
    public String vQr;
    public String vUW;
    public String vUX;
    public String viU;
    public String wEf;
    public String wEg;
    public String wEh;
    public int wEi;
    public String wgM;
    public String woG;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vQn != null) {
                aVar.fZ(2, this.vQn.bkL());
                this.vQn.a(aVar);
            }
            if (this.viU != null) {
                aVar.g(3, this.viU);
            }
            if (this.vQo != null) {
                aVar.g(4, this.vQo);
            }
            aVar.fX(5, this.vQp);
            if (this.vQq != null) {
                aVar.g(6, this.vQq);
            }
            if (this.hxh != null) {
                aVar.g(7, this.hxh);
            }
            if (this.kyK != null) {
                aVar.g(8, this.kyK);
            }
            if (this.vQr != null) {
                aVar.g(9, this.vQr);
            }
            if (this.lTZ != null) {
                aVar.g(10, this.lTZ);
            }
            if (this.lTY != null) {
                aVar.g(11, this.lTY);
            }
            aVar.fX(13, this.vKK);
            aVar.fX(14, this.nnd);
            if (this.vUX != null) {
                aVar.g(15, this.vUX);
            }
            if (this.vUW != null) {
                aVar.g(16, this.vUW);
            }
            if (this.wEf != null) {
                aVar.g(17, this.wEf);
            }
            if (this.wgM != null) {
                aVar.g(18, this.wgM);
            }
            if (this.woG != null) {
                aVar.g(19, this.woG);
            }
            if (this.wEg != null) {
                aVar.g(20, this.wEg);
            }
            if (this.wEh != null) {
                aVar.g(21, this.wEh);
            }
            aVar.fX(22, this.wEi);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vQn != null) {
                fW += e.a.a.a.fW(2, this.vQn.bkL());
            }
            if (this.viU != null) {
                fW += e.a.a.b.b.a.h(3, this.viU);
            }
            if (this.vQo != null) {
                fW += e.a.a.b.b.a.h(4, this.vQo);
            }
            fW += e.a.a.a.fU(5, this.vQp);
            if (this.vQq != null) {
                fW += e.a.a.b.b.a.h(6, this.vQq);
            }
            if (this.hxh != null) {
                fW += e.a.a.b.b.a.h(7, this.hxh);
            }
            if (this.kyK != null) {
                fW += e.a.a.b.b.a.h(8, this.kyK);
            }
            if (this.vQr != null) {
                fW += e.a.a.b.b.a.h(9, this.vQr);
            }
            if (this.lTZ != null) {
                fW += e.a.a.b.b.a.h(10, this.lTZ);
            }
            if (this.lTY != null) {
                fW += e.a.a.b.b.a.h(11, this.lTY);
            }
            fW = (fW + e.a.a.a.fU(13, this.vKK)) + e.a.a.a.fU(14, this.nnd);
            if (this.vUX != null) {
                fW += e.a.a.b.b.a.h(15, this.vUX);
            }
            if (this.vUW != null) {
                fW += e.a.a.b.b.a.h(16, this.vUW);
            }
            if (this.wEf != null) {
                fW += e.a.a.b.b.a.h(17, this.wEf);
            }
            if (this.wgM != null) {
                fW += e.a.a.b.b.a.h(18, this.wgM);
            }
            if (this.woG != null) {
                fW += e.a.a.b.b.a.h(19, this.woG);
            }
            if (this.wEg != null) {
                fW += e.a.a.b.b.a.h(20, this.wEg);
            }
            if (this.wEh != null) {
                fW += e.a.a.b.b.a.h(21, this.wEh);
            }
            return fW + e.a.a.a.fU(22, this.wEi);
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
            aqq aqq = (aqq) objArr[1];
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
                        aqq.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new ff();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aqq.vQn = fhVar;
                    }
                    return 0;
                case 3:
                    aqq.viU = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aqq.vQo = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aqq.vQp = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    aqq.vQq = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    aqq.hxh = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    aqq.kyK = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    aqq.vQr = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    aqq.lTZ = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    aqq.lTY = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    aqq.vKK = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    aqq.nnd = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    aqq.vUX = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    aqq.vUW = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    aqq.wEf = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    aqq.wgM = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    aqq.woG = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    aqq.wEg = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    aqq.wEh = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    aqq.wEi = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

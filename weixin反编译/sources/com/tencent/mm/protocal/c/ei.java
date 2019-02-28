package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ei extends bea {
    public String hxh;
    public String kyK;
    public String lTY;
    public String lTZ;
    public int vKK;
    public bes vPR;
    public ff vQn;
    public String vQo;
    public int vQp;
    public String vQq;
    public String vQr;
    public String viU;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vPR == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vQn != null) {
                aVar.fZ(2, this.vQn.bkL());
                this.vQn.a(aVar);
            }
            if (this.vPR != null) {
                aVar.fZ(3, this.vPR.bkL());
                this.vPR.a(aVar);
            }
            if (this.viU != null) {
                aVar.g(4, this.viU);
            }
            if (this.vQo != null) {
                aVar.g(5, this.vQo);
            }
            aVar.fX(6, this.vQp);
            if (this.vQq != null) {
                aVar.g(7, this.vQq);
            }
            if (this.hxh != null) {
                aVar.g(8, this.hxh);
            }
            if (this.kyK != null) {
                aVar.g(9, this.kyK);
            }
            if (this.vQr != null) {
                aVar.g(10, this.vQr);
            }
            if (this.lTZ != null) {
                aVar.g(11, this.lTZ);
            }
            if (this.lTY != null) {
                aVar.g(12, this.lTY);
            }
            aVar.fX(13, this.vKK);
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
            if (this.vPR != null) {
                fW += e.a.a.a.fW(3, this.vPR.bkL());
            }
            if (this.viU != null) {
                fW += e.a.a.b.b.a.h(4, this.viU);
            }
            if (this.vQo != null) {
                fW += e.a.a.b.b.a.h(5, this.vQo);
            }
            fW += e.a.a.a.fU(6, this.vQp);
            if (this.vQq != null) {
                fW += e.a.a.b.b.a.h(7, this.vQq);
            }
            if (this.hxh != null) {
                fW += e.a.a.b.b.a.h(8, this.hxh);
            }
            if (this.kyK != null) {
                fW += e.a.a.b.b.a.h(9, this.kyK);
            }
            if (this.vQr != null) {
                fW += e.a.a.b.b.a.h(10, this.vQr);
            }
            if (this.lTZ != null) {
                fW += e.a.a.b.b.a.h(11, this.lTZ);
            }
            if (this.lTY != null) {
                fW += e.a.a.b.b.a.h(12, this.lTY);
            }
            return fW + e.a.a.a.fU(13, this.vKK);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vPR != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AutoAuthKey");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ei eiVar = (ei) objArr[1];
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
                        eiVar.wQE = fhVar;
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
                        eiVar.vQn = fhVar;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        eiVar.vPR = fhVar;
                    }
                    return 0;
                case 4:
                    eiVar.viU = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    eiVar.vQo = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    eiVar.vQp = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    eiVar.vQq = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    eiVar.hxh = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    eiVar.kyK = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    eiVar.vQr = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    eiVar.lTZ = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    eiVar.lTY = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    eiVar.vKK = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

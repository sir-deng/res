package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class btv extends bea {
    public int pgW;
    public String vPI;
    public String wMA;
    public String wMx;
    public String wMy;
    public int wMz;
    public bes xbw;
    public int xbx;
    public int xby;
    public String xbz;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xbw == null) {
                throw new b("Not all required fields were included: Receipt");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.xbw != null) {
                aVar.fZ(2, this.xbw.bkL());
                this.xbw.a(aVar);
            }
            if (this.vPI != null) {
                aVar.g(3, this.vPI);
            }
            aVar.fX(4, this.xbx);
            aVar.fX(5, this.pgW);
            if (this.wMx != null) {
                aVar.g(6, this.wMx);
            }
            if (this.wMy != null) {
                aVar.g(7, this.wMy);
            }
            if (this.wMA != null) {
                aVar.g(8, this.wMA);
            }
            aVar.fX(9, this.xby);
            if (this.xbz != null) {
                aVar.g(10, this.xbz);
            }
            aVar.fX(11, this.wMz);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.xbw != null) {
                fW += e.a.a.a.fW(2, this.xbw.bkL());
            }
            if (this.vPI != null) {
                fW += e.a.a.b.b.a.h(3, this.vPI);
            }
            fW = (fW + e.a.a.a.fU(4, this.xbx)) + e.a.a.a.fU(5, this.pgW);
            if (this.wMx != null) {
                fW += e.a.a.b.b.a.h(6, this.wMx);
            }
            if (this.wMy != null) {
                fW += e.a.a.b.b.a.h(7, this.wMy);
            }
            if (this.wMA != null) {
                fW += e.a.a.b.b.a.h(8, this.wMA);
            }
            fW += e.a.a.a.fU(9, this.xby);
            if (this.xbz != null) {
                fW += e.a.a.b.b.a.h(10, this.xbz);
            }
            return fW + e.a.a.a.fU(11, this.wMz);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.xbw != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Receipt");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btv btv = (btv) objArr[1];
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
                        btv.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        btv.xbw = fhVar;
                    }
                    return 0;
                case 3:
                    btv.vPI = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    btv.xbx = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    btv.pgW = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    btv.wMx = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    btv.wMy = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    btv.wMA = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    btv.xby = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    btv.xbz = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    btv.wMz = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class cdx extends bea {
    public String lTZ;
    public int nkZ;
    public String vQo;
    public String xjm;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.lTZ != null) {
                aVar.g(2, this.lTZ);
            }
            if (this.vQo != null) {
                aVar.g(3, this.vQo);
            }
            if (this.xjm != null) {
                aVar.g(4, this.xjm);
            }
            aVar.fX(5, this.nkZ);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.lTZ != null) {
                fW += e.a.a.b.b.a.h(2, this.lTZ);
            }
            if (this.vQo != null) {
                fW += e.a.a.b.b.a.h(3, this.vQo);
            }
            if (this.xjm != null) {
                fW += e.a.a.b.b.a.h(4, this.xjm);
            }
            return fW + e.a.a.a.fU(5, this.nkZ);
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
            cdx cdx = (cdx) objArr[1];
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
                        cdx.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    cdx.lTZ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cdx.vQo = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cdx.xjm = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    cdx.nkZ = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

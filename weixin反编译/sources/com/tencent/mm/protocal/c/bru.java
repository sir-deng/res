package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bru extends bea {
    public String vNF;
    public int vPs;
    public int vPt;
    public int vPu;
    public bes weD;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.weD == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vNF != null) {
                aVar.g(2, this.vNF);
            }
            aVar.fX(3, this.vPs);
            aVar.fX(4, this.vPt);
            aVar.fX(5, this.vPu);
            if (this.weD == null) {
                return 0;
            }
            aVar.fZ(6, this.weD.bkL());
            this.weD.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vNF != null) {
                fW += e.a.a.b.b.a.h(2, this.vNF);
            }
            fW = ((fW + e.a.a.a.fU(3, this.vPs)) + e.a.a.a.fU(4, this.vPt)) + e.a.a.a.fU(5, this.vPu);
            if (this.weD != null) {
                fW += e.a.a.a.fW(6, this.weD.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.weD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bru bru = (bru) objArr[1];
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
                        bru.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bru.vNF = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bru.vPs = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bru.vPt = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bru.vPu = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bru.weD = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

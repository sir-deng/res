package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class brw extends bea {
    public String kyG;
    public int vPs;
    public int vPt;
    public String wZK;
    public bes weD;
    public int wss;

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
            aVar.fX(2, this.vPs);
            aVar.fX(3, this.vPt);
            aVar.fX(4, this.wss);
            if (this.weD != null) {
                aVar.fZ(5, this.weD.bkL());
                this.weD.a(aVar);
            }
            if (this.wZK != null) {
                aVar.g(6, this.wZK);
            }
            if (this.kyG == null) {
                return 0;
            }
            aVar.g(7, this.kyG);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((fW + e.a.a.a.fU(2, this.vPs)) + e.a.a.a.fU(3, this.vPt)) + e.a.a.a.fU(4, this.wss);
            if (this.weD != null) {
                fW += e.a.a.a.fW(5, this.weD.bkL());
            }
            if (this.wZK != null) {
                fW += e.a.a.b.b.a.h(6, this.wZK);
            }
            if (this.kyG != null) {
                fW += e.a.a.b.b.a.h(7, this.kyG);
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
            brw brw = (brw) objArr[1];
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
                        brw.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    brw.vPs = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    brw.vPt = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    brw.wss = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        brw.weD = fhVar;
                    }
                    return 0;
                case 6:
                    brw.wZK = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    brw.kyG = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

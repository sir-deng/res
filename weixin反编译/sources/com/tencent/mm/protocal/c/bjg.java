package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bjg extends bea {
    public int vOK;
    public int vSa;
    public float vXy;
    public int wTc;
    public float wTd;
    public float wTe;
    public int wdO;
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
            if (this.weD != null) {
                aVar.fZ(2, this.weD.bkL());
                this.weD.a(aVar);
            }
            aVar.fX(3, this.wTc);
            aVar.fX(4, this.vSa);
            aVar.m(5, this.wTd);
            aVar.fX(6, this.wdO);
            aVar.fX(7, this.vOK);
            aVar.m(8, this.wTe);
            aVar.m(9, this.vXy);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.weD != null) {
                fW += e.a.a.a.fW(2, this.weD.bkL());
            }
            return ((((((fW + e.a.a.a.fU(3, this.wTc)) + e.a.a.a.fU(4, this.vSa)) + (e.a.a.b.b.a.dX(5) + 4)) + e.a.a.a.fU(6, this.wdO)) + e.a.a.a.fU(7, this.vOK)) + (e.a.a.b.b.a.dX(8) + 4)) + (e.a.a.b.b.a.dX(9) + 4);
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
            bjg bjg = (bjg) objArr[1];
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
                        bjg.wQE = fhVar;
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
                        bjg.weD = fhVar;
                    }
                    return 0;
                case 3:
                    bjg.wTc = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bjg.vSa = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bjg.wTd = aVar3.AEQ.readFloat();
                    return 0;
                case 6:
                    bjg.wdO = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bjg.vOK = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bjg.wTe = aVar3.AEQ.readFloat();
                    return 0;
                case 9:
                    bjg.vXy = aVar3.AEQ.readFloat();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

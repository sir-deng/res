package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class rt extends bea {
    public int vNL;
    public long vNT;
    public int vPs;
    public int vPt;
    public int wgy;
    public int wgz;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.vNL);
            aVar.fX(3, this.vPs);
            aVar.fX(4, this.vPt);
            aVar.fX(5, this.wgy);
            aVar.fX(6, this.wgz);
            aVar.S(7, this.vNT);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            return (((((fW + e.a.a.a.fU(2, this.vNL)) + e.a.a.a.fU(3, this.vPs)) + e.a.a.a.fU(4, this.vPt)) + e.a.a.a.fU(5, this.wgy)) + e.a.a.a.fU(6, this.wgz)) + e.a.a.a.R(7, this.vNT);
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
            rt rtVar = (rt) objArr[1];
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
                        rtVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    rtVar.vNL = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    rtVar.vPs = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    rtVar.vPt = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    rtVar.wgy = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    rtVar.wgz = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    rtVar.vNT = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class boo extends bea {
    public int sfa;
    public int vND;
    public int wil;
    public long wim;
    public int wnV;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.wil);
            aVar.S(3, this.wim);
            aVar.fX(4, this.wnV);
            aVar.fX(5, this.vND);
            aVar.fX(6, this.sfa);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            return ((((fW + e.a.a.a.fU(2, this.wil)) + e.a.a.a.R(3, this.wim)) + e.a.a.a.fU(4, this.wnV)) + e.a.a.a.fU(5, this.vND)) + e.a.a.a.fU(6, this.sfa);
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
            boo boo = (boo) objArr[1];
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
                        boo.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    boo.wil = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    boo.wim = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    boo.wnV = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    boo.vND = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    boo.sfa = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

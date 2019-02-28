package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class abh extends a {
    public int wdP;
    public int wdQ;
    public int wdR;
    public b wdT;
    public akp wdU;
    public int wrb;
    public int wrc;
    public int wrd;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wdP);
            aVar.fX(2, this.wdQ);
            aVar.fX(3, this.wdR);
            if (this.wdT != null) {
                aVar.b(4, this.wdT);
            }
            aVar.fX(5, this.wrb);
            aVar.fX(6, this.wrc);
            aVar.fX(7, this.wrd);
            if (this.wdU != null) {
                aVar.fZ(8, this.wdU.bkL());
                this.wdU.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.wdP) + 0) + e.a.a.a.fU(2, this.wdQ)) + e.a.a.a.fU(3, this.wdR);
            if (this.wdT != null) {
                fU += e.a.a.a.a(4, this.wdT);
            }
            fU = ((fU + e.a.a.a.fU(5, this.wrb)) + e.a.a.a.fU(6, this.wrc)) + e.a.a.a.fU(7, this.wrd);
            if (this.wdU != null) {
                return fU + e.a.a.a.fW(8, this.wdU.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abh abh = (abh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    abh.wdP = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    abh.wdQ = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    abh.wdR = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    abh.wdT = aVar3.cKw();
                    return 0;
                case 5:
                    abh.wrb = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    abh.wrc = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    abh.wrd = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a akp = new akp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = akp.a(aVar4, akp, a.a(aVar4))) {
                        }
                        abh.wdU = akp;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

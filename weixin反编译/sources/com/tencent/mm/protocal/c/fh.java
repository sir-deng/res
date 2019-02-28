package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class fh extends a {
    public int lTO;
    public int sfa;
    public b vRP;
    public b vRQ;
    public int vRR;
    public b vRS;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vRP != null) {
                aVar.b(1, this.vRP);
            }
            aVar.fX(2, this.lTO);
            if (this.vRQ != null) {
                aVar.b(3, this.vRQ);
            }
            aVar.fX(4, this.vRR);
            if (this.vRS != null) {
                aVar.b(5, this.vRS);
            }
            aVar.fX(6, this.sfa);
            return 0;
        } else if (i == 1) {
            if (this.vRP != null) {
                a = e.a.a.a.a(1, this.vRP) + 0;
            } else {
                a = 0;
            }
            a += e.a.a.a.fU(2, this.lTO);
            if (this.vRQ != null) {
                a += e.a.a.a.a(3, this.vRQ);
            }
            a += e.a.a.a.fU(4, this.vRR);
            if (this.vRS != null) {
                a += e.a.a.a.a(5, this.vRS);
            }
            return a + e.a.a.a.fU(6, this.sfa);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fh fhVar = (fh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fhVar.vRP = aVar3.cKw();
                    return 0;
                case 2:
                    fhVar.lTO = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    fhVar.vRQ = aVar3.cKw();
                    return 0;
                case 4:
                    fhVar.vRR = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    fhVar.vRS = aVar3.cKw();
                    return 0;
                case 6:
                    fhVar.sfa = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

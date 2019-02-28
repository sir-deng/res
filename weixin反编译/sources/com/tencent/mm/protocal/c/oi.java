package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class oi extends a {
    public int wdP;
    public int wdQ;
    public int wdR;
    public LinkedList<oh> wdS = new LinkedList();
    public b wdT;
    public akp wdU;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wdP);
            aVar.fX(2, this.wdQ);
            aVar.fX(3, this.wdR);
            aVar.d(4, 8, this.wdS);
            if (this.wdT != null) {
                aVar.b(5, this.wdT);
            }
            if (this.wdU != null) {
                aVar.fZ(6, this.wdU.bkL());
                this.wdU.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = (((e.a.a.a.fU(1, this.wdP) + 0) + e.a.a.a.fU(2, this.wdQ)) + e.a.a.a.fU(3, this.wdR)) + e.a.a.a.c(4, 8, this.wdS);
            if (this.wdT != null) {
                fU += e.a.a.a.a(5, this.wdT);
            }
            if (this.wdU != null) {
                return fU + e.a.a.a.fW(6, this.wdU.bkL());
            }
            return fU;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wdS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            oi oiVar = (oi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a ohVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    oiVar.wdP = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    oiVar.wdQ = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    oiVar.wdR = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ohVar = new oh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ohVar.a(aVar4, ohVar, a.a(aVar4))) {
                        }
                        oiVar.wdS.add(ohVar);
                    }
                    return 0;
                case 5:
                    oiVar.wdT = aVar3.cKw();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        ohVar = new akp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ohVar.a(aVar4, ohVar, a.a(aVar4))) {
                        }
                        oiVar.wdU = ohVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

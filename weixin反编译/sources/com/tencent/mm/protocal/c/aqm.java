package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class aqm extends a {
    public String lTZ;
    public int sfa;
    public int wDS;
    public aou wDT;
    public int wDU;
    public long wDV;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.sfa);
            aVar.fX(2, this.wDS);
            if (this.wDT != null) {
                aVar.fZ(3, this.wDT.bkL());
                this.wDT.a(aVar);
            }
            aVar.fX(4, this.wDU);
            if (this.lTZ != null) {
                aVar.g(5, this.lTZ);
            }
            aVar.S(6, this.wDV);
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.sfa) + 0) + e.a.a.a.fU(2, this.wDS);
            if (this.wDT != null) {
                fU += e.a.a.a.fW(3, this.wDT.bkL());
            }
            fU += e.a.a.a.fU(4, this.wDU);
            if (this.lTZ != null) {
                fU += e.a.a.b.b.a.h(5, this.lTZ);
            }
            return fU + e.a.a.a.R(6, this.wDV);
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
            aqm aqm = (aqm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aqm.sfa = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    aqm.wDS = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a aou = new aou();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aou.a(aVar4, aou, a.a(aVar4))) {
                        }
                        aqm.wDT = aou;
                    }
                    return 0;
                case 4:
                    aqm.wDU = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aqm.lTZ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aqm.wDV = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

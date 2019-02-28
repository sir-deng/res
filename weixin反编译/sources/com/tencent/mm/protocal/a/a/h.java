package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class h extends a {
    public int ret;
    public int vIP;
    public int vIQ;
    public o vIR;
    public o vIS;
    public int vIT;
    public int vIU;
    public int vJi;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.ret);
            aVar.fX(2, this.vIP);
            aVar.fX(3, this.vIQ);
            if (this.vIR != null) {
                aVar.fZ(4, this.vIR.bkL());
                this.vIR.a(aVar);
            }
            if (this.vIS != null) {
                aVar.fZ(5, this.vIS.bkL());
                this.vIS.a(aVar);
            }
            aVar.fX(6, this.vIT);
            aVar.fX(7, this.vJi);
            aVar.fX(8, this.vIU);
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.ret) + 0) + e.a.a.a.fU(2, this.vIP)) + e.a.a.a.fU(3, this.vIQ);
            if (this.vIR != null) {
                fU += e.a.a.a.fW(4, this.vIR.bkL());
            }
            if (this.vIS != null) {
                fU += e.a.a.a.fW(5, this.vIS.bkL());
            }
            return ((fU + e.a.a.a.fU(6, this.vIT)) + e.a.a.a.fU(7, this.vJi)) + e.a.a.a.fU(8, this.vIU);
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
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a oVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    hVar.ret = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    hVar.vIP = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    hVar.vIQ = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        hVar.vIR = oVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        hVar.vIS = oVar;
                    }
                    return 0;
                case 6:
                    hVar.vIT = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    hVar.vJi = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    hVar.vIU = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

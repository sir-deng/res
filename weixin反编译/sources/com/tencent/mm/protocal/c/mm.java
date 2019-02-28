package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class mm extends a {
    public int lfj;
    public LinkedList<mn> wbU = new LinkedList();
    public int wbV;
    public bet wbW;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.lfj);
            aVar.d(2, 8, this.wbU);
            aVar.fX(3, this.wbV);
            if (this.wbW != null) {
                aVar.fZ(4, this.wbW.bkL());
                this.wbW.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.lfj) + 0) + e.a.a.a.c(2, 8, this.wbU)) + e.a.a.a.fU(3, this.wbV);
            if (this.wbW != null) {
                return fU + e.a.a.a.fW(4, this.wbW.bkL());
            }
            return fU;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wbU.clear();
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
            mm mmVar = (mm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a mnVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    mmVar.lfj = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        mnVar = new mn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mnVar.a(aVar4, mnVar, a.a(aVar4))) {
                        }
                        mmVar.wbU.add(mnVar);
                    }
                    return 0;
                case 3:
                    mmVar.wbV = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        mnVar = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mnVar.a(aVar4, mnVar, a.a(aVar4))) {
                        }
                        mmVar.wbW = mnVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

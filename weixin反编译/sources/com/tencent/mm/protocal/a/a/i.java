package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class i extends a {
    public int vIP;
    public int vJd;
    public int vJf;
    public LinkedList<e> vJg = new LinkedList();
    public b vJh;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vIP);
            aVar.fX(2, this.vJf);
            aVar.fX(3, this.vJd);
            aVar.d(4, 8, this.vJg);
            if (this.vJh != null) {
                aVar.b(5, this.vJh);
            }
            return 0;
        } else if (i == 1) {
            fU = (((e.a.a.a.fU(1, this.vIP) + 0) + e.a.a.a.fU(2, this.vJf)) + e.a.a.a.fU(3, this.vJd)) + e.a.a.a.c(4, 8, this.vJg);
            if (this.vJh != null) {
                return fU + e.a.a.a.a(5, this.vJh);
            }
            return fU;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vJg.clear();
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
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.vIP = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    iVar.vJf = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    iVar.vJd = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        iVar.vJg.add(eVar);
                    }
                    return 0;
                case 5:
                    iVar.vJh = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

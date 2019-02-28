package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class g extends a {
    public int vIP;
    public int vJf;
    public LinkedList<b> vJg = new LinkedList();
    public b vJh;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vIP);
            aVar.fX(2, this.vJf);
            aVar.d(3, 8, this.vJg);
            if (this.vJh != null) {
                aVar.b(4, this.vJh);
            }
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.vIP) + 0) + e.a.a.a.fU(2, this.vJf)) + e.a.a.a.c(3, 8, this.vJg);
            if (this.vJh != null) {
                return fU + e.a.a.a.a(4, this.vJh);
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
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gVar.vIP = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    gVar.vJf = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a bVar = new b();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        gVar.vJg.add(bVar);
                    }
                    return 0;
                case 4:
                    gVar.vJh = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

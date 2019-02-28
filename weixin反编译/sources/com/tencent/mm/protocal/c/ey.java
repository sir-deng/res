package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ey extends a {
    public boolean vRs;
    public LinkedList<ez> vRt = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.am(1, this.vRs);
            aVar.d(2, 8, this.vRt);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.b.b.a.dX(1) + 1) + 0) + e.a.a.a.c(2, 8, this.vRt);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.vRt.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                ey eyVar = (ey) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        eyVar.vRs = aVar3.cKv();
                        return 0;
                    case 2:
                        LinkedList JD = aVar3.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a ezVar = new ez();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = ezVar.a(aVar4, ezVar, a.a(aVar4))) {
                            }
                            eyVar.vRt.add(ezVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cck extends a {
    public LinkedList<ayh> xhZ = new LinkedList();
    public LinkedList<anr> xia = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.xhZ);
            aVar.d(2, 8, this.xia);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 8, this.xhZ) + 0) + e.a.a.a.c(2, 8, this.xia);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.xhZ.clear();
                this.xia.clear();
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
                cck cck = (cck) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList JD;
                int size;
                a ayh;
                e.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            ayh = new ayh();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = ayh.a(aVar4, ayh, a.a(aVar4))) {
                            }
                            cck.xhZ.add(ayh);
                        }
                        return 0;
                    case 2:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            ayh = new anr();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = ayh.a(aVar4, ayh, a.a(aVar4))) {
                            }
                            cck.xia.add(ayh);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

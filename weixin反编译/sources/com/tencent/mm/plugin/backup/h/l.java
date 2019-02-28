package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class l extends a {
    public LinkedList<k> kyH = new LinkedList();
    public int kyI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.kyH);
            aVar.fX(2, this.kyI);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 8, this.kyH) + 0) + e.a.a.a.fU(2, this.kyI);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.kyH.clear();
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
                l lVar = (l) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList JD = aVar3.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a kVar = new k();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                            }
                            lVar.kyH.add(kVar);
                        }
                        return 0;
                    case 2:
                        lVar.kyI = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

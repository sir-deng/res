package com.tencent.mm.storage;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class aw extends a {
    public LinkedList<ax> xIr = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).d(1, 8, this.xIr);
            return 0;
        } else if (i == 1) {
            return e.a.a.a.c(1, 8, this.xIr) + 0;
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.xIr.clear();
                e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
                aw awVar = (aw) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList JD = aVar2.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a axVar = new ax();
                            e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = axVar.a(aVar3, axVar, a.a(aVar3))) {
                            }
                            awVar.xIr.add(axVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

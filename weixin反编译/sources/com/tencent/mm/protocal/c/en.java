package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class en extends a {
    public LinkedList<String> vQB = new LinkedList();
    public int vQC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.vQB);
            aVar.fX(2, this.vQC);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 1, this.vQB) + 0) + e.a.a.a.fU(2, this.vQC);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.vQB.clear();
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
                en enVar = (en) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        enVar.vQB.add(aVar3.AEQ.readString());
                        return 0;
                    case 2:
                        enVar.vQC = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

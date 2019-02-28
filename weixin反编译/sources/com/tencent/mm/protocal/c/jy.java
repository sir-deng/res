package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class jy extends a {
    public int vXr;
    public LinkedList<Integer> vXs = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vXr);
            aVar.c(2, this.vXs);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.fU(1, this.vXr) + 0) + e.a.a.a.b(2, this.vXs);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.vXs.clear();
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
                jy jyVar = (jy) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        jyVar.vXr = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        jyVar.vXs = new e.a.a.a.a(aVar3.cKw().oz, unknownTagHandler).cKt();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

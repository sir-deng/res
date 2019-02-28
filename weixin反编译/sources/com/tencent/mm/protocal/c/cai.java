package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cai extends a {
    public LinkedList<Integer> xgL = new LinkedList();
    public boolean xgM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 2, this.xgL);
            aVar.am(2, this.xgM);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 2, this.xgL) + 0) + (e.a.a.b.b.a.dX(2) + 1);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.xgL.clear();
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
                cai cai = (cai) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cai.xgL.add(Integer.valueOf(aVar3.AEQ.rz()));
                        return 0;
                    case 2:
                        cai.xgM = aVar3.cKv();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

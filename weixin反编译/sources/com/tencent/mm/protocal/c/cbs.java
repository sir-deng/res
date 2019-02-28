package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cbs extends a {
    public LinkedList<cbq> xhG = new LinkedList();
    public boolean xhH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.xhG);
            aVar.am(2, this.xhH);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 8, this.xhG) + 0) + (e.a.a.b.b.a.dX(2) + 1);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.xhG.clear();
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
                cbs cbs = (cbs) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList JD = aVar3.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a cbq = new cbq();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = cbq.a(aVar4, cbq, a.a(aVar4))) {
                            }
                            cbs.xhG.add(cbq);
                        }
                        return 0;
                    case 2:
                        cbs.xhH = aVar3.cKv();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

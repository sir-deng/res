package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bfc extends a {
    public String wDa;
    public LinkedList<cq> wRv = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.wRv);
            if (this.wDa != null) {
                aVar.g(2, this.wDa);
            }
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.wRv) + 0;
            if (this.wDa != null) {
                return c + e.a.a.b.b.a.h(2, this.wDa);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wRv.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfc bfc = (bfc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a cqVar = new cq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cqVar.a(aVar4, cqVar, a.a(aVar4))) {
                        }
                        bfc.wRv.add(cqVar);
                    }
                    return 0;
                case 2:
                    bfc.wDa = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

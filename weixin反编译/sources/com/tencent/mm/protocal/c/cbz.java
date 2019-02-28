package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class cbz extends a {
    public LinkedList<bnk> xhR = new LinkedList();
    public b xhS;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.xhR);
            if (this.xhS != null) {
                aVar.b(2, this.xhS);
            }
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.xhR) + 0;
            if (this.xhS != null) {
                return c + e.a.a.a.a(2, this.xhS);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xhR.clear();
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
            cbz cbz = (cbz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a bnk = new bnk();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bnk.a(aVar4, bnk, a.a(aVar4))) {
                        }
                        cbz.xhR.add(bnk);
                    }
                    return 0;
                case 2:
                    cbz.xhS = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

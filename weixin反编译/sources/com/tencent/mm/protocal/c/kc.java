package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class kc extends a {
    public String vXN;
    public LinkedList<String> vXO = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vXN != null) {
                aVar.g(1, this.vXN);
            }
            aVar.d(2, 1, this.vXO);
            return 0;
        } else if (i == 1) {
            if (this.vXN != null) {
                h = e.a.a.b.b.a.h(1, this.vXN) + 0;
            } else {
                h = 0;
            }
            return h + e.a.a.a.c(2, 1, this.vXO);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vXO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            kc kcVar = (kc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kcVar.vXN = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    kcVar.vXO.add(aVar3.AEQ.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class nk extends a {
    public b wcZ;
    public LinkedList<b> wda = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wcZ != null) {
                aVar.b(1, this.wcZ);
            }
            aVar.d(2, 6, this.wda);
            return 0;
        } else if (i == 1) {
            if (this.wcZ != null) {
                a = e.a.a.a.a(1, this.wcZ) + 0;
            } else {
                a = 0;
            }
            return a + e.a.a.a.c(2, 6, this.wda);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wda.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nk nkVar = (nk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nkVar.wcZ = aVar3.cKw();
                    return 0;
                case 2:
                    nkVar.wda.add(aVar3.cKw());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

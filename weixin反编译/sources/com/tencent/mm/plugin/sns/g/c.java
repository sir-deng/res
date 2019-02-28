package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class c extends a {
    public LinkedList<Long> rgM = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).d(1, 3, this.rgM);
            return 0;
        } else if (i == 1) {
            return e.a.a.a.c(1, 3, this.rgM) + 0;
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.rgM.clear();
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
                c cVar = (c) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cVar.rgM.add(Long.valueOf(aVar2.AEQ.rA()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

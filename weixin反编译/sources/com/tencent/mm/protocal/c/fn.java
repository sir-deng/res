package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class fn extends a {
    public LinkedList<String> vQB = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).d(1, 1, this.vQB);
            return 0;
        } else if (i == 1) {
            return e.a.a.a.c(1, 1, this.vQB) + 0;
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.vQB.clear();
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
                fn fnVar = (fn) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        fnVar.vQB.add(aVar2.AEQ.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

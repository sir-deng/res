package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class bqg extends a {
    public int uin;
    public b wZb;
    public String wZc;
    public b wZd;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wZb != null) {
                aVar.b(1, this.wZb);
            }
            if (this.wZc != null) {
                aVar.g(2, this.wZc);
            }
            if (this.wZd != null) {
                aVar.b(3, this.wZd);
            }
            aVar.fX(4, this.uin);
            return 0;
        } else if (i == 1) {
            if (this.wZb != null) {
                a = e.a.a.a.a(1, this.wZb) + 0;
            } else {
                a = 0;
            }
            if (this.wZc != null) {
                a += e.a.a.b.b.a.h(2, this.wZc);
            }
            if (this.wZd != null) {
                a += e.a.a.a.a(3, this.wZd);
            }
            return a + e.a.a.a.fU(4, this.uin);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bqg bqg = (bqg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqg.wZb = aVar3.cKw();
                    return 0;
                case 2:
                    bqg.wZc = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bqg.wZd = aVar3.cKw();
                    return 0;
                case 4:
                    bqg.uin = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class kx extends a {
    public String code;
    public String kPy;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kPy != null) {
                aVar.g(1, this.kPy);
            }
            if (this.code == null) {
                return 0;
            }
            aVar.g(2, this.code);
            return 0;
        } else if (i == 1) {
            if (this.kPy != null) {
                h = e.a.a.b.b.a.h(1, this.kPy) + 0;
            } else {
                h = 0;
            }
            if (this.code != null) {
                h += e.a.a.b.b.a.h(2, this.code);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            kx kxVar = (kx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kxVar.kPy = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    kxVar.code = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

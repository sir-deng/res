package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bqf extends a {
    public String wYZ;
    public String wZa;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYZ != null) {
                aVar.g(1, this.wYZ);
            }
            if (this.wZa == null) {
                return 0;
            }
            aVar.g(2, this.wZa);
            return 0;
        } else if (i == 1) {
            if (this.wYZ != null) {
                h = e.a.a.b.b.a.h(1, this.wYZ) + 0;
            } else {
                h = 0;
            }
            if (this.wZa != null) {
                h += e.a.a.b.b.a.h(2, this.wZa);
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
            bqf bqf = (bqf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqf.wYZ = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bqf.wZa = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

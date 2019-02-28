package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aog extends a {
    public String value;
    public String wBR;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wBR != null) {
                aVar.g(1, this.wBR);
            }
            if (this.value == null) {
                return 0;
            }
            aVar.g(2, this.value);
            return 0;
        } else if (i == 1) {
            if (this.wBR != null) {
                h = e.a.a.b.b.a.h(1, this.wBR) + 0;
            } else {
                h = 0;
            }
            if (this.value != null) {
                h += e.a.a.b.b.a.h(2, this.value);
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
            aog aog = (aog) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aog.wBR = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aog.value = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

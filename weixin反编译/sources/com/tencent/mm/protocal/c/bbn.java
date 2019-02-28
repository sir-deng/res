package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bbn extends a {
    public String wOG;
    public String wOH;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wOG != null) {
                aVar.g(1, this.wOG);
            }
            if (this.wOH == null) {
                return 0;
            }
            aVar.g(2, this.wOH);
            return 0;
        } else if (i == 1) {
            if (this.wOG != null) {
                h = e.a.a.b.b.a.h(1, this.wOG) + 0;
            } else {
                h = 0;
            }
            if (this.wOH != null) {
                h += e.a.a.b.b.a.h(2, this.wOH);
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
            bbn bbn = (bbn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbn.wOG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bbn.wOH = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

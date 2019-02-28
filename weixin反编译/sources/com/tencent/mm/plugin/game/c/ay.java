package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class ay extends a {
    public String nkN;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkN == null) {
                return 0;
            }
            aVar.g(1, this.nkN);
            return 0;
        } else if (i == 1) {
            if (this.nkN != null) {
                h = e.a.a.b.b.a.h(1, this.nkN) + 0;
            } else {
                h = 0;
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
            ay ayVar = (ay) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayVar.nkN = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

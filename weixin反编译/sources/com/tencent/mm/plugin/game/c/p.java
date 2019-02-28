package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class p extends a {
    public String fpg;
    public String nkL;
    public String nlI;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg != null) {
                aVar.g(1, this.fpg);
            }
            if (this.nkL != null) {
                aVar.g(2, this.nkL);
            }
            if (this.nlI == null) {
                return 0;
            }
            aVar.g(3, this.nlI);
            return 0;
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            if (this.nkL != null) {
                h += e.a.a.b.b.a.h(2, this.nkL);
            }
            if (this.nlI != null) {
                h += e.a.a.b.b.a.h(3, this.nlI);
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
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    pVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    pVar.nlI = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

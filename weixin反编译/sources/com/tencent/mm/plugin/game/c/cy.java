package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class cy extends a {
    public String fpg;
    public String nkL;
    public String nkM;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg != null) {
                aVar.g(1, this.fpg);
            }
            if (this.nkM != null) {
                aVar.g(2, this.nkM);
            }
            if (this.nkL == null) {
                return 0;
            }
            aVar.g(3, this.nkL);
            return 0;
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            if (this.nkM != null) {
                h += e.a.a.b.b.a.h(2, this.nkM);
            }
            if (this.nkL != null) {
                h += e.a.a.b.b.a.h(3, this.nkL);
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
            cy cyVar = (cy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cyVar.nkM = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cyVar.nkL = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

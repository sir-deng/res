package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class q extends a {
    public String nlJ;
    public String nlK;
    public String nlL;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlJ != null) {
                aVar.g(1, this.nlJ);
            }
            if (this.nlK != null) {
                aVar.g(2, this.nlK);
            }
            if (this.nlL == null) {
                return 0;
            }
            aVar.g(3, this.nlL);
            return 0;
        } else if (i == 1) {
            if (this.nlJ != null) {
                h = e.a.a.b.b.a.h(1, this.nlJ) + 0;
            } else {
                h = 0;
            }
            if (this.nlK != null) {
                h += e.a.a.b.b.a.h(2, this.nlK);
            }
            if (this.nlL != null) {
                h += e.a.a.b.b.a.h(3, this.nlL);
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
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.nlJ = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    qVar.nlK = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    qVar.nlL = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

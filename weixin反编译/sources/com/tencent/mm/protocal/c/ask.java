package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ask extends a {
    public int kzz;
    public String noE;
    public String pWq;
    public String wGQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.noE != null) {
                aVar.g(1, this.noE);
            }
            if (this.wGQ != null) {
                aVar.g(2, this.wGQ);
            }
            if (this.pWq != null) {
                aVar.g(3, this.pWq);
            }
            aVar.fX(4, this.kzz);
            return 0;
        } else if (i == 1) {
            if (this.noE != null) {
                h = e.a.a.b.b.a.h(1, this.noE) + 0;
            } else {
                h = 0;
            }
            if (this.wGQ != null) {
                h += e.a.a.b.b.a.h(2, this.wGQ);
            }
            if (this.pWq != null) {
                h += e.a.a.b.b.a.h(3, this.pWq);
            }
            return h + e.a.a.a.fU(4, this.kzz);
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
            ask ask = (ask) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ask.noE = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ask.wGQ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ask.pWq = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ask.kzz = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

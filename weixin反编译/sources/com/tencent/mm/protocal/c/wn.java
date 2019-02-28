package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class wn extends a {
    public int fun;
    public String id;
    public int mKO;
    public String wnG;
    public long wnH;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.g(1, this.id);
            }
            aVar.fX(2, this.mKO);
            if (this.wnG != null) {
                aVar.g(3, this.wnG);
            }
            aVar.S(4, this.wnH);
            aVar.fX(5, this.fun);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                h = e.a.a.b.b.a.h(1, this.id) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.mKO);
            if (this.wnG != null) {
                h += e.a.a.b.b.a.h(3, this.wnG);
            }
            return (h + e.a.a.a.R(4, this.wnH)) + e.a.a.a.fU(5, this.fun);
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
            wn wnVar = (wn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wnVar.id = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    wnVar.mKO = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    wnVar.wnG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    wnVar.wnH = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    wnVar.fun = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

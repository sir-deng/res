package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class byd extends a {
    public String hxn;
    public String xfB;
    public int xfC;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfB != null) {
                aVar.g(1, this.xfB);
            }
            if (this.hxn != null) {
                aVar.g(2, this.hxn);
            }
            aVar.fX(3, this.xfC);
            return 0;
        } else if (i == 1) {
            if (this.xfB != null) {
                h = e.a.a.b.b.a.h(1, this.xfB) + 0;
            } else {
                h = 0;
            }
            if (this.hxn != null) {
                h += e.a.a.b.b.a.h(2, this.hxn);
            }
            return h + e.a.a.a.fU(3, this.xfC);
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
            byd byd = (byd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    byd.xfB = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    byd.hxn = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    byd.xfC = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

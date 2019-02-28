package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bkq extends a {
    public String kyG;
    public int wCA;
    public String wUw;
    public int wUx;
    public String wUy;
    public int wUz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wUw != null) {
                aVar.g(1, this.wUw);
            }
            aVar.fX(2, this.wUx);
            if (this.kyG != null) {
                aVar.g(3, this.kyG);
            }
            if (this.wUy != null) {
                aVar.g(4, this.wUy);
            }
            aVar.fX(5, this.wCA);
            aVar.fX(6, this.wUz);
            return 0;
        } else if (i == 1) {
            if (this.wUw != null) {
                h = e.a.a.b.b.a.h(1, this.wUw) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.wUx);
            if (this.kyG != null) {
                h += e.a.a.b.b.a.h(3, this.kyG);
            }
            if (this.wUy != null) {
                h += e.a.a.b.b.a.h(4, this.wUy);
            }
            return (h + e.a.a.a.fU(5, this.wCA)) + e.a.a.a.fU(6, this.wUz);
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
            bkq bkq = (bkq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bkq.wUw = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bkq.wUx = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bkq.kyG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bkq.wUy = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bkq.wCA = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bkq.wUz = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bad extends a {
    public String kyG;
    public int wNC;
    public String wbX;
    public int wfd;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyG != null) {
                aVar.g(1, this.kyG);
            }
            if (this.wbX != null) {
                aVar.g(2, this.wbX);
            }
            aVar.fX(3, this.wNC);
            aVar.fX(4, this.wfd);
            return 0;
        } else if (i == 1) {
            if (this.kyG != null) {
                h = e.a.a.b.b.a.h(1, this.kyG) + 0;
            } else {
                h = 0;
            }
            if (this.wbX != null) {
                h += e.a.a.b.b.a.h(2, this.wbX);
            }
            return (h + e.a.a.a.fU(3, this.wNC)) + e.a.a.a.fU(4, this.wfd);
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
            bad bad = (bad) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bad.kyG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bad.wbX = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bad.wNC = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bad.wfd = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bbr extends a {
    public String kyG;
    public String kzN;
    public int wLT;
    public String whs;
    public String wjz;
    public String woW;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyG != null) {
                aVar.g(1, this.kyG);
            }
            aVar.fX(2, this.wLT);
            if (this.kzN != null) {
                aVar.g(3, this.kzN);
            }
            if (this.whs != null) {
                aVar.g(4, this.whs);
            }
            if (this.wjz != null) {
                aVar.g(5, this.wjz);
            }
            if (this.woW == null) {
                return 0;
            }
            aVar.g(6, this.woW);
            return 0;
        } else if (i == 1) {
            if (this.kyG != null) {
                h = e.a.a.b.b.a.h(1, this.kyG) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.wLT);
            if (this.kzN != null) {
                h += e.a.a.b.b.a.h(3, this.kzN);
            }
            if (this.whs != null) {
                h += e.a.a.b.b.a.h(4, this.whs);
            }
            if (this.wjz != null) {
                h += e.a.a.b.b.a.h(5, this.wjz);
            }
            if (this.woW != null) {
                h += e.a.a.b.b.a.h(6, this.woW);
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
            bbr bbr = (bbr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbr.kyG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bbr.wLT = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bbr.kzN = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bbr.whs = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bbr.wjz = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bbr.woW = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

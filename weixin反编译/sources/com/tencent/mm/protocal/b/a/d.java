package com.tencent.mm.protocal.b.a;

import com.tencent.mm.bp.a;

public final class d extends a {
    public String desc;
    public int fFD;
    public String fwx;
    public String mvs;
    public String title;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            if (this.fwx != null) {
                aVar.g(3, this.fwx);
            }
            aVar.fX(4, this.fFD);
            if (this.mvs == null) {
                return 0;
            }
            aVar.g(5, this.mvs);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.desc != null) {
                h += e.a.a.b.b.a.h(2, this.desc);
            }
            if (this.fwx != null) {
                h += e.a.a.b.b.a.h(3, this.fwx);
            }
            h += e.a.a.a.fU(4, this.fFD);
            if (this.mvs != null) {
                h += e.a.a.b.b.a.h(5, this.mvs);
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
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.title = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    dVar.desc = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    dVar.fwx = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    dVar.fFD = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    dVar.mvs = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

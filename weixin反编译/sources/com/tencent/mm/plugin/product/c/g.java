package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bp.a;

public final class g extends a {
    public String country;
    public String fXk;
    public String fXl;
    public String hzf;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.country != null) {
                aVar.g(1, this.country);
            }
            if (this.fXk != null) {
                aVar.g(2, this.fXk);
            }
            if (this.fXl != null) {
                aVar.g(3, this.fXl);
            }
            if (this.hzf == null) {
                return 0;
            }
            aVar.g(4, this.hzf);
            return 0;
        } else if (i == 1) {
            if (this.country != null) {
                h = e.a.a.b.b.a.h(1, this.country) + 0;
            } else {
                h = 0;
            }
            if (this.fXk != null) {
                h += e.a.a.b.b.a.h(2, this.fXk);
            }
            if (this.fXl != null) {
                h += e.a.a.b.b.a.h(3, this.fXl);
            }
            if (this.hzf != null) {
                h += e.a.a.b.b.a.h(4, this.hzf);
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
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.country = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    gVar.fXk = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    gVar.fXl = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    gVar.hzf = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

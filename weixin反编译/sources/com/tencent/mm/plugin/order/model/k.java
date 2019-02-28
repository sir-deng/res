package com.tencent.mm.plugin.order.model;

import com.tencent.mm.bp.a;

public final class k extends a {
    public String phv;
    public String phw;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.phv != null) {
                aVar.g(1, this.phv);
            }
            if (this.phw == null) {
                return 0;
            }
            aVar.g(2, this.phw);
            return 0;
        } else if (i == 1) {
            if (this.phv != null) {
                h = e.a.a.b.b.a.h(1, this.phv) + 0;
            } else {
                h = 0;
            }
            if (this.phw != null) {
                h += e.a.a.b.b.a.h(2, this.phw);
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
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.phv = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    kVar.phw = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.ay;

import com.tencent.mm.bp.a;

public final class e extends a {
    public String hLm;
    public String lang;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.hLm != null) {
                aVar.g(1, this.hLm);
            }
            if (this.lang == null) {
                return 0;
            }
            aVar.g(2, this.lang);
            return 0;
        } else if (i == 1) {
            if (this.hLm != null) {
                h = e.a.a.b.b.a.h(1, this.hLm) + 0;
            } else {
                h = 0;
            }
            if (this.lang != null) {
                h += e.a.a.b.b.a.h(2, this.lang);
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
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.hLm = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    eVar.lang = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class db extends a {
    public String nkQ;
    public String npl;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.npl != null) {
                aVar.g(1, this.npl);
            }
            if (this.nkQ == null) {
                return 0;
            }
            aVar.g(2, this.nkQ);
            return 0;
        } else if (i == 1) {
            if (this.npl != null) {
                h = e.a.a.b.b.a.h(1, this.npl) + 0;
            } else {
                h = 0;
            }
            if (this.nkQ != null) {
                h += e.a.a.b.b.a.h(2, this.nkQ);
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
            db dbVar = (db) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dbVar.npl = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    dbVar.nkQ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

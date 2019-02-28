package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class t extends a {
    public String fpg;
    public String nkQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nkQ == null) {
                throw new b("Not all required fields were included: WebURL");
            } else {
                if (this.fpg != null) {
                    aVar.g(1, this.fpg);
                }
                if (this.nkQ == null) {
                    return 0;
                }
                aVar.g(2, this.nkQ);
                return 0;
            }
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
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
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nkQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: WebURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    tVar.nkQ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

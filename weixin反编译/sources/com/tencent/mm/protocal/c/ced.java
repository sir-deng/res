package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class ced extends a {
    public String hds;
    public String title;
    public int xjp;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.hds == null) {
                throw new b("Not all required fields were included: rankid");
            } else if (this.title == null) {
                throw new b("Not all required fields were included: title");
            } else {
                if (this.hds != null) {
                    aVar.g(1, this.hds);
                }
                if (this.title != null) {
                    aVar.g(2, this.title);
                }
                aVar.fX(3, this.xjp);
                return 0;
            }
        } else if (i == 1) {
            if (this.hds != null) {
                h = e.a.a.b.b.a.h(1, this.hds) + 0;
            } else {
                h = 0;
            }
            if (this.title != null) {
                h += e.a.a.b.b.a.h(2, this.title);
            }
            return h + e.a.a.a.fU(3, this.xjp);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.hds == null) {
                throw new b("Not all required fields were included: rankid");
            } else if (this.title != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: title");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ced ced = (ced) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ced.hds = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ced.title = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ced.xjp = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

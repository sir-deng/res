package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class t extends a {
    public String ID;
    public int kzt;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            aVar.fX(2, this.kzt);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                h = e.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                h = 0;
            }
            return h + e.a.a.a.fU(2, this.kzt);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.ID = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    tVar.kzt = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

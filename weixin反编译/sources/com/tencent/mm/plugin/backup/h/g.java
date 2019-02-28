package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class g extends a {
    public String kyy;
    public int kyz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyy == null) {
                throw new b("Not all required fields were included: BakChatName");
            }
            if (this.kyy != null) {
                aVar.g(1, this.kyy);
            }
            aVar.fX(2, this.kyz);
            return 0;
        } else if (i == 1) {
            if (this.kyy != null) {
                h = e.a.a.b.b.a.h(1, this.kyy) + 0;
            } else {
                h = 0;
            }
            return h + e.a.a.a.fU(2, this.kyz);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.kyy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BakChatName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.kyy = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    gVar.kyz = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

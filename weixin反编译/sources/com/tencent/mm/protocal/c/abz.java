package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class abz extends a {
    public String wgP;
    public String wrD;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wrD == null) {
                throw new b("Not all required fields were included: ActivityId");
            }
            if (this.wrD != null) {
                aVar.g(1, this.wrD);
            }
            if (this.wgP == null) {
                return 0;
            }
            aVar.g(2, this.wgP);
            return 0;
        } else if (i == 1) {
            if (this.wrD != null) {
                h = e.a.a.b.b.a.h(1, this.wrD) + 0;
            } else {
                h = 0;
            }
            if (this.wgP != null) {
                h += e.a.a.b.b.a.h(2, this.wgP);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wrD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ActivityId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abz abz = (abz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abz.wrD = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    abz.wgP = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

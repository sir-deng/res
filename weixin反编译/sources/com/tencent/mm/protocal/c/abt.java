package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class abt extends a {
    public String wgQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wgQ == null) {
                throw new b("Not all required fields were included: DesignerID");
            } else if (this.wgQ == null) {
                return 0;
            } else {
                aVar.g(1, this.wgQ);
                return 0;
            }
        } else if (i == 1) {
            if (this.wgQ != null) {
                h = e.a.a.b.b.a.h(1, this.wgQ) + 0;
            } else {
                h = 0;
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wgQ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DesignerID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abt abt = (abt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abt.wgQ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class cw extends a {
    public String nkL;
    public String nkN;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkL == null) {
                throw new b("Not all required fields were included: Desc");
            }
            if (this.nkL != null) {
                aVar.g(1, this.nkL);
            }
            if (this.nkN == null) {
                return 0;
            }
            aVar.g(2, this.nkN);
            return 0;
        } else if (i == 1) {
            if (this.nkL != null) {
                h = e.a.a.b.b.a.h(1, this.nkL) + 0;
            } else {
                h = 0;
            }
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(2, this.nkN);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.nkL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Desc");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cw cwVar = (cw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cwVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cwVar.nkN = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

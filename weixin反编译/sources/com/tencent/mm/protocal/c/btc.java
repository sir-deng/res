package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class btc extends a {
    public String kyG;
    public String wfP;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyG != null) {
                aVar.g(1, this.kyG);
            }
            if (this.wfP == null) {
                return 0;
            }
            aVar.g(2, this.wfP);
            return 0;
        } else if (i == 1) {
            if (this.kyG != null) {
                h = e.a.a.b.b.a.h(1, this.kyG) + 0;
            } else {
                h = 0;
            }
            if (this.wfP != null) {
                h += e.a.a.b.b.a.h(2, this.wfP);
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
            btc btc = (btc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btc.kyG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    btc.wfP = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

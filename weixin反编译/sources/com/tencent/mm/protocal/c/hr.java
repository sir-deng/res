package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class hr extends a {
    public String kTk;
    public String vUi;
    public int ver;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vUi != null) {
                aVar.g(1, this.vUi);
            }
            if (this.kTk != null) {
                aVar.g(2, this.kTk);
            }
            aVar.fX(3, this.ver);
            return 0;
        } else if (i == 1) {
            if (this.vUi != null) {
                h = e.a.a.b.b.a.h(1, this.vUi) + 0;
            } else {
                h = 0;
            }
            if (this.kTk != null) {
                h += e.a.a.b.b.a.h(2, this.kTk);
            }
            return h + e.a.a.a.fU(3, this.ver);
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
            hr hrVar = (hr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hrVar.vUi = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    hrVar.kTk = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    hrVar.ver = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

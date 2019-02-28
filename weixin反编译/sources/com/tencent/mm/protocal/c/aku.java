package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aku extends a {
    public String wyM;
    public String wyN;
    public int wyO;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyM != null) {
                aVar.g(1, this.wyM);
            }
            if (this.wyN != null) {
                aVar.g(2, this.wyN);
            }
            aVar.fX(3, this.wyO);
            return 0;
        } else if (i == 1) {
            if (this.wyM != null) {
                h = e.a.a.b.b.a.h(1, this.wyM) + 0;
            } else {
                h = 0;
            }
            if (this.wyN != null) {
                h += e.a.a.b.b.a.h(2, this.wyN);
            }
            return h + e.a.a.a.fU(3, this.wyO);
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
            aku aku = (aku) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aku.wyM = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aku.wyN = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aku.wyO = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

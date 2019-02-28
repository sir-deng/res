package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aqv extends a {
    public String bssid;
    public int ful;
    public String ssid;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ssid != null) {
                aVar.g(1, this.ssid);
            }
            if (this.bssid != null) {
                aVar.g(2, this.bssid);
            }
            aVar.fX(3, this.ful);
            return 0;
        } else if (i == 1) {
            if (this.ssid != null) {
                h = e.a.a.b.b.a.h(1, this.ssid) + 0;
            } else {
                h = 0;
            }
            if (this.bssid != null) {
                h += e.a.a.b.b.a.h(2, this.bssid);
            }
            return h + e.a.a.a.fU(3, this.ful);
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
            aqv aqv = (aqv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqv.ssid = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aqv.bssid = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aqv.ful = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aqw extends a {
    public String bssid;
    public String fqu;
    public int ful;
    public int mIj;
    public String ssid;
    public int wEp;
    public String wEq;

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
            aVar.fX(4, this.wEp);
            if (this.wEq != null) {
                aVar.g(5, this.wEq);
            }
            if (this.fqu != null) {
                aVar.g(6, this.fqu);
            }
            aVar.fX(7, this.mIj);
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
            h = (h + e.a.a.a.fU(3, this.ful)) + e.a.a.a.fU(4, this.wEp);
            if (this.wEq != null) {
                h += e.a.a.b.b.a.h(5, this.wEq);
            }
            if (this.fqu != null) {
                h += e.a.a.b.b.a.h(6, this.fqu);
            }
            return h + e.a.a.a.fU(7, this.mIj);
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
            aqw aqw = (aqw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqw.ssid = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aqw.bssid = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aqw.ful = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aqw.wEp = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aqw.wEq = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aqw.fqu = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    aqw.mIj = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

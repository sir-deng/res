package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class fg extends a {
    public String imei;
    public String vRM;
    public String vRN;
    public String vRO;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.imei != null) {
                aVar.g(1, this.imei);
            }
            if (this.vRM != null) {
                aVar.g(2, this.vRM);
            }
            if (this.vRN != null) {
                aVar.g(3, this.vRN);
            }
            if (this.vRO == null) {
                return 0;
            }
            aVar.g(4, this.vRO);
            return 0;
        } else if (i == 1) {
            if (this.imei != null) {
                h = e.a.a.b.b.a.h(1, this.imei) + 0;
            } else {
                h = 0;
            }
            if (this.vRM != null) {
                h += e.a.a.b.b.a.h(2, this.vRM);
            }
            if (this.vRN != null) {
                h += e.a.a.b.b.a.h(3, this.vRN);
            }
            if (this.vRO != null) {
                h += e.a.a.b.b.a.h(4, this.vRO);
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
            fg fgVar = (fg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fgVar.imei = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    fgVar.vRM = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    fgVar.vRN = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    fgVar.vRO = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

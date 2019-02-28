package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class cac extends a {
    public String kzN;
    public String xgB;
    public long xgD;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xgB == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.kzN == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.xgB != null) {
                    aVar.g(1, this.xgB);
                }
                if (this.kzN != null) {
                    aVar.g(2, this.kzN);
                }
                aVar.S(3, this.xgD);
                return 0;
            }
        } else if (i == 1) {
            if (this.xgB != null) {
                h = e.a.a.b.b.a.h(1, this.xgB) + 0;
            } else {
                h = 0;
            }
            if (this.kzN != null) {
                h += e.a.a.b.b.a.h(2, this.kzN);
            }
            return h + e.a.a.a.R(3, this.xgD);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.xgB == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.kzN != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cac cac = (cac) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cac.xgB = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cac.kzN = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cac.xgD = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

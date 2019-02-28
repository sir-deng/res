package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class cay extends a {
    public String xgY;
    public String xgZ;
    public String xha;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xgY == null) {
                throw new b("Not all required fields were included: Plugin");
            } else if (this.xgZ == null) {
                throw new b("Not all required fields were included: ActivityPath");
            } else {
                if (this.xgY != null) {
                    aVar.g(1, this.xgY);
                }
                if (this.xgZ != null) {
                    aVar.g(2, this.xgZ);
                }
                if (this.xha == null) {
                    return 0;
                }
                aVar.g(3, this.xha);
                return 0;
            }
        } else if (i == 1) {
            if (this.xgY != null) {
                h = e.a.a.b.b.a.h(1, this.xgY) + 0;
            } else {
                h = 0;
            }
            if (this.xgZ != null) {
                h += e.a.a.b.b.a.h(2, this.xgZ);
            }
            if (this.xha != null) {
                h += e.a.a.b.b.a.h(3, this.xha);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.xgY == null) {
                throw new b("Not all required fields were included: Plugin");
            } else if (this.xgZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ActivityPath");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cay cay = (cay) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cay.xgY = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cay.xgZ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cay.xha = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

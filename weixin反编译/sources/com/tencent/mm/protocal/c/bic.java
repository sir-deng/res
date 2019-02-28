package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bic extends a {
    public String fqG;
    public String username;
    public boolean wSN;
    public String wSO;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.am(2, this.wSN);
            if (this.fqG != null) {
                aVar.g(3, this.fqG);
            }
            if (this.wSO == null) {
                return 0;
            }
            aVar.g(4, this.wSO);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.b.b.a.dX(2) + 1;
            if (this.fqG != null) {
                h += e.a.a.b.b.a.h(3, this.fqG);
            }
            if (this.wSO != null) {
                h += e.a.a.b.b.a.h(4, this.wSO);
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
            bic bic = (bic) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bic.username = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bic.wSN = aVar3.cKv();
                    return 0;
                case 3:
                    bic.fqG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bic.wSO = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

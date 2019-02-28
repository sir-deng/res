package com.tencent.mm.h.a.a;

import com.tencent.mm.bp.a;

public final class b extends a {
    public String gDt;
    public int gDu;
    public String gDv;
    public String userName;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.userName != null) {
                aVar.g(1, this.userName);
            }
            if (this.gDt != null) {
                aVar.g(2, this.gDt);
            }
            aVar.fX(3, this.gDu);
            if (this.gDv == null) {
                return 0;
            }
            aVar.g(4, this.gDv);
            return 0;
        } else if (i == 1) {
            if (this.userName != null) {
                h = e.a.a.b.b.a.h(1, this.userName) + 0;
            } else {
                h = 0;
            }
            if (this.gDt != null) {
                h += e.a.a.b.b.a.h(2, this.gDt);
            }
            h += e.a.a.a.fU(3, this.gDu);
            if (this.gDv != null) {
                h += e.a.a.b.b.a.h(4, this.gDv);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.userName = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bVar.gDt = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bVar.gDu = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bVar.gDv = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

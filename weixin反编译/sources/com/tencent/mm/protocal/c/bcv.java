package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bcv extends a {
    public String lTP;
    public String vSj;
    public int wOt;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.lTP != null) {
                aVar.g(1, this.lTP);
            }
            if (this.vSj != null) {
                aVar.g(2, this.vSj);
            }
            aVar.fX(3, this.wOt);
            return 0;
        } else if (i == 1) {
            if (this.lTP != null) {
                h = e.a.a.b.b.a.h(1, this.lTP) + 0;
            } else {
                h = 0;
            }
            if (this.vSj != null) {
                h += e.a.a.b.b.a.h(2, this.vSj);
            }
            return h + e.a.a.a.fU(3, this.wOt);
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
            bcv bcv = (bcv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcv.lTP = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bcv.vSj = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bcv.wOt = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

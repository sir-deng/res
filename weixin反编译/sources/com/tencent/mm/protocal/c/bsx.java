package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bsx extends a {
    public String qmh;
    public int qmi;
    public String scope;
    public int state;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.g(1, this.scope);
            }
            if (this.qmh != null) {
                aVar.g(2, this.qmh);
            }
            aVar.fX(3, this.state);
            aVar.fX(4, this.qmi);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                h = e.a.a.b.b.a.h(1, this.scope) + 0;
            } else {
                h = 0;
            }
            if (this.qmh != null) {
                h += e.a.a.b.b.a.h(2, this.qmh);
            }
            return (h + e.a.a.a.fU(3, this.state)) + e.a.a.a.fU(4, this.qmi);
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
            bsx bsx = (bsx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bsx.scope = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bsx.qmh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bsx.state = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bsx.qmi = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

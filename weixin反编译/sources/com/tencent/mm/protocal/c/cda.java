package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class cda extends a {
    public int scene;
    public String xiw;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xiw != null) {
                aVar.g(1, this.xiw);
            }
            aVar.fX(2, this.scene);
            return 0;
        } else if (i == 1) {
            if (this.xiw != null) {
                h = e.a.a.b.b.a.h(1, this.xiw) + 0;
            } else {
                h = 0;
            }
            return h + e.a.a.a.fU(2, this.scene);
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
            cda cda = (cda) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cda.xiw = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cda.scene = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

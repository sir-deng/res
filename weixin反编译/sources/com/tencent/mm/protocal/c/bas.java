package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bas extends a {
    public String lTP;
    public int wOt;
    public String wju;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.lTP != null) {
                aVar.g(1, this.lTP);
            }
            aVar.fX(2, this.wOt);
            if (this.wju == null) {
                return 0;
            }
            aVar.g(3, this.wju);
            return 0;
        } else if (i == 1) {
            if (this.lTP != null) {
                h = e.a.a.b.b.a.h(1, this.lTP) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.wOt);
            if (this.wju != null) {
                h += e.a.a.b.b.a.h(3, this.wju);
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
            bas bas = (bas) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bas.lTP = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bas.wOt = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bas.wju = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

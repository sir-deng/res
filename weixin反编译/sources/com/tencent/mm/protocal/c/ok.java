package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ok extends a {
    public String fGh;
    public String path;
    public int qnM;
    public long wef;

    protected final int a(int i, Object... objArr) {
        int R;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.wef);
            aVar.fX(2, this.qnM);
            if (this.fGh != null) {
                aVar.g(3, this.fGh);
            }
            if (this.path != null) {
                aVar.g(4, this.path);
            }
            return 0;
        } else if (i == 1) {
            R = (e.a.a.a.R(1, this.wef) + 0) + e.a.a.a.fU(2, this.qnM);
            if (this.fGh != null) {
                R += e.a.a.b.b.a.h(3, this.fGh);
            }
            if (this.path != null) {
                return R + e.a.a.b.b.a.h(4, this.path);
            }
            return R;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ok okVar = (ok) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    okVar.wef = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    okVar.qnM = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    okVar.fGh = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    okVar.path = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

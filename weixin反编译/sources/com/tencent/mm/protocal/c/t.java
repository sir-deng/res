package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class t extends a {
    public long vJR;
    public String vKe;
    public long vKf;
    public int vKg;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vKe != null) {
                aVar.g(1, this.vKe);
            }
            aVar.S(2, this.vJR);
            aVar.S(3, this.vKf);
            aVar.fX(4, this.vKg);
            return 0;
        } else if (i == 1) {
            if (this.vKe != null) {
                h = e.a.a.b.b.a.h(1, this.vKe) + 0;
            } else {
                h = 0;
            }
            return ((h + e.a.a.a.R(2, this.vJR)) + e.a.a.a.R(3, this.vKf)) + e.a.a.a.fU(4, this.vKg);
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
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.vKe = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    tVar.vJR = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    tVar.vKf = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    tVar.vKg = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

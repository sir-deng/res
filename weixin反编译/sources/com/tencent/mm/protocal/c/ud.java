package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ud extends a {
    public String nkW;
    public long pXa;
    public int wiW;

    protected final int a(int i, Object... objArr) {
        int R;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.pXa);
            if (this.nkW != null) {
                aVar.g(2, this.nkW);
            }
            aVar.fX(3, this.wiW);
            return 0;
        } else if (i == 1) {
            R = e.a.a.a.R(1, this.pXa) + 0;
            if (this.nkW != null) {
                R += e.a.a.b.b.a.h(2, this.nkW);
            }
            return R + e.a.a.a.fU(3, this.wiW);
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
            ud udVar = (ud) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    udVar.pXa = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    udVar.nkW = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    udVar.wiW = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

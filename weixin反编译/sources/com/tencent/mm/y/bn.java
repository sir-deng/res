package com.tencent.mm.y;

import com.tencent.mm.bp.a;

public final class bn extends a {
    public String hjk;
    public long hjl;
    public int key;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.key);
            if (this.hjk != null) {
                aVar.g(2, this.hjk);
            }
            aVar.S(3, this.hjl);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.key) + 0;
            if (this.hjk != null) {
                fU += e.a.a.b.b.a.h(2, this.hjk);
            }
            return fU + e.a.a.a.R(3, this.hjl);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bn bnVar = (bn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bnVar.key = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bnVar.hjk = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bnVar.hjl = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

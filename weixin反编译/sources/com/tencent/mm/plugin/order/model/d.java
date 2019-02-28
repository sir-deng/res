package com.tencent.mm.plugin.order.model;

import com.tencent.mm.bp.a;

public final class d extends a {
    public int month;
    public String pgI;
    public int year;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.year);
            aVar.fX(2, this.month);
            if (this.pgI != null) {
                aVar.g(3, this.pgI);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.year) + 0) + e.a.a.a.fU(2, this.month);
            if (this.pgI != null) {
                return fU + e.a.a.b.b.a.h(3, this.pgI);
            }
            return fU;
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
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.year = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    dVar.month = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    dVar.pgI = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

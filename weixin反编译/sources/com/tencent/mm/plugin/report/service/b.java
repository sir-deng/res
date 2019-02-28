package com.tencent.mm.plugin.report.service;

import com.tencent.mm.bp.a;

public final class b extends a {
    public int fgJ;
    public int pWg;
    public int pWh;
    public boolean pWi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.fgJ);
            aVar.fX(2, this.pWg);
            aVar.fX(3, this.pWh);
            aVar.am(4, this.pWi);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fU(1, this.fgJ) + 0) + e.a.a.a.fU(2, this.pWg)) + e.a.a.a.fU(3, this.pWh)) + (e.a.a.b.b.a.dX(4) + 1);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
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
                        bVar.fgJ = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        bVar.pWg = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        bVar.pWh = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        bVar.pWi = aVar3.cKv();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class sb extends a {
    public boolean wgH;
    public boolean wgI;
    public String wgJ;

    protected final int a(int i, Object... objArr) {
        int dX;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.am(1, this.wgH);
            aVar.am(2, this.wgI);
            if (this.wgJ != null) {
                aVar.g(3, this.wgJ);
            }
            return 0;
        } else if (i == 1) {
            dX = ((e.a.a.b.b.a.dX(1) + 1) + 0) + (e.a.a.b.b.a.dX(2) + 1);
            if (this.wgJ != null) {
                return dX + e.a.a.b.b.a.h(3, this.wgJ);
            }
            return dX;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (dX = a.a(aVar2); dX > 0; dX = a.a(aVar2)) {
                if (!super.a(aVar2, this, dX)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sb sbVar = (sb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sbVar.wgH = aVar3.cKv();
                    return 0;
                case 2:
                    sbVar.wgI = aVar3.cKv();
                    return 0;
                case 3:
                    sbVar.wgJ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

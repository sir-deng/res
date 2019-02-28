package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aqp extends a {
    public boolean wDZ;
    public boolean wEa;
    public int wEb;
    public int wEc;
    public String wEd;
    public boolean wEe;

    protected final int a(int i, Object... objArr) {
        int dX;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.am(1, this.wDZ);
            aVar.am(2, this.wEa);
            aVar.fX(3, this.wEb);
            aVar.fX(4, this.wEc);
            if (this.wEd != null) {
                aVar.g(5, this.wEd);
            }
            aVar.am(6, this.wEe);
            return 0;
        } else if (i == 1) {
            dX = ((((e.a.a.b.b.a.dX(1) + 1) + 0) + (e.a.a.b.b.a.dX(2) + 1)) + e.a.a.a.fU(3, this.wEb)) + e.a.a.a.fU(4, this.wEc);
            if (this.wEd != null) {
                dX += e.a.a.b.b.a.h(5, this.wEd);
            }
            return dX + (e.a.a.b.b.a.dX(6) + 1);
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
            aqp aqp = (aqp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqp.wDZ = aVar3.cKv();
                    return 0;
                case 2:
                    aqp.wEa = aVar3.cKv();
                    return 0;
                case 3:
                    aqp.wEb = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aqp.wEc = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aqp.wEd = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aqp.wEe = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

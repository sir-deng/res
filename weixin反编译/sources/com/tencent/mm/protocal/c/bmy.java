package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bmy extends a {
    public String appName;
    public int blZ;
    public String wWT;
    public boolean wWU;
    public boolean wWV;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wWT != null) {
                aVar.g(1, this.wWT);
            }
            if (this.appName != null) {
                aVar.g(2, this.appName);
            }
            aVar.fX(3, this.blZ);
            aVar.am(4, this.wWU);
            aVar.am(5, this.wWV);
            return 0;
        } else if (i == 1) {
            if (this.wWT != null) {
                h = e.a.a.b.b.a.h(1, this.wWT) + 0;
            } else {
                h = 0;
            }
            if (this.appName != null) {
                h += e.a.a.b.b.a.h(2, this.appName);
            }
            return ((h + e.a.a.a.fU(3, this.blZ)) + (e.a.a.b.b.a.dX(4) + 1)) + (e.a.a.b.b.a.dX(5) + 1);
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
            bmy bmy = (bmy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bmy.wWT = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bmy.appName = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bmy.blZ = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bmy.wWU = aVar3.cKv();
                    return 0;
                case 5:
                    bmy.wWV = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

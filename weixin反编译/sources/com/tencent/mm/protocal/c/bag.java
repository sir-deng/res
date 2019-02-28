package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bag extends a {
    public int wNI;
    public String wgY;
    public int wio;
    public String wnK;
    public int wtY;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wtY);
            if (this.wnK != null) {
                aVar.g(2, this.wnK);
            }
            if (this.wgY != null) {
                aVar.g(3, this.wgY);
            }
            aVar.fX(4, this.wio);
            aVar.fX(5, this.wNI);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wtY) + 0;
            if (this.wnK != null) {
                fU += e.a.a.b.b.a.h(2, this.wnK);
            }
            if (this.wgY != null) {
                fU += e.a.a.b.b.a.h(3, this.wgY);
            }
            return (fU + e.a.a.a.fU(4, this.wio)) + e.a.a.a.fU(5, this.wNI);
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
            bag bag = (bag) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bag.wtY = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bag.wnK = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bag.wgY = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bag.wio = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bag.wNI = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

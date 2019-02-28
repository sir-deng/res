package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ala extends a {
    public String npE;
    public float vUR;
    public float vUS;
    public float wyX;
    public String wyY;

    protected final int a(int i, Object... objArr) {
        int dX;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.m(1, this.vUR);
            aVar.m(2, this.vUS);
            aVar.m(3, this.wyX);
            if (this.npE != null) {
                aVar.g(4, this.npE);
            }
            if (this.wyY != null) {
                aVar.g(5, this.wyY);
            }
            return 0;
        } else if (i == 1) {
            dX = (((e.a.a.b.b.a.dX(1) + 4) + 0) + (e.a.a.b.b.a.dX(2) + 4)) + (e.a.a.b.b.a.dX(3) + 4);
            if (this.npE != null) {
                dX += e.a.a.b.b.a.h(4, this.npE);
            }
            if (this.wyY != null) {
                return dX + e.a.a.b.b.a.h(5, this.wyY);
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
            ala ala = (ala) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ala.vUR = aVar3.AEQ.readFloat();
                    return 0;
                case 2:
                    ala.vUS = aVar3.AEQ.readFloat();
                    return 0;
                case 3:
                    ala.wyX = aVar3.AEQ.readFloat();
                    return 0;
                case 4:
                    ala.npE = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ala.wyY = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

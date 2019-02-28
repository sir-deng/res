package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bxd extends a {
    public String xeK;
    public String xeL;
    public String xeM;
    public String xeN;
    public int xeO;
    public float xeP;
    public float xeQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xeK != null) {
                aVar.g(1, this.xeK);
            }
            if (this.xeL != null) {
                aVar.g(2, this.xeL);
            }
            if (this.xeM != null) {
                aVar.g(3, this.xeM);
            }
            if (this.xeN != null) {
                aVar.g(4, this.xeN);
            }
            aVar.fX(5, this.xeO);
            aVar.m(6, this.xeP);
            aVar.m(7, this.xeQ);
            return 0;
        } else if (i == 1) {
            if (this.xeK != null) {
                h = e.a.a.b.b.a.h(1, this.xeK) + 0;
            } else {
                h = 0;
            }
            if (this.xeL != null) {
                h += e.a.a.b.b.a.h(2, this.xeL);
            }
            if (this.xeM != null) {
                h += e.a.a.b.b.a.h(3, this.xeM);
            }
            if (this.xeN != null) {
                h += e.a.a.b.b.a.h(4, this.xeN);
            }
            return ((h + e.a.a.a.fU(5, this.xeO)) + (e.a.a.b.b.a.dX(6) + 4)) + (e.a.a.b.b.a.dX(7) + 4);
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
            bxd bxd = (bxd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bxd.xeK = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bxd.xeL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bxd.xeM = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bxd.xeN = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bxd.xeO = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bxd.xeP = aVar3.AEQ.readFloat();
                    return 0;
                case 7:
                    bxd.xeQ = aVar3.AEQ.readFloat();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

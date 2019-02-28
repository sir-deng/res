package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class btz extends a {
    public String pWq;
    public String wRd;
    public String woW;
    public String xbB;
    public int xbC;
    public String xbD;
    public String xbE;
    public int xbF;
    public String xbG;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pWq != null) {
                aVar.g(1, this.pWq);
            }
            if (this.xbB != null) {
                aVar.g(2, this.xbB);
            }
            if (this.woW != null) {
                aVar.g(3, this.woW);
            }
            aVar.fX(4, this.xbC);
            if (this.wRd != null) {
                aVar.g(5, this.wRd);
            }
            if (this.xbD != null) {
                aVar.g(6, this.xbD);
            }
            if (this.xbE != null) {
                aVar.g(7, this.xbE);
            }
            aVar.fX(8, this.xbF);
            if (this.xbG == null) {
                return 0;
            }
            aVar.g(9, this.xbG);
            return 0;
        } else if (i == 1) {
            if (this.pWq != null) {
                h = e.a.a.b.b.a.h(1, this.pWq) + 0;
            } else {
                h = 0;
            }
            if (this.xbB != null) {
                h += e.a.a.b.b.a.h(2, this.xbB);
            }
            if (this.woW != null) {
                h += e.a.a.b.b.a.h(3, this.woW);
            }
            h += e.a.a.a.fU(4, this.xbC);
            if (this.wRd != null) {
                h += e.a.a.b.b.a.h(5, this.wRd);
            }
            if (this.xbD != null) {
                h += e.a.a.b.b.a.h(6, this.xbD);
            }
            if (this.xbE != null) {
                h += e.a.a.b.b.a.h(7, this.xbE);
            }
            h += e.a.a.a.fU(8, this.xbF);
            if (this.xbG != null) {
                h += e.a.a.b.b.a.h(9, this.xbG);
            }
            return h;
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
            btz btz = (btz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btz.pWq = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    btz.xbB = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    btz.woW = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    btz.xbC = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    btz.wRd = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    btz.xbD = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    btz.xbE = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    btz.xbF = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    btz.xbG = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

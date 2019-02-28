package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ajr extends a {
    public String kyG;
    public String kzN;
    public int vQL;
    public String vSF;
    public String woW;
    public String wxO;
    public String wxP;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vSF != null) {
                aVar.g(1, this.vSF);
            }
            if (this.kyG != null) {
                aVar.g(2, this.kyG);
            }
            if (this.wxO != null) {
                aVar.g(3, this.wxO);
            }
            if (this.wxP != null) {
                aVar.g(4, this.wxP);
            }
            aVar.fX(5, this.vQL);
            if (this.kzN != null) {
                aVar.g(6, this.kzN);
            }
            if (this.woW == null) {
                return 0;
            }
            aVar.g(7, this.woW);
            return 0;
        } else if (i == 1) {
            if (this.vSF != null) {
                h = e.a.a.b.b.a.h(1, this.vSF) + 0;
            } else {
                h = 0;
            }
            if (this.kyG != null) {
                h += e.a.a.b.b.a.h(2, this.kyG);
            }
            if (this.wxO != null) {
                h += e.a.a.b.b.a.h(3, this.wxO);
            }
            if (this.wxP != null) {
                h += e.a.a.b.b.a.h(4, this.wxP);
            }
            h += e.a.a.a.fU(5, this.vQL);
            if (this.kzN != null) {
                h += e.a.a.b.b.a.h(6, this.kzN);
            }
            if (this.woW != null) {
                h += e.a.a.b.b.a.h(7, this.woW);
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
            ajr ajr = (ajr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ajr.vSF = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ajr.kyG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ajr.wxO = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ajr.wxP = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ajr.vQL = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    ajr.kzN = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    ajr.woW = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

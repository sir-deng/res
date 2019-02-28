package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class byu extends a {
    public String pho;
    public int sfa;
    public String wDX;
    public String wQr;
    public String xfP;
    public String xfQ;
    public int xfR;
    public String xfS;
    public String xfT;
    public String xfU;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfP != null) {
                aVar.g(1, this.xfP);
            }
            if (this.xfQ != null) {
                aVar.g(2, this.xfQ);
            }
            if (this.wDX != null) {
                aVar.g(3, this.wDX);
            }
            if (this.wQr != null) {
                aVar.g(4, this.wQr);
            }
            aVar.fX(5, this.xfR);
            if (this.pho != null) {
                aVar.g(6, this.pho);
            }
            if (this.xfS != null) {
                aVar.g(7, this.xfS);
            }
            if (this.xfT != null) {
                aVar.g(8, this.xfT);
            }
            aVar.fX(9, this.sfa);
            if (this.xfU == null) {
                return 0;
            }
            aVar.g(19, this.xfU);
            return 0;
        } else if (i == 1) {
            if (this.xfP != null) {
                h = e.a.a.b.b.a.h(1, this.xfP) + 0;
            } else {
                h = 0;
            }
            if (this.xfQ != null) {
                h += e.a.a.b.b.a.h(2, this.xfQ);
            }
            if (this.wDX != null) {
                h += e.a.a.b.b.a.h(3, this.wDX);
            }
            if (this.wQr != null) {
                h += e.a.a.b.b.a.h(4, this.wQr);
            }
            h += e.a.a.a.fU(5, this.xfR);
            if (this.pho != null) {
                h += e.a.a.b.b.a.h(6, this.pho);
            }
            if (this.xfS != null) {
                h += e.a.a.b.b.a.h(7, this.xfS);
            }
            if (this.xfT != null) {
                h += e.a.a.b.b.a.h(8, this.xfT);
            }
            h += e.a.a.a.fU(9, this.sfa);
            if (this.xfU != null) {
                h += e.a.a.b.b.a.h(19, this.xfU);
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
            byu byu = (byu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    byu.xfP = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    byu.xfQ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    byu.wDX = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    byu.wQr = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    byu.xfR = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    byu.pho = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    byu.xfS = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    byu.xfT = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    byu.sfa = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    byu.xfU = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class we extends a {
    public String wbo;
    public long wmN;
    public long wmO;
    public long wmP;
    public String wmQ;
    public long wmR;
    public String wmS;
    public String wmT;
    public String wmU;
    public String wmV;
    public String wmW;
    public String wmX;
    public int wmY;
    public String wmZ;
    public int wna;

    protected final int a(int i, Object... objArr) {
        int R;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.wmN);
            aVar.S(2, this.wmO);
            aVar.S(3, this.wmP);
            if (this.wmQ != null) {
                aVar.g(4, this.wmQ);
            }
            aVar.S(5, this.wmR);
            if (this.wmS != null) {
                aVar.g(6, this.wmS);
            }
            if (this.wmT != null) {
                aVar.g(7, this.wmT);
            }
            if (this.wmU != null) {
                aVar.g(8, this.wmU);
            }
            if (this.wmV != null) {
                aVar.g(9, this.wmV);
            }
            if (this.wmW != null) {
                aVar.g(10, this.wmW);
            }
            if (this.wmX != null) {
                aVar.g(11, this.wmX);
            }
            aVar.fX(12, this.wmY);
            if (this.wmZ != null) {
                aVar.g(13, this.wmZ);
            }
            aVar.fX(14, this.wna);
            if (this.wbo != null) {
                aVar.g(15, this.wbo);
            }
            return 0;
        } else if (i == 1) {
            R = ((e.a.a.a.R(1, this.wmN) + 0) + e.a.a.a.R(2, this.wmO)) + e.a.a.a.R(3, this.wmP);
            if (this.wmQ != null) {
                R += e.a.a.b.b.a.h(4, this.wmQ);
            }
            R += e.a.a.a.R(5, this.wmR);
            if (this.wmS != null) {
                R += e.a.a.b.b.a.h(6, this.wmS);
            }
            if (this.wmT != null) {
                R += e.a.a.b.b.a.h(7, this.wmT);
            }
            if (this.wmU != null) {
                R += e.a.a.b.b.a.h(8, this.wmU);
            }
            if (this.wmV != null) {
                R += e.a.a.b.b.a.h(9, this.wmV);
            }
            if (this.wmW != null) {
                R += e.a.a.b.b.a.h(10, this.wmW);
            }
            if (this.wmX != null) {
                R += e.a.a.b.b.a.h(11, this.wmX);
            }
            R += e.a.a.a.fU(12, this.wmY);
            if (this.wmZ != null) {
                R += e.a.a.b.b.a.h(13, this.wmZ);
            }
            R += e.a.a.a.fU(14, this.wna);
            if (this.wbo != null) {
                return R + e.a.a.b.b.a.h(15, this.wbo);
            }
            return R;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            we weVar = (we) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    weVar.wmN = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    weVar.wmO = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    weVar.wmP = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    weVar.wmQ = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    weVar.wmR = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    weVar.wmS = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    weVar.wmT = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    weVar.wmU = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    weVar.wmV = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    weVar.wmW = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    weVar.wmX = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    weVar.wmY = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    weVar.wmZ = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    weVar.wna = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    weVar.wbo = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

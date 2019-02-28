package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bku extends a {
    public int kzz;
    public String noL;
    public int pgR;
    public int vON;
    public String vPp;
    public String wDh;
    public int wGC;
    public String wUH;
    public int wUm;
    public int wUn;
    public int wUo;
    public long wUp;
    public long wUq;
    public int wUs;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPp != null) {
                aVar.g(1, this.vPp);
            }
            if (this.wDh != null) {
                aVar.g(2, this.wDh);
            }
            aVar.fX(3, this.vON);
            aVar.fX(4, this.kzz);
            if (this.noL != null) {
                aVar.g(5, this.noL);
            }
            aVar.fX(6, this.pgR);
            aVar.fX(7, this.wUn);
            aVar.fX(8, this.wUm);
            if (this.wUH != null) {
                aVar.g(9, this.wUH);
            }
            aVar.fX(10, this.wUo);
            aVar.S(11, this.wUp);
            aVar.S(12, this.wUq);
            aVar.fX(13, this.wGC);
            aVar.fX(14, this.wUs);
            return 0;
        } else if (i == 1) {
            if (this.vPp != null) {
                h = e.a.a.b.b.a.h(1, this.vPp) + 0;
            } else {
                h = 0;
            }
            if (this.wDh != null) {
                h += e.a.a.b.b.a.h(2, this.wDh);
            }
            h = (h + e.a.a.a.fU(3, this.vON)) + e.a.a.a.fU(4, this.kzz);
            if (this.noL != null) {
                h += e.a.a.b.b.a.h(5, this.noL);
            }
            h = ((h + e.a.a.a.fU(6, this.pgR)) + e.a.a.a.fU(7, this.wUn)) + e.a.a.a.fU(8, this.wUm);
            if (this.wUH != null) {
                h += e.a.a.b.b.a.h(9, this.wUH);
            }
            return ((((h + e.a.a.a.fU(10, this.wUo)) + e.a.a.a.R(11, this.wUp)) + e.a.a.a.R(12, this.wUq)) + e.a.a.a.fU(13, this.wGC)) + e.a.a.a.fU(14, this.wUs);
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
            bku bku = (bku) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bku.vPp = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bku.wDh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bku.vON = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bku.kzz = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bku.noL = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bku.pgR = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bku.wUn = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bku.wUm = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bku.wUH = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    bku.wUo = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    bku.wUp = aVar3.AEQ.rA();
                    return 0;
                case 12:
                    bku.wUq = aVar3.AEQ.rA();
                    return 0;
                case 13:
                    bku.wGC = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    bku.wUs = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

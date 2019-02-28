package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class apl extends a {
    public float biF;
    public String country;
    public String hxg;
    public String nYL;
    public String rAh;
    public int rAj;
    public int rAl;
    public int score;
    public float vXx;
    public float vXy;
    public String wCS;
    public String wCT;
    public int wCU;
    public int wCV;
    public b wCW;
    public String wCX;

    protected final int a(int i, Object... objArr) {
        int dX;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.m(1, this.vXx);
            aVar.m(2, this.vXy);
            if (this.hxg != null) {
                aVar.g(3, this.hxg);
            }
            if (this.nYL != null) {
                aVar.g(4, this.nYL);
            }
            if (this.rAh != null) {
                aVar.g(5, this.rAh);
            }
            if (this.wCS != null) {
                aVar.g(6, this.wCS);
            }
            aVar.fX(7, this.rAj);
            if (this.wCT != null) {
                aVar.g(8, this.wCT);
            }
            aVar.fX(9, this.wCU);
            aVar.fX(10, this.wCV);
            aVar.fX(11, this.rAl);
            aVar.m(12, this.biF);
            if (this.wCW != null) {
                aVar.b(13, this.wCW);
            }
            aVar.fX(14, this.score);
            if (this.wCX != null) {
                aVar.g(15, this.wCX);
            }
            if (this.country != null) {
                aVar.g(16, this.country);
            }
            return 0;
        } else if (i == 1) {
            dX = ((e.a.a.b.b.a.dX(1) + 4) + 0) + (e.a.a.b.b.a.dX(2) + 4);
            if (this.hxg != null) {
                dX += e.a.a.b.b.a.h(3, this.hxg);
            }
            if (this.nYL != null) {
                dX += e.a.a.b.b.a.h(4, this.nYL);
            }
            if (this.rAh != null) {
                dX += e.a.a.b.b.a.h(5, this.rAh);
            }
            if (this.wCS != null) {
                dX += e.a.a.b.b.a.h(6, this.wCS);
            }
            dX += e.a.a.a.fU(7, this.rAj);
            if (this.wCT != null) {
                dX += e.a.a.b.b.a.h(8, this.wCT);
            }
            dX = (((dX + e.a.a.a.fU(9, this.wCU)) + e.a.a.a.fU(10, this.wCV)) + e.a.a.a.fU(11, this.rAl)) + (e.a.a.b.b.a.dX(12) + 4);
            if (this.wCW != null) {
                dX += e.a.a.a.a(13, this.wCW);
            }
            dX += e.a.a.a.fU(14, this.score);
            if (this.wCX != null) {
                dX += e.a.a.b.b.a.h(15, this.wCX);
            }
            if (this.country != null) {
                return dX + e.a.a.b.b.a.h(16, this.country);
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
            apl apl = (apl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    apl.vXx = aVar3.AEQ.readFloat();
                    return 0;
                case 2:
                    apl.vXy = aVar3.AEQ.readFloat();
                    return 0;
                case 3:
                    apl.hxg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    apl.nYL = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    apl.rAh = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    apl.wCS = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    apl.rAj = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    apl.wCT = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    apl.wCU = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    apl.wCV = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    apl.rAl = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    apl.biF = aVar3.AEQ.readFloat();
                    return 0;
                case 13:
                    apl.wCW = aVar3.cKw();
                    return 0;
                case 14:
                    apl.score = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    apl.wCX = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    apl.country = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

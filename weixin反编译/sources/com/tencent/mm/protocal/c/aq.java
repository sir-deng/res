package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aq extends a {
    public String hxj;
    public String kyG;
    public int kyY;
    public String kzN;
    public int vMd;
    public String vMe;
    public String vMf;
    public int vMg;
    public int vMh;
    public String vMi;
    public int vMj;
    public String vMk;
    public String vMl;
    public int vMm;
    public String vMn;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyG != null) {
                aVar.g(1, this.kyG);
            }
            if (this.kzN != null) {
                aVar.g(2, this.kzN);
            }
            aVar.fX(3, this.vMd);
            if (this.vMe != null) {
                aVar.g(4, this.vMe);
            }
            if (this.vMf != null) {
                aVar.g(5, this.vMf);
            }
            if (this.hxj != null) {
                aVar.g(6, this.hxj);
            }
            aVar.fX(8, this.kyY);
            aVar.fX(9, this.vMg);
            aVar.fX(10, this.vMh);
            if (this.vMi != null) {
                aVar.g(11, this.vMi);
            }
            aVar.fX(12, this.vMj);
            if (this.vMk != null) {
                aVar.g(13, this.vMk);
            }
            if (this.vMl != null) {
                aVar.g(14, this.vMl);
            }
            aVar.fX(15, this.vMm);
            if (this.vMn == null) {
                return 0;
            }
            aVar.g(16, this.vMn);
            return 0;
        } else if (i == 1) {
            if (this.kyG != null) {
                h = e.a.a.b.b.a.h(1, this.kyG) + 0;
            } else {
                h = 0;
            }
            if (this.kzN != null) {
                h += e.a.a.b.b.a.h(2, this.kzN);
            }
            h += e.a.a.a.fU(3, this.vMd);
            if (this.vMe != null) {
                h += e.a.a.b.b.a.h(4, this.vMe);
            }
            if (this.vMf != null) {
                h += e.a.a.b.b.a.h(5, this.vMf);
            }
            if (this.hxj != null) {
                h += e.a.a.b.b.a.h(6, this.hxj);
            }
            h = ((h + e.a.a.a.fU(8, this.kyY)) + e.a.a.a.fU(9, this.vMg)) + e.a.a.a.fU(10, this.vMh);
            if (this.vMi != null) {
                h += e.a.a.b.b.a.h(11, this.vMi);
            }
            h += e.a.a.a.fU(12, this.vMj);
            if (this.vMk != null) {
                h += e.a.a.b.b.a.h(13, this.vMk);
            }
            if (this.vMl != null) {
                h += e.a.a.b.b.a.h(14, this.vMl);
            }
            h += e.a.a.a.fU(15, this.vMm);
            if (this.vMn != null) {
                h += e.a.a.b.b.a.h(16, this.vMn);
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
            aq aqVar = (aq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqVar.kyG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aqVar.kzN = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aqVar.vMd = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aqVar.vMe = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aqVar.vMf = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aqVar.hxj = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    aqVar.kyY = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    aqVar.vMg = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    aqVar.vMh = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    aqVar.vMi = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    aqVar.vMj = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    aqVar.vMk = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    aqVar.vMl = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    aqVar.vMm = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    aqVar.vMn = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

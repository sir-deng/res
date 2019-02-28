package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class sx extends a {
    public String nlA;
    public String vPI;
    public int whA;
    public String whD;
    public int whE;
    public String whF;
    public String whG;
    public String whH;
    public String whI;
    public String whM;
    public String whv;
    public String whw;
    public String whx;
    public String why;
    public int whz;
    public int wid;
    public String wie;
    public String wif;
    public String wig;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPI != null) {
                aVar.g(1, this.vPI);
            }
            if (this.nlA != null) {
                aVar.g(2, this.nlA);
            }
            if (this.whv != null) {
                aVar.g(3, this.whv);
            }
            if (this.whw != null) {
                aVar.g(4, this.whw);
            }
            if (this.whx != null) {
                aVar.g(5, this.whx);
            }
            if (this.why != null) {
                aVar.g(6, this.why);
            }
            aVar.fX(7, this.whz);
            aVar.fX(8, this.whA);
            if (this.whD != null) {
                aVar.g(9, this.whD);
            }
            aVar.fX(10, this.whE);
            if (this.whF != null) {
                aVar.g(11, this.whF);
            }
            aVar.fX(12, this.wid);
            if (this.whI != null) {
                aVar.g(13, this.whI);
            }
            if (this.whG != null) {
                aVar.g(14, this.whG);
            }
            if (this.whH != null) {
                aVar.g(15, this.whH);
            }
            if (this.wie != null) {
                aVar.g(16, this.wie);
            }
            if (this.whM != null) {
                aVar.g(17, this.whM);
            }
            if (this.wif != null) {
                aVar.g(18, this.wif);
            }
            if (this.wig == null) {
                return 0;
            }
            aVar.g(19, this.wig);
            return 0;
        } else if (i == 1) {
            if (this.vPI != null) {
                h = e.a.a.b.b.a.h(1, this.vPI) + 0;
            } else {
                h = 0;
            }
            if (this.nlA != null) {
                h += e.a.a.b.b.a.h(2, this.nlA);
            }
            if (this.whv != null) {
                h += e.a.a.b.b.a.h(3, this.whv);
            }
            if (this.whw != null) {
                h += e.a.a.b.b.a.h(4, this.whw);
            }
            if (this.whx != null) {
                h += e.a.a.b.b.a.h(5, this.whx);
            }
            if (this.why != null) {
                h += e.a.a.b.b.a.h(6, this.why);
            }
            h = (h + e.a.a.a.fU(7, this.whz)) + e.a.a.a.fU(8, this.whA);
            if (this.whD != null) {
                h += e.a.a.b.b.a.h(9, this.whD);
            }
            h += e.a.a.a.fU(10, this.whE);
            if (this.whF != null) {
                h += e.a.a.b.b.a.h(11, this.whF);
            }
            h += e.a.a.a.fU(12, this.wid);
            if (this.whI != null) {
                h += e.a.a.b.b.a.h(13, this.whI);
            }
            if (this.whG != null) {
                h += e.a.a.b.b.a.h(14, this.whG);
            }
            if (this.whH != null) {
                h += e.a.a.b.b.a.h(15, this.whH);
            }
            if (this.wie != null) {
                h += e.a.a.b.b.a.h(16, this.wie);
            }
            if (this.whM != null) {
                h += e.a.a.b.b.a.h(17, this.whM);
            }
            if (this.wif != null) {
                h += e.a.a.b.b.a.h(18, this.wif);
            }
            if (this.wig != null) {
                h += e.a.a.b.b.a.h(19, this.wig);
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
            sx sxVar = (sx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sxVar.vPI = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    sxVar.nlA = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    sxVar.whv = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    sxVar.whw = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    sxVar.whx = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    sxVar.why = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    sxVar.whz = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    sxVar.whA = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    sxVar.whD = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    sxVar.whE = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    sxVar.whF = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    sxVar.wid = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    sxVar.whI = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    sxVar.whG = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    sxVar.whH = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    sxVar.wie = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    sxVar.whM = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    sxVar.wif = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    sxVar.wig = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

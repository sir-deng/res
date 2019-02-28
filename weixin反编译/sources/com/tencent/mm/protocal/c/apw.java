package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;

public final class apw extends a {
    public String fGh;
    public String wDA;
    public String wDB;
    public String wDC;
    public String wDk;
    public String wDl;
    public String wDm;
    public String wDn;
    public int wDo;
    public int wDp;
    public String wDq;
    public int wDr;
    public int wDs;
    public String wDt;
    public int wDu;
    public int wDv;
    public String wDw;
    public int wDx;
    public int wDy;
    public String wDz;
    public String wbJ;
    public int wgd;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fGh != null) {
                aVar.g(1, this.fGh);
            }
            if (this.wDk != null) {
                aVar.g(20, this.wDk);
            }
            if (this.wDl != null) {
                aVar.g(21, this.wDl);
            }
            if (this.wDm != null) {
                aVar.g(22, this.wDm);
            }
            if (this.wDn != null) {
                aVar.g(23, this.wDn);
            }
            if (this.wbJ != null) {
                aVar.g(31, this.wbJ);
            }
            aVar.fX(32, this.wDo);
            aVar.fX(33, this.wDp);
            if (this.wDq != null) {
                aVar.g(34, this.wDq);
            }
            aVar.fX(35, this.wDr);
            aVar.fX(36, this.wDs);
            if (this.wDt != null) {
                aVar.g(37, this.wDt);
            }
            aVar.fX(38, this.wDu);
            aVar.fX(39, this.wDv);
            if (this.wDw != null) {
                aVar.g(41, this.wDw);
            }
            aVar.fX(200, this.wDx);
            aVar.fX(201, this.wDy);
            aVar.fX(202, this.wgd);
            if (this.wDz != null) {
                aVar.g(203, this.wDz);
            }
            if (this.wDA != null) {
                aVar.g(d.CTRL_INDEX, this.wDA);
            }
            if (this.wDB != null) {
                aVar.g(g.CTRL_INDEX, this.wDB);
            }
            if (this.wDC == null) {
                return 0;
            }
            aVar.g(b.CTRL_INDEX, this.wDC);
            return 0;
        } else if (i == 1) {
            if (this.fGh != null) {
                h = e.a.a.b.b.a.h(1, this.fGh) + 0;
            } else {
                h = 0;
            }
            if (this.wDk != null) {
                h += e.a.a.b.b.a.h(20, this.wDk);
            }
            if (this.wDl != null) {
                h += e.a.a.b.b.a.h(21, this.wDl);
            }
            if (this.wDm != null) {
                h += e.a.a.b.b.a.h(22, this.wDm);
            }
            if (this.wDn != null) {
                h += e.a.a.b.b.a.h(23, this.wDn);
            }
            if (this.wbJ != null) {
                h += e.a.a.b.b.a.h(31, this.wbJ);
            }
            h = (h + e.a.a.a.fU(32, this.wDo)) + e.a.a.a.fU(33, this.wDp);
            if (this.wDq != null) {
                h += e.a.a.b.b.a.h(34, this.wDq);
            }
            h = (h + e.a.a.a.fU(35, this.wDr)) + e.a.a.a.fU(36, this.wDs);
            if (this.wDt != null) {
                h += e.a.a.b.b.a.h(37, this.wDt);
            }
            h = (h + e.a.a.a.fU(38, this.wDu)) + e.a.a.a.fU(39, this.wDv);
            if (this.wDw != null) {
                h += e.a.a.b.b.a.h(41, this.wDw);
            }
            h = ((h + e.a.a.a.fU(200, this.wDx)) + e.a.a.a.fU(201, this.wDy)) + e.a.a.a.fU(202, this.wgd);
            if (this.wDz != null) {
                h += e.a.a.b.b.a.h(203, this.wDz);
            }
            if (this.wDA != null) {
                h += e.a.a.b.b.a.h(d.CTRL_INDEX, this.wDA);
            }
            if (this.wDB != null) {
                h += e.a.a.b.b.a.h(g.CTRL_INDEX, this.wDB);
            }
            if (this.wDC != null) {
                h += e.a.a.b.b.a.h(b.CTRL_INDEX, this.wDC);
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
            apw apw = (apw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    apw.fGh = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    apw.wDk = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    apw.wDl = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    apw.wDm = aVar3.AEQ.readString();
                    return 0;
                case 23:
                    apw.wDn = aVar3.AEQ.readString();
                    return 0;
                case 31:
                    apw.wbJ = aVar3.AEQ.readString();
                    return 0;
                case 32:
                    apw.wDo = aVar3.AEQ.rz();
                    return 0;
                case 33:
                    apw.wDp = aVar3.AEQ.rz();
                    return 0;
                case 34:
                    apw.wDq = aVar3.AEQ.readString();
                    return 0;
                case 35:
                    apw.wDr = aVar3.AEQ.rz();
                    return 0;
                case 36:
                    apw.wDs = aVar3.AEQ.rz();
                    return 0;
                case 37:
                    apw.wDt = aVar3.AEQ.readString();
                    return 0;
                case 38:
                    apw.wDu = aVar3.AEQ.rz();
                    return 0;
                case 39:
                    apw.wDv = aVar3.AEQ.rz();
                    return 0;
                case 41:
                    apw.wDw = aVar3.AEQ.readString();
                    return 0;
                case 200:
                    apw.wDx = aVar3.AEQ.rz();
                    return 0;
                case 201:
                    apw.wDy = aVar3.AEQ.rz();
                    return 0;
                case 202:
                    apw.wgd = aVar3.AEQ.rz();
                    return 0;
                case 203:
                    apw.wDz = aVar3.AEQ.readString();
                    return 0;
                case d.CTRL_INDEX /*204*/:
                    apw.wDA = aVar3.AEQ.readString();
                    return 0;
                case g.CTRL_INDEX /*205*/:
                    apw.wDB = aVar3.AEQ.readString();
                    return 0;
                case b.CTRL_INDEX /*206*/:
                    apw.wDC = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

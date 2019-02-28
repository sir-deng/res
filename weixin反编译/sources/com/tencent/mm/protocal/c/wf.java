package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class wf extends a {
    public boolean wnb;
    public boolean wnc;
    public boolean wnd;
    public boolean wne;
    public boolean wnf;
    public boolean wng;
    public boolean wnh;
    public boolean wni;
    public boolean wnj;
    public boolean wnk;
    public boolean wnl;
    public boolean wnm;
    public boolean wnn;
    public boolean wno;
    public boolean wnp;
    public boolean wnq;
    public boolean wnr;
    public boolean wns;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.am(1, this.wnb);
            aVar.am(2, this.wnc);
            aVar.am(3, this.wnd);
            aVar.am(4, this.wne);
            aVar.am(5, this.wnf);
            aVar.am(6, this.wng);
            aVar.am(7, this.wnh);
            aVar.am(8, this.wni);
            aVar.am(9, this.wnj);
            aVar.am(10, this.wnk);
            aVar.am(11, this.wnl);
            aVar.am(12, this.wnm);
            aVar.am(13, this.wnn);
            aVar.am(14, this.wno);
            aVar.am(15, this.wnp);
            aVar.am(16, this.wnq);
            aVar.am(17, this.wnr);
            aVar.am(18, this.wns);
            return 0;
        } else if (i == 1) {
            return ((((((((((((((((((e.a.a.b.b.a.dX(1) + 1) + 0) + (e.a.a.b.b.a.dX(2) + 1)) + (e.a.a.b.b.a.dX(3) + 1)) + (e.a.a.b.b.a.dX(4) + 1)) + (e.a.a.b.b.a.dX(5) + 1)) + (e.a.a.b.b.a.dX(6) + 1)) + (e.a.a.b.b.a.dX(7) + 1)) + (e.a.a.b.b.a.dX(8) + 1)) + (e.a.a.b.b.a.dX(9) + 1)) + (e.a.a.b.b.a.dX(10) + 1)) + (e.a.a.b.b.a.dX(11) + 1)) + (e.a.a.b.b.a.dX(12) + 1)) + (e.a.a.b.b.a.dX(13) + 1)) + (e.a.a.b.b.a.dX(14) + 1)) + (e.a.a.b.b.a.dX(15) + 1)) + (e.a.a.b.b.a.dX(16) + 1)) + (e.a.a.b.b.a.dX(17) + 1)) + (e.a.a.b.b.a.dX(18) + 1);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                wf wfVar = (wf) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        wfVar.wnb = aVar3.cKv();
                        return 0;
                    case 2:
                        wfVar.wnc = aVar3.cKv();
                        return 0;
                    case 3:
                        wfVar.wnd = aVar3.cKv();
                        return 0;
                    case 4:
                        wfVar.wne = aVar3.cKv();
                        return 0;
                    case 5:
                        wfVar.wnf = aVar3.cKv();
                        return 0;
                    case 6:
                        wfVar.wng = aVar3.cKv();
                        return 0;
                    case 7:
                        wfVar.wnh = aVar3.cKv();
                        return 0;
                    case 8:
                        wfVar.wni = aVar3.cKv();
                        return 0;
                    case 9:
                        wfVar.wnj = aVar3.cKv();
                        return 0;
                    case 10:
                        wfVar.wnk = aVar3.cKv();
                        return 0;
                    case 11:
                        wfVar.wnl = aVar3.cKv();
                        return 0;
                    case 12:
                        wfVar.wnm = aVar3.cKv();
                        return 0;
                    case 13:
                        wfVar.wnn = aVar3.cKv();
                        return 0;
                    case 14:
                        wfVar.wno = aVar3.cKv();
                        return 0;
                    case 15:
                        wfVar.wnp = aVar3.cKv();
                        return 0;
                    case 16:
                        wfVar.wnq = aVar3.cKv();
                        return 0;
                    case 17:
                        wfVar.wnr = aVar3.cKv();
                        return 0;
                    case 18:
                        wfVar.wns = aVar3.cKv();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

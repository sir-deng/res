package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class cdw extends a {
    public String nqg;
    public String nqi;
    public String nqj;
    public int nqk;
    public String vTU;
    public int xjk;
    public String xjl;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.xjk);
            if (this.vTU != null) {
                aVar.g(2, this.vTU);
            }
            if (this.nqg != null) {
                aVar.g(3, this.nqg);
            }
            if (this.xjl != null) {
                aVar.g(4, this.xjl);
            }
            if (this.nqi != null) {
                aVar.g(5, this.nqi);
            }
            if (this.nqj != null) {
                aVar.g(6, this.nqj);
            }
            aVar.fX(7, this.nqk);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.xjk) + 0;
            if (this.vTU != null) {
                fU += e.a.a.b.b.a.h(2, this.vTU);
            }
            if (this.nqg != null) {
                fU += e.a.a.b.b.a.h(3, this.nqg);
            }
            if (this.xjl != null) {
                fU += e.a.a.b.b.a.h(4, this.xjl);
            }
            if (this.nqi != null) {
                fU += e.a.a.b.b.a.h(5, this.nqi);
            }
            if (this.nqj != null) {
                fU += e.a.a.b.b.a.h(6, this.nqj);
            }
            return fU + e.a.a.a.fU(7, this.nqk);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdw cdw = (cdw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdw.xjk = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    cdw.vTU = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cdw.nqg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cdw.xjl = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    cdw.nqi = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    cdw.nqj = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    cdw.nqk = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class azx extends a {
    public int lUc;
    public String lUd;
    public int nJk;
    public String nJl;
    public int wLS;
    public int wNs;
    public int wNt;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wLS);
            aVar.fX(2, this.wNt);
            aVar.fX(3, this.wNs);
            aVar.fX(4, this.lUc);
            if (this.lUd != null) {
                aVar.g(5, this.lUd);
            }
            aVar.fX(6, this.nJk);
            if (this.nJl != null) {
                aVar.g(7, this.nJl);
            }
            return 0;
        } else if (i == 1) {
            fU = (((e.a.a.a.fU(1, this.wLS) + 0) + e.a.a.a.fU(2, this.wNt)) + e.a.a.a.fU(3, this.wNs)) + e.a.a.a.fU(4, this.lUc);
            if (this.lUd != null) {
                fU += e.a.a.b.b.a.h(5, this.lUd);
            }
            fU += e.a.a.a.fU(6, this.nJk);
            if (this.nJl != null) {
                return fU + e.a.a.b.b.a.h(7, this.nJl);
            }
            return fU;
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
            azx azx = (azx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azx.wLS = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    azx.wNt = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    azx.wNs = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    azx.lUc = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    azx.lUd = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    azx.nJk = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    azx.nJl = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

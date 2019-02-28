package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bmk extends a {
    public int hxp;
    public String hxq;
    public long hxr;
    public int wWj;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.hxp);
            if (this.hxq != null) {
                aVar.g(2, this.hxq);
            }
            aVar.S(3, this.hxr);
            aVar.fX(4, this.wWj);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.hxp) + 0;
            if (this.hxq != null) {
                fU += e.a.a.b.b.a.h(2, this.hxq);
            }
            return (fU + e.a.a.a.R(3, this.hxr)) + e.a.a.a.fU(4, this.wWj);
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
            bmk bmk = (bmk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bmk.hxp = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bmk.hxq = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bmk.hxr = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    bmk.wWj = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

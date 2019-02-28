package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class bqh extends a {
    public int wZe;
    public int wZf;
    public String wZg;
    public b wZh;
    public int wZi;
    public int wZj;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wZe);
            aVar.fX(2, this.wZf);
            if (this.wZg != null) {
                aVar.g(3, this.wZg);
            }
            if (this.wZh != null) {
                aVar.b(4, this.wZh);
            }
            aVar.fX(5, this.wZi);
            aVar.fX(6, this.wZj);
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.wZe) + 0) + e.a.a.a.fU(2, this.wZf);
            if (this.wZg != null) {
                fU += e.a.a.b.b.a.h(3, this.wZg);
            }
            if (this.wZh != null) {
                fU += e.a.a.a.a(4, this.wZh);
            }
            return (fU + e.a.a.a.fU(5, this.wZi)) + e.a.a.a.fU(6, this.wZj);
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
            bqh bqh = (bqh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqh.wZe = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bqh.wZf = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bqh.wZg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bqh.wZh = aVar3.cKw();
                    return 0;
                case 5:
                    bqh.wZi = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bqh.wZj = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class py extends a {
    public int hxs;
    public String hxt;
    public String hxu;
    public String hxv;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.hxs);
            if (this.hxt != null) {
                aVar.g(2, this.hxt);
            }
            if (this.hxu != null) {
                aVar.g(3, this.hxu);
            }
            if (this.hxv != null) {
                aVar.g(4, this.hxv);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.hxs) + 0;
            if (this.hxt != null) {
                fU += e.a.a.b.b.a.h(2, this.hxt);
            }
            if (this.hxu != null) {
                fU += e.a.a.b.b.a.h(3, this.hxu);
            }
            if (this.hxv != null) {
                return fU + e.a.a.b.b.a.h(4, this.hxv);
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
            py pyVar = (py) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pyVar.hxs = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    pyVar.hxt = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    pyVar.hxu = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    pyVar.hxv = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

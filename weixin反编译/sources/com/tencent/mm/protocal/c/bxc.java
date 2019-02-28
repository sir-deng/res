package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class bxc extends a {
    public String category;
    public int hQv;
    public b wgG;
    public int xeJ;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.hQv);
            aVar.fX(2, this.xeJ);
            if (this.category != null) {
                aVar.g(3, this.category);
            }
            if (this.wgG != null) {
                aVar.b(4, this.wgG);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.hQv) + 0) + e.a.a.a.fU(2, this.xeJ);
            if (this.category != null) {
                fU += e.a.a.b.b.a.h(3, this.category);
            }
            if (this.wgG != null) {
                return fU + e.a.a.a.a(4, this.wgG);
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
            bxc bxc = (bxc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bxc.hQv = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bxc.xeJ = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bxc.category = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bxc.wgG = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

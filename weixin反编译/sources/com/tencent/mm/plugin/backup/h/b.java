package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;

public final class b extends a {
    public int kym;
    public com.tencent.mm.bp.b kyn;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.kym);
            if (this.kyn != null) {
                aVar.b(2, this.kyn);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.kym) + 0;
            if (this.kyn != null) {
                return fU + e.a.a.a.a(2, this.kyn);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.kym = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bVar.kyn = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

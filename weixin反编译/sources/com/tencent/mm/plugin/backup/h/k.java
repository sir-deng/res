package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class k extends a {
    public int kyE;
    public int kyF;
    public String kyG;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyG == null) {
                throw new b("Not all required fields were included: UserName");
            }
            aVar.fX(1, this.kyE);
            aVar.fX(2, this.kyF);
            if (this.kyG != null) {
                aVar.g(3, this.kyG);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.kyE) + 0) + e.a.a.a.fU(2, this.kyF);
            if (this.kyG != null) {
                return fU + e.a.a.b.b.a.h(3, this.kyG);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.kyG != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.kyE = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    kVar.kyF = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    kVar.kyG = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

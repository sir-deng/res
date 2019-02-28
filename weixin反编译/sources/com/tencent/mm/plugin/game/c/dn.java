package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class dn extends a {
    public String kyG;
    public int npC;
    public long npD;
    public String npE;
    public boolean npF;
    public int npG;
    public String npH;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyG == null) {
                throw new b("Not all required fields were included: UserName");
            }
            if (this.kyG != null) {
                aVar.g(1, this.kyG);
            }
            aVar.fX(2, this.npC);
            aVar.S(3, this.npD);
            if (this.npE != null) {
                aVar.g(4, this.npE);
            }
            aVar.am(5, this.npF);
            aVar.fX(6, this.npG);
            if (this.npH == null) {
                return 0;
            }
            aVar.g(7, this.npH);
            return 0;
        } else if (i == 1) {
            if (this.kyG != null) {
                h = e.a.a.b.b.a.h(1, this.kyG) + 0;
            } else {
                h = 0;
            }
            h = (h + e.a.a.a.fU(2, this.npC)) + e.a.a.a.R(3, this.npD);
            if (this.npE != null) {
                h += e.a.a.b.b.a.h(4, this.npE);
            }
            h = (h + (e.a.a.b.b.a.dX(5) + 1)) + e.a.a.a.fU(6, this.npG);
            if (this.npH != null) {
                h += e.a.a.b.b.a.h(7, this.npH);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
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
            dn dnVar = (dn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dnVar.kyG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    dnVar.npC = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    dnVar.npD = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    dnVar.npE = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    dnVar.npF = aVar3.cKv();
                    return 0;
                case 6:
                    dnVar.npG = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    dnVar.npH = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

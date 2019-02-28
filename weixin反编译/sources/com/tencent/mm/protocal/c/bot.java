package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bot extends a {
    public String kyG;
    public int wXZ;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wXZ);
            if (this.kyG != null) {
                aVar.g(2, this.kyG);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wXZ) + 0;
            if (this.kyG != null) {
                return fU + e.a.a.b.b.a.h(2, this.kyG);
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
            bot bot = (bot) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bot.wXZ = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bot.kyG = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

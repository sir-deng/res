package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class sg extends a {
    public int wgW;
    public String wgX;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wgX == null) {
                throw new b("Not all required fields were included: TagDesc");
            }
            aVar.fX(1, this.wgW);
            if (this.wgX != null) {
                aVar.g(2, this.wgX);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wgW) + 0;
            if (this.wgX != null) {
                return fU + e.a.a.b.b.a.h(2, this.wgX);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.wgX != null) {
                return 0;
            }
            throw new b("Not all required fields were included: TagDesc");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sg sgVar = (sg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sgVar.wgW = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    sgVar.wgX = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

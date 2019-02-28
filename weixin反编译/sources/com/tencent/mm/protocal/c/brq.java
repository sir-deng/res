package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class brq extends a {
    public int vPs;
    public int vPt;
    public b wZI;
    public String wgY;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wZI == null) {
                throw new e.a.a.b("Not all required fields were included: EmojiBuffer");
            }
            if (this.wgY != null) {
                aVar.g(1, this.wgY);
            }
            aVar.fX(2, this.vPt);
            aVar.fX(3, this.vPs);
            if (this.wZI == null) {
                return 0;
            }
            aVar.b(4, this.wZI);
            return 0;
        } else if (i == 1) {
            if (this.wgY != null) {
                h = e.a.a.b.b.a.h(1, this.wgY) + 0;
            } else {
                h = 0;
            }
            h = (h + e.a.a.a.fU(2, this.vPt)) + e.a.a.a.fU(3, this.vPs);
            if (this.wZI != null) {
                h += e.a.a.a.a(4, this.wZI);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wZI != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: EmojiBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brq brq = (brq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    brq.wgY = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    brq.vPt = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    brq.vPs = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    brq.wZI = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

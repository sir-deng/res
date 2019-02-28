package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class rl extends a {
    public String fpg;
    public int vWH;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg != null) {
                aVar.g(1, this.fpg);
            }
            aVar.fX(2, this.vWH);
            return 0;
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            return h + e.a.a.a.fU(2, this.vWH);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rl rlVar = (rl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rlVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    rlVar.vWH = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

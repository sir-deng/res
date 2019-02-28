package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ame extends a {
    public int vQj;
    public String wzP;
    public String wzQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wzP != null) {
                aVar.g(1, this.wzP);
            }
            aVar.fX(2, this.vQj);
            if (this.wzQ == null) {
                return 0;
            }
            aVar.g(3, this.wzQ);
            return 0;
        } else if (i == 1) {
            if (this.wzP != null) {
                h = e.a.a.b.b.a.h(1, this.wzP) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.vQj);
            if (this.wzQ != null) {
                h += e.a.a.b.b.a.h(3, this.wzQ);
            }
            return h;
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
            ame ame = (ame) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ame.wzP = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ame.vQj = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ame.wzQ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

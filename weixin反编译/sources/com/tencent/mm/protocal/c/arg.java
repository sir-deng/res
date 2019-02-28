package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class arg extends a {
    public float wFF;
    public float wFG;
    public float wFH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.m(1, this.wFF);
            aVar.m(2, this.wFG);
            aVar.m(3, this.wFH);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.b.b.a.dX(1) + 4) + 0) + (e.a.a.b.b.a.dX(2) + 4)) + (e.a.a.b.b.a.dX(3) + 4);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                arg arg = (arg) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        arg.wFF = aVar3.AEQ.readFloat();
                        return 0;
                    case 2:
                        arg.wFG = aVar3.AEQ.readFloat();
                        return 0;
                    case 3:
                        arg.wFH = aVar3.AEQ.readFloat();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

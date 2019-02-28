package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class wv extends a {
    public boolean wnR;
    public boolean wnS;
    public boolean wnT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.am(1, this.wnR);
            aVar.am(2, this.wnS);
            aVar.am(3, this.wnT);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.b.b.a.dX(1) + 1) + 0) + (e.a.a.b.b.a.dX(2) + 1)) + (e.a.a.b.b.a.dX(3) + 1);
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
                wv wvVar = (wv) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        wvVar.wnR = aVar3.cKv();
                        return 0;
                    case 2:
                        wvVar.wnS = aVar3.cKv();
                        return 0;
                    case 3:
                        wvVar.wnT = aVar3.cKv();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

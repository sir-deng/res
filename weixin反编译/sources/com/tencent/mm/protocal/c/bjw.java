package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bjw extends a {
    public String username;
    public int vTR;
    public int wAn;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.fX(2, this.wAn);
            aVar.fX(3, this.vTR);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            return (h + e.a.a.a.fU(2, this.wAn)) + e.a.a.a.fU(3, this.vTR);
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
            bjw bjw = (bjw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bjw.username = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bjw.wAn = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bjw.vTR = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

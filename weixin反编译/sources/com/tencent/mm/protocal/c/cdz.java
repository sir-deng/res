package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class cdz extends a {
    public int score;
    public String username;
    public int xjp;
    public int xjq;
    public int xjr;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            }
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.fX(2, this.score);
            aVar.fX(3, this.xjp);
            aVar.fX(4, this.xjq);
            aVar.fX(5, this.xjr);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            return (((h + e.a.a.a.fU(2, this.score)) + e.a.a.a.fU(3, this.xjp)) + e.a.a.a.fU(4, this.xjq)) + e.a.a.a.fU(5, this.xjr);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.username != null) {
                return 0;
            }
            throw new b("Not all required fields were included: username");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdz cdz = (cdz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdz.username = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cdz.score = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    cdz.xjp = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    cdz.xjq = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    cdz.xjr = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

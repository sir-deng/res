package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class avz extends a {
    public String fHP;
    public String kRn;
    public int wKj;
    public int wKk;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fHP != null) {
                aVar.g(1, this.fHP);
            }
            if (this.kRn != null) {
                aVar.g(2, this.kRn);
            }
            aVar.fX(3, this.wKj);
            aVar.fX(4, this.wKk);
            return 0;
        } else if (i == 1) {
            if (this.fHP != null) {
                h = e.a.a.b.b.a.h(1, this.fHP) + 0;
            } else {
                h = 0;
            }
            if (this.kRn != null) {
                h += e.a.a.b.b.a.h(2, this.kRn);
            }
            return (h + e.a.a.a.fU(3, this.wKj)) + e.a.a.a.fU(4, this.wKk);
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
            avz avz = (avz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    avz.fHP = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    avz.kRn = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    avz.wKj = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    avz.wKk = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

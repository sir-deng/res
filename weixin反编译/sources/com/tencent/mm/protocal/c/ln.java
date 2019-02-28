package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ln extends a {
    public int ceA;
    public String fHP;
    public String kTf;
    public int wbg;
    public String wbh;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fHP != null) {
                aVar.g(1, this.fHP);
            }
            if (this.kTf != null) {
                aVar.g(2, this.kTf);
            }
            aVar.fX(3, this.ceA);
            aVar.fX(4, this.wbg);
            if (this.wbh == null) {
                return 0;
            }
            aVar.g(5, this.wbh);
            return 0;
        } else if (i == 1) {
            if (this.fHP != null) {
                h = e.a.a.b.b.a.h(1, this.fHP) + 0;
            } else {
                h = 0;
            }
            if (this.kTf != null) {
                h += e.a.a.b.b.a.h(2, this.kTf);
            }
            h = (h + e.a.a.a.fU(3, this.ceA)) + e.a.a.a.fU(4, this.wbg);
            if (this.wbh != null) {
                h += e.a.a.b.b.a.h(5, this.wbh);
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
            ln lnVar = (ln) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lnVar.fHP = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    lnVar.kTf = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    lnVar.ceA = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    lnVar.wbg = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    lnVar.wbh = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

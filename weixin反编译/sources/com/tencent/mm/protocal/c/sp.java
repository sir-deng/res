package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class sp extends a {
    public String nlE;
    public int wfl;
    public String wgS;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlE != null) {
                aVar.g(1, this.nlE);
            }
            if (this.wgS != null) {
                aVar.g(2, this.wgS);
            }
            aVar.fX(3, this.wfl);
            return 0;
        } else if (i == 1) {
            if (this.nlE != null) {
                h = e.a.a.b.b.a.h(1, this.nlE) + 0;
            } else {
                h = 0;
            }
            if (this.wgS != null) {
                h += e.a.a.b.b.a.h(2, this.wgS);
            }
            return h + e.a.a.a.fU(3, this.wfl);
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
            sp spVar = (sp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    spVar.nlE = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    spVar.wgS = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    spVar.wfl = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

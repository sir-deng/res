package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class sn extends a {
    public int Height;
    public int Width;
    public String nMl;
    public String whl;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nMl != null) {
                aVar.g(1, this.nMl);
            }
            aVar.fX(2, this.Width);
            aVar.fX(3, this.Height);
            if (this.whl == null) {
                return 0;
            }
            aVar.g(4, this.whl);
            return 0;
        } else if (i == 1) {
            if (this.nMl != null) {
                h = e.a.a.b.b.a.h(1, this.nMl) + 0;
            } else {
                h = 0;
            }
            h = (h + e.a.a.a.fU(2, this.Width)) + e.a.a.a.fU(3, this.Height);
            if (this.whl != null) {
                h += e.a.a.b.b.a.h(4, this.whl);
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
            sn snVar = (sn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    snVar.nMl = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    snVar.Width = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    snVar.Height = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    snVar.whl = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bem extends a {
    public String nkN;
    public int nne;
    public String wRb;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wRb != null) {
                aVar.g(1, this.wRb);
            }
            aVar.fX(2, this.nne);
            if (this.nkN == null) {
                return 0;
            }
            aVar.g(3, this.nkN);
            return 0;
        } else if (i == 1) {
            if (this.wRb != null) {
                h = e.a.a.b.b.a.h(1, this.wRb) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.nne);
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(3, this.nkN);
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
            bem bem = (bem) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bem.wRb = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bem.nne = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bem.nkN = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

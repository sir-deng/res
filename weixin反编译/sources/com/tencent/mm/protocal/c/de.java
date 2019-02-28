package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class de extends a {
    public String nkU;
    public String nng;
    public int vPc;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkU != null) {
                aVar.g(1, this.nkU);
            }
            aVar.fX(2, this.vPc);
            if (this.nng == null) {
                return 0;
            }
            aVar.g(3, this.nng);
            return 0;
        } else if (i == 1) {
            if (this.nkU != null) {
                h = e.a.a.b.b.a.h(1, this.nkU) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.vPc);
            if (this.nng != null) {
                h += e.a.a.b.b.a.h(3, this.nng);
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
            de deVar = (de) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    deVar.nkU = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    deVar.vPc = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    deVar.nng = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

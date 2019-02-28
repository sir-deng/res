package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ae extends a {
    public String vLh;
    public int vLi;
    public int vLj;
    public int vLk;
    public int vLl;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vLh != null) {
                aVar.g(1, this.vLh);
            }
            aVar.fX(2, this.vLi);
            aVar.fX(3, this.vLj);
            aVar.fX(4, this.vLk);
            aVar.fX(5, this.vLl);
            return 0;
        } else if (i == 1) {
            if (this.vLh != null) {
                h = e.a.a.b.b.a.h(1, this.vLh) + 0;
            } else {
                h = 0;
            }
            return (((h + e.a.a.a.fU(2, this.vLi)) + e.a.a.a.fU(3, this.vLj)) + e.a.a.a.fU(4, this.vLk)) + e.a.a.a.fU(5, this.vLl);
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
            ae aeVar = (ae) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aeVar.vLh = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aeVar.vLi = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    aeVar.vLj = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aeVar.vLk = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aeVar.vLl = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

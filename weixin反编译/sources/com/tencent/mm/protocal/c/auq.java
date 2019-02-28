package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class auq extends a {
    public String hLi;
    public int vVz;
    public int wJo;
    public int wJp;
    public String wJq;
    public int wJr;
    public String wJs;
    public int wdO;
    public int wfl;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.hLi != null) {
                aVar.g(1, this.hLi);
            }
            aVar.fX(2, this.wJo);
            aVar.fX(3, this.wJp);
            aVar.fX(4, this.vVz);
            if (this.wJq != null) {
                aVar.g(5, this.wJq);
            }
            aVar.fX(6, this.wfl);
            aVar.fX(7, this.wJr);
            aVar.fX(8, this.wdO);
            if (this.wJs == null) {
                return 0;
            }
            aVar.g(9, this.wJs);
            return 0;
        } else if (i == 1) {
            if (this.hLi != null) {
                h = e.a.a.b.b.a.h(1, this.hLi) + 0;
            } else {
                h = 0;
            }
            h = ((h + e.a.a.a.fU(2, this.wJo)) + e.a.a.a.fU(3, this.wJp)) + e.a.a.a.fU(4, this.vVz);
            if (this.wJq != null) {
                h += e.a.a.b.b.a.h(5, this.wJq);
            }
            h = ((h + e.a.a.a.fU(6, this.wfl)) + e.a.a.a.fU(7, this.wJr)) + e.a.a.a.fU(8, this.wdO);
            if (this.wJs != null) {
                h += e.a.a.b.b.a.h(9, this.wJs);
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
            auq auq = (auq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    auq.hLi = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    auq.wJo = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    auq.wJp = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    auq.vVz = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    auq.wJq = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    auq.wfl = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    auq.wJr = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    auq.wdO = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    auq.wJs = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

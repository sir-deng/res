package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ez extends a {
    public int sGd;
    public String sGe;
    public String sGf;
    public String sGg;
    public String title;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            aVar.fX(2, this.sGd);
            if (this.sGe != null) {
                aVar.g(3, this.sGe);
            }
            if (this.sGf != null) {
                aVar.g(4, this.sGf);
            }
            if (this.sGg == null) {
                return 0;
            }
            aVar.g(5, this.sGg);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.sGd);
            if (this.sGe != null) {
                h += e.a.a.b.b.a.h(3, this.sGe);
            }
            if (this.sGf != null) {
                h += e.a.a.b.b.a.h(4, this.sGf);
            }
            if (this.sGg != null) {
                h += e.a.a.b.b.a.h(5, this.sGg);
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
            ez ezVar = (ez) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezVar.title = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ezVar.sGd = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ezVar.sGe = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ezVar.sGf = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ezVar.sGg = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ajm extends a {
    public String fpg;
    public String nkL;
    public String nlA;
    public String wxI;
    public String wxJ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wxI != null) {
                aVar.g(1, this.wxI);
            }
            if (this.nlA != null) {
                aVar.g(2, this.nlA);
            }
            if (this.fpg != null) {
                aVar.g(3, this.fpg);
            }
            if (this.nkL != null) {
                aVar.g(4, this.nkL);
            }
            if (this.wxJ == null) {
                return 0;
            }
            aVar.g(5, this.wxJ);
            return 0;
        } else if (i == 1) {
            if (this.wxI != null) {
                h = e.a.a.b.b.a.h(1, this.wxI) + 0;
            } else {
                h = 0;
            }
            if (this.nlA != null) {
                h += e.a.a.b.b.a.h(2, this.nlA);
            }
            if (this.fpg != null) {
                h += e.a.a.b.b.a.h(3, this.fpg);
            }
            if (this.nkL != null) {
                h += e.a.a.b.b.a.h(4, this.nkL);
            }
            if (this.wxJ != null) {
                h += e.a.a.b.b.a.h(5, this.wxJ);
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
            ajm ajm = (ajm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ajm.wxI = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ajm.nlA = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ajm.fpg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ajm.nkL = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ajm.wxJ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

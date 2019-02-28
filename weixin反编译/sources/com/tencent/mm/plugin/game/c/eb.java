package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class eb extends a {
    public String fpg;
    public String nkN;
    public String nlA;
    public String nlr;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlA != null) {
                aVar.g(1, this.nlA);
            }
            if (this.fpg != null) {
                aVar.g(2, this.fpg);
            }
            if (this.nkN != null) {
                aVar.g(3, this.nkN);
            }
            if (this.nlr == null) {
                return 0;
            }
            aVar.g(4, this.nlr);
            return 0;
        } else if (i == 1) {
            if (this.nlA != null) {
                h = e.a.a.b.b.a.h(1, this.nlA) + 0;
            } else {
                h = 0;
            }
            if (this.fpg != null) {
                h += e.a.a.b.b.a.h(2, this.fpg);
            }
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(3, this.nkN);
            }
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(4, this.nlr);
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
            eb ebVar = (eb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ebVar.nlA = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ebVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ebVar.nkN = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ebVar.nlr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

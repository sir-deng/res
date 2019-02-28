package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class cf extends a {
    public String fpg;
    public String nkQ;
    public String nlZ;
    public String noA;
    public String noE;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.noA != null) {
                aVar.g(1, this.noA);
            }
            if (this.fpg != null) {
                aVar.g(2, this.fpg);
            }
            if (this.nlZ != null) {
                aVar.g(3, this.nlZ);
            }
            if (this.nkQ != null) {
                aVar.g(4, this.nkQ);
            }
            if (this.noE == null) {
                return 0;
            }
            aVar.g(5, this.noE);
            return 0;
        } else if (i == 1) {
            if (this.noA != null) {
                h = e.a.a.b.b.a.h(1, this.noA) + 0;
            } else {
                h = 0;
            }
            if (this.fpg != null) {
                h += e.a.a.b.b.a.h(2, this.fpg);
            }
            if (this.nlZ != null) {
                h += e.a.a.b.b.a.h(3, this.nlZ);
            }
            if (this.nkQ != null) {
                h += e.a.a.b.b.a.h(4, this.nkQ);
            }
            if (this.noE != null) {
                h += e.a.a.b.b.a.h(5, this.noE);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.fpg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cf cfVar = (cf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfVar.noA = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cfVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cfVar.nlZ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cfVar.nkQ = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    cfVar.noE = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

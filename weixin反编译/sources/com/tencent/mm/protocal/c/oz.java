package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class oz extends a {
    public String aAM;
    public long weB;
    public String weC;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.aAM == null) {
                throw new b("Not all required fields were included: key");
            }
            if (this.aAM != null) {
                aVar.g(1, this.aAM);
            }
            aVar.S(2, this.weB);
            if (this.weC == null) {
                return 0;
            }
            aVar.g(3, this.weC);
            return 0;
        } else if (i == 1) {
            if (this.aAM != null) {
                h = e.a.a.b.b.a.h(1, this.aAM) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.R(2, this.weB);
            if (this.weC != null) {
                h += e.a.a.b.b.a.h(3, this.weC);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.aAM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: key");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            oz ozVar = (oz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ozVar.aAM = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ozVar.weB = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    ozVar.weC = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

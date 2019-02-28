package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class jt extends a {
    public long vWS;
    public String vWT;

    protected final int a(int i, Object... objArr) {
        int R;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vWT == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            aVar.S(1, this.vWS);
            if (this.vWT != null) {
                aVar.g(2, this.vWT);
            }
            return 0;
        } else if (i == 1) {
            R = e.a.a.a.R(1, this.vWS) + 0;
            if (this.vWT != null) {
                return R + e.a.a.b.b.a.h(2, this.vWT);
            }
            return R;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            if (this.vWT != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ObjectDesc");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jt jtVar = (jt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jtVar.vWS = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    jtVar.vWT = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class on extends a {
    public String kzm;
    public int sfa;
    public String wej;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wej == null) {
                throw new b("Not all required fields were included: PkgId");
            }
            if (this.wej != null) {
                aVar.g(1, this.wej);
            }
            if (this.kzm != null) {
                aVar.g(2, this.kzm);
            }
            aVar.fX(3, this.sfa);
            return 0;
        } else if (i == 1) {
            if (this.wej != null) {
                h = e.a.a.b.b.a.h(1, this.wej) + 0;
            } else {
                h = 0;
            }
            if (this.kzm != null) {
                h += e.a.a.b.b.a.h(2, this.kzm);
            }
            return h + e.a.a.a.fU(3, this.sfa);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wej != null) {
                return 0;
            }
            throw new b("Not all required fields were included: PkgId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            on onVar = (on) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    onVar.wej = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    onVar.kzm = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    onVar.sfa = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

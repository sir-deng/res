package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class btb extends a {
    public String hxj;
    public String kyG;
    public String kzN;
    public String vPF;
    public String weS;
    public String xbi;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyG == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.xbi == null) {
                throw new b("Not all required fields were included: MatchWord");
            } else {
                if (this.kyG != null) {
                    aVar.g(1, this.kyG);
                }
                if (this.xbi != null) {
                    aVar.g(2, this.xbi);
                }
                if (this.kzN != null) {
                    aVar.g(3, this.kzN);
                }
                if (this.weS != null) {
                    aVar.g(4, this.weS);
                }
                if (this.hxj != null) {
                    aVar.g(5, this.hxj);
                }
                if (this.vPF == null) {
                    return 0;
                }
                aVar.g(6, this.vPF);
                return 0;
            }
        } else if (i == 1) {
            if (this.kyG != null) {
                h = e.a.a.b.b.a.h(1, this.kyG) + 0;
            } else {
                h = 0;
            }
            if (this.xbi != null) {
                h += e.a.a.b.b.a.h(2, this.xbi);
            }
            if (this.kzN != null) {
                h += e.a.a.b.b.a.h(3, this.kzN);
            }
            if (this.weS != null) {
                h += e.a.a.b.b.a.h(4, this.weS);
            }
            if (this.hxj != null) {
                h += e.a.a.b.b.a.h(5, this.hxj);
            }
            if (this.vPF != null) {
                h += e.a.a.b.b.a.h(6, this.vPF);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.kyG == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.xbi != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MatchWord");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btb btb = (btb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btb.kyG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    btb.xbi = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    btb.kzN = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    btb.weS = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    btb.hxj = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    btb.vPF = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

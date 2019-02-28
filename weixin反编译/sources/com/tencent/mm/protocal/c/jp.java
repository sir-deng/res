package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class jp extends a {
    public String fpg;
    public String nlE;
    public String vWA;
    public int vWB;
    public String vWC;
    public int vWD;
    public String vWz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nlE == null) {
                throw new b("Not all required fields were included: Url");
            } else if (this.vWz == null) {
                throw new b("Not all required fields were included: Position");
            } else if (this.vWA == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else {
                if (this.fpg != null) {
                    aVar.g(1, this.fpg);
                }
                if (this.nlE != null) {
                    aVar.g(2, this.nlE);
                }
                if (this.vWz != null) {
                    aVar.g(3, this.vWz);
                }
                if (this.vWA != null) {
                    aVar.g(4, this.vWA);
                }
                aVar.fX(5, this.vWB);
                if (this.vWC != null) {
                    aVar.g(6, this.vWC);
                }
                aVar.fX(7, this.vWD);
                return 0;
            }
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            if (this.nlE != null) {
                h += e.a.a.b.b.a.h(2, this.nlE);
            }
            if (this.vWz != null) {
                h += e.a.a.b.b.a.h(3, this.vWz);
            }
            if (this.vWA != null) {
                h += e.a.a.b.b.a.h(4, this.vWA);
            }
            h += e.a.a.a.fU(5, this.vWB);
            if (this.vWC != null) {
                h += e.a.a.b.b.a.h(6, this.vWC);
            }
            return h + e.a.a.a.fU(7, this.vWD);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nlE == null) {
                throw new b("Not all required fields were included: Url");
            } else if (this.vWz == null) {
                throw new b("Not all required fields were included: Position");
            } else if (this.vWA != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DetailInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jp jpVar = (jp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jpVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    jpVar.nlE = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    jpVar.vWz = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    jpVar.vWA = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    jpVar.vWB = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    jpVar.vWC = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    jpVar.vWD = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

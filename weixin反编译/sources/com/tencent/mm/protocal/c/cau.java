package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class cau extends a {
    public int sfa;
    public String wmc;
    public String xgB;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xgB == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.wmc == null) {
                throw new b("Not all required fields were included: Text");
            } else {
                if (this.xgB != null) {
                    aVar.g(1, this.xgB);
                }
                if (this.wmc != null) {
                    aVar.g(2, this.wmc);
                }
                aVar.fX(3, this.sfa);
                return 0;
            }
        } else if (i == 1) {
            if (this.xgB != null) {
                h = e.a.a.b.b.a.h(1, this.xgB) + 0;
            } else {
                h = 0;
            }
            if (this.wmc != null) {
                h += e.a.a.b.b.a.h(2, this.wmc);
            }
            return h + e.a.a.a.fU(3, this.sfa);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.xgB == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.wmc != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Text");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cau cau = (cau) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cau.xgB = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cau.wmc = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cau.sfa = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

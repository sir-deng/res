package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class sv extends a {
    public String npE;
    public String whS;
    public String whT;
    public String whU;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.npE == null) {
                throw new b("Not all required fields were included: Label");
            } else if (this.whS == null) {
                throw new b("Not all required fields were included: Number");
            } else if (this.whT == null) {
                throw new b("Not all required fields were included: Type");
            } else {
                if (this.npE != null) {
                    aVar.g(1, this.npE);
                }
                if (this.whS != null) {
                    aVar.g(2, this.whS);
                }
                if (this.whT != null) {
                    aVar.g(3, this.whT);
                }
                if (this.whU == null) {
                    return 0;
                }
                aVar.g(4, this.whU);
                return 0;
            }
        } else if (i == 1) {
            if (this.npE != null) {
                h = e.a.a.b.b.a.h(1, this.npE) + 0;
            } else {
                h = 0;
            }
            if (this.whS != null) {
                h += e.a.a.b.b.a.h(2, this.whS);
            }
            if (this.whT != null) {
                h += e.a.a.b.b.a.h(3, this.whT);
            }
            if (this.whU != null) {
                h += e.a.a.b.b.a.h(4, this.whU);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.npE == null) {
                throw new b("Not all required fields were included: Label");
            } else if (this.whS == null) {
                throw new b("Not all required fields were included: Number");
            } else if (this.whT != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Type");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sv svVar = (sv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    svVar.npE = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    svVar.whS = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    svVar.whT = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    svVar.whU = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

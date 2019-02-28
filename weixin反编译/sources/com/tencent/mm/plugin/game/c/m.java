package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class m extends a {
    public String nlB;
    public String nlC;
    public String nlD;
    public String nlE;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlB == null) {
                throw new b("Not all required fields were included: Message");
            } else if (this.nlC == null) {
                throw new b("Not all required fields were included: GotoBtn");
            } else if (this.nlD == null) {
                throw new b("Not all required fields were included: CancelBtn");
            } else if (this.nlE == null) {
                throw new b("Not all required fields were included: Url");
            } else {
                if (this.nlB != null) {
                    aVar.g(1, this.nlB);
                }
                if (this.nlC != null) {
                    aVar.g(2, this.nlC);
                }
                if (this.nlD != null) {
                    aVar.g(3, this.nlD);
                }
                if (this.nlE == null) {
                    return 0;
                }
                aVar.g(4, this.nlE);
                return 0;
            }
        } else if (i == 1) {
            if (this.nlB != null) {
                h = e.a.a.b.b.a.h(1, this.nlB) + 0;
            } else {
                h = 0;
            }
            if (this.nlC != null) {
                h += e.a.a.b.b.a.h(2, this.nlC);
            }
            if (this.nlD != null) {
                h += e.a.a.b.b.a.h(3, this.nlD);
            }
            if (this.nlE != null) {
                h += e.a.a.b.b.a.h(4, this.nlE);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.nlB == null) {
                throw new b("Not all required fields were included: Message");
            } else if (this.nlC == null) {
                throw new b("Not all required fields were included: GotoBtn");
            } else if (this.nlD == null) {
                throw new b("Not all required fields were included: CancelBtn");
            } else if (this.nlE != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Url");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.nlB = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    mVar.nlC = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    mVar.nlD = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    mVar.nlE = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

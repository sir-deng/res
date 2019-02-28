package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class btp extends a {
    public String idC;
    public String xbr;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.idC == null) {
                throw new b("Not all required fields were included: tp_username");
            } else if (this.xbr == null) {
                throw new b("Not all required fields were included: verify_ticket");
            } else {
                if (this.idC != null) {
                    aVar.g(1, this.idC);
                }
                if (this.xbr == null) {
                    return 0;
                }
                aVar.g(2, this.xbr);
                return 0;
            }
        } else if (i == 1) {
            if (this.idC != null) {
                h = e.a.a.b.b.a.h(1, this.idC) + 0;
            } else {
                h = 0;
            }
            if (this.xbr != null) {
                h += e.a.a.b.b.a.h(2, this.xbr);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.idC == null) {
                throw new b("Not all required fields were included: tp_username");
            } else if (this.xbr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: verify_ticket");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btp btp = (btp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btp.idC = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    btp.xbr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class bva extends a {
    public String wDa;
    public int wMQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wDa == null) {
                throw new b("Not all required fields were included: Ip");
            }
            if (this.wDa != null) {
                aVar.g(1, this.wDa);
            }
            aVar.fX(2, this.wMQ);
            return 0;
        } else if (i == 1) {
            if (this.wDa != null) {
                h = e.a.a.b.b.a.h(1, this.wDa) + 0;
            } else {
                h = 0;
            }
            return h + e.a.a.a.fU(2, this.wMQ);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wDa != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Ip");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bva bva = (bva) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bva.wDa = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bva.wMQ = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class cea extends a {
    public int cRQ;
    public String username;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            }
            aVar.fX(1, this.cRQ);
            if (this.username != null) {
                aVar.g(2, this.username);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.cRQ) + 0;
            if (this.username != null) {
                return fU + e.a.a.b.b.a.h(2, this.username);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.username != null) {
                return 0;
            }
            throw new b("Not all required fields were included: username");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cea cea = (cea) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cea.cRQ = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    cea.username = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

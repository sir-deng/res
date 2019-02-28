package com.tencent.mm.protocal.b.a;

import e.a.a.b;

public final class a extends com.tencent.mm.bp.a {
    public int actionType;
    public int id;
    public String vJC;
    public String vJD;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJC == null) {
                throw new b("Not all required fields were included: btnStr");
            }
            aVar.fX(1, this.id);
            aVar.fX(2, this.actionType);
            if (this.vJC != null) {
                aVar.g(3, this.vJC);
            }
            if (this.vJD != null) {
                aVar.g(4, this.vJD);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.id) + 0) + e.a.a.a.fU(2, this.actionType);
            if (this.vJC != null) {
                fU += e.a.a.b.b.a.h(3, this.vJC);
            }
            if (this.vJD != null) {
                return fU + e.a.a.b.b.a.h(4, this.vJD);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = com.tencent.mm.bp.a.a(aVar2); fU > 0; fU = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.vJC != null) {
                return 0;
            }
            throw new b("Not all required fields were included: btnStr");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.id = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    aVar4.actionType = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    aVar4.vJC = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aVar4.vJD = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

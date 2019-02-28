package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class tx extends a {
    public int wiC;
    public String wiD;
    public String wiE;
    public String wiF;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wiC);
            if (this.wiD != null) {
                aVar.g(2, this.wiD);
            }
            if (this.wiF != null) {
                aVar.g(3, this.wiF);
            }
            if (this.wiE != null) {
                aVar.g(4, this.wiE);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wiC) + 0;
            if (this.wiD != null) {
                fU += e.a.a.b.b.a.h(2, this.wiD);
            }
            if (this.wiF != null) {
                fU += e.a.a.b.b.a.h(3, this.wiF);
            }
            if (this.wiE != null) {
                return fU + e.a.a.b.b.a.h(4, this.wiE);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            tx txVar = (tx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    txVar.wiC = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    txVar.wiD = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    txVar.wiF = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    txVar.wiE = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class can extends a {
    public int wXj;
    public String xfB;
    public b xgR;
    public b xgS;
    public String xgT;
    public String xgU;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfB == null) {
                throw new e.a.a.b("Not all required fields were included: Msg");
            }
            aVar.fX(1, this.wXj);
            if (this.xfB != null) {
                aVar.g(2, this.xfB);
            }
            if (this.xgR != null) {
                aVar.b(3, this.xgR);
            }
            if (this.xgS != null) {
                aVar.b(4, this.xgS);
            }
            if (this.xgT != null) {
                aVar.g(5, this.xgT);
            }
            if (this.xgU != null) {
                aVar.g(6, this.xgU);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wXj) + 0;
            if (this.xfB != null) {
                fU += e.a.a.b.b.a.h(2, this.xfB);
            }
            if (this.xgR != null) {
                fU += e.a.a.a.a(3, this.xgR);
            }
            if (this.xgS != null) {
                fU += e.a.a.a.a(4, this.xgS);
            }
            if (this.xgT != null) {
                fU += e.a.a.b.b.a.h(5, this.xgT);
            }
            if (this.xgU != null) {
                return fU + e.a.a.b.b.a.h(6, this.xgU);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.xfB != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: Msg");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            can can = (can) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    can.wXj = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    can.xfB = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    can.xgR = aVar3.cKw();
                    return 0;
                case 4:
                    can.xgS = aVar3.cKw();
                    return 0;
                case 5:
                    can.xgT = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    can.xgU = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

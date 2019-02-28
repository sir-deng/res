package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class iq extends a {
    public int port;
    public int type;
    public b vVv;
    public b vVw;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.type);
            aVar.fX(2, this.port);
            if (this.vVv != null) {
                aVar.b(3, this.vVv);
            }
            if (this.vVw != null) {
                aVar.b(4, this.vVw);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.type) + 0) + e.a.a.a.fU(2, this.port);
            if (this.vVv != null) {
                fU += e.a.a.a.a(3, this.vVv);
            }
            if (this.vVw != null) {
                return fU + e.a.a.a.a(4, this.vVw);
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
            iq iqVar = (iq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iqVar.type = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    iqVar.port = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    iqVar.vVv = aVar3.cKw();
                    return 0;
                case 4:
                    iqVar.vVw = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

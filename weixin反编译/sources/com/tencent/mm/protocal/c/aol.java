package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aol extends a {
    public int vKQ;
    public String wBW;
    public boolean wBX;
    public String wBY;
    public String wwx;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vKQ);
            if (this.wBW != null) {
                aVar.g(2, this.wBW);
            }
            aVar.am(3, this.wBX);
            if (this.wBY != null) {
                aVar.g(4, this.wBY);
            }
            if (this.wwx != null) {
                aVar.g(5, this.wwx);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vKQ) + 0;
            if (this.wBW != null) {
                fU += e.a.a.b.b.a.h(2, this.wBW);
            }
            fU += e.a.a.b.b.a.dX(3) + 1;
            if (this.wBY != null) {
                fU += e.a.a.b.b.a.h(4, this.wBY);
            }
            if (this.wwx != null) {
                return fU + e.a.a.b.b.a.h(5, this.wwx);
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
            aol aol = (aol) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aol.vKQ = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    aol.wBW = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aol.wBX = aVar3.cKv();
                    return 0;
                case 4:
                    aol.wBY = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aol.wwx = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

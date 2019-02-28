package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bps extends a {
    public String vXI;
    public int wYH;
    public int wYI;
    public long wYJ;
    public String wgS;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wYH);
            if (this.vXI != null) {
                aVar.g(2, this.vXI);
            }
            if (this.wgS != null) {
                aVar.g(3, this.wgS);
            }
            aVar.fX(4, this.wYI);
            aVar.S(5, this.wYJ);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wYH) + 0;
            if (this.vXI != null) {
                fU += e.a.a.b.b.a.h(2, this.vXI);
            }
            if (this.wgS != null) {
                fU += e.a.a.b.b.a.h(3, this.wgS);
            }
            return (fU + e.a.a.a.fU(4, this.wYI)) + e.a.a.a.R(5, this.wYJ);
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
            bps bps = (bps) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bps.wYH = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bps.vXI = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bps.wgS = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bps.wYI = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bps.wYJ = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

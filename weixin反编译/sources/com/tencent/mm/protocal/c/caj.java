package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class caj extends a {
    public String fpg;
    public String noL;
    public int npU;
    public String xgB;
    public int xgN;
    public boolean xgO;
    public boolean xgP;
    public boolean xgQ;
    public b xgt;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xgB == null) {
                throw new e.a.a.b("Not all required fields were included: Talker");
            } else if (this.fpg == null) {
                throw new e.a.a.b("Not all required fields were included: Title");
            } else if (this.noL == null) {
                throw new e.a.a.b("Not all required fields were included: Content");
            } else {
                aVar.fX(1, this.npU);
                if (this.xgB != null) {
                    aVar.g(2, this.xgB);
                }
                if (this.fpg != null) {
                    aVar.g(3, this.fpg);
                }
                if (this.noL != null) {
                    aVar.g(4, this.noL);
                }
                aVar.fX(5, this.xgN);
                if (this.xgt != null) {
                    aVar.b(6, this.xgt);
                }
                aVar.am(7, this.xgO);
                aVar.am(8, this.xgP);
                aVar.am(9, this.xgQ);
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.npU) + 0;
            if (this.xgB != null) {
                fU += e.a.a.b.b.a.h(2, this.xgB);
            }
            if (this.fpg != null) {
                fU += e.a.a.b.b.a.h(3, this.fpg);
            }
            if (this.noL != null) {
                fU += e.a.a.b.b.a.h(4, this.noL);
            }
            fU += e.a.a.a.fU(5, this.xgN);
            if (this.xgt != null) {
                fU += e.a.a.a.a(6, this.xgt);
            }
            return ((fU + (e.a.a.b.b.a.dX(7) + 1)) + (e.a.a.b.b.a.dX(8) + 1)) + (e.a.a.b.b.a.dX(9) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.xgB == null) {
                throw new e.a.a.b("Not all required fields were included: Talker");
            } else if (this.fpg == null) {
                throw new e.a.a.b("Not all required fields were included: Title");
            } else if (this.noL != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            caj caj = (caj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    caj.npU = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    caj.xgB = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    caj.fpg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    caj.noL = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    caj.xgN = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    caj.xgt = aVar3.cKw();
                    return 0;
                case 7:
                    caj.xgO = aVar3.cKv();
                    return 0;
                case 8:
                    caj.xgP = aVar3.cKv();
                    return 0;
                case 9:
                    caj.xgQ = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

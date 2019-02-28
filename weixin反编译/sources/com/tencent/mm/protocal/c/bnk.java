package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bnk extends a {
    public int kzx;
    public int wXs;
    public int wXt;
    public int wXu;
    public int wXv;
    public int wXw;
    public int wXx;
    public int wid;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.kzx);
            aVar.fX(2, this.wid);
            aVar.fX(3, this.wXs);
            aVar.fX(4, this.wXt);
            aVar.fX(5, this.wXu);
            aVar.fX(6, this.wXv);
            aVar.fX(7, this.wXw);
            aVar.fX(8, this.wXx);
            return 0;
        } else if (i == 1) {
            return (((((((e.a.a.a.fU(1, this.kzx) + 0) + e.a.a.a.fU(2, this.wid)) + e.a.a.a.fU(3, this.wXs)) + e.a.a.a.fU(4, this.wXt)) + e.a.a.a.fU(5, this.wXu)) + e.a.a.a.fU(6, this.wXv)) + e.a.a.a.fU(7, this.wXw)) + e.a.a.a.fU(8, this.wXx);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                bnk bnk = (bnk) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bnk.kzx = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        bnk.wid = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        bnk.wXs = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        bnk.wXt = aVar3.AEQ.rz();
                        return 0;
                    case 5:
                        bnk.wXu = aVar3.AEQ.rz();
                        return 0;
                    case 6:
                        bnk.wXv = aVar3.AEQ.rz();
                        return 0;
                    case 7:
                        bnk.wXw = aVar3.AEQ.rz();
                        return 0;
                    case 8:
                        bnk.wXx = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

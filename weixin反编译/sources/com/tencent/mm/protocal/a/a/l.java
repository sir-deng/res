package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bp.a;

public final class l extends a {
    public int action;
    public int vJl;
    public int vJm;
    public int vJn;
    public int vJo;
    public int vJp;
    public int vJq;
    public int vJr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vJl);
            aVar.fX(2, this.action);
            aVar.fX(3, this.vJm);
            aVar.fX(4, this.vJn);
            aVar.fX(5, this.vJo);
            aVar.fX(6, this.vJp);
            aVar.fX(7, this.vJq);
            aVar.fX(8, this.vJr);
            return 0;
        } else if (i == 1) {
            return (((((((e.a.a.a.fU(1, this.vJl) + 0) + e.a.a.a.fU(2, this.action)) + e.a.a.a.fU(3, this.vJm)) + e.a.a.a.fU(4, this.vJn)) + e.a.a.a.fU(5, this.vJo)) + e.a.a.a.fU(6, this.vJp)) + e.a.a.a.fU(7, this.vJq)) + e.a.a.a.fU(8, this.vJr);
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
                l lVar = (l) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        lVar.vJl = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        lVar.action = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        lVar.vJm = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        lVar.vJn = aVar3.AEQ.rz();
                        return 0;
                    case 5:
                        lVar.vJo = aVar3.AEQ.rz();
                        return 0;
                    case 6:
                        lVar.vJp = aVar3.AEQ.rz();
                        return 0;
                    case 7:
                        lVar.vJq = aVar3.AEQ.rz();
                        return 0;
                    case 8:
                        lVar.vJr = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

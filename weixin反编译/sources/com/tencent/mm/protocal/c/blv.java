package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class blv extends a {
    public float biF;
    public int rAl;
    public float wVL;
    public float wVM;
    public float wVN;
    public float wVO;
    public int wVP;
    public long wVQ;
    public long wVR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.m(1, this.wVL);
            aVar.m(2, this.wVM);
            aVar.m(3, this.wVN);
            aVar.m(4, this.wVO);
            aVar.fX(5, this.wVP);
            aVar.S(6, this.wVQ);
            aVar.S(7, this.wVR);
            aVar.m(8, this.biF);
            aVar.fX(9, this.rAl);
            return 0;
        } else if (i == 1) {
            return (((((((((e.a.a.b.b.a.dX(1) + 4) + 0) + (e.a.a.b.b.a.dX(2) + 4)) + (e.a.a.b.b.a.dX(3) + 4)) + (e.a.a.b.b.a.dX(4) + 4)) + e.a.a.a.fU(5, this.wVP)) + e.a.a.a.R(6, this.wVQ)) + e.a.a.a.R(7, this.wVR)) + (e.a.a.b.b.a.dX(8) + 4)) + e.a.a.a.fU(9, this.rAl);
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
                blv blv = (blv) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        blv.wVL = aVar3.AEQ.readFloat();
                        return 0;
                    case 2:
                        blv.wVM = aVar3.AEQ.readFloat();
                        return 0;
                    case 3:
                        blv.wVN = aVar3.AEQ.readFloat();
                        return 0;
                    case 4:
                        blv.wVO = aVar3.AEQ.readFloat();
                        return 0;
                    case 5:
                        blv.wVP = aVar3.AEQ.rz();
                        return 0;
                    case 6:
                        blv.wVQ = aVar3.AEQ.rA();
                        return 0;
                    case 7:
                        blv.wVR = aVar3.AEQ.rA();
                        return 0;
                    case 8:
                        blv.biF = aVar3.AEQ.readFloat();
                        return 0;
                    case 9:
                        blv.rAl = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class bvh extends a {
    public long wim;
    public long xcP;
    public int xcZ;
    public int xda;
    public int xdb;
    public int xdc;
    public b xdd;

    protected final int a(int i, Object... objArr) {
        int R;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.xcP);
            aVar.S(2, this.wim);
            aVar.fX(3, this.xcZ);
            aVar.fX(4, this.xda);
            aVar.fX(5, this.xdb);
            aVar.fX(6, this.xdc);
            if (this.xdd != null) {
                aVar.b(7, this.xdd);
            }
            return 0;
        } else if (i == 1) {
            R = (((((e.a.a.a.R(1, this.xcP) + 0) + e.a.a.a.R(2, this.wim)) + e.a.a.a.fU(3, this.xcZ)) + e.a.a.a.fU(4, this.xda)) + e.a.a.a.fU(5, this.xdb)) + e.a.a.a.fU(6, this.xdc);
            if (this.xdd != null) {
                return R + e.a.a.a.a(7, this.xdd);
            }
            return R;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvh bvh = (bvh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bvh.xcP = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    bvh.wim = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    bvh.xcZ = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bvh.xda = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bvh.xdb = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bvh.xdc = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bvh.xdd = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

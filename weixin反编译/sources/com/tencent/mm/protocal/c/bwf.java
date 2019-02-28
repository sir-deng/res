package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bwf extends a {
    public String mHK;
    public String userName;
    public int xdY;
    public int xdZ;
    public int xea;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.xdY);
            aVar.fX(2, this.xdZ);
            aVar.fX(3, this.xea);
            if (this.userName != null) {
                aVar.g(4, this.userName);
            }
            if (this.mHK != null) {
                aVar.g(5, this.mHK);
            }
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.xdY) + 0) + e.a.a.a.fU(2, this.xdZ)) + e.a.a.a.fU(3, this.xea);
            if (this.userName != null) {
                fU += e.a.a.b.b.a.h(4, this.userName);
            }
            if (this.mHK != null) {
                return fU + e.a.a.b.b.a.h(5, this.mHK);
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
            bwf bwf = (bwf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bwf.xdY = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bwf.xdZ = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bwf.xea = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bwf.userName = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bwf.mHK = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

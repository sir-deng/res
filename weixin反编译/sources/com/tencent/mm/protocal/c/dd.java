package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class dd extends a {
    public long vOU;
    public int vOV;
    public int vOW;
    public int vOX;
    public int vOY;
    public int vOZ;
    public int vPa;
    public String vPb;

    protected final int a(int i, Object... objArr) {
        int R;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.vOU);
            aVar.fX(2, this.vOV);
            aVar.fX(3, this.vOW);
            aVar.fX(4, this.vOX);
            aVar.fX(5, this.vOY);
            aVar.fX(6, this.vOZ);
            aVar.fX(7, this.vPa);
            if (this.vPb != null) {
                aVar.g(8, this.vPb);
            }
            return 0;
        } else if (i == 1) {
            R = ((((((e.a.a.a.R(1, this.vOU) + 0) + e.a.a.a.fU(2, this.vOV)) + e.a.a.a.fU(3, this.vOW)) + e.a.a.a.fU(4, this.vOX)) + e.a.a.a.fU(5, this.vOY)) + e.a.a.a.fU(6, this.vOZ)) + e.a.a.a.fU(7, this.vPa);
            if (this.vPb != null) {
                return R + e.a.a.b.b.a.h(8, this.vPb);
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
            dd ddVar = (dd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ddVar.vOU = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    ddVar.vOV = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ddVar.vOW = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    ddVar.vOX = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    ddVar.vOY = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    ddVar.vOZ = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    ddVar.vPa = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    ddVar.vPb = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

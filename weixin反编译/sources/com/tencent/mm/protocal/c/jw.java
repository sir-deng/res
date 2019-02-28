package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class jw extends a {
    public int vWX;
    public int vWY;
    public int vWZ;
    public int vXa;
    public int vXb;
    public int vXc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vWX);
            aVar.fX(2, this.vWY);
            aVar.fX(3, this.vWZ);
            aVar.fX(4, this.vXa);
            aVar.fX(5, this.vXb);
            aVar.fX(6, this.vXc);
            return 0;
        } else if (i == 1) {
            return (((((e.a.a.a.fU(1, this.vWX) + 0) + e.a.a.a.fU(2, this.vWY)) + e.a.a.a.fU(3, this.vWZ)) + e.a.a.a.fU(4, this.vXa)) + e.a.a.a.fU(5, this.vXb)) + e.a.a.a.fU(6, this.vXc);
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
                jw jwVar = (jw) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        jwVar.vWX = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        jwVar.vWY = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        jwVar.vWZ = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        jwVar.vXa = aVar3.AEQ.rz();
                        return 0;
                    case 5:
                        jwVar.vXb = aVar3.AEQ.rz();
                        return 0;
                    case 6:
                        jwVar.vXc = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

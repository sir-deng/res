package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aou extends a {
    public float vXx;
    public float vXy;
    public String wCC;
    public int wjv;
    public String wjw;
    public String wjx;
    public int wjy;

    protected final int a(int i, Object... objArr) {
        int dX;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.m(1, this.vXx);
            aVar.m(2, this.vXy);
            aVar.fX(3, this.wjv);
            if (this.wjw != null) {
                aVar.g(4, this.wjw);
            }
            if (this.wjx != null) {
                aVar.g(5, this.wjx);
            }
            aVar.fX(6, this.wjy);
            if (this.wCC != null) {
                aVar.g(7, this.wCC);
            }
            return 0;
        } else if (i == 1) {
            dX = (((e.a.a.b.b.a.dX(1) + 4) + 0) + (e.a.a.b.b.a.dX(2) + 4)) + e.a.a.a.fU(3, this.wjv);
            if (this.wjw != null) {
                dX += e.a.a.b.b.a.h(4, this.wjw);
            }
            if (this.wjx != null) {
                dX += e.a.a.b.b.a.h(5, this.wjx);
            }
            dX += e.a.a.a.fU(6, this.wjy);
            if (this.wCC != null) {
                return dX + e.a.a.b.b.a.h(7, this.wCC);
            }
            return dX;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (dX = a.a(aVar2); dX > 0; dX = a.a(aVar2)) {
                if (!super.a(aVar2, this, dX)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aou aou = (aou) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aou.vXx = aVar3.AEQ.readFloat();
                    return 0;
                case 2:
                    aou.vXy = aVar3.AEQ.readFloat();
                    return 0;
                case 3:
                    aou.wjv = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aou.wjw = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aou.wjx = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aou.wjy = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    aou.wCC = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aph extends a {
    public String kyG;
    public int kyY;
    public String kzN;
    public String pWq;
    public String wbY;
    public String wbZ;
    public String woW;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pWq != null) {
                aVar.g(1, this.pWq);
            }
            if (this.kyG != null) {
                aVar.g(2, this.kyG);
            }
            aVar.fX(3, this.kyY);
            if (this.wbY != null) {
                aVar.g(4, this.wbY);
            }
            if (this.wbZ != null) {
                aVar.g(5, this.wbZ);
            }
            if (this.kzN != null) {
                aVar.g(6, this.kzN);
            }
            if (this.woW == null) {
                return 0;
            }
            aVar.g(7, this.woW);
            return 0;
        } else if (i == 1) {
            if (this.pWq != null) {
                h = e.a.a.b.b.a.h(1, this.pWq) + 0;
            } else {
                h = 0;
            }
            if (this.kyG != null) {
                h += e.a.a.b.b.a.h(2, this.kyG);
            }
            h += e.a.a.a.fU(3, this.kyY);
            if (this.wbY != null) {
                h += e.a.a.b.b.a.h(4, this.wbY);
            }
            if (this.wbZ != null) {
                h += e.a.a.b.b.a.h(5, this.wbZ);
            }
            if (this.kzN != null) {
                h += e.a.a.b.b.a.h(6, this.kzN);
            }
            if (this.woW != null) {
                h += e.a.a.b.b.a.h(7, this.woW);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aph aph = (aph) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aph.pWq = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aph.kyG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aph.kyY = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aph.wbY = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aph.wbZ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aph.kzN = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    aph.woW = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

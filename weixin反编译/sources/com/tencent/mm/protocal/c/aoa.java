package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aoa extends a {
    public String vUW;
    public String vUX;
    public String vUY;
    public String vUZ;
    public String vVa;
    public int wBM;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vUW != null) {
                aVar.g(1, this.vUW);
            }
            if (this.vUX != null) {
                aVar.g(2, this.vUX);
            }
            if (this.vUY != null) {
                aVar.g(3, this.vUY);
            }
            if (this.vUZ != null) {
                aVar.g(4, this.vUZ);
            }
            if (this.vVa != null) {
                aVar.g(5, this.vVa);
            }
            aVar.fX(6, this.wBM);
            return 0;
        } else if (i == 1) {
            if (this.vUW != null) {
                h = e.a.a.b.b.a.h(1, this.vUW) + 0;
            } else {
                h = 0;
            }
            if (this.vUX != null) {
                h += e.a.a.b.b.a.h(2, this.vUX);
            }
            if (this.vUY != null) {
                h += e.a.a.b.b.a.h(3, this.vUY);
            }
            if (this.vUZ != null) {
                h += e.a.a.b.b.a.h(4, this.vUZ);
            }
            if (this.vVa != null) {
                h += e.a.a.b.b.a.h(5, this.vVa);
            }
            return h + e.a.a.a.fU(6, this.wBM);
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
            aoa aoa = (aoa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aoa.vUW = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aoa.vUX = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aoa.vUY = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aoa.vUZ = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aoa.vVa = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aoa.wBM = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class cy extends a {
    public String kzm;
    public String nMq;
    public String noG;
    public String vOC;
    public String vOD;
    public int vOE;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nMq != null) {
                aVar.g(1, this.nMq);
            }
            if (this.kzm != null) {
                aVar.g(2, this.kzm);
            }
            if (this.noG != null) {
                aVar.g(3, this.noG);
            }
            if (this.vOC != null) {
                aVar.g(4, this.vOC);
            }
            if (this.vOD != null) {
                aVar.g(5, this.vOD);
            }
            aVar.fX(6, this.vOE);
            return 0;
        } else if (i == 1) {
            if (this.nMq != null) {
                h = e.a.a.b.b.a.h(1, this.nMq) + 0;
            } else {
                h = 0;
            }
            if (this.kzm != null) {
                h += e.a.a.b.b.a.h(2, this.kzm);
            }
            if (this.noG != null) {
                h += e.a.a.b.b.a.h(3, this.noG);
            }
            if (this.vOC != null) {
                h += e.a.a.b.b.a.h(4, this.vOC);
            }
            if (this.vOD != null) {
                h += e.a.a.b.b.a.h(5, this.vOD);
            }
            return h + e.a.a.a.fU(6, this.vOE);
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
            cy cyVar = (cy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyVar.nMq = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cyVar.kzm = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cyVar.noG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cyVar.vOC = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    cyVar.vOD = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    cyVar.vOE = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

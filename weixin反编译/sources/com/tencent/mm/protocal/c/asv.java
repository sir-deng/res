package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class asv extends a {
    public int vUT;
    public int wHa;
    public b wHb;
    public String wHc;
    public String wbY;
    public String wbZ;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vUT);
            aVar.fX(2, this.wHa);
            if (this.wHb != null) {
                aVar.b(3, this.wHb);
            }
            if (this.wHc != null) {
                aVar.g(4, this.wHc);
            }
            if (this.wbY != null) {
                aVar.g(5, this.wbY);
            }
            if (this.wbZ != null) {
                aVar.g(6, this.wbZ);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.vUT) + 0) + e.a.a.a.fU(2, this.wHa);
            if (this.wHb != null) {
                fU += e.a.a.a.a(3, this.wHb);
            }
            if (this.wHc != null) {
                fU += e.a.a.b.b.a.h(4, this.wHc);
            }
            if (this.wbY != null) {
                fU += e.a.a.b.b.a.h(5, this.wbY);
            }
            if (this.wbZ != null) {
                return fU + e.a.a.b.b.a.h(6, this.wbZ);
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
            asv asv = (asv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asv.vUT = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    asv.wHa = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    asv.wHb = aVar3.cKw();
                    return 0;
                case 4:
                    asv.wHc = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    asv.wbY = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    asv.wbZ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

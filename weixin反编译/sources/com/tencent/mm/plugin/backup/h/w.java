package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class w extends a {
    public String ID;
    public int kyY;
    public b kyn;
    public int kzA;
    public b kzC;
    public int kzx;
    public int kzy;
    public int kzz;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new e.a.a.b("Not all required fields were included: ID");
            }
            aVar.fX(1, this.kzx);
            aVar.fX(2, this.kyY);
            if (this.ID != null) {
                aVar.g(3, this.ID);
            }
            if (this.kyn != null) {
                aVar.b(4, this.kyn);
            }
            aVar.fX(5, this.kzy);
            aVar.fX(6, this.kzz);
            aVar.fX(7, this.kzA);
            if (this.kzC != null) {
                aVar.b(8, this.kzC);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.kzx) + 0) + e.a.a.a.fU(2, this.kyY);
            if (this.ID != null) {
                fU += e.a.a.b.b.a.h(3, this.ID);
            }
            if (this.kyn != null) {
                fU += e.a.a.a.a(4, this.kyn);
            }
            fU = ((fU + e.a.a.a.fU(5, this.kzy)) + e.a.a.a.fU(6, this.kzz)) + e.a.a.a.fU(7, this.kzA);
            if (this.kzC != null) {
                return fU + e.a.a.a.a(8, this.kzC);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            w wVar = (w) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wVar.kzx = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    wVar.kyY = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    wVar.ID = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    wVar.kyn = aVar3.cKw();
                    return 0;
                case 5:
                    wVar.kzy = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    wVar.kzz = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    wVar.kzA = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    wVar.kzC = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

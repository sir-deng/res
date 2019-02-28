package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class v extends a {
    public String ID;
    public b kyn;
    public int kzA;
    public int kzB;
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
            if (this.ID != null) {
                aVar.g(2, this.ID);
            }
            if (this.kyn != null) {
                aVar.b(3, this.kyn);
            }
            aVar.fX(4, this.kzy);
            aVar.fX(5, this.kzz);
            aVar.fX(6, this.kzA);
            aVar.fX(7, this.kzB);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.kzx) + 0;
            if (this.ID != null) {
                fU += e.a.a.b.b.a.h(2, this.ID);
            }
            if (this.kyn != null) {
                fU += e.a.a.a.a(3, this.kyn);
            }
            return (((fU + e.a.a.a.fU(4, this.kzy)) + e.a.a.a.fU(5, this.kzz)) + e.a.a.a.fU(6, this.kzA)) + e.a.a.a.fU(7, this.kzB);
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
            v vVar = (v) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vVar.kzx = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    vVar.ID = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    vVar.kyn = aVar3.cKw();
                    return 0;
                case 4:
                    vVar.kzy = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    vVar.kzz = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    vVar.kzA = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    vVar.kzB = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class p extends a {
    public String ID;
    public long kyX;
    public int kza;
    public int kzb;
    public int kzc;
    public long kzd;
    public long kze;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            aVar.fX(2, this.kza);
            aVar.fX(3, this.kzb);
            aVar.fX(4, this.kzc);
            aVar.S(5, this.kyX);
            aVar.S(6, this.kzd);
            aVar.S(7, this.kze);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                h = e.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                h = 0;
            }
            return (((((h + e.a.a.a.fU(2, this.kza)) + e.a.a.a.fU(3, this.kzb)) + e.a.a.a.fU(4, this.kzc)) + e.a.a.a.R(5, this.kyX)) + e.a.a.a.R(6, this.kzd)) + e.a.a.a.R(7, this.kze);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.ID = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    pVar.kza = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    pVar.kzb = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    pVar.kzc = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    pVar.kyX = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    pVar.kzd = aVar3.AEQ.rA();
                    return 0;
                case 7:
                    pVar.kze = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

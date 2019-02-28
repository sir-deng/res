package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class y extends a {
    public int kyY;
    public String kzD;
    public int kzE;
    public int kzG;
    public int kzH;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kzD == null) {
                throw new b("Not all required fields were included: DataID");
            }
            if (this.kzD != null) {
                aVar.g(1, this.kzD);
            }
            aVar.fX(2, this.kzE);
            aVar.fX(3, this.kzG);
            aVar.fX(4, this.kzH);
            aVar.fX(5, this.kyY);
            return 0;
        } else if (i == 1) {
            if (this.kzD != null) {
                h = e.a.a.b.b.a.h(1, this.kzD) + 0;
            } else {
                h = 0;
            }
            return (((h + e.a.a.a.fU(2, this.kzE)) + e.a.a.a.fU(3, this.kzG)) + e.a.a.a.fU(4, this.kzH)) + e.a.a.a.fU(5, this.kyY);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.kzD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DataID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yVar.kzD = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    yVar.kzE = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    yVar.kzG = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    yVar.kzH = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    yVar.kyY = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class cz extends a {
    public int nph;
    public String npi;
    public String npj;
    public boolean npk;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.npj == null) {
                throw new b("Not all required fields were included: MediaURL");
            }
            aVar.fX(1, this.nph);
            if (this.npi != null) {
                aVar.g(2, this.npi);
            }
            if (this.npj != null) {
                aVar.g(3, this.npj);
            }
            aVar.am(4, this.npk);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.nph) + 0;
            if (this.npi != null) {
                fU += e.a.a.b.b.a.h(2, this.npi);
            }
            if (this.npj != null) {
                fU += e.a.a.b.b.a.h(3, this.npj);
            }
            return fU + (e.a.a.b.b.a.dX(4) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.npj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: MediaURL");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cz czVar = (cz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czVar.nph = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    czVar.npi = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    czVar.npj = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    czVar.npk = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

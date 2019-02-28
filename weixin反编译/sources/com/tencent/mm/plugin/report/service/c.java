package com.tencent.mm.plugin.report.service;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class c extends a {
    public boolean pWi;
    public int pWp;
    public String pWq;
    public boolean pWr;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pWq == null) {
                throw new b("Not all required fields were included: Value");
            }
            aVar.fX(1, this.pWp);
            if (this.pWq != null) {
                aVar.g(2, this.pWq);
            }
            aVar.am(3, this.pWr);
            aVar.am(4, this.pWi);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.pWp) + 0;
            if (this.pWq != null) {
                fU += e.a.a.b.b.a.h(2, this.pWq);
            }
            return (fU + (e.a.a.b.b.a.dX(3) + 1)) + (e.a.a.b.b.a.dX(4) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.pWq != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Value");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.pWp = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    cVar.pWq = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cVar.pWr = aVar3.cKv();
                    return 0;
                case 4:
                    cVar.pWi = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

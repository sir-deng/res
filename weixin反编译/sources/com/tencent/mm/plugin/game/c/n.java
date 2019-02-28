package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class n extends a {
    public String nkQ;
    public String nkV;
    public String nkW;
    public int nlF;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkW == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.nkV == null) {
                throw new b("Not all required fields were included: IconURL");
            } else {
                aVar.fX(1, this.nlF);
                if (this.nkW != null) {
                    aVar.g(2, this.nkW);
                }
                if (this.nkV != null) {
                    aVar.g(3, this.nkV);
                }
                if (this.nkQ != null) {
                    aVar.g(4, this.nkQ);
                }
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.nlF) + 0;
            if (this.nkW != null) {
                fU += e.a.a.b.b.a.h(2, this.nkW);
            }
            if (this.nkV != null) {
                fU += e.a.a.b.b.a.h(3, this.nkV);
            }
            if (this.nkQ != null) {
                return fU + e.a.a.b.b.a.h(4, this.nkQ);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.nkW == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.nkV != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: IconURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.nlF = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    nVar.nkW = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    nVar.nkV = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    nVar.nkQ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

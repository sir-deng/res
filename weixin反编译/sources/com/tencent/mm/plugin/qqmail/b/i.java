package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class i extends a {
    public String nWa;
    public String name;
    public int puj;
    public int puk;
    public String pul;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.nWa == null) {
                throw new b("Not all required fields were included: addr");
            } else {
                aVar.fX(1, this.puj);
                if (this.name != null) {
                    aVar.g(2, this.name);
                }
                if (this.nWa != null) {
                    aVar.g(3, this.nWa);
                }
                aVar.fX(4, this.puk);
                if (this.pul != null) {
                    aVar.g(5, this.pul);
                }
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.puj) + 0;
            if (this.name != null) {
                fU += e.a.a.b.b.a.h(2, this.name);
            }
            if (this.nWa != null) {
                fU += e.a.a.b.b.a.h(3, this.nWa);
            }
            fU += e.a.a.a.fU(4, this.puk);
            if (this.pul != null) {
                return fU + e.a.a.b.b.a.h(5, this.pul);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.nWa != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: addr");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.puj = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    iVar.name = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    iVar.nWa = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    iVar.puk = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    iVar.pul = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

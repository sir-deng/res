package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bp.a;

public final class ah extends a {
    public String content;
    public int gGi;
    public String iconUrl;
    public String name;
    public int ojk;
    public int ojl;
    public String type;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.gGi);
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.type != null) {
                aVar.g(3, this.type);
            }
            if (this.content != null) {
                aVar.g(4, this.content);
            }
            aVar.fX(5, this.ojk);
            if (this.iconUrl != null) {
                aVar.g(6, this.iconUrl);
            }
            aVar.fX(7, this.ojl);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.gGi) + 0;
            if (this.name != null) {
                fU += e.a.a.b.b.a.h(2, this.name);
            }
            if (this.type != null) {
                fU += e.a.a.b.b.a.h(3, this.type);
            }
            if (this.content != null) {
                fU += e.a.a.b.b.a.h(4, this.content);
            }
            fU += e.a.a.a.fU(5, this.ojk);
            if (this.iconUrl != null) {
                fU += e.a.a.b.b.a.h(6, this.iconUrl);
            }
            return fU + e.a.a.a.fU(7, this.ojl);
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
            ah ahVar = (ah) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ahVar.gGi = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    ahVar.name = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ahVar.type = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ahVar.content = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ahVar.ojk = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    ahVar.iconUrl = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    ahVar.ojl = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bp.a;

public final class n extends a {
    public int fEo;
    public String fGh;
    public String name;
    public String pkG;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fGh != null) {
                aVar.g(1, this.fGh);
            }
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.pkG != null) {
                aVar.g(3, this.pkG);
            }
            if (this.username != null) {
                aVar.g(4, this.username);
            }
            aVar.fX(5, this.fEo);
            return 0;
        } else if (i == 1) {
            if (this.fGh != null) {
                h = e.a.a.b.b.a.h(1, this.fGh) + 0;
            } else {
                h = 0;
            }
            if (this.name != null) {
                h += e.a.a.b.b.a.h(2, this.name);
            }
            if (this.pkG != null) {
                h += e.a.a.b.b.a.h(3, this.pkG);
            }
            if (this.username != null) {
                h += e.a.a.b.b.a.h(4, this.username);
            }
            return h + e.a.a.a.fU(5, this.fEo);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.fGh = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    nVar.name = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    nVar.pkG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    nVar.username = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    nVar.fEo = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

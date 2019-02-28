package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class hp extends a {
    public String name;
    public int type;
    public String vUb;
    public String vUc;
    public int vUd;
    public int vUe;
    public String vUf;
    public String vUg;
    public int ver;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vUb != null) {
                aVar.g(1, this.vUb);
            }
            aVar.fX(2, this.type);
            if (this.vUc != null) {
                aVar.g(3, this.vUc);
            }
            if (this.name != null) {
                aVar.g(4, this.name);
            }
            aVar.fX(5, this.ver);
            aVar.fX(6, this.vUd);
            aVar.fX(7, this.vUe);
            if (this.vUf != null) {
                aVar.g(8, this.vUf);
            }
            if (this.vUg == null) {
                return 0;
            }
            aVar.g(9, this.vUg);
            return 0;
        } else if (i == 1) {
            if (this.vUb != null) {
                h = e.a.a.b.b.a.h(1, this.vUb) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.type);
            if (this.vUc != null) {
                h += e.a.a.b.b.a.h(3, this.vUc);
            }
            if (this.name != null) {
                h += e.a.a.b.b.a.h(4, this.name);
            }
            h = ((h + e.a.a.a.fU(5, this.ver)) + e.a.a.a.fU(6, this.vUd)) + e.a.a.a.fU(7, this.vUe);
            if (this.vUf != null) {
                h += e.a.a.b.b.a.h(8, this.vUf);
            }
            if (this.vUg != null) {
                h += e.a.a.b.b.a.h(9, this.vUg);
            }
            return h;
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
            hp hpVar = (hp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hpVar.vUb = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    hpVar.type = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    hpVar.vUc = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    hpVar.name = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    hpVar.ver = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    hpVar.vUd = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    hpVar.vUe = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    hpVar.vUf = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    hpVar.vUg = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

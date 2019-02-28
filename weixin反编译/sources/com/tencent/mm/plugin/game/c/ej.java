package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class ej extends a {
    public String nlM;
    public String nqg;
    public String nqh;
    public String nqi;
    public String nqj;
    public int nqk;
    public String nql;
    public String nqm;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlM != null) {
                aVar.g(1, this.nlM);
            }
            if (this.nqg != null) {
                aVar.g(2, this.nqg);
            }
            if (this.nqh != null) {
                aVar.g(3, this.nqh);
            }
            if (this.nqi != null) {
                aVar.g(4, this.nqi);
            }
            if (this.nqj != null) {
                aVar.g(5, this.nqj);
            }
            aVar.fX(6, this.nqk);
            if (this.nql != null) {
                aVar.g(7, this.nql);
            }
            if (this.nqm == null) {
                return 0;
            }
            aVar.g(8, this.nqm);
            return 0;
        } else if (i == 1) {
            if (this.nlM != null) {
                h = e.a.a.b.b.a.h(1, this.nlM) + 0;
            } else {
                h = 0;
            }
            if (this.nqg != null) {
                h += e.a.a.b.b.a.h(2, this.nqg);
            }
            if (this.nqh != null) {
                h += e.a.a.b.b.a.h(3, this.nqh);
            }
            if (this.nqi != null) {
                h += e.a.a.b.b.a.h(4, this.nqi);
            }
            if (this.nqj != null) {
                h += e.a.a.b.b.a.h(5, this.nqj);
            }
            h += e.a.a.a.fU(6, this.nqk);
            if (this.nql != null) {
                h += e.a.a.b.b.a.h(7, this.nql);
            }
            if (this.nqm != null) {
                h += e.a.a.b.b.a.h(8, this.nqm);
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
            ej ejVar = (ej) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ejVar.nlM = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ejVar.nqg = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ejVar.nqh = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ejVar.nqi = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ejVar.nqj = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    ejVar.nqk = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    ejVar.nql = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    ejVar.nqm = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

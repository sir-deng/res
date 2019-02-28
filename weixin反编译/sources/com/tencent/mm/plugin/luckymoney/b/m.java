package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bp.a;

public final class m extends a {
    public String ohB;
    public long ohW;
    public String ohX;
    public String oii;
    public String oij;
    public String oik;
    public String oil;
    public String userName;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.oii != null) {
                aVar.g(1, this.oii);
            }
            if (this.oij != null) {
                aVar.g(2, this.oij);
            }
            aVar.S(3, this.ohW);
            if (this.ohX != null) {
                aVar.g(4, this.ohX);
            }
            if (this.oik != null) {
                aVar.g(5, this.oik);
            }
            if (this.ohB != null) {
                aVar.g(6, this.ohB);
            }
            if (this.oil != null) {
                aVar.g(7, this.oil);
            }
            if (this.userName == null) {
                return 0;
            }
            aVar.g(8, this.userName);
            return 0;
        } else if (i == 1) {
            if (this.oii != null) {
                h = e.a.a.b.b.a.h(1, this.oii) + 0;
            } else {
                h = 0;
            }
            if (this.oij != null) {
                h += e.a.a.b.b.a.h(2, this.oij);
            }
            h += e.a.a.a.R(3, this.ohW);
            if (this.ohX != null) {
                h += e.a.a.b.b.a.h(4, this.ohX);
            }
            if (this.oik != null) {
                h += e.a.a.b.b.a.h(5, this.oik);
            }
            if (this.ohB != null) {
                h += e.a.a.b.b.a.h(6, this.ohB);
            }
            if (this.oil != null) {
                h += e.a.a.b.b.a.h(7, this.oil);
            }
            if (this.userName != null) {
                h += e.a.a.b.b.a.h(8, this.userName);
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
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.oii = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    mVar.oij = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    mVar.ohW = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    mVar.ohX = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    mVar.oik = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    mVar.ohB = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    mVar.oil = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    mVar.userName = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

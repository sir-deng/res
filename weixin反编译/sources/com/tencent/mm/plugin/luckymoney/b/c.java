package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bp.a;

public final class c extends a {
    public int loD;
    public int ohf;
    public double ohg;
    public String ohh;
    public String ohi;
    public double ohj;
    public double ohk;
    public double ohl;
    public int ohm;
    public String ohn;
    public String oho;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.ohf);
            aVar.b(2, this.ohg);
            if (this.ohh != null) {
                aVar.g(3, this.ohh);
            }
            if (this.ohi != null) {
                aVar.g(4, this.ohi);
            }
            aVar.b(5, this.ohj);
            aVar.b(6, this.ohk);
            aVar.b(7, this.ohl);
            aVar.fX(8, this.ohm);
            aVar.fX(9, this.loD);
            if (this.ohn != null) {
                aVar.g(10, this.ohn);
            }
            if (this.oho != null) {
                aVar.g(11, this.oho);
            }
            return 0;
        } else if (i == 1) {
            fU = (e.a.a.a.fU(1, this.ohf) + 0) + (e.a.a.b.b.a.dX(2) + 8);
            if (this.ohh != null) {
                fU += e.a.a.b.b.a.h(3, this.ohh);
            }
            if (this.ohi != null) {
                fU += e.a.a.b.b.a.h(4, this.ohi);
            }
            fU = ((((fU + (e.a.a.b.b.a.dX(5) + 8)) + (e.a.a.b.b.a.dX(6) + 8)) + (e.a.a.b.b.a.dX(7) + 8)) + e.a.a.a.fU(8, this.ohm)) + e.a.a.a.fU(9, this.loD);
            if (this.ohn != null) {
                fU += e.a.a.b.b.a.h(10, this.ohn);
            }
            if (this.oho != null) {
                return fU + e.a.a.b.b.a.h(11, this.oho);
            }
            return fU;
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
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.ohf = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    cVar.ohg = aVar3.AEQ.readDouble();
                    return 0;
                case 3:
                    cVar.ohh = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cVar.ohi = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    cVar.ohj = aVar3.AEQ.readDouble();
                    return 0;
                case 6:
                    cVar.ohk = aVar3.AEQ.readDouble();
                    return 0;
                case 7:
                    cVar.ohl = aVar3.AEQ.readDouble();
                    return 0;
                case 8:
                    cVar.ohm = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    cVar.loD = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    cVar.ohn = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    cVar.oho = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.c;

import com.tencent.mm.bp.a;

public final class b extends a {
    public String apkMd5;
    public int fei;
    public String fej;
    public int fek;
    public String fel;
    public String fem;
    public boolean fen;
    public int feo;
    public boolean fep;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.apkMd5 == null) {
                throw new e.a.a.b("Not all required fields were included: apkMd5");
            }
            if (this.apkMd5 != null) {
                aVar.g(1, this.apkMd5);
            }
            aVar.fY(2, this.fei);
            if (this.fej != null) {
                aVar.g(3, this.fej);
            }
            aVar.fY(4, this.fek);
            if (this.fel != null) {
                aVar.g(5, this.fel);
            }
            if (this.fem != null) {
                aVar.g(6, this.fem);
            }
            aVar.am(7, this.fen);
            aVar.fY(8, this.feo);
            aVar.am(9, this.fep);
            return 0;
        } else if (i == 1) {
            if (this.apkMd5 != null) {
                h = e.a.a.a.h(1, this.apkMd5) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fV(2, this.fei);
            if (this.fej != null) {
                h += e.a.a.a.h(3, this.fej);
            }
            h += e.a.a.a.fV(4, this.fek);
            if (this.fel != null) {
                h += e.a.a.a.h(5, this.fel);
            }
            if (this.fem != null) {
                h += e.a.a.a.h(6, this.fem);
            }
            return ((h + e.a.a.a.JC(7)) + e.a.a.a.fV(8, this.feo)) + e.a.a.a.JC(9);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.apkMd5 != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: apkMd5");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.apkMd5 = aVar3.cKu();
                    return 0;
                case 2:
                    bVar.fei = aVar3.cKs();
                    return 0;
                case 3:
                    bVar.fej = aVar3.cKu();
                    return 0;
                case 4:
                    bVar.fek = aVar3.cKs();
                    return 0;
                case 5:
                    bVar.fel = aVar3.cKu();
                    return 0;
                case 6:
                    bVar.fem = aVar3.cKu();
                    return 0;
                case 7:
                    bVar.fen = aVar3.cKv();
                    return 0;
                case 8:
                    bVar.feo = aVar3.cKs();
                    return 0;
                case 9:
                    bVar.fep = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

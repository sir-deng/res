package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bp.a;

public final class h extends a {
    public String oeH;
    public long ohA;
    public String ohB;
    public int ohM;
    public String ohV;
    public long ohW;
    public String ohX;
    public String ohY;
    public String ohZ;
    public int ohq;
    public String ohv;
    public long ohy;
    public long oia;
    public int oib;
    public int status;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ohV != null) {
                aVar.g(1, this.ohV);
            }
            if (this.ohv != null) {
                aVar.g(2, this.ohv);
            }
            aVar.S(3, this.ohW);
            if (this.ohX != null) {
                aVar.g(4, this.ohX);
            }
            aVar.fX(5, this.ohq);
            if (this.ohY != null) {
                aVar.g(6, this.ohY);
            }
            if (this.ohZ != null) {
                aVar.g(7, this.ohZ);
            }
            aVar.S(8, this.ohA);
            aVar.S(9, this.oia);
            aVar.S(10, this.ohy);
            aVar.fX(11, this.status);
            aVar.fX(12, this.oib);
            if (this.ohB != null) {
                aVar.g(13, this.ohB);
            }
            if (this.oeH != null) {
                aVar.g(14, this.oeH);
            }
            aVar.fX(15, this.ohM);
            return 0;
        } else if (i == 1) {
            if (this.ohV != null) {
                h = e.a.a.b.b.a.h(1, this.ohV) + 0;
            } else {
                h = 0;
            }
            if (this.ohv != null) {
                h += e.a.a.b.b.a.h(2, this.ohv);
            }
            h += e.a.a.a.R(3, this.ohW);
            if (this.ohX != null) {
                h += e.a.a.b.b.a.h(4, this.ohX);
            }
            h += e.a.a.a.fU(5, this.ohq);
            if (this.ohY != null) {
                h += e.a.a.b.b.a.h(6, this.ohY);
            }
            if (this.ohZ != null) {
                h += e.a.a.b.b.a.h(7, this.ohZ);
            }
            h = ((((h + e.a.a.a.R(8, this.ohA)) + e.a.a.a.R(9, this.oia)) + e.a.a.a.R(10, this.ohy)) + e.a.a.a.fU(11, this.status)) + e.a.a.a.fU(12, this.oib);
            if (this.ohB != null) {
                h += e.a.a.b.b.a.h(13, this.ohB);
            }
            if (this.oeH != null) {
                h += e.a.a.b.b.a.h(14, this.oeH);
            }
            return h + e.a.a.a.fU(15, this.ohM);
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
            h hVar = (h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hVar.ohV = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    hVar.ohv = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    hVar.ohW = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    hVar.ohX = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    hVar.ohq = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    hVar.ohY = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    hVar.ohZ = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    hVar.ohA = aVar3.AEQ.rA();
                    return 0;
                case 9:
                    hVar.oia = aVar3.AEQ.rA();
                    return 0;
                case 10:
                    hVar.ohy = aVar3.AEQ.rA();
                    return 0;
                case 11:
                    hVar.status = aVar3.AEQ.rz();
                    return 0;
                case 12:
                    hVar.oib = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    hVar.ohB = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    hVar.oeH = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    hVar.ohM = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bdu extends a {
    public int sfa;
    public long vWt;
    public String wDX;
    public long wMR;
    public String wQq;
    public String wQr;
    public int wQs;
    public int wQt;
    public int wQu;
    public String wQv;
    public String wQw;
    public String wQx;
    public int weg;
    public int wzs;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.sfa);
            if (this.wDX != null) {
                aVar.g(2, this.wDX);
            }
            if (this.wQq != null) {
                aVar.g(3, this.wQq);
            }
            aVar.S(4, this.vWt);
            if (this.wQr != null) {
                aVar.g(5, this.wQr);
            }
            aVar.fX(6, this.wQs);
            aVar.fX(7, this.wQt);
            aVar.fX(8, this.wQu);
            aVar.S(9, this.wMR);
            aVar.fX(10, this.wzs);
            if (this.wQv != null) {
                aVar.g(11, this.wQv);
            }
            aVar.fX(12, this.weg);
            if (this.wQw != null) {
                aVar.g(13, this.wQw);
            }
            if (this.wQx != null) {
                aVar.g(14, this.wQx);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.sfa) + 0;
            if (this.wDX != null) {
                fU += e.a.a.b.b.a.h(2, this.wDX);
            }
            if (this.wQq != null) {
                fU += e.a.a.b.b.a.h(3, this.wQq);
            }
            fU += e.a.a.a.R(4, this.vWt);
            if (this.wQr != null) {
                fU += e.a.a.b.b.a.h(5, this.wQr);
            }
            fU = ((((fU + e.a.a.a.fU(6, this.wQs)) + e.a.a.a.fU(7, this.wQt)) + e.a.a.a.fU(8, this.wQu)) + e.a.a.a.R(9, this.wMR)) + e.a.a.a.fU(10, this.wzs);
            if (this.wQv != null) {
                fU += e.a.a.b.b.a.h(11, this.wQv);
            }
            fU += e.a.a.a.fU(12, this.weg);
            if (this.wQw != null) {
                fU += e.a.a.b.b.a.h(13, this.wQw);
            }
            if (this.wQx != null) {
                return fU + e.a.a.b.b.a.h(14, this.wQx);
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
            bdu bdu = (bdu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdu.sfa = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bdu.wDX = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bdu.wQq = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bdu.vWt = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    bdu.wQr = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bdu.wQs = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bdu.wQt = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bdu.wQu = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    bdu.wMR = aVar3.AEQ.rA();
                    return 0;
                case 10:
                    bdu.wzs = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    bdu.wQv = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    bdu.weg = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    bdu.wQw = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    bdu.wQx = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

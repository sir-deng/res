package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class alk extends a {
    public String nlB;
    public String pke;
    public int wcX;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wcX);
            if (this.pke != null) {
                aVar.g(2, this.pke);
            }
            if (this.nlB != null) {
                aVar.g(3, this.nlB);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wcX) + 0;
            if (this.pke != null) {
                fU += e.a.a.b.b.a.h(2, this.pke);
            }
            if (this.nlB != null) {
                return fU + e.a.a.b.b.a.h(3, this.nlB);
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
            alk alk = (alk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    alk.wcX = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    alk.pke = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    alk.nlB = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

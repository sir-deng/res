package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class atk extends a {
    public String wHS;
    public String wHT;
    public int wHU;
    public int wHV;
    public int wHW;
    public int wHX;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wHS != null) {
                aVar.g(1, this.wHS);
            }
            if (this.wHT != null) {
                aVar.g(2, this.wHT);
            }
            aVar.fX(3, this.wHU);
            aVar.fX(4, this.wHV);
            aVar.fX(5, this.wHW);
            aVar.fX(7, this.wHX);
            return 0;
        } else if (i == 1) {
            if (this.wHS != null) {
                h = e.a.a.b.b.a.h(1, this.wHS) + 0;
            } else {
                h = 0;
            }
            if (this.wHT != null) {
                h += e.a.a.b.b.a.h(2, this.wHT);
            }
            return (((h + e.a.a.a.fU(3, this.wHU)) + e.a.a.a.fU(4, this.wHV)) + e.a.a.a.fU(5, this.wHW)) + e.a.a.a.fU(7, this.wHX);
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
            atk atk = (atk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atk.wHS = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    atk.wHT = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    atk.wHU = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    atk.wHV = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    atk.wHW = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    atk.wHX = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

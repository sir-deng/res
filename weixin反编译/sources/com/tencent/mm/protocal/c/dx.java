package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class dx extends a {
    public String nkU;
    public String nlA;
    public String nlr;
    public String noG;
    public String vPL;
    public String vPM;
    public String vPN;
    public int vPc;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkU != null) {
                aVar.g(1, this.nkU);
            }
            if (this.vPL != null) {
                aVar.g(2, this.vPL);
            }
            if (this.nlA != null) {
                aVar.g(3, this.nlA);
            }
            if (this.noG != null) {
                aVar.g(4, this.noG);
            }
            aVar.fX(5, this.vPc);
            if (this.nlr != null) {
                aVar.g(6, this.nlr);
            }
            if (this.vPM != null) {
                aVar.g(7, this.vPM);
            }
            if (this.vPN == null) {
                return 0;
            }
            aVar.g(8, this.vPN);
            return 0;
        } else if (i == 1) {
            if (this.nkU != null) {
                h = e.a.a.b.b.a.h(1, this.nkU) + 0;
            } else {
                h = 0;
            }
            if (this.vPL != null) {
                h += e.a.a.b.b.a.h(2, this.vPL);
            }
            if (this.nlA != null) {
                h += e.a.a.b.b.a.h(3, this.nlA);
            }
            if (this.noG != null) {
                h += e.a.a.b.b.a.h(4, this.noG);
            }
            h += e.a.a.a.fU(5, this.vPc);
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(6, this.nlr);
            }
            if (this.vPM != null) {
                h += e.a.a.b.b.a.h(7, this.vPM);
            }
            if (this.vPN != null) {
                h += e.a.a.b.b.a.h(8, this.vPN);
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
            dx dxVar = (dx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dxVar.nkU = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    dxVar.vPL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    dxVar.nlA = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    dxVar.noG = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    dxVar.vPc = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    dxVar.nlr = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    dxVar.vPM = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    dxVar.vPN = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class akr extends a {
    public String pMZ;
    public int state;
    public String title;
    public String vWn;
    public String wyA;
    public long wyB;
    public String wyC;
    public String wyD;
    public String wyE;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vWn != null) {
                aVar.g(1, this.vWn);
            }
            aVar.fX(2, this.state);
            if (this.title != null) {
                aVar.g(3, this.title);
            }
            if (this.wyA != null) {
                aVar.g(4, this.wyA);
            }
            aVar.S(5, this.wyB);
            if (this.wyC != null) {
                aVar.g(6, this.wyC);
            }
            if (this.pMZ != null) {
                aVar.g(7, this.pMZ);
            }
            if (this.wyD != null) {
                aVar.g(8, this.wyD);
            }
            if (this.wyE == null) {
                return 0;
            }
            aVar.g(9, this.wyE);
            return 0;
        } else if (i == 1) {
            if (this.vWn != null) {
                h = e.a.a.b.b.a.h(1, this.vWn) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.state);
            if (this.title != null) {
                h += e.a.a.b.b.a.h(3, this.title);
            }
            if (this.wyA != null) {
                h += e.a.a.b.b.a.h(4, this.wyA);
            }
            h += e.a.a.a.R(5, this.wyB);
            if (this.wyC != null) {
                h += e.a.a.b.b.a.h(6, this.wyC);
            }
            if (this.pMZ != null) {
                h += e.a.a.b.b.a.h(7, this.pMZ);
            }
            if (this.wyD != null) {
                h += e.a.a.b.b.a.h(8, this.wyD);
            }
            if (this.wyE != null) {
                h += e.a.a.b.b.a.h(9, this.wyE);
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
            akr akr = (akr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    akr.vWn = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    akr.state = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    akr.title = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    akr.wyA = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    akr.wyB = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    akr.wyC = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    akr.pMZ = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    akr.wyD = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    akr.wyE = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

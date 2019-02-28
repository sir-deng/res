package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class kr extends a {
    public String country;
    public String descriptor;
    public float fAo;
    public float fBX;
    public String fXk;
    public String fXl;
    public String hzf;
    public String kPP;
    public String kRm;
    public String name;
    public float vYA;
    public String vYB;
    public String vYC;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.g(1, this.name);
            }
            if (this.descriptor != null) {
                aVar.g(2, this.descriptor);
            }
            if (this.kPP != null) {
                aVar.g(3, this.kPP);
            }
            if (this.country != null) {
                aVar.g(4, this.country);
            }
            if (this.fXk != null) {
                aVar.g(5, this.fXk);
            }
            if (this.fXl != null) {
                aVar.g(6, this.fXl);
            }
            if (this.hzf != null) {
                aVar.g(7, this.hzf);
            }
            aVar.m(8, this.vYA);
            aVar.m(9, this.fBX);
            aVar.m(10, this.fAo);
            if (this.kRm != null) {
                aVar.g(11, this.kRm);
            }
            if (this.vYB != null) {
                aVar.g(12, this.vYB);
            }
            if (this.vYC == null) {
                return 0;
            }
            aVar.g(13, this.vYC);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                h = e.a.a.b.b.a.h(1, this.name) + 0;
            } else {
                h = 0;
            }
            if (this.descriptor != null) {
                h += e.a.a.b.b.a.h(2, this.descriptor);
            }
            if (this.kPP != null) {
                h += e.a.a.b.b.a.h(3, this.kPP);
            }
            if (this.country != null) {
                h += e.a.a.b.b.a.h(4, this.country);
            }
            if (this.fXk != null) {
                h += e.a.a.b.b.a.h(5, this.fXk);
            }
            if (this.fXl != null) {
                h += e.a.a.b.b.a.h(6, this.fXl);
            }
            if (this.hzf != null) {
                h += e.a.a.b.b.a.h(7, this.hzf);
            }
            h = ((h + (e.a.a.b.b.a.dX(8) + 4)) + (e.a.a.b.b.a.dX(9) + 4)) + (e.a.a.b.b.a.dX(10) + 4);
            if (this.kRm != null) {
                h += e.a.a.b.b.a.h(11, this.kRm);
            }
            if (this.vYB != null) {
                h += e.a.a.b.b.a.h(12, this.vYB);
            }
            if (this.vYC != null) {
                h += e.a.a.b.b.a.h(13, this.vYC);
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
            kr krVar = (kr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    krVar.name = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    krVar.descriptor = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    krVar.kPP = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    krVar.country = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    krVar.fXk = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    krVar.fXl = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    krVar.hzf = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    krVar.vYA = aVar3.AEQ.readFloat();
                    return 0;
                case 9:
                    krVar.fBX = aVar3.AEQ.readFloat();
                    return 0;
                case 10:
                    krVar.fAo = aVar3.AEQ.readFloat();
                    return 0;
                case 11:
                    krVar.kRm = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    krVar.vYB = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    krVar.vYC = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

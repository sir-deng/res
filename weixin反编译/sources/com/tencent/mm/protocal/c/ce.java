package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ce extends a {
    public String hxf;
    public String hxg;
    public String hxn;
    public String kyG;
    public String nlZ;
    public String vOc;
    public String vOd;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.hxn != null) {
                aVar.g(1, this.hxn);
            }
            if (this.hxf != null) {
                aVar.g(2, this.hxf);
            }
            if (this.hxg != null) {
                aVar.g(3, this.hxg);
            }
            if (this.nlZ != null) {
                aVar.g(4, this.nlZ);
            }
            if (this.kyG != null) {
                aVar.g(5, this.kyG);
            }
            if (this.vOc != null) {
                aVar.g(6, this.vOc);
            }
            if (this.vOd == null) {
                return 0;
            }
            aVar.g(7, this.vOd);
            return 0;
        } else if (i == 1) {
            if (this.hxn != null) {
                h = e.a.a.b.b.a.h(1, this.hxn) + 0;
            } else {
                h = 0;
            }
            if (this.hxf != null) {
                h += e.a.a.b.b.a.h(2, this.hxf);
            }
            if (this.hxg != null) {
                h += e.a.a.b.b.a.h(3, this.hxg);
            }
            if (this.nlZ != null) {
                h += e.a.a.b.b.a.h(4, this.nlZ);
            }
            if (this.kyG != null) {
                h += e.a.a.b.b.a.h(5, this.kyG);
            }
            if (this.vOc != null) {
                h += e.a.a.b.b.a.h(6, this.vOc);
            }
            if (this.vOd != null) {
                h += e.a.a.b.b.a.h(7, this.vOd);
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
            ce ceVar = (ce) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ceVar.hxn = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ceVar.hxf = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ceVar.hxg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ceVar.nlZ = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ceVar.kyG = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    ceVar.vOc = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    ceVar.vOd = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

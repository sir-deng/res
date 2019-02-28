package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ayl extends a {
    public String hxg;
    public String hxn;
    public float vXx;
    public float vXy;
    public String wMa;
    public String wMb;
    public long wMc;
    public String wyY;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wMa != null) {
                aVar.g(1, this.wMa);
            }
            if (this.hxn != null) {
                aVar.g(2, this.hxn);
            }
            if (this.hxg != null) {
                aVar.g(3, this.hxg);
            }
            if (this.wyY != null) {
                aVar.g(4, this.wyY);
            }
            aVar.m(5, this.vXy);
            aVar.m(6, this.vXx);
            if (this.wMb != null) {
                aVar.g(7, this.wMb);
            }
            aVar.S(8, this.wMc);
            return 0;
        } else if (i == 1) {
            if (this.wMa != null) {
                h = e.a.a.b.b.a.h(1, this.wMa) + 0;
            } else {
                h = 0;
            }
            if (this.hxn != null) {
                h += e.a.a.b.b.a.h(2, this.hxn);
            }
            if (this.hxg != null) {
                h += e.a.a.b.b.a.h(3, this.hxg);
            }
            if (this.wyY != null) {
                h += e.a.a.b.b.a.h(4, this.wyY);
            }
            h = (h + (e.a.a.b.b.a.dX(5) + 4)) + (e.a.a.b.b.a.dX(6) + 4);
            if (this.wMb != null) {
                h += e.a.a.b.b.a.h(7, this.wMb);
            }
            return h + e.a.a.a.R(8, this.wMc);
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
            ayl ayl = (ayl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayl.wMa = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ayl.hxn = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ayl.hxg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ayl.wyY = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ayl.vXy = aVar3.AEQ.readFloat();
                    return 0;
                case 6:
                    ayl.vXx = aVar3.AEQ.readFloat();
                    return 0;
                case 7:
                    ayl.wMb = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    ayl.wMc = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class byc extends a {
    public String nlG;
    public String npW;
    public String wMx;
    public String xfA;
    public String xfz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wMx != null) {
                aVar.g(1, this.wMx);
            }
            if (this.xfz != null) {
                aVar.g(2, this.xfz);
            }
            if (this.npW != null) {
                aVar.g(3, this.npW);
            }
            if (this.nlG != null) {
                aVar.g(4, this.nlG);
            }
            if (this.xfA == null) {
                return 0;
            }
            aVar.g(5, this.xfA);
            return 0;
        } else if (i == 1) {
            if (this.wMx != null) {
                h = e.a.a.b.b.a.h(1, this.wMx) + 0;
            } else {
                h = 0;
            }
            if (this.xfz != null) {
                h += e.a.a.b.b.a.h(2, this.xfz);
            }
            if (this.npW != null) {
                h += e.a.a.b.b.a.h(3, this.npW);
            }
            if (this.nlG != null) {
                h += e.a.a.b.b.a.h(4, this.nlG);
            }
            if (this.xfA != null) {
                h += e.a.a.b.b.a.h(5, this.xfA);
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
            byc byc = (byc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    byc.wMx = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    byc.xfz = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    byc.npW = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    byc.nlG = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    byc.xfA = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

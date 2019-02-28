package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class awv extends a {
    public String fGh;
    public String kPA;
    public String vYJ;
    public int wKV;
    public String wKW;
    public String wKX;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fGh != null) {
                aVar.g(1, this.fGh);
            }
            aVar.fX(2, this.wKV);
            if (this.wKW != null) {
                aVar.g(3, this.wKW);
            }
            if (this.wKX != null) {
                aVar.g(4, this.wKX);
            }
            if (this.vYJ != null) {
                aVar.g(5, this.vYJ);
            }
            if (this.kPA == null) {
                return 0;
            }
            aVar.g(6, this.kPA);
            return 0;
        } else if (i == 1) {
            if (this.fGh != null) {
                h = e.a.a.b.b.a.h(1, this.fGh) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.wKV);
            if (this.wKW != null) {
                h += e.a.a.b.b.a.h(3, this.wKW);
            }
            if (this.wKX != null) {
                h += e.a.a.b.b.a.h(4, this.wKX);
            }
            if (this.vYJ != null) {
                h += e.a.a.b.b.a.h(5, this.vYJ);
            }
            if (this.kPA != null) {
                h += e.a.a.b.b.a.h(6, this.kPA);
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
            awv awv = (awv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awv.fGh = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    awv.wKV = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    awv.wKW = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    awv.wKX = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    awv.vYJ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    awv.kPA = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

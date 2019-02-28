package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aym extends a {
    public String sKt;
    public String wMd;
    public String wMe;
    public String wgp;
    public int wxv;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wMd != null) {
                aVar.g(1, this.wMd);
            }
            if (this.wMe != null) {
                aVar.g(2, this.wMe);
            }
            if (this.sKt != null) {
                aVar.g(3, this.sKt);
            }
            if (this.wgp != null) {
                aVar.g(4, this.wgp);
            }
            aVar.fX(5, this.wxv);
            return 0;
        } else if (i == 1) {
            if (this.wMd != null) {
                h = e.a.a.b.b.a.h(1, this.wMd) + 0;
            } else {
                h = 0;
            }
            if (this.wMe != null) {
                h += e.a.a.b.b.a.h(2, this.wMe);
            }
            if (this.sKt != null) {
                h += e.a.a.b.b.a.h(3, this.sKt);
            }
            if (this.wgp != null) {
                h += e.a.a.b.b.a.h(4, this.wgp);
            }
            return h + e.a.a.a.fU(5, this.wxv);
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
            aym aym = (aym) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aym.wMd = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aym.wMe = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aym.sKt = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aym.wgp = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aym.wxv = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

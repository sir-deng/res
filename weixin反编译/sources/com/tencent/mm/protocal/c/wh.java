package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class wh extends a {
    public int kzt;
    public String wnt;
    public long wnu;
    public String wnv;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wnt == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.wnv == null) {
                throw new b("Not all required fields were included: MimeType");
            } else {
                if (this.wnt != null) {
                    aVar.g(1, this.wnt);
                }
                aVar.S(2, this.wnu);
                aVar.fX(3, this.kzt);
                if (this.wnv == null) {
                    return 0;
                }
                aVar.g(4, this.wnv);
                return 0;
            }
        } else if (i == 1) {
            if (this.wnt != null) {
                h = e.a.a.b.b.a.h(1, this.wnt) + 0;
            } else {
                h = 0;
            }
            h = (h + e.a.a.a.R(2, this.wnu)) + e.a.a.a.fU(3, this.kzt);
            if (this.wnv != null) {
                h += e.a.a.b.b.a.h(4, this.wnv);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wnt == null) {
                throw new b("Not all required fields were included: Rid");
            } else if (this.wnv != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MimeType");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            wh whVar = (wh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    whVar.wnt = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    whVar.wnu = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    whVar.kzt = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    whVar.wnv = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

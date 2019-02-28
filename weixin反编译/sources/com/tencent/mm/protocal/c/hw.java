package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class hw extends a {
    public String kTk;
    public String vUc;
    public int vUd;
    public String vUg;
    public String vUi;
    public String vUq;
    public int ver;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vUi != null) {
                aVar.g(1, this.vUi);
            }
            if (this.kTk != null) {
                aVar.g(2, this.kTk);
            }
            aVar.fX(3, this.ver);
            if (this.vUc != null) {
                aVar.g(4, this.vUc);
            }
            if (this.vUq != null) {
                aVar.g(5, this.vUq);
            }
            aVar.fX(6, this.vUd);
            if (this.vUg == null) {
                return 0;
            }
            aVar.g(7, this.vUg);
            return 0;
        } else if (i == 1) {
            if (this.vUi != null) {
                h = e.a.a.b.b.a.h(1, this.vUi) + 0;
            } else {
                h = 0;
            }
            if (this.kTk != null) {
                h += e.a.a.b.b.a.h(2, this.kTk);
            }
            h += e.a.a.a.fU(3, this.ver);
            if (this.vUc != null) {
                h += e.a.a.b.b.a.h(4, this.vUc);
            }
            if (this.vUq != null) {
                h += e.a.a.b.b.a.h(5, this.vUq);
            }
            h += e.a.a.a.fU(6, this.vUd);
            if (this.vUg != null) {
                h += e.a.a.b.b.a.h(7, this.vUg);
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
            hw hwVar = (hw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hwVar.vUi = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    hwVar.kTk = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    hwVar.ver = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    hwVar.vUc = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    hwVar.vUq = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    hwVar.vUd = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    hwVar.vUg = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

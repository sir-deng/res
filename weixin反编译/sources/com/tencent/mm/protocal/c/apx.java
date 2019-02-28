package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class apx extends a {
    public String type;
    public String wDD;
    public String wDE;
    public String wDF;
    public int wbM;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wDD != null) {
                aVar.g(1, this.wDD);
            }
            if (this.wDE != null) {
                aVar.g(2, this.wDE);
            }
            if (this.type != null) {
                aVar.g(3, this.type);
            }
            aVar.fX(4, this.wbM);
            if (this.wDF == null) {
                return 0;
            }
            aVar.g(5, this.wDF);
            return 0;
        } else if (i == 1) {
            if (this.wDD != null) {
                h = e.a.a.b.b.a.h(1, this.wDD) + 0;
            } else {
                h = 0;
            }
            if (this.wDE != null) {
                h += e.a.a.b.b.a.h(2, this.wDE);
            }
            if (this.type != null) {
                h += e.a.a.b.b.a.h(3, this.type);
            }
            h += e.a.a.a.fU(4, this.wbM);
            if (this.wDF != null) {
                h += e.a.a.b.b.a.h(5, this.wDF);
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
            apx apx = (apx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    apx.wDD = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    apx.wDE = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    apx.type = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    apx.wbM = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    apx.wDF = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

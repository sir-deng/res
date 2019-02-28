package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class acx extends a {
    public String path;
    public String pfi;
    public String pkz;
    public String title;
    public int type;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pfi != null) {
                aVar.g(1, this.pfi);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            aVar.fX(3, this.type);
            if (this.pkz != null) {
                aVar.g(4, this.pkz);
            }
            if (this.username != null) {
                aVar.g(5, this.username);
            }
            if (this.path == null) {
                return 0;
            }
            aVar.g(6, this.path);
            return 0;
        } else if (i == 1) {
            if (this.pfi != null) {
                h = e.a.a.b.b.a.h(1, this.pfi) + 0;
            } else {
                h = 0;
            }
            if (this.title != null) {
                h += e.a.a.b.b.a.h(2, this.title);
            }
            h += e.a.a.a.fU(3, this.type);
            if (this.pkz != null) {
                h += e.a.a.b.b.a.h(4, this.pkz);
            }
            if (this.username != null) {
                h += e.a.a.b.b.a.h(5, this.username);
            }
            if (this.path != null) {
                h += e.a.a.b.b.a.h(6, this.path);
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
            acx acx = (acx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acx.pfi = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    acx.title = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    acx.type = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    acx.pkz = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    acx.username = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    acx.path = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

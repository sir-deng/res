package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class cdb extends a {
    public String path;
    public String username;
    public int vVm;
    public String wHQ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            if (this.wHQ != null) {
                aVar.g(2, this.wHQ);
            }
            aVar.fX(3, this.vVm);
            if (this.path == null) {
                return 0;
            }
            aVar.g(4, this.path);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            if (this.wHQ != null) {
                h += e.a.a.b.b.a.h(2, this.wHQ);
            }
            h += e.a.a.a.fU(3, this.vVm);
            if (this.path != null) {
                h += e.a.a.b.b.a.h(4, this.path);
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
            cdb cdb = (cdb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdb.username = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cdb.wHQ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cdb.vVm = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    cdb.path = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

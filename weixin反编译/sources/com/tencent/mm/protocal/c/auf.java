package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class auf extends a {
    public String desc;
    public String jjN;
    public String scope;
    public int wIZ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.g(1, this.scope);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            aVar.fX(3, this.wIZ);
            if (this.jjN == null) {
                return 0;
            }
            aVar.g(4, this.jjN);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                h = e.a.a.b.b.a.h(1, this.scope) + 0;
            } else {
                h = 0;
            }
            if (this.desc != null) {
                h += e.a.a.b.b.a.h(2, this.desc);
            }
            h += e.a.a.a.fU(3, this.wIZ);
            if (this.jjN != null) {
                h += e.a.a.b.b.a.h(4, this.jjN);
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
            auf auf = (auf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    auf.scope = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    auf.desc = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    auf.wIZ = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    auf.jjN = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

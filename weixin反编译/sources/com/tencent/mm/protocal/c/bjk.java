package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bjk extends a {
    public String fHP;
    public String fHQ;
    public String kPy;
    public String vLs;
    public String vLt;
    public int vLu;
    public String wTu;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fHP != null) {
                aVar.g(1, this.fHP);
            }
            if (this.kPy != null) {
                aVar.g(2, this.kPy);
            }
            if (this.fHQ != null) {
                aVar.g(3, this.fHQ);
            }
            if (this.vLs != null) {
                aVar.g(4, this.vLs);
            }
            if (this.vLt != null) {
                aVar.g(5, this.vLt);
            }
            aVar.fX(6, this.vLu);
            if (this.wTu == null) {
                return 0;
            }
            aVar.g(7, this.wTu);
            return 0;
        } else if (i == 1) {
            if (this.fHP != null) {
                h = e.a.a.b.b.a.h(1, this.fHP) + 0;
            } else {
                h = 0;
            }
            if (this.kPy != null) {
                h += e.a.a.b.b.a.h(2, this.kPy);
            }
            if (this.fHQ != null) {
                h += e.a.a.b.b.a.h(3, this.fHQ);
            }
            if (this.vLs != null) {
                h += e.a.a.b.b.a.h(4, this.vLs);
            }
            if (this.vLt != null) {
                h += e.a.a.b.b.a.h(5, this.vLt);
            }
            h += e.a.a.a.fU(6, this.vLu);
            if (this.wTu != null) {
                h += e.a.a.b.b.a.h(7, this.wTu);
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
            bjk bjk = (bjk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bjk.fHP = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bjk.kPy = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bjk.fHQ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bjk.vLs = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bjk.vLt = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bjk.vLu = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bjk.wTu = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

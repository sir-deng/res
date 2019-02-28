package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class io extends a {
    public String fGh;
    public int vVl;
    public int vVm;
    public String vVn;
    public int vVo;
    public String vVp;
    public int vVq;
    public int vVr;
    public int vVs;
    public String vVt;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fGh != null) {
                aVar.g(1, this.fGh);
            }
            aVar.fX(2, this.vVl);
            aVar.fX(3, this.vVm);
            if (this.vVn != null) {
                aVar.g(4, this.vVn);
            }
            aVar.fX(5, this.vVo);
            if (this.vVp != null) {
                aVar.g(6, this.vVp);
            }
            aVar.fX(7, this.vVq);
            aVar.fX(8, this.vVr);
            aVar.fX(9, this.vVs);
            if (this.vVt == null) {
                return 0;
            }
            aVar.g(10, this.vVt);
            return 0;
        } else if (i == 1) {
            if (this.fGh != null) {
                h = e.a.a.b.b.a.h(1, this.fGh) + 0;
            } else {
                h = 0;
            }
            h = (h + e.a.a.a.fU(2, this.vVl)) + e.a.a.a.fU(3, this.vVm);
            if (this.vVn != null) {
                h += e.a.a.b.b.a.h(4, this.vVn);
            }
            h += e.a.a.a.fU(5, this.vVo);
            if (this.vVp != null) {
                h += e.a.a.b.b.a.h(6, this.vVp);
            }
            h = ((h + e.a.a.a.fU(7, this.vVq)) + e.a.a.a.fU(8, this.vVr)) + e.a.a.a.fU(9, this.vVs);
            if (this.vVt != null) {
                h += e.a.a.b.b.a.h(10, this.vVt);
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
            io ioVar = (io) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ioVar.fGh = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ioVar.vVl = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ioVar.vVm = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    ioVar.vVn = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ioVar.vVo = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    ioVar.vVp = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    ioVar.vVq = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    ioVar.vVr = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    ioVar.vVs = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    ioVar.vVt = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

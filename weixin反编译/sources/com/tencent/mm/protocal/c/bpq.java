package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bpq extends a {
    public String nkW;
    public double vUF;
    public double vUG;
    public String wKq;

    protected final int a(int i, Object... objArr) {
        int dX;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.b(1, this.vUG);
            aVar.b(2, this.vUF);
            if (this.nkW != null) {
                aVar.g(3, this.nkW);
            }
            if (this.wKq != null) {
                aVar.g(4, this.wKq);
            }
            return 0;
        } else if (i == 1) {
            dX = ((e.a.a.b.b.a.dX(1) + 8) + 0) + (e.a.a.b.b.a.dX(2) + 8);
            if (this.nkW != null) {
                dX += e.a.a.b.b.a.h(3, this.nkW);
            }
            if (this.wKq != null) {
                return dX + e.a.a.b.b.a.h(4, this.wKq);
            }
            return dX;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (dX = a.a(aVar2); dX > 0; dX = a.a(aVar2)) {
                if (!super.a(aVar2, this, dX)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpq bpq = (bpq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpq.vUG = aVar3.AEQ.readDouble();
                    return 0;
                case 2:
                    bpq.vUF = aVar3.AEQ.readDouble();
                    return 0;
                case 3:
                    bpq.nkW = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bpq.wKq = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

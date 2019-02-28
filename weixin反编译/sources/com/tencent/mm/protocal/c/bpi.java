package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bpi extends a {
    public String path;
    public String pfi;
    public int showType;
    public String title;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.showType);
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            if (this.pfi != null) {
                aVar.g(3, this.pfi);
            }
            if (this.path != null) {
                aVar.g(4, this.path);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.showType) + 0;
            if (this.title != null) {
                fU += e.a.a.b.b.a.h(2, this.title);
            }
            if (this.pfi != null) {
                fU += e.a.a.b.b.a.h(3, this.pfi);
            }
            if (this.path != null) {
                return fU + e.a.a.b.b.a.h(4, this.path);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpi bpi = (bpi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpi.showType = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bpi.title = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bpi.pfi = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bpi.path = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

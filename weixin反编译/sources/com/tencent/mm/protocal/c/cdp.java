package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class cdp extends a {
    public String fGh;
    public int type;
    public String xiZ;
    public String xja;
    public int xjb;
    public int xjc;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.type);
            if (this.fGh != null) {
                aVar.g(2, this.fGh);
            }
            if (this.xiZ != null) {
                aVar.g(3, this.xiZ);
            }
            if (this.xja != null) {
                aVar.g(4, this.xja);
            }
            aVar.fX(5, this.xjb);
            aVar.fX(6, this.xjc);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.type) + 0;
            if (this.fGh != null) {
                fU += e.a.a.b.b.a.h(2, this.fGh);
            }
            if (this.xiZ != null) {
                fU += e.a.a.b.b.a.h(3, this.xiZ);
            }
            if (this.xja != null) {
                fU += e.a.a.b.b.a.h(4, this.xja);
            }
            return (fU + e.a.a.a.fU(5, this.xjb)) + e.a.a.a.fU(6, this.xjc);
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
            cdp cdp = (cdp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdp.type = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    cdp.fGh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cdp.xiZ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cdp.xja = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    cdp.xjb = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    cdp.xjc = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class kq extends a {
    public int bZP;
    public int quA;
    public String text;
    public int type;
    public String url;
    public String vYz;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.type);
            if (this.text != null) {
                aVar.g(2, this.text);
            }
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            aVar.fX(4, this.quA);
            aVar.fX(5, this.bZP);
            if (this.vYz != null) {
                aVar.g(6, this.vYz);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.type) + 0;
            if (this.text != null) {
                fU += e.a.a.b.b.a.h(2, this.text);
            }
            if (this.url != null) {
                fU += e.a.a.b.b.a.h(3, this.url);
            }
            fU = (fU + e.a.a.a.fU(4, this.quA)) + e.a.a.a.fU(5, this.bZP);
            if (this.vYz != null) {
                return fU + e.a.a.b.b.a.h(6, this.vYz);
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
            kq kqVar = (kq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kqVar.type = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    kqVar.text = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    kqVar.url = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    kqVar.quA = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    kqVar.bZP = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    kqVar.vYz = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

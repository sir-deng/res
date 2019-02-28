package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class tf extends a {
    public String hdx;
    public int pNg;
    public String pNh;
    public String pNi;
    public int pNj;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.pNg);
            if (this.pNh != null) {
                aVar.g(2, this.pNh);
            }
            if (this.pNi != null) {
                aVar.g(3, this.pNi);
            }
            aVar.fX(4, this.pNj);
            if (this.hdx != null) {
                aVar.g(5, this.hdx);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.pNg) + 0;
            if (this.pNh != null) {
                fU += e.a.a.b.b.a.h(2, this.pNh);
            }
            if (this.pNi != null) {
                fU += e.a.a.b.b.a.h(3, this.pNi);
            }
            fU += e.a.a.a.fU(4, this.pNj);
            if (this.hdx != null) {
                return fU + e.a.a.b.b.a.h(5, this.hdx);
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
            tf tfVar = (tf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tfVar.pNg = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    tfVar.pNh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    tfVar.pNi = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    tfVar.pNj = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    tfVar.hdx = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

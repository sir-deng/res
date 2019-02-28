package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class km extends a {
    public int kRj;
    public String text;
    public String url;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.kRj);
            if (this.text != null) {
                aVar.g(2, this.text);
            }
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.kRj) + 0;
            if (this.text != null) {
                fU += e.a.a.b.b.a.h(2, this.text);
            }
            if (this.url != null) {
                return fU + e.a.a.b.b.a.h(3, this.url);
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
            km kmVar = (km) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kmVar.kRj = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    kmVar.text = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    kmVar.url = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

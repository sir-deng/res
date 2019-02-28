package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ap extends a {
    public String kQA;
    public String kQB;
    public String kQC;
    public String kQz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kQz != null) {
                aVar.g(1, this.kQz);
            }
            if (this.kQA != null) {
                aVar.g(2, this.kQA);
            }
            if (this.kQB != null) {
                aVar.g(3, this.kQB);
            }
            if (this.kQC == null) {
                return 0;
            }
            aVar.g(4, this.kQC);
            return 0;
        } else if (i == 1) {
            if (this.kQz != null) {
                h = e.a.a.b.b.a.h(1, this.kQz) + 0;
            } else {
                h = 0;
            }
            if (this.kQA != null) {
                h += e.a.a.b.b.a.h(2, this.kQA);
            }
            if (this.kQB != null) {
                h += e.a.a.b.b.a.h(3, this.kQB);
            }
            if (this.kQC != null) {
                h += e.a.a.b.b.a.h(4, this.kQC);
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
            ap apVar = (ap) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    apVar.kQz = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    apVar.kQA = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    apVar.kQB = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    apVar.kQC = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

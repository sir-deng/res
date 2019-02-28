package com.tencent.mm.protocal.c;

public final class a extends com.tencent.mm.bp.a {
    public int fEo;
    public String fzT;
    public String loA;
    public String ojb;
    public String ojc;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.fEo);
            if (this.fzT != null) {
                aVar.g(2, this.fzT);
            }
            if (this.ojb != null) {
                aVar.g(3, this.ojb);
            }
            if (this.ojc != null) {
                aVar.g(4, this.ojc);
            }
            if (this.loA != null) {
                aVar.g(5, this.loA);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.fEo) + 0;
            if (this.fzT != null) {
                fU += e.a.a.b.b.a.h(2, this.fzT);
            }
            if (this.ojb != null) {
                fU += e.a.a.b.b.a.h(3, this.ojb);
            }
            if (this.ojc != null) {
                fU += e.a.a.b.b.a.h(4, this.ojc);
            }
            if (this.loA != null) {
                return fU + e.a.a.b.b.a.h(5, this.loA);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = com.tencent.mm.bp.a.a(aVar2); fU > 0; fU = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.fEo = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    aVar4.fzT = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aVar4.ojb = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aVar4.ojc = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aVar4.loA = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

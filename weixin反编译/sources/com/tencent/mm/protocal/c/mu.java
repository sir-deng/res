package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class mu extends a {
    public String wck;
    public String wcl;
    public String wcm;
    public int wcn;
    public int wco;
    public String wcp;
    public int wcq;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wck != null) {
                aVar.g(1, this.wck);
            }
            if (this.wcl != null) {
                aVar.g(2, this.wcl);
            }
            if (this.wcm != null) {
                aVar.g(3, this.wcm);
            }
            aVar.fX(4, this.wcn);
            aVar.fX(5, this.wco);
            if (this.wcp != null) {
                aVar.g(6, this.wcp);
            }
            aVar.fX(7, this.wcq);
            return 0;
        } else if (i == 1) {
            if (this.wck != null) {
                h = e.a.a.b.b.a.h(1, this.wck) + 0;
            } else {
                h = 0;
            }
            if (this.wcl != null) {
                h += e.a.a.b.b.a.h(2, this.wcl);
            }
            if (this.wcm != null) {
                h += e.a.a.b.b.a.h(3, this.wcm);
            }
            h = (h + e.a.a.a.fU(4, this.wcn)) + e.a.a.a.fU(5, this.wco);
            if (this.wcp != null) {
                h += e.a.a.b.b.a.h(6, this.wcp);
            }
            return h + e.a.a.a.fU(7, this.wcq);
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
            mu muVar = (mu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    muVar.wck = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    muVar.wcl = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    muVar.wcm = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    muVar.wcn = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    muVar.wco = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    muVar.wcp = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    muVar.wcq = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

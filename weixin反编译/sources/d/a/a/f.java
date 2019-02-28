package d.a.a;

import com.tencent.mm.bp.a;

public final class f extends a {
    public String wKS;
    public String wKT;
    public int wKU;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wKS != null) {
                aVar.g(1, this.wKS);
            }
            if (this.wKT != null) {
                aVar.g(2, this.wKT);
            }
            aVar.fX(3, this.wKU);
            return 0;
        } else if (i == 1) {
            if (this.wKS != null) {
                h = e.a.a.b.b.a.h(1, this.wKS) + 0;
            } else {
                h = 0;
            }
            if (this.wKT != null) {
                h += e.a.a.b.b.a.h(2, this.wKT);
            }
            return h + e.a.a.a.fU(3, this.wKU);
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
            f fVar = (f) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fVar.wKS = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    fVar.wKT = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    fVar.wKU = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

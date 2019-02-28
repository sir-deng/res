package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class byn extends a {
    public b xfG;
    public b xfH;
    public b xfI;
    public b xfJ;

    protected final int a(int i, Object... objArr) {
        int a;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfG != null) {
                aVar.b(1, this.xfG);
            }
            if (this.xfH != null) {
                aVar.b(2, this.xfH);
            }
            if (this.xfI != null) {
                aVar.b(3, this.xfI);
            }
            if (this.xfJ == null) {
                return 0;
            }
            aVar.b(4, this.xfJ);
            return 0;
        } else if (i == 1) {
            if (this.xfG != null) {
                a = e.a.a.a.a(1, this.xfG) + 0;
            } else {
                a = 0;
            }
            if (this.xfH != null) {
                a += e.a.a.a.a(2, this.xfH);
            }
            if (this.xfI != null) {
                a += e.a.a.a.a(3, this.xfI);
            }
            if (this.xfJ != null) {
                a += e.a.a.a.a(4, this.xfJ);
            }
            return a;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byn byn = (byn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    byn.xfG = aVar3.cKw();
                    return 0;
                case 2:
                    byn.xfH = aVar3.cKw();
                    return 0;
                case 3:
                    byn.xfI = aVar3.cKw();
                    return 0;
                case 4:
                    byn.xfJ = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

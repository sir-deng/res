package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class cbx extends a {
    public String fzT;
    public String pul;
    public String xhO;
    public String xhP;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xhO != null) {
                aVar.g(1, this.xhO);
            }
            if (this.fzT != null) {
                aVar.g(2, this.fzT);
            }
            if (this.pul != null) {
                aVar.g(3, this.pul);
            }
            if (this.xhP == null) {
                return 0;
            }
            aVar.g(4, this.xhP);
            return 0;
        } else if (i == 1) {
            if (this.xhO != null) {
                h = e.a.a.b.b.a.h(1, this.xhO) + 0;
            } else {
                h = 0;
            }
            if (this.fzT != null) {
                h += e.a.a.b.b.a.h(2, this.fzT);
            }
            if (this.pul != null) {
                h += e.a.a.b.b.a.h(3, this.pul);
            }
            if (this.xhP != null) {
                h += e.a.a.b.b.a.h(4, this.xhP);
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
            cbx cbx = (cbx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbx.xhO = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    cbx.fzT = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cbx.pul = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    cbx.xhP = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

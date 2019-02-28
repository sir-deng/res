package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;

public final class dt extends a {
    public String nkQ;
    public String nkV;
    public String npN;
    public String npO;
    public String npP;
    public boolean npQ;
    public boolean npR;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkV != null) {
                aVar.g(1, this.nkV);
            }
            if (this.npN != null) {
                aVar.g(2, this.npN);
            }
            if (this.npO != null) {
                aVar.g(3, this.npO);
            }
            if (this.npP != null) {
                aVar.g(4, this.npP);
            }
            if (this.nkQ != null) {
                aVar.g(5, this.nkQ);
            }
            aVar.am(6, this.npQ);
            aVar.am(7, this.npR);
            return 0;
        } else if (i == 1) {
            if (this.nkV != null) {
                h = e.a.a.b.b.a.h(1, this.nkV) + 0;
            } else {
                h = 0;
            }
            if (this.npN != null) {
                h += e.a.a.b.b.a.h(2, this.npN);
            }
            if (this.npO != null) {
                h += e.a.a.b.b.a.h(3, this.npO);
            }
            if (this.npP != null) {
                h += e.a.a.b.b.a.h(4, this.npP);
            }
            if (this.nkQ != null) {
                h += e.a.a.b.b.a.h(5, this.nkQ);
            }
            return (h + (e.a.a.b.b.a.dX(6) + 1)) + (e.a.a.b.b.a.dX(7) + 1);
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
            dt dtVar = (dt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dtVar.nkV = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    dtVar.npN = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    dtVar.npO = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    dtVar.npP = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    dtVar.nkQ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    dtVar.npQ = aVar3.cKv();
                    return 0;
                case 7:
                    dtVar.npR = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

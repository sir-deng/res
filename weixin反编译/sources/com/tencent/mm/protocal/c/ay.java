package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class ay extends a {
    public String fED;
    public String fzT;
    public String sGf;
    public String sGg;
    public String taB;
    public int taC;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.g(1, this.url);
            }
            if (this.fzT != null) {
                aVar.g(2, this.fzT);
            }
            if (this.fED != null) {
                aVar.g(3, this.fED);
            }
            if (this.taB != null) {
                aVar.g(4, this.taB);
            }
            if (this.title != null) {
                aVar.g(5, this.title);
            }
            if (this.sGf != null) {
                aVar.g(6, this.sGf);
            }
            if (this.sGg != null) {
                aVar.g(7, this.sGg);
            }
            aVar.fX(8, this.taC);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                h = e.a.a.b.b.a.h(1, this.url) + 0;
            } else {
                h = 0;
            }
            if (this.fzT != null) {
                h += e.a.a.b.b.a.h(2, this.fzT);
            }
            if (this.fED != null) {
                h += e.a.a.b.b.a.h(3, this.fED);
            }
            if (this.taB != null) {
                h += e.a.a.b.b.a.h(4, this.taB);
            }
            if (this.title != null) {
                h += e.a.a.b.b.a.h(5, this.title);
            }
            if (this.sGf != null) {
                h += e.a.a.b.b.a.h(6, this.sGf);
            }
            if (this.sGg != null) {
                h += e.a.a.b.b.a.h(7, this.sGg);
            }
            return h + e.a.a.a.fU(8, this.taC);
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
            ay ayVar = (ay) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayVar.url = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    ayVar.fzT = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ayVar.fED = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ayVar.taB = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ayVar.title = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    ayVar.sGf = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    ayVar.sGg = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    ayVar.taC = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

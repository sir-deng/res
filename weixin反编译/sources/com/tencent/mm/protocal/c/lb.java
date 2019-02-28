package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public class lb extends a {
    public String kPB;
    public String kTd;
    public String pfi;
    public String title;
    public String url;
    public String vYB;
    public String vYC;
    public long vZQ;
    public String vZR;
    public String vZS;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.kPB != null) {
                aVar.g(2, this.kPB);
            }
            if (this.kTd != null) {
                aVar.g(3, this.kTd);
            }
            if (this.url != null) {
                aVar.g(4, this.url);
            }
            aVar.S(5, this.vZQ);
            if (this.vZR != null) {
                aVar.g(6, this.vZR);
            }
            if (this.vZS != null) {
                aVar.g(7, this.vZS);
            }
            if (this.pfi != null) {
                aVar.g(8, this.pfi);
            }
            if (this.vYB != null) {
                aVar.g(9, this.vYB);
            }
            if (this.vYC == null) {
                return 0;
            }
            aVar.g(10, this.vYC);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.kPB != null) {
                h += e.a.a.b.b.a.h(2, this.kPB);
            }
            if (this.kTd != null) {
                h += e.a.a.b.b.a.h(3, this.kTd);
            }
            if (this.url != null) {
                h += e.a.a.b.b.a.h(4, this.url);
            }
            h += e.a.a.a.R(5, this.vZQ);
            if (this.vZR != null) {
                h += e.a.a.b.b.a.h(6, this.vZR);
            }
            if (this.vZS != null) {
                h += e.a.a.b.b.a.h(7, this.vZS);
            }
            if (this.pfi != null) {
                h += e.a.a.b.b.a.h(8, this.pfi);
            }
            if (this.vYB != null) {
                h += e.a.a.b.b.a.h(9, this.vYB);
            }
            if (this.vYC != null) {
                h += e.a.a.b.b.a.h(10, this.vYC);
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
            lb lbVar = (lb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lbVar.title = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    lbVar.kPB = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    lbVar.kTd = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    lbVar.url = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    lbVar.vZQ = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    lbVar.vZR = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    lbVar.vZS = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    lbVar.pfi = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    lbVar.vYB = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    lbVar.vYC = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

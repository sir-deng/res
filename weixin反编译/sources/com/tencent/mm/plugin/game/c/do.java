package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class do extends a {
    public String fpg;
    public String nkL;
    public String nkM;
    public String nkN;
    public String nlV;
    public String nlr;
    public String noG;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.noG == null) {
                throw new b("Not all required fields were included: AppName");
            }
            if (this.noG != null) {
                aVar.g(1, this.noG);
            }
            if (this.nkM != null) {
                aVar.g(2, this.nkM);
            }
            if (this.fpg != null) {
                aVar.g(3, this.fpg);
            }
            if (this.nkL != null) {
                aVar.g(4, this.nkL);
            }
            if (this.nlr != null) {
                aVar.g(5, this.nlr);
            }
            if (this.nkN != null) {
                aVar.g(6, this.nkN);
            }
            if (this.nlV == null) {
                return 0;
            }
            aVar.g(7, this.nlV);
            return 0;
        } else if (i == 1) {
            if (this.noG != null) {
                h = e.a.a.b.b.a.h(1, this.noG) + 0;
            } else {
                h = 0;
            }
            if (this.nkM != null) {
                h += e.a.a.b.b.a.h(2, this.nkM);
            }
            if (this.fpg != null) {
                h += e.a.a.b.b.a.h(3, this.fpg);
            }
            if (this.nkL != null) {
                h += e.a.a.b.b.a.h(4, this.nkL);
            }
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(5, this.nlr);
            }
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(6, this.nkN);
            }
            if (this.nlV != null) {
                h += e.a.a.b.b.a.h(7, this.nlV);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.noG != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            do doVar = (do) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    doVar.noG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    doVar.nkM = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    doVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    doVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    doVar.nlr = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    doVar.nkN = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    doVar.nlV = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

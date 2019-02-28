package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class sf extends a {
    public String nlE;
    public String phv;
    public String vPI;
    public String wgP;
    public String wgQ;
    public String wgR;
    public String wgS;
    public String wgT;
    public String wgU;
    public String wgV;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wgP == null) {
                throw new b("Not all required fields were included: Md5");
            }
            if (this.wgP != null) {
                aVar.g(1, this.wgP);
            }
            if (this.nlE != null) {
                aVar.g(2, this.nlE);
            }
            if (this.phv != null) {
                aVar.g(3, this.phv);
            }
            if (this.wgQ != null) {
                aVar.g(4, this.wgQ);
            }
            if (this.wgR != null) {
                aVar.g(5, this.wgR);
            }
            if (this.wgS != null) {
                aVar.g(6, this.wgS);
            }
            if (this.vPI != null) {
                aVar.g(7, this.vPI);
            }
            if (this.wgT != null) {
                aVar.g(8, this.wgT);
            }
            if (this.wgU != null) {
                aVar.g(9, this.wgU);
            }
            if (this.wgV == null) {
                return 0;
            }
            aVar.g(10, this.wgV);
            return 0;
        } else if (i == 1) {
            if (this.wgP != null) {
                h = e.a.a.b.b.a.h(1, this.wgP) + 0;
            } else {
                h = 0;
            }
            if (this.nlE != null) {
                h += e.a.a.b.b.a.h(2, this.nlE);
            }
            if (this.phv != null) {
                h += e.a.a.b.b.a.h(3, this.phv);
            }
            if (this.wgQ != null) {
                h += e.a.a.b.b.a.h(4, this.wgQ);
            }
            if (this.wgR != null) {
                h += e.a.a.b.b.a.h(5, this.wgR);
            }
            if (this.wgS != null) {
                h += e.a.a.b.b.a.h(6, this.wgS);
            }
            if (this.vPI != null) {
                h += e.a.a.b.b.a.h(7, this.vPI);
            }
            if (this.wgT != null) {
                h += e.a.a.b.b.a.h(8, this.wgT);
            }
            if (this.wgU != null) {
                h += e.a.a.b.b.a.h(9, this.wgU);
            }
            if (this.wgV != null) {
                h += e.a.a.b.b.a.h(10, this.wgV);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.wgP != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Md5");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sf sfVar = (sf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sfVar.wgP = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    sfVar.nlE = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    sfVar.phv = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    sfVar.wgQ = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    sfVar.wgR = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    sfVar.wgS = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    sfVar.vPI = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    sfVar.wgT = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    sfVar.wgU = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    sfVar.wgV = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

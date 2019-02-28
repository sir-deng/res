package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class fa extends a {
    public String nHt;
    public String pff;
    public String pfg;
    public String sOP;
    public String vRu;
    public String vRv;
    public String vRw;
    public String vRx;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vRu != null) {
                aVar.g(1, this.vRu);
            }
            if (this.sOP != null) {
                aVar.g(2, this.sOP);
            }
            if (this.pff != null) {
                aVar.g(3, this.pff);
            }
            if (this.pfg != null) {
                aVar.g(4, this.pfg);
            }
            if (this.nHt != null) {
                aVar.g(5, this.nHt);
            }
            if (this.vRv != null) {
                aVar.g(6, this.vRv);
            }
            if (this.vRw != null) {
                aVar.g(7, this.vRw);
            }
            if (this.vRx == null) {
                return 0;
            }
            aVar.g(8, this.vRx);
            return 0;
        } else if (i == 1) {
            if (this.vRu != null) {
                h = e.a.a.b.b.a.h(1, this.vRu) + 0;
            } else {
                h = 0;
            }
            if (this.sOP != null) {
                h += e.a.a.b.b.a.h(2, this.sOP);
            }
            if (this.pff != null) {
                h += e.a.a.b.b.a.h(3, this.pff);
            }
            if (this.pfg != null) {
                h += e.a.a.b.b.a.h(4, this.pfg);
            }
            if (this.nHt != null) {
                h += e.a.a.b.b.a.h(5, this.nHt);
            }
            if (this.vRv != null) {
                h += e.a.a.b.b.a.h(6, this.vRv);
            }
            if (this.vRw != null) {
                h += e.a.a.b.b.a.h(7, this.vRw);
            }
            if (this.vRx != null) {
                h += e.a.a.b.b.a.h(8, this.vRx);
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
            fa faVar = (fa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    faVar.vRu = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    faVar.sOP = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    faVar.pff = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    faVar.pfg = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    faVar.nHt = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    faVar.vRv = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    faVar.vRw = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    faVar.vRx = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

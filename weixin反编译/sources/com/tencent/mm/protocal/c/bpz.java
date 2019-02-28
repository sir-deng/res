package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bpz extends a {
    public String nHt;
    public String pMZ;
    public String pNt;
    public String pNu;
    public String pNv;
    public String pNw;
    public String pff;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pNt != null) {
                aVar.g(1, this.pNt);
            }
            if (this.pNu != null) {
                aVar.g(2, this.pNu);
            }
            if (this.pMZ != null) {
                aVar.g(3, this.pMZ);
            }
            if (this.nHt != null) {
                aVar.g(4, this.nHt);
            }
            if (this.pff != null) {
                aVar.g(5, this.pff);
            }
            if (this.pNv != null) {
                aVar.g(6, this.pNv);
            }
            if (this.pNw == null) {
                return 0;
            }
            aVar.g(7, this.pNw);
            return 0;
        } else if (i == 1) {
            if (this.pNt != null) {
                h = e.a.a.b.b.a.h(1, this.pNt) + 0;
            } else {
                h = 0;
            }
            if (this.pNu != null) {
                h += e.a.a.b.b.a.h(2, this.pNu);
            }
            if (this.pMZ != null) {
                h += e.a.a.b.b.a.h(3, this.pMZ);
            }
            if (this.nHt != null) {
                h += e.a.a.b.b.a.h(4, this.nHt);
            }
            if (this.pff != null) {
                h += e.a.a.b.b.a.h(5, this.pff);
            }
            if (this.pNv != null) {
                h += e.a.a.b.b.a.h(6, this.pNv);
            }
            if (this.pNw != null) {
                h += e.a.a.b.b.a.h(7, this.pNw);
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
            bpz bpz = (bpz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpz.pNt = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bpz.pNu = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bpz.pMZ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bpz.nHt = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bpz.pff = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bpz.pNv = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bpz.pNw = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

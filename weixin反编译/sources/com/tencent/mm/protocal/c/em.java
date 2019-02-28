package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class em extends a {
    public String hxh;
    public String kyG;
    public String kzN;
    public int mOo;
    public String nqc;
    public String vQA;
    public int vQy;
    public String vQz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nqc != null) {
                aVar.g(1, this.nqc);
            }
            if (this.kzN != null) {
                aVar.g(2, this.kzN);
            }
            if (this.kyG != null) {
                aVar.g(3, this.kyG);
            }
            aVar.fX(4, this.vQy);
            if (this.vQz != null) {
                aVar.g(5, this.vQz);
            }
            if (this.hxh != null) {
                aVar.g(6, this.hxh);
            }
            if (this.vQA != null) {
                aVar.g(7, this.vQA);
            }
            aVar.fX(8, this.mOo);
            return 0;
        } else if (i == 1) {
            if (this.nqc != null) {
                h = e.a.a.b.b.a.h(1, this.nqc) + 0;
            } else {
                h = 0;
            }
            if (this.kzN != null) {
                h += e.a.a.b.b.a.h(2, this.kzN);
            }
            if (this.kyG != null) {
                h += e.a.a.b.b.a.h(3, this.kyG);
            }
            h += e.a.a.a.fU(4, this.vQy);
            if (this.vQz != null) {
                h += e.a.a.b.b.a.h(5, this.vQz);
            }
            if (this.hxh != null) {
                h += e.a.a.b.b.a.h(6, this.hxh);
            }
            if (this.vQA != null) {
                h += e.a.a.b.b.a.h(7, this.vQA);
            }
            return h + e.a.a.a.fU(8, this.mOo);
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
            em emVar = (em) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emVar.nqc = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    emVar.kzN = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    emVar.kyG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    emVar.vQy = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    emVar.vQz = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    emVar.hxh = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    emVar.vQA = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    emVar.mOo = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aru extends a {
    public int hxe;
    public String hxf;
    public String hxg;
    public String hxh;
    public String hxn;
    public String kyG;
    public int kzz;
    public int wGj;
    public int wGk;
    public String wbY;
    public String wbZ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyG != null) {
                aVar.g(1, this.kyG);
            }
            aVar.fX(2, this.kzz);
            aVar.fX(3, this.hxe);
            if (this.hxg != null) {
                aVar.g(4, this.hxg);
            }
            if (this.hxf != null) {
                aVar.g(5, this.hxf);
            }
            if (this.hxh != null) {
                aVar.g(6, this.hxh);
            }
            aVar.fX(7, this.wGj);
            aVar.fX(8, this.wGk);
            if (this.hxn != null) {
                aVar.g(9, this.hxn);
            }
            if (this.wbY != null) {
                aVar.g(10, this.wbY);
            }
            if (this.wbZ == null) {
                return 0;
            }
            aVar.g(11, this.wbZ);
            return 0;
        } else if (i == 1) {
            if (this.kyG != null) {
                h = e.a.a.b.b.a.h(1, this.kyG) + 0;
            } else {
                h = 0;
            }
            h = (h + e.a.a.a.fU(2, this.kzz)) + e.a.a.a.fU(3, this.hxe);
            if (this.hxg != null) {
                h += e.a.a.b.b.a.h(4, this.hxg);
            }
            if (this.hxf != null) {
                h += e.a.a.b.b.a.h(5, this.hxf);
            }
            if (this.hxh != null) {
                h += e.a.a.b.b.a.h(6, this.hxh);
            }
            h = (h + e.a.a.a.fU(7, this.wGj)) + e.a.a.a.fU(8, this.wGk);
            if (this.hxn != null) {
                h += e.a.a.b.b.a.h(9, this.hxn);
            }
            if (this.wbY != null) {
                h += e.a.a.b.b.a.h(10, this.wbY);
            }
            if (this.wbZ != null) {
                h += e.a.a.b.b.a.h(11, this.wbZ);
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
            aru aru = (aru) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aru.kyG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aru.kzz = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    aru.hxe = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aru.hxg = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aru.hxf = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aru.hxh = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    aru.wGj = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    aru.wGk = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    aru.hxn = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    aru.wbY = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    aru.wbZ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

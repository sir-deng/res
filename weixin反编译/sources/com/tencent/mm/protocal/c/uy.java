package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class uy extends a {
    public int kyY;
    public String vXE;
    public int vXF;
    public String wck;
    public String wcl;
    public String wcm;
    public int wcn;
    public String wjD;
    public String wjE;
    public int wjF;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wck != null) {
                aVar.g(1, this.wck);
            }
            if (this.wcl != null) {
                aVar.g(2, this.wcl);
            }
            if (this.wcm != null) {
                aVar.g(3, this.wcm);
            }
            aVar.fX(4, this.wcn);
            if (this.wjD != null) {
                aVar.g(5, this.wjD);
            }
            if (this.vXE != null) {
                aVar.g(6, this.vXE);
            }
            aVar.fX(7, this.vXF);
            if (this.wjE != null) {
                aVar.g(8, this.wjE);
            }
            aVar.fX(9, this.kyY);
            aVar.fX(10, this.wjF);
            return 0;
        } else if (i == 1) {
            if (this.wck != null) {
                h = e.a.a.b.b.a.h(1, this.wck) + 0;
            } else {
                h = 0;
            }
            if (this.wcl != null) {
                h += e.a.a.b.b.a.h(2, this.wcl);
            }
            if (this.wcm != null) {
                h += e.a.a.b.b.a.h(3, this.wcm);
            }
            h += e.a.a.a.fU(4, this.wcn);
            if (this.wjD != null) {
                h += e.a.a.b.b.a.h(5, this.wjD);
            }
            if (this.vXE != null) {
                h += e.a.a.b.b.a.h(6, this.vXE);
            }
            h += e.a.a.a.fU(7, this.vXF);
            if (this.wjE != null) {
                h += e.a.a.b.b.a.h(8, this.wjE);
            }
            return (h + e.a.a.a.fU(9, this.kyY)) + e.a.a.a.fU(10, this.wjF);
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
            uy uyVar = (uy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uyVar.wck = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    uyVar.wcl = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    uyVar.wcm = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    uyVar.wcn = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    uyVar.wjD = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    uyVar.vXE = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    uyVar.vXF = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    uyVar.wjE = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    uyVar.kyY = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    uyVar.wjF = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

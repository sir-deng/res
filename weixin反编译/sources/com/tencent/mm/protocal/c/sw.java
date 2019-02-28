package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class sw extends a {
    public int vNC;
    public String whV;
    public String whW;
    public String whX;
    public String whY;
    public String whZ;
    public int wia;
    public int wib;
    public String wic;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.whV == null) {
                throw new b("Not all required fields were included: BegWord");
            } else if (this.whW == null) {
                throw new b("Not all required fields were included: BegPicUrl");
            } else if (this.whX == null) {
                throw new b("Not all required fields were included: ThanksPicUrl");
            } else {
                if (this.whV != null) {
                    aVar.g(1, this.whV);
                }
                if (this.whW != null) {
                    aVar.g(2, this.whW);
                }
                if (this.whX != null) {
                    aVar.g(3, this.whX);
                }
                if (this.whY != null) {
                    aVar.g(4, this.whY);
                }
                if (this.whZ != null) {
                    aVar.g(5, this.whZ);
                }
                aVar.fX(6, this.wia);
                aVar.fX(7, this.wib);
                if (this.wic != null) {
                    aVar.g(8, this.wic);
                }
                aVar.fX(9, this.vNC);
                return 0;
            }
        } else if (i == 1) {
            if (this.whV != null) {
                h = e.a.a.b.b.a.h(1, this.whV) + 0;
            } else {
                h = 0;
            }
            if (this.whW != null) {
                h += e.a.a.b.b.a.h(2, this.whW);
            }
            if (this.whX != null) {
                h += e.a.a.b.b.a.h(3, this.whX);
            }
            if (this.whY != null) {
                h += e.a.a.b.b.a.h(4, this.whY);
            }
            if (this.whZ != null) {
                h += e.a.a.b.b.a.h(5, this.whZ);
            }
            h = (h + e.a.a.a.fU(6, this.wia)) + e.a.a.a.fU(7, this.wib);
            if (this.wic != null) {
                h += e.a.a.b.b.a.h(8, this.wic);
            }
            return h + e.a.a.a.fU(9, this.vNC);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.whV == null) {
                throw new b("Not all required fields were included: BegWord");
            } else if (this.whW == null) {
                throw new b("Not all required fields were included: BegPicUrl");
            } else if (this.whX != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThanksPicUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sw swVar = (sw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    swVar.whV = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    swVar.whW = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    swVar.whX = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    swVar.whY = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    swVar.whZ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    swVar.wia = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    swVar.wib = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    swVar.wic = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    swVar.vNC = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

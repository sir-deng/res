package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class mn extends a {
    public String kyG;
    public String kzN;
    public String wbX;
    public String wbY;
    public String wbZ;
    public int wca;
    public String wcb;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyG != null) {
                aVar.g(1, this.kyG);
            }
            if (this.kzN != null) {
                aVar.g(2, this.kzN);
            }
            if (this.wbX != null) {
                aVar.g(3, this.wbX);
            }
            if (this.wbY != null) {
                aVar.g(4, this.wbY);
            }
            if (this.wbZ != null) {
                aVar.g(5, this.wbZ);
            }
            aVar.fX(6, this.wca);
            if (this.wcb == null) {
                return 0;
            }
            aVar.g(7, this.wcb);
            return 0;
        } else if (i == 1) {
            if (this.kyG != null) {
                h = e.a.a.b.b.a.h(1, this.kyG) + 0;
            } else {
                h = 0;
            }
            if (this.kzN != null) {
                h += e.a.a.b.b.a.h(2, this.kzN);
            }
            if (this.wbX != null) {
                h += e.a.a.b.b.a.h(3, this.wbX);
            }
            if (this.wbY != null) {
                h += e.a.a.b.b.a.h(4, this.wbY);
            }
            if (this.wbZ != null) {
                h += e.a.a.b.b.a.h(5, this.wbZ);
            }
            h += e.a.a.a.fU(6, this.wca);
            if (this.wcb != null) {
                h += e.a.a.b.b.a.h(7, this.wcb);
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
            mn mnVar = (mn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mnVar.kyG = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    mnVar.kzN = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    mnVar.wbX = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    mnVar.wbY = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    mnVar.wbZ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    mnVar.wca = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    mnVar.wcb = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

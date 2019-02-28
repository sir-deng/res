package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class vc extends a {
    public String heZ;
    public String hfb;
    public String hfc;
    public String hfd;
    public String hfe;
    public String hff;
    public String hfg;
    public int wlG;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.heZ != null) {
                aVar.g(1, this.heZ);
            }
            aVar.fX(2, this.wlG);
            if (this.hfc != null) {
                aVar.g(3, this.hfc);
            }
            if (this.hfd != null) {
                aVar.g(4, this.hfd);
            }
            if (this.hfb != null) {
                aVar.g(5, this.hfb);
            }
            if (this.hfe != null) {
                aVar.g(6, this.hfe);
            }
            if (this.hff != null) {
                aVar.g(7, this.hff);
            }
            if (this.hfg == null) {
                return 0;
            }
            aVar.g(8, this.hfg);
            return 0;
        } else if (i == 1) {
            if (this.heZ != null) {
                h = e.a.a.b.b.a.h(1, this.heZ) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.wlG);
            if (this.hfc != null) {
                h += e.a.a.b.b.a.h(3, this.hfc);
            }
            if (this.hfd != null) {
                h += e.a.a.b.b.a.h(4, this.hfd);
            }
            if (this.hfb != null) {
                h += e.a.a.b.b.a.h(5, this.hfb);
            }
            if (this.hfe != null) {
                h += e.a.a.b.b.a.h(6, this.hfe);
            }
            if (this.hff != null) {
                h += e.a.a.b.b.a.h(7, this.hff);
            }
            if (this.hfg != null) {
                h += e.a.a.b.b.a.h(8, this.hfg);
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
            vc vcVar = (vc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vcVar.heZ = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    vcVar.wlG = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    vcVar.hfc = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    vcVar.hfd = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    vcVar.hfb = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    vcVar.hfe = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    vcVar.hff = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    vcVar.hfg = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class wz extends a {
    public String nkU;
    public String vPF;
    public int wnV;
    public String wnW;
    public String woe;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkU == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.woe == null) {
                throw new b("Not all required fields were included: RecommendKey");
            } else {
                if (this.nkU != null) {
                    aVar.g(1, this.nkU);
                }
                if (this.woe != null) {
                    aVar.g(2, this.woe);
                }
                if (this.vPF != null) {
                    aVar.g(3, this.vPF);
                }
                aVar.fX(4, this.wnV);
                if (this.wnW == null) {
                    return 0;
                }
                aVar.g(5, this.wnW);
                return 0;
            }
        } else if (i == 1) {
            if (this.nkU != null) {
                h = e.a.a.b.b.a.h(1, this.nkU) + 0;
            } else {
                h = 0;
            }
            if (this.woe != null) {
                h += e.a.a.b.b.a.h(2, this.woe);
            }
            if (this.vPF != null) {
                h += e.a.a.b.b.a.h(3, this.vPF);
            }
            h += e.a.a.a.fU(4, this.wnV);
            if (this.wnW != null) {
                h += e.a.a.b.b.a.h(5, this.wnW);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.nkU == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.woe != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RecommendKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            wz wzVar = (wz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wzVar.nkU = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    wzVar.woe = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    wzVar.vPF = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    wzVar.wnV = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    wzVar.wnW = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class alb extends a {
    public String fpg;
    public int kzz;
    public String nlE;
    public String noG;
    public String wdh;
    public String wyZ;
    public String wza;
    public String wzb;
    public String wzc;
    public int wzd;
    public String wze;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg != null) {
                aVar.g(1, this.fpg);
            }
            if (this.wyZ != null) {
                aVar.g(2, this.wyZ);
            }
            aVar.fX(3, this.kzz);
            if (this.nlE != null) {
                aVar.g(4, this.nlE);
            }
            if (this.wza != null) {
                aVar.g(5, this.wza);
            }
            if (this.wdh != null) {
                aVar.g(6, this.wdh);
            }
            if (this.wzb != null) {
                aVar.g(7, this.wzb);
            }
            if (this.noG != null) {
                aVar.g(8, this.noG);
            }
            if (this.wzc != null) {
                aVar.g(9, this.wzc);
            }
            aVar.fX(10, this.wzd);
            if (this.wze == null) {
                return 0;
            }
            aVar.g(11, this.wze);
            return 0;
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            if (this.wyZ != null) {
                h += e.a.a.b.b.a.h(2, this.wyZ);
            }
            h += e.a.a.a.fU(3, this.kzz);
            if (this.nlE != null) {
                h += e.a.a.b.b.a.h(4, this.nlE);
            }
            if (this.wza != null) {
                h += e.a.a.b.b.a.h(5, this.wza);
            }
            if (this.wdh != null) {
                h += e.a.a.b.b.a.h(6, this.wdh);
            }
            if (this.wzb != null) {
                h += e.a.a.b.b.a.h(7, this.wzb);
            }
            if (this.noG != null) {
                h += e.a.a.b.b.a.h(8, this.noG);
            }
            if (this.wzc != null) {
                h += e.a.a.b.b.a.h(9, this.wzc);
            }
            h += e.a.a.a.fU(10, this.wzd);
            if (this.wze != null) {
                h += e.a.a.b.b.a.h(11, this.wze);
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
            alb alb = (alb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    alb.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    alb.wyZ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    alb.kzz = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    alb.nlE = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    alb.wza = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    alb.wdh = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    alb.wzb = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    alb.noG = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    alb.wzc = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    alb.wzd = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    alb.wze = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

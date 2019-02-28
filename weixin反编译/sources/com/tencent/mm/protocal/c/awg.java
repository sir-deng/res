package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public class awg extends a {
    public String hxf;
    public String hxg;
    public String nkW;
    public String oVe;
    public double vUF;
    public double vUG;
    public String wKq;
    public String wKr;
    public String wKs;
    public String wKt;
    public String wfC;
    public String wfD;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkW != null) {
                aVar.g(1, this.nkW);
            }
            if (this.wKq != null) {
                aVar.g(2, this.wKq);
            }
            aVar.b(3, this.vUF);
            aVar.b(4, this.vUG);
            if (this.wKr != null) {
                aVar.g(5, this.wKr);
            }
            if (this.oVe != null) {
                aVar.g(6, this.oVe);
            }
            if (this.wKs != null) {
                aVar.g(7, this.wKs);
            }
            if (this.hxf != null) {
                aVar.g(8, this.hxf);
            }
            if (this.hxg != null) {
                aVar.g(9, this.hxg);
            }
            if (this.wfC != null) {
                aVar.g(10, this.wfC);
            }
            if (this.wfD != null) {
                aVar.g(11, this.wfD);
            }
            if (this.wKt == null) {
                return 0;
            }
            aVar.g(12, this.wKt);
            return 0;
        } else if (i == 1) {
            if (this.nkW != null) {
                h = e.a.a.b.b.a.h(1, this.nkW) + 0;
            } else {
                h = 0;
            }
            if (this.wKq != null) {
                h += e.a.a.b.b.a.h(2, this.wKq);
            }
            h = (h + (e.a.a.b.b.a.dX(3) + 8)) + (e.a.a.b.b.a.dX(4) + 8);
            if (this.wKr != null) {
                h += e.a.a.b.b.a.h(5, this.wKr);
            }
            if (this.oVe != null) {
                h += e.a.a.b.b.a.h(6, this.oVe);
            }
            if (this.wKs != null) {
                h += e.a.a.b.b.a.h(7, this.wKs);
            }
            if (this.hxf != null) {
                h += e.a.a.b.b.a.h(8, this.hxf);
            }
            if (this.hxg != null) {
                h += e.a.a.b.b.a.h(9, this.hxg);
            }
            if (this.wfC != null) {
                h += e.a.a.b.b.a.h(10, this.wfC);
            }
            if (this.wfD != null) {
                h += e.a.a.b.b.a.h(11, this.wfD);
            }
            if (this.wKt != null) {
                h += e.a.a.b.b.a.h(12, this.wKt);
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
            awg awg = (awg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awg.nkW = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    awg.wKq = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    awg.vUF = aVar3.AEQ.readDouble();
                    return 0;
                case 4:
                    awg.vUG = aVar3.AEQ.readDouble();
                    return 0;
                case 5:
                    awg.wKr = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    awg.oVe = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    awg.wKs = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    awg.hxf = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    awg.hxg = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    awg.wfC = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    awg.wfD = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    awg.wKt = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

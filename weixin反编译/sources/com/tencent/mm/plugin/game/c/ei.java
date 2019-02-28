package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class ei extends a {
    public String kyG;
    public String nlA;
    public String nlV;
    public String nlr;
    public String noG;
    public String nqe;
    public int nqf;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlV == null) {
                throw new b("Not all required fields were included: AppId");
            }
            if (this.nlV != null) {
                aVar.g(1, this.nlV);
            }
            if (this.noG != null) {
                aVar.g(2, this.noG);
            }
            if (this.nlA != null) {
                aVar.g(3, this.nlA);
            }
            if (this.kyG != null) {
                aVar.g(4, this.kyG);
            }
            if (this.nqe != null) {
                aVar.g(5, this.nqe);
            }
            aVar.fX(6, this.nqf);
            if (this.nlr == null) {
                return 0;
            }
            aVar.g(7, this.nlr);
            return 0;
        } else if (i == 1) {
            if (this.nlV != null) {
                h = e.a.a.b.b.a.h(1, this.nlV) + 0;
            } else {
                h = 0;
            }
            if (this.noG != null) {
                h += e.a.a.b.b.a.h(2, this.noG);
            }
            if (this.nlA != null) {
                h += e.a.a.b.b.a.h(3, this.nlA);
            }
            if (this.kyG != null) {
                h += e.a.a.b.b.a.h(4, this.kyG);
            }
            if (this.nqe != null) {
                h += e.a.a.b.b.a.h(5, this.nqe);
            }
            h += e.a.a.a.fU(6, this.nqf);
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(7, this.nlr);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.nlV != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ei eiVar = (ei) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eiVar.nlV = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    eiVar.noG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    eiVar.nlA = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    eiVar.kyG = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    eiVar.nqe = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    eiVar.nqf = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    eiVar.nlr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

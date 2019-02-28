package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class fc extends a {
    public String kZR;
    public String nHt;
    public String pff;
    public String sOP;
    public String vRA;
    public String vRB;
    public boolean vRC;
    public String vRz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nHt != null) {
                aVar.g(1, this.nHt);
            }
            if (this.pff != null) {
                aVar.g(2, this.pff);
            }
            if (this.kZR != null) {
                aVar.g(3, this.kZR);
            }
            if (this.sOP != null) {
                aVar.g(4, this.sOP);
            }
            if (this.vRz != null) {
                aVar.g(5, this.vRz);
            }
            if (this.vRA != null) {
                aVar.g(6, this.vRA);
            }
            if (this.vRB != null) {
                aVar.g(8, this.vRB);
            }
            aVar.am(9, this.vRC);
            return 0;
        } else if (i == 1) {
            if (this.nHt != null) {
                h = e.a.a.b.b.a.h(1, this.nHt) + 0;
            } else {
                h = 0;
            }
            if (this.pff != null) {
                h += e.a.a.b.b.a.h(2, this.pff);
            }
            if (this.kZR != null) {
                h += e.a.a.b.b.a.h(3, this.kZR);
            }
            if (this.sOP != null) {
                h += e.a.a.b.b.a.h(4, this.sOP);
            }
            if (this.vRz != null) {
                h += e.a.a.b.b.a.h(5, this.vRz);
            }
            if (this.vRA != null) {
                h += e.a.a.b.b.a.h(6, this.vRA);
            }
            if (this.vRB != null) {
                h += e.a.a.b.b.a.h(8, this.vRB);
            }
            return h + (e.a.a.b.b.a.dX(9) + 1);
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
            fc fcVar = (fc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fcVar.nHt = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    fcVar.pff = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    fcVar.kZR = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    fcVar.sOP = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    fcVar.vRz = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    fcVar.vRA = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    fcVar.vRB = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    fcVar.vRC = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

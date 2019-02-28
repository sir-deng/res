package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class axz extends a {
    public String noG;
    public String pgO;
    public String pgQ;
    public int pgR;
    public String pgS;
    public int pgT;
    public String pgU;
    public int pgV;
    public int pgW;
    public String pgY;
    public String pgZ;
    public String pha;
    public String phb;
    public int wLB;
    public String wLN;
    public String wLO;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pgO != null) {
                aVar.g(1, this.pgO);
            }
            aVar.fX(2, this.wLB);
            if (this.pgQ != null) {
                aVar.g(3, this.pgQ);
            }
            aVar.fX(4, this.pgR);
            if (this.pgS != null) {
                aVar.g(5, this.pgS);
            }
            aVar.fX(6, this.pgT);
            if (this.pgU != null) {
                aVar.g(7, this.pgU);
            }
            aVar.fX(8, this.pgV);
            aVar.fX(9, this.pgW);
            if (this.noG != null) {
                aVar.g(11, this.noG);
            }
            if (this.pgY != null) {
                aVar.g(12, this.pgY);
            }
            if (this.pgZ != null) {
                aVar.g(13, this.pgZ);
            }
            if (this.pha != null) {
                aVar.g(14, this.pha);
            }
            if (this.phb != null) {
                aVar.g(15, this.phb);
            }
            if (this.wLN != null) {
                aVar.g(18, this.wLN);
            }
            if (this.wLO == null) {
                return 0;
            }
            aVar.g(19, this.wLO);
            return 0;
        } else if (i == 1) {
            if (this.pgO != null) {
                h = e.a.a.b.b.a.h(1, this.pgO) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.wLB);
            if (this.pgQ != null) {
                h += e.a.a.b.b.a.h(3, this.pgQ);
            }
            h += e.a.a.a.fU(4, this.pgR);
            if (this.pgS != null) {
                h += e.a.a.b.b.a.h(5, this.pgS);
            }
            h += e.a.a.a.fU(6, this.pgT);
            if (this.pgU != null) {
                h += e.a.a.b.b.a.h(7, this.pgU);
            }
            h = (h + e.a.a.a.fU(8, this.pgV)) + e.a.a.a.fU(9, this.pgW);
            if (this.noG != null) {
                h += e.a.a.b.b.a.h(11, this.noG);
            }
            if (this.pgY != null) {
                h += e.a.a.b.b.a.h(12, this.pgY);
            }
            if (this.pgZ != null) {
                h += e.a.a.b.b.a.h(13, this.pgZ);
            }
            if (this.pha != null) {
                h += e.a.a.b.b.a.h(14, this.pha);
            }
            if (this.phb != null) {
                h += e.a.a.b.b.a.h(15, this.phb);
            }
            if (this.wLN != null) {
                h += e.a.a.b.b.a.h(18, this.wLN);
            }
            if (this.wLO != null) {
                h += e.a.a.b.b.a.h(19, this.wLO);
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
            axz axz = (axz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axz.pgO = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    axz.wLB = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    axz.pgQ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    axz.pgR = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    axz.pgS = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    axz.pgT = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    axz.pgU = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    axz.pgV = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    axz.pgW = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    axz.noG = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    axz.pgY = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    axz.pgZ = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    axz.pha = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    axz.phb = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    axz.wLN = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    axz.wLO = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

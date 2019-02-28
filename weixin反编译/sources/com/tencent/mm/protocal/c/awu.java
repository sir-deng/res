package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class awu extends a {
    public String fED;
    public String fzT;
    public String sTH;
    public long sUT;
    public long sUU;
    public long sUV;
    public int sUW;
    public int sUX;
    public long sUY;
    public String taB;
    public String title;
    public String type;
    public String url;
    public String wKQ;
    public String wKR;
    public String wKS;
    public String wKT;
    public int wKU;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.g(1, this.url);
            }
            if (this.fzT != null) {
                aVar.g(2, this.fzT);
            }
            if (this.fED != null) {
                aVar.g(3, this.fED);
            }
            if (this.taB != null) {
                aVar.g(4, this.taB);
            }
            if (this.wKQ != null) {
                aVar.g(5, this.wKQ);
            }
            if (this.wKR != null) {
                aVar.g(6, this.wKR);
            }
            if (this.type != null) {
                aVar.g(7, this.type);
            }
            if (this.title != null) {
                aVar.g(8, this.title);
            }
            aVar.S(9, this.sUT);
            aVar.S(10, this.sUU);
            if (this.sTH != null) {
                aVar.g(11, this.sTH);
            }
            aVar.S(12, this.sUV);
            aVar.fX(13, this.sUW);
            aVar.fX(14, this.sUX);
            if (this.wKS != null) {
                aVar.g(15, this.wKS);
            }
            if (this.wKT != null) {
                aVar.g(16, this.wKT);
            }
            aVar.S(17, this.sUY);
            aVar.fX(18, this.wKU);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                h = e.a.a.b.b.a.h(1, this.url) + 0;
            } else {
                h = 0;
            }
            if (this.fzT != null) {
                h += e.a.a.b.b.a.h(2, this.fzT);
            }
            if (this.fED != null) {
                h += e.a.a.b.b.a.h(3, this.fED);
            }
            if (this.taB != null) {
                h += e.a.a.b.b.a.h(4, this.taB);
            }
            if (this.wKQ != null) {
                h += e.a.a.b.b.a.h(5, this.wKQ);
            }
            if (this.wKR != null) {
                h += e.a.a.b.b.a.h(6, this.wKR);
            }
            if (this.type != null) {
                h += e.a.a.b.b.a.h(7, this.type);
            }
            if (this.title != null) {
                h += e.a.a.b.b.a.h(8, this.title);
            }
            h = (h + e.a.a.a.R(9, this.sUT)) + e.a.a.a.R(10, this.sUU);
            if (this.sTH != null) {
                h += e.a.a.b.b.a.h(11, this.sTH);
            }
            h = ((h + e.a.a.a.R(12, this.sUV)) + e.a.a.a.fU(13, this.sUW)) + e.a.a.a.fU(14, this.sUX);
            if (this.wKS != null) {
                h += e.a.a.b.b.a.h(15, this.wKS);
            }
            if (this.wKT != null) {
                h += e.a.a.b.b.a.h(16, this.wKT);
            }
            return (h + e.a.a.a.R(17, this.sUY)) + e.a.a.a.fU(18, this.wKU);
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
            awu awu = (awu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awu.url = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    awu.fzT = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    awu.fED = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    awu.taB = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    awu.wKQ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    awu.wKR = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    awu.type = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    awu.title = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    awu.sUT = aVar3.AEQ.rA();
                    return 0;
                case 10:
                    awu.sUU = aVar3.AEQ.rA();
                    return 0;
                case 11:
                    awu.sTH = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    awu.sUV = aVar3.AEQ.rA();
                    return 0;
                case 13:
                    awu.sUW = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    awu.sUX = aVar3.AEQ.rz();
                    return 0;
                case 15:
                    awu.wKS = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    awu.wKT = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    awu.sUY = aVar3.AEQ.rA();
                    return 0;
                case 18:
                    awu.wKU = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

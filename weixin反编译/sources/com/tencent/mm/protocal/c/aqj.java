package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aqj extends a {
    public String fGh;
    public int sfa;
    public String username;
    public int vTR;
    public int wAn;
    public int wDL;
    public int wDM;
    public String wDN;
    public int wDO;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fGh != null) {
                aVar.g(1, this.fGh);
            }
            if (this.username != null) {
                aVar.g(2, this.username);
            }
            aVar.fX(3, this.wAn);
            aVar.fX(4, this.vTR);
            aVar.fX(5, this.sfa);
            aVar.fX(6, this.wDL);
            aVar.fX(7, this.wDM);
            if (this.wDN != null) {
                aVar.g(8, this.wDN);
            }
            aVar.fX(9, this.wDO);
            return 0;
        } else if (i == 1) {
            if (this.fGh != null) {
                h = e.a.a.b.b.a.h(1, this.fGh) + 0;
            } else {
                h = 0;
            }
            if (this.username != null) {
                h += e.a.a.b.b.a.h(2, this.username);
            }
            h = ((((h + e.a.a.a.fU(3, this.wAn)) + e.a.a.a.fU(4, this.vTR)) + e.a.a.a.fU(5, this.sfa)) + e.a.a.a.fU(6, this.wDL)) + e.a.a.a.fU(7, this.wDM);
            if (this.wDN != null) {
                h += e.a.a.b.b.a.h(8, this.wDN);
            }
            return h + e.a.a.a.fU(9, this.wDO);
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
            aqj aqj = (aqj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqj.fGh = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    aqj.username = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aqj.wAn = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aqj.vTR = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aqj.sfa = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    aqj.wDL = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    aqj.wDM = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    aqj.wDN = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    aqj.wDO = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

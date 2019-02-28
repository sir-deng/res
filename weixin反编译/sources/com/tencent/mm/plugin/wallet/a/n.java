package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bp.a;

public final class n extends a {
    public String desc;
    public String id;
    public String name;
    public String sJQ;
    public String sJR;
    public String sJS = "0";
    public String sJT = "0";
    public int sJU = 0;
    public int status;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.g(1, this.id);
            }
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            aVar.fX(4, this.status);
            if (this.url != null) {
                aVar.g(5, this.url);
            }
            aVar.fX(6, this.type);
            if (this.sJQ != null) {
                aVar.g(7, this.sJQ);
            }
            if (this.sJR != null) {
                aVar.g(8, this.sJR);
            }
            if (this.sJS != null) {
                aVar.g(9, this.sJS);
            }
            if (this.sJT != null) {
                aVar.g(10, this.sJT);
            }
            aVar.fX(11, this.sJU);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                h = e.a.a.b.b.a.h(1, this.id) + 0;
            } else {
                h = 0;
            }
            if (this.name != null) {
                h += e.a.a.b.b.a.h(2, this.name);
            }
            if (this.desc != null) {
                h += e.a.a.b.b.a.h(3, this.desc);
            }
            h += e.a.a.a.fU(4, this.status);
            if (this.url != null) {
                h += e.a.a.b.b.a.h(5, this.url);
            }
            h += e.a.a.a.fU(6, this.type);
            if (this.sJQ != null) {
                h += e.a.a.b.b.a.h(7, this.sJQ);
            }
            if (this.sJR != null) {
                h += e.a.a.b.b.a.h(8, this.sJR);
            }
            if (this.sJS != null) {
                h += e.a.a.b.b.a.h(9, this.sJS);
            }
            if (this.sJT != null) {
                h += e.a.a.b.b.a.h(10, this.sJT);
            }
            return h + e.a.a.a.fU(11, this.sJU);
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
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.id = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    nVar.name = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    nVar.desc = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    nVar.status = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    nVar.url = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    nVar.type = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    nVar.sJQ = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    nVar.sJR = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    nVar.sJS = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    nVar.sJT = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    nVar.sJU = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

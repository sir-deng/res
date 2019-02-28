package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class btf extends a {
    public String kyK;
    public String nlA;
    public String noG;
    public String vQr;
    public String wKK;
    public String weM;
    public String wxV;
    public long xbk;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.weM != null) {
                aVar.g(1, this.weM);
            }
            if (this.vQr != null) {
                aVar.g(2, this.vQr);
            }
            if (this.wKK != null) {
                aVar.g(3, this.wKK);
            }
            if (this.noG != null) {
                aVar.g(4, this.noG);
            }
            if (this.kyK != null) {
                aVar.g(5, this.kyK);
            }
            if (this.nlA != null) {
                aVar.g(6, this.nlA);
            }
            if (this.wxV != null) {
                aVar.g(7, this.wxV);
            }
            aVar.S(8, this.xbk);
            return 0;
        } else if (i == 1) {
            if (this.weM != null) {
                h = e.a.a.b.b.a.h(1, this.weM) + 0;
            } else {
                h = 0;
            }
            if (this.vQr != null) {
                h += e.a.a.b.b.a.h(2, this.vQr);
            }
            if (this.wKK != null) {
                h += e.a.a.b.b.a.h(3, this.wKK);
            }
            if (this.noG != null) {
                h += e.a.a.b.b.a.h(4, this.noG);
            }
            if (this.kyK != null) {
                h += e.a.a.b.b.a.h(5, this.kyK);
            }
            if (this.nlA != null) {
                h += e.a.a.b.b.a.h(6, this.nlA);
            }
            if (this.wxV != null) {
                h += e.a.a.b.b.a.h(7, this.wxV);
            }
            return h + e.a.a.a.R(8, this.xbk);
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
            btf btf = (btf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btf.weM = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    btf.vQr = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    btf.wKK = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    btf.noG = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    btf.kyK = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    btf.nlA = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    btf.wxV = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    btf.xbk = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

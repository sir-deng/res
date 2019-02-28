package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class xe extends a {
    public int bZP;
    public String fpg;
    public String nkL;
    public String nlV;
    public String noG;
    public String phv;
    public String wnW;
    public int wor;
    public int wos;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nkL == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.phv == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else {
                if (this.fpg != null) {
                    aVar.g(1, this.fpg);
                }
                if (this.nkL != null) {
                    aVar.g(2, this.nkL);
                }
                if (this.phv != null) {
                    aVar.g(3, this.phv);
                }
                if (this.wnW != null) {
                    aVar.g(4, this.wnW);
                }
                aVar.fX(5, this.wor);
                aVar.fX(6, this.wos);
                if (this.nlV != null) {
                    aVar.g(7, this.nlV);
                }
                aVar.fX(8, this.bZP);
                if (this.noG == null) {
                    return 0;
                }
                aVar.g(9, this.noG);
                return 0;
            }
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            if (this.nkL != null) {
                h += e.a.a.b.b.a.h(2, this.nkL);
            }
            if (this.phv != null) {
                h += e.a.a.b.b.a.h(3, this.phv);
            }
            if (this.wnW != null) {
                h += e.a.a.b.b.a.h(4, this.wnW);
            }
            h = (h + e.a.a.a.fU(5, this.wor)) + e.a.a.a.fU(6, this.wos);
            if (this.nlV != null) {
                h += e.a.a.b.b.a.h(7, this.nlV);
            }
            h += e.a.a.a.fU(8, this.bZP);
            if (this.noG != null) {
                h += e.a.a.b.b.a.h(9, this.noG);
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nkL == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.phv != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xe xeVar = (xe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xeVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    xeVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    xeVar.phv = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    xeVar.wnW = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    xeVar.wor = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    xeVar.wos = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    xeVar.nlV = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    xeVar.bZP = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    xeVar.noG = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ex extends a {
    public String fBa;
    public String sRp;
    public String sRr;
    public String sRs;
    public String sRt;
    public String vRc;
    public String vRd;
    public String vRe;
    public String vRf;
    public String vRg;
    public String vRh;
    public String vRi;
    public String vRj;
    public String vRk;
    public long vRl;
    public int vRm;
    public String vRn;
    public String vRo;
    public String vRp;
    public String vRq;
    public ey vRr;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vRc != null) {
                aVar.g(1, this.vRc);
            }
            if (this.vRd != null) {
                aVar.g(2, this.vRd);
            }
            if (this.vRe != null) {
                aVar.g(3, this.vRe);
            }
            if (this.vRf != null) {
                aVar.g(4, this.vRf);
            }
            if (this.vRg != null) {
                aVar.g(5, this.vRg);
            }
            if (this.vRh != null) {
                aVar.g(6, this.vRh);
            }
            if (this.vRi != null) {
                aVar.g(7, this.vRi);
            }
            if (this.vRj != null) {
                aVar.g(8, this.vRj);
            }
            if (this.fBa != null) {
                aVar.g(9, this.fBa);
            }
            if (this.vRk != null) {
                aVar.g(10, this.vRk);
            }
            if (this.sRr != null) {
                aVar.g(11, this.sRr);
            }
            if (this.sRt != null) {
                aVar.g(12, this.sRt);
            }
            if (this.sRs != null) {
                aVar.g(13, this.sRs);
            }
            aVar.S(14, this.vRl);
            aVar.fX(15, this.vRm);
            if (this.vRn != null) {
                aVar.g(16, this.vRn);
            }
            if (this.vRo != null) {
                aVar.g(17, this.vRo);
            }
            if (this.vRp != null) {
                aVar.g(18, this.vRp);
            }
            if (this.sRp != null) {
                aVar.g(19, this.sRp);
            }
            if (this.vRq != null) {
                aVar.g(20, this.vRq);
            }
            if (this.vRr == null) {
                return 0;
            }
            aVar.fZ(21, this.vRr.bkL());
            this.vRr.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vRc != null) {
                h = e.a.a.b.b.a.h(1, this.vRc) + 0;
            } else {
                h = 0;
            }
            if (this.vRd != null) {
                h += e.a.a.b.b.a.h(2, this.vRd);
            }
            if (this.vRe != null) {
                h += e.a.a.b.b.a.h(3, this.vRe);
            }
            if (this.vRf != null) {
                h += e.a.a.b.b.a.h(4, this.vRf);
            }
            if (this.vRg != null) {
                h += e.a.a.b.b.a.h(5, this.vRg);
            }
            if (this.vRh != null) {
                h += e.a.a.b.b.a.h(6, this.vRh);
            }
            if (this.vRi != null) {
                h += e.a.a.b.b.a.h(7, this.vRi);
            }
            if (this.vRj != null) {
                h += e.a.a.b.b.a.h(8, this.vRj);
            }
            if (this.fBa != null) {
                h += e.a.a.b.b.a.h(9, this.fBa);
            }
            if (this.vRk != null) {
                h += e.a.a.b.b.a.h(10, this.vRk);
            }
            if (this.sRr != null) {
                h += e.a.a.b.b.a.h(11, this.sRr);
            }
            if (this.sRt != null) {
                h += e.a.a.b.b.a.h(12, this.sRt);
            }
            if (this.sRs != null) {
                h += e.a.a.b.b.a.h(13, this.sRs);
            }
            h = (h + e.a.a.a.R(14, this.vRl)) + e.a.a.a.fU(15, this.vRm);
            if (this.vRn != null) {
                h += e.a.a.b.b.a.h(16, this.vRn);
            }
            if (this.vRo != null) {
                h += e.a.a.b.b.a.h(17, this.vRo);
            }
            if (this.vRp != null) {
                h += e.a.a.b.b.a.h(18, this.vRp);
            }
            if (this.sRp != null) {
                h += e.a.a.b.b.a.h(19, this.sRp);
            }
            if (this.vRq != null) {
                h += e.a.a.b.b.a.h(20, this.vRq);
            }
            if (this.vRr != null) {
                h += e.a.a.a.fW(21, this.vRr.bkL());
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
            ex exVar = (ex) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    exVar.vRc = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    exVar.vRd = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    exVar.vRe = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    exVar.vRf = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    exVar.vRg = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    exVar.vRh = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    exVar.vRi = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    exVar.vRj = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    exVar.fBa = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    exVar.vRk = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    exVar.sRr = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    exVar.sRt = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    exVar.sRs = aVar3.AEQ.readString();
                    return 0;
                case 14:
                    exVar.vRl = aVar3.AEQ.rA();
                    return 0;
                case 15:
                    exVar.vRm = aVar3.AEQ.rz();
                    return 0;
                case 16:
                    exVar.vRn = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    exVar.vRo = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    exVar.vRp = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    exVar.sRp = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    exVar.vRq = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a eyVar = new ey();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eyVar.a(aVar4, eyVar, a.a(aVar4))) {
                        }
                        exVar.vRr = eyVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

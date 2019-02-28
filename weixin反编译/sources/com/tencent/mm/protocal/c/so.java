package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class so extends a {
    public int fgJ;
    public String fpg;
    public String nkL;
    public String nlA;
    public String vPI;
    public sn whk;
    public String whm;
    public String whn;
    public int who;
    public String whp;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.whk == null) {
                throw new b("Not all required fields were included: BannerImg");
            }
            if (this.whk != null) {
                aVar.fZ(1, this.whk.bkL());
                this.whk.a(aVar);
            }
            if (this.fpg != null) {
                aVar.g(2, this.fpg);
            }
            if (this.whm != null) {
                aVar.g(3, this.whm);
            }
            aVar.fX(4, this.fgJ);
            if (this.whn != null) {
                aVar.g(5, this.whn);
            }
            aVar.fX(6, this.who);
            if (this.nlA != null) {
                aVar.g(7, this.nlA);
            }
            if (this.nkL != null) {
                aVar.g(8, this.nkL);
            }
            if (this.vPI != null) {
                aVar.g(9, this.vPI);
            }
            if (this.whp == null) {
                return 0;
            }
            aVar.g(10, this.whp);
            return 0;
        } else if (i == 1) {
            if (this.whk != null) {
                fW = e.a.a.a.fW(1, this.whk.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.fpg != null) {
                fW += e.a.a.b.b.a.h(2, this.fpg);
            }
            if (this.whm != null) {
                fW += e.a.a.b.b.a.h(3, this.whm);
            }
            fW += e.a.a.a.fU(4, this.fgJ);
            if (this.whn != null) {
                fW += e.a.a.b.b.a.h(5, this.whn);
            }
            fW += e.a.a.a.fU(6, this.who);
            if (this.nlA != null) {
                fW += e.a.a.b.b.a.h(7, this.nlA);
            }
            if (this.nkL != null) {
                fW += e.a.a.b.b.a.h(8, this.nkL);
            }
            if (this.vPI != null) {
                fW += e.a.a.b.b.a.h(9, this.vPI);
            }
            if (this.whp != null) {
                fW += e.a.a.b.b.a.h(10, this.whp);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.whk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BannerImg");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            so soVar = (so) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a snVar = new sn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = snVar.a(aVar4, snVar, a.a(aVar4))) {
                        }
                        soVar.whk = snVar;
                    }
                    return 0;
                case 2:
                    soVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    soVar.whm = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    soVar.fgJ = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    soVar.whn = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    soVar.who = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    soVar.nlA = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    soVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    soVar.vPI = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    soVar.whp = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class wd extends a {
    public String pPL;
    public LinkedList<we> vVE = new LinkedList();
    public String wbo;
    public String wmI;
    public long wmJ;
    public long wmK;
    public String wmL;
    public long wmM;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wmI != null) {
                aVar.g(1, this.wmI);
            }
            aVar.d(2, 8, this.vVE);
            aVar.S(3, this.wmJ);
            aVar.S(4, this.wmK);
            if (this.wmL != null) {
                aVar.g(5, this.wmL);
            }
            if (this.pPL != null) {
                aVar.g(6, this.pPL);
            }
            aVar.S(7, this.wmM);
            if (this.wbo == null) {
                return 0;
            }
            aVar.g(8, this.wbo);
            return 0;
        } else if (i == 1) {
            if (this.wmI != null) {
                h = e.a.a.b.b.a.h(1, this.wmI) + 0;
            } else {
                h = 0;
            }
            h = ((h + e.a.a.a.c(2, 8, this.vVE)) + e.a.a.a.R(3, this.wmJ)) + e.a.a.a.R(4, this.wmK);
            if (this.wmL != null) {
                h += e.a.a.b.b.a.h(5, this.wmL);
            }
            if (this.pPL != null) {
                h += e.a.a.b.b.a.h(6, this.pPL);
            }
            h += e.a.a.a.R(7, this.wmM);
            if (this.wbo != null) {
                h += e.a.a.b.b.a.h(8, this.wbo);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vVE.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            wd wdVar = (wd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    wdVar.wmI = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a weVar = new we();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = weVar.a(aVar4, weVar, a.a(aVar4))) {
                        }
                        wdVar.vVE.add(weVar);
                    }
                    return 0;
                case 3:
                    wdVar.wmJ = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    wdVar.wmK = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    wdVar.wmL = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    wdVar.pPL = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    wdVar.wmM = aVar3.AEQ.rA();
                    return 0;
                case 8:
                    wdVar.wbo = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

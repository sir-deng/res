package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class k extends a {
    public String nlr;
    public String nlv;
    public int nlw;
    public a nlx;
    public du nly;
    public int nlz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nlv != null) {
                aVar.g(1, this.nlv);
            }
            aVar.fX(2, this.nlw);
            if (this.nlx != null) {
                aVar.fZ(3, this.nlx.bkL());
                this.nlx.a(aVar);
            }
            if (this.nly != null) {
                aVar.fZ(4, this.nly.bkL());
                this.nly.a(aVar);
            }
            aVar.fX(5, this.nlz);
            if (this.nlr == null) {
                return 0;
            }
            aVar.g(6, this.nlr);
            return 0;
        } else if (i == 1) {
            if (this.nlv != null) {
                h = e.a.a.b.b.a.h(1, this.nlv) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.nlw);
            if (this.nlx != null) {
                h += e.a.a.a.fW(3, this.nlx.bkL());
            }
            if (this.nly != null) {
                h += e.a.a.a.fW(4, this.nly.bkL());
            }
            h += e.a.a.a.fU(5, this.nlz);
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(6, this.nlr);
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
            k kVar = (k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a aVar4;
            e.a.a.a.a aVar5;
            boolean z;
            switch (intValue) {
                case 1:
                    kVar.nlv = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    kVar.nlw = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aVar4 = new a();
                        aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        kVar.nlx = aVar4;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aVar4 = new du();
                        aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        kVar.nly = aVar4;
                    }
                    return 0;
                case 5:
                    kVar.nlz = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    kVar.nlr = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

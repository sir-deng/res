package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class i extends a {
    public String fpg;
    public String nkL;
    public String nkM;
    public String nkN;
    public String nlr;
    public String nls;
    public LinkedList<w> nlt = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg != null) {
                aVar.g(1, this.fpg);
            }
            if (this.nkL != null) {
                aVar.g(2, this.nkL);
            }
            if (this.nkM != null) {
                aVar.g(3, this.nkM);
            }
            if (this.nkN != null) {
                aVar.g(4, this.nkN);
            }
            if (this.nlr != null) {
                aVar.g(5, this.nlr);
            }
            if (this.nls != null) {
                aVar.g(6, this.nls);
            }
            aVar.d(7, 8, this.nlt);
            return 0;
        } else if (i == 1) {
            if (this.fpg != null) {
                h = e.a.a.b.b.a.h(1, this.fpg) + 0;
            } else {
                h = 0;
            }
            if (this.nkL != null) {
                h += e.a.a.b.b.a.h(2, this.nkL);
            }
            if (this.nkM != null) {
                h += e.a.a.b.b.a.h(3, this.nkM);
            }
            if (this.nkN != null) {
                h += e.a.a.b.b.a.h(4, this.nkN);
            }
            if (this.nlr != null) {
                h += e.a.a.b.b.a.h(5, this.nlr);
            }
            if (this.nls != null) {
                h += e.a.a.b.b.a.h(6, this.nls);
            }
            return h + e.a.a.a.c(7, 8, this.nlt);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nlt.clear();
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
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    iVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    iVar.nkM = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    iVar.nkN = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    iVar.nlr = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    iVar.nls = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a wVar = new w();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = wVar.a(aVar4, wVar, a.a(aVar4))) {
                        }
                        iVar.nlt.add(wVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

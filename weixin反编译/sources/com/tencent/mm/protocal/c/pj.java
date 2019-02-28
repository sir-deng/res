package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class pj extends a {
    public String fpg;
    public String nkL;
    public String nlE;
    public int wfg;
    public LinkedList<are> wfh = new LinkedList();
    public int wfi;
    public String wfj;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkL != null) {
                aVar.g(1, this.nkL);
            }
            aVar.fX(2, this.wfg);
            if (this.fpg != null) {
                aVar.g(3, this.fpg);
            }
            if (this.nlE != null) {
                aVar.g(4, this.nlE);
            }
            aVar.d(5, 8, this.wfh);
            aVar.fX(6, this.wfi);
            if (this.wfj == null) {
                return 0;
            }
            aVar.g(7, this.wfj);
            return 0;
        } else if (i == 1) {
            if (this.nkL != null) {
                h = e.a.a.b.b.a.h(1, this.nkL) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.wfg);
            if (this.fpg != null) {
                h += e.a.a.b.b.a.h(3, this.fpg);
            }
            if (this.nlE != null) {
                h += e.a.a.b.b.a.h(4, this.nlE);
            }
            h = (h + e.a.a.a.c(5, 8, this.wfh)) + e.a.a.a.fU(6, this.wfi);
            if (this.wfj != null) {
                h += e.a.a.b.b.a.h(7, this.wfj);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wfh.clear();
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
            pj pjVar = (pj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    pjVar.nkL = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    pjVar.wfg = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    pjVar.fpg = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    pjVar.nlE = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a are = new are();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = are.a(aVar4, are, a.a(aVar4))) {
                        }
                        pjVar.wfh.add(are);
                    }
                    return 0;
                case 6:
                    pjVar.wfi = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    pjVar.wfj = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

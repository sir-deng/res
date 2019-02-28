package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bsv extends a {
    public String title;
    public LinkedList<bom> xaI = new LinkedList();
    public LinkedList<bom> xaJ = new LinkedList();
    public LinkedList<oy> xaK = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            aVar.d(2, 8, this.xaI);
            aVar.d(3, 8, this.xaJ);
            aVar.d(4, 8, this.xaK);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            return ((h + e.a.a.a.c(2, 8, this.xaI)) + e.a.a.a.c(3, 8, this.xaJ)) + e.a.a.a.c(4, 8, this.xaK);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xaI.clear();
            this.xaJ.clear();
            this.xaK.clear();
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
            bsv bsv = (bsv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a bom;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bsv.title = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bom = new bom();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bom.a(aVar4, bom, a.a(aVar4))) {
                        }
                        bsv.xaI.add(bom);
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bom = new bom();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bom.a(aVar4, bom, a.a(aVar4))) {
                        }
                        bsv.xaJ.add(bom);
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bom = new oy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bom.a(aVar4, bom, a.a(aVar4))) {
                        }
                        bsv.xaK.add(bom);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

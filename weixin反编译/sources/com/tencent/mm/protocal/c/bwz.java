package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bwz extends a {
    public String xeF;
    public String xeG;
    public LinkedList<String> xeH = new LinkedList();
    public int xeI;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xeF != null) {
                aVar.g(1, this.xeF);
            }
            if (this.xeG != null) {
                aVar.g(2, this.xeG);
            }
            aVar.d(3, 1, this.xeH);
            aVar.fX(4, this.xeI);
            return 0;
        } else if (i == 1) {
            if (this.xeF != null) {
                h = e.a.a.b.b.a.h(1, this.xeF) + 0;
            } else {
                h = 0;
            }
            if (this.xeG != null) {
                h += e.a.a.b.b.a.h(2, this.xeG);
            }
            return (h + e.a.a.a.c(3, 1, this.xeH)) + e.a.a.a.fU(4, this.xeI);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xeH.clear();
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
            bwz bwz = (bwz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bwz.xeF = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bwz.xeG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bwz.xeH.add(aVar3.AEQ.readString());
                    return 0;
                case 4:
                    bwz.xeI = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

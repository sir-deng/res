package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bxm extends a {
    public String xeF;
    public LinkedList<bxj> xeX = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xeF != null) {
                aVar.g(1, this.xeF);
            }
            aVar.d(2, 8, this.xeX);
            return 0;
        } else if (i == 1) {
            if (this.xeF != null) {
                h = e.a.a.b.b.a.h(1, this.xeF) + 0;
            } else {
                h = 0;
            }
            return h + e.a.a.a.c(2, 8, this.xeX);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xeX.clear();
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
            bxm bxm = (bxm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bxm.xeF = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a bxj = new bxj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bxj.a(aVar4, bxj, a.a(aVar4))) {
                        }
                        bxm.xeX.add(bxj);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

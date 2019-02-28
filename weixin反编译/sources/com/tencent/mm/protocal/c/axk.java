package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class axk extends a {
    public String title;
    public LinkedList<axj> wLA = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            aVar.d(2, 8, this.wLA);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = e.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            return h + e.a.a.a.c(2, 8, this.wLA);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wLA.clear();
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
            axk axk = (axk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    axk.title = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a axj = new axj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = axj.a(aVar4, axj, a.a(aVar4))) {
                        }
                        axk.wLA.add(axj);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ch extends a {
    public String title;
    public String vOm;
    public LinkedList<bnj> vOn = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vOm != null) {
                aVar.g(1, this.vOm);
            }
            aVar.d(2, 8, this.vOn);
            if (this.title == null) {
                return 0;
            }
            aVar.g(3, this.title);
            return 0;
        } else if (i == 1) {
            if (this.vOm != null) {
                h = e.a.a.b.b.a.h(1, this.vOm) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.c(2, 8, this.vOn);
            if (this.title != null) {
                h += e.a.a.b.b.a.h(3, this.title);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vOn.clear();
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
            ch chVar = (ch) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    chVar.vOm = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a bnj = new bnj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bnj.a(aVar4, bnj, a.a(aVar4))) {
                        }
                        chVar.vOn.add(bnj);
                    }
                    return 0;
                case 3:
                    chVar.title = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class m extends a {
    public String pkD;
    public String pkE;
    public LinkedList<h> pkF = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pkD != null) {
                aVar.g(1, this.pkD);
            }
            if (this.pkE != null) {
                aVar.g(2, this.pkE);
            }
            aVar.d(3, 8, this.pkF);
            return 0;
        } else if (i == 1) {
            if (this.pkD != null) {
                h = e.a.a.b.b.a.h(1, this.pkD) + 0;
            } else {
                h = 0;
            }
            if (this.pkE != null) {
                h += e.a.a.b.b.a.h(2, this.pkE);
            }
            return h + e.a.a.a.c(3, 8, this.pkF);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pkF.clear();
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
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mVar.pkD = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    mVar.pkE = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a hVar = new h();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        mVar.pkF.add(hVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

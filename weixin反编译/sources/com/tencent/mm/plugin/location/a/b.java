package com.tencent.mm.plugin.location.a;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class b extends a {
    public LinkedList<a> nWb = new LinkedList();
    public String nWc;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.nWb);
            if (this.nWc != null) {
                aVar.g(2, this.nWc);
            }
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.nWb) + 0;
            if (this.nWc != null) {
                return c + e.a.a.b.b.a.h(2, this.nWc);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nWb.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a aVar4 = new a();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        bVar.nWb.add(aVar4);
                    }
                    return 0;
                case 2:
                    bVar.nWc = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

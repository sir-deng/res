package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class g extends a {
    public LinkedList<h> sJG = new LinkedList();
    public b sJH;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.sJG);
            if (this.sJH != null) {
                aVar.b(2, this.sJH);
            }
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.sJG) + 0;
            if (this.sJH != null) {
                return c + e.a.a.a.a(2, this.sJH);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sJG.clear();
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
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a hVar = new h();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        gVar.sJG.add(hVar);
                    }
                    return 0;
                case 2:
                    gVar.sJH = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

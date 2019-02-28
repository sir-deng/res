package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cd extends a {
    public ape vOb;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vOb == null) {
                return 0;
            }
            aVar.fZ(1, this.vOb.bkL());
            this.vOb.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vOb != null) {
                fW = e.a.a.a.fW(1, this.vOb.bkL()) + 0;
            } else {
                fW = 0;
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cd cdVar = (cd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a ape = new ape();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ape.a(aVar4, ape, a.a(aVar4))) {
                        }
                        cdVar.vOb = ape;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

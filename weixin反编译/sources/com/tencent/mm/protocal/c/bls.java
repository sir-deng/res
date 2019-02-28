package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bls extends a {
    public bes wVF;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wVF == null) {
                return 0;
            }
            aVar.fZ(1, this.wVF.bkL());
            this.wVF.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wVF != null) {
                fW = e.a.a.a.fW(1, this.wVF.bkL()) + 0;
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
            bls bls = (bls) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bes = new bes();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        bls.wVF = bes;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

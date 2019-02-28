package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ayd extends a {
    public aot wfE;
    public int wid;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wfE != null) {
                aVar.fZ(1, this.wfE.bkL());
                this.wfE.a(aVar);
            }
            aVar.fX(2, this.wid);
            return 0;
        } else if (i == 1) {
            if (this.wfE != null) {
                fW = e.a.a.a.fW(1, this.wfE.bkL()) + 0;
            } else {
                fW = 0;
            }
            return fW + e.a.a.a.fU(2, this.wid);
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
            ayd ayd = (ayd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a aot = new aot();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aot.a(aVar4, aot, a.a(aVar4))) {
                        }
                        ayd.wfE = aot;
                    }
                    return 0;
                case 2:
                    ayd.wid = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bge extends a {
    public String lTZ;
    public int sfa;
    public aou wDT;
    public String wRS;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wRS != null) {
                aVar.g(1, this.wRS);
            }
            aVar.fX(2, this.sfa);
            if (this.lTZ != null) {
                aVar.g(3, this.lTZ);
            }
            if (this.wDT == null) {
                return 0;
            }
            aVar.fZ(4, this.wDT.bkL());
            this.wDT.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wRS != null) {
                h = e.a.a.b.b.a.h(1, this.wRS) + 0;
            } else {
                h = 0;
            }
            h += e.a.a.a.fU(2, this.sfa);
            if (this.lTZ != null) {
                h += e.a.a.b.b.a.h(3, this.lTZ);
            }
            if (this.wDT != null) {
                h += e.a.a.a.fW(4, this.wDT.bkL());
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bge bge = (bge) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bge.wRS = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    bge.sfa = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bge.lTZ = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a aou = new aou();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aou.a(aVar4, aou, a.a(aVar4))) {
                        }
                        bge.wDT = aou;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

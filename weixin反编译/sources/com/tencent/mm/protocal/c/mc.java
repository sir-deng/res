package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class mc extends bea {
    public String desc;
    public boolean wbB;
    public boolean wbC;
    public LinkedList<Integer> wbc = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.d(2, 2, this.wbc);
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            aVar.am(4, this.wbB);
            aVar.am(5, this.wbC);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.c(2, 2, this.wbc);
            if (this.desc != null) {
                fW += e.a.a.b.b.a.h(3, this.desc);
            }
            return (fW + (e.a.a.b.b.a.dX(4) + 1)) + (e.a.a.b.b.a.dX(5) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wbc.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mc mcVar = (mc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        mcVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    mcVar.wbc.add(Integer.valueOf(aVar3.AEQ.rz()));
                    return 0;
                case 3:
                    mcVar.desc = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    mcVar.wbB = aVar3.cKv();
                    return 0;
                case 5:
                    mcVar.wbC = aVar3.cKv();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

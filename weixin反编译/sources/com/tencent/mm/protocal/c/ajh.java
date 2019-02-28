package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ajh extends bea {
    public int aAk;
    public int condition;
    public int wxA;
    public int wxB;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.aAk);
            aVar.fX(3, this.condition);
            aVar.fX(4, this.wxA);
            aVar.fX(5, this.wxB);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            return (((fW + e.a.a.a.fU(2, this.aAk)) + e.a.a.a.fU(3, this.condition)) + e.a.a.a.fU(4, this.wxA)) + e.a.a.a.fU(5, this.wxB);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            ajh ajh = (ajh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ajh.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    ajh.aAk = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ajh.condition = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    ajh.wxA = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    ajh.wxB = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ir extends a {
    public LinkedList<iq> vVA = new LinkedList();
    public LinkedList<iq> vVB = new LinkedList();
    public int vVx;
    public int vVy;
    public int vVz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vVx);
            aVar.fX(2, this.vVy);
            aVar.fX(5, this.vVz);
            aVar.d(3, 8, this.vVA);
            aVar.d(4, 8, this.vVB);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.fU(1, this.vVx) + 0) + e.a.a.a.fU(2, this.vVy)) + e.a.a.a.fU(5, this.vVz)) + e.a.a.a.c(3, 8, this.vVA)) + e.a.a.a.c(4, 8, this.vVB);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.vVA.clear();
                this.vVB.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                ir irVar = (ir) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList JD;
                int size;
                a iqVar;
                e.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        irVar.vVx = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        irVar.vVy = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            iqVar = new iq();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = iqVar.a(aVar4, iqVar, a.a(aVar4))) {
                            }
                            irVar.vVA.add(iqVar);
                        }
                        return 0;
                    case 4:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            iqVar = new iq();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = iqVar.a(aVar4, iqVar, a.a(aVar4))) {
                            }
                            irVar.vVB.add(iqVar);
                        }
                        return 0;
                    case 5:
                        irVar.vVz = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bvu extends a {
    public int kyA;
    public int vVz;
    public LinkedList<bvt> xdi = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.kyA);
            aVar.d(2, 8, this.xdi);
            aVar.fX(3, this.vVz);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fU(1, this.kyA) + 0) + e.a.a.a.c(2, 8, this.xdi)) + e.a.a.a.fU(3, this.vVz);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.xdi.clear();
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
                bvu bvu = (bvu) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        bvu.kyA = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        LinkedList JD = aVar3.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a bvt = new bvt();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bvt.a(aVar4, bvt, a.a(aVar4))) {
                            }
                            bvu.xdi.add(bvt);
                        }
                        return 0;
                    case 3:
                        bvu.vVz = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

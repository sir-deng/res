package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class awf extends a {
    public int kyA;
    public LinkedList<awc> wKp = new LinkedList();
    public LinkedList<Integer> wrr = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.kyA);
            aVar.c(2, this.wrr);
            aVar.d(3, 8, this.wKp);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fU(1, this.kyA) + 0) + e.a.a.a.b(2, this.wrr)) + e.a.a.a.c(3, 8, this.wKp);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wrr.clear();
                this.wKp.clear();
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
                awf awf = (awf) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        awf.kyA = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        awf.wrr = new e.a.a.a.a(aVar3.cKw().oz, unknownTagHandler).cKt();
                        return 0;
                    case 3:
                        LinkedList JD = aVar3.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a awc = new awc();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = awc.a(aVar4, awc, a.a(aVar4))) {
                            }
                            awf.wKp.add(awc);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ag extends a {
    public int vLm;
    public int vLn;
    public int vLo;
    public LinkedList<ae> vLp = new LinkedList();
    public int vLq;
    public LinkedList<ae> vLr = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vLm);
            aVar.fX(2, this.vLo);
            aVar.d(3, 8, this.vLp);
            aVar.fX(4, this.vLn);
            aVar.fX(5, this.vLq);
            aVar.d(6, 8, this.vLr);
            return 0;
        } else if (i == 1) {
            return (((((e.a.a.a.fU(1, this.vLm) + 0) + e.a.a.a.fU(2, this.vLo)) + e.a.a.a.c(3, 8, this.vLp)) + e.a.a.a.fU(4, this.vLn)) + e.a.a.a.fU(5, this.vLq)) + e.a.a.a.c(6, 8, this.vLr);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.vLp.clear();
                this.vLr.clear();
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
                ag agVar = (ag) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList JD;
                int size;
                a aeVar;
                e.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        agVar.vLm = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        agVar.vLo = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            aeVar = new ae();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = aeVar.a(aVar4, aeVar, a.a(aVar4))) {
                            }
                            agVar.vLp.add(aeVar);
                        }
                        return 0;
                    case 4:
                        agVar.vLn = aVar3.AEQ.rz();
                        return 0;
                    case 5:
                        agVar.vLq = aVar3.AEQ.rz();
                        return 0;
                    case 6:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            aeVar = new ae();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = aeVar.a(aVar4, aeVar, a.a(aVar4))) {
                            }
                            agVar.vLr.add(aeVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

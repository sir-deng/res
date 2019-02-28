package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cx extends a {
    public LinkedList<avt> vMp = new LinkedList();
    public LinkedList<avs> vMq = new LinkedList();
    public int vOB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vOB);
            aVar.d(2, 8, this.vMp);
            aVar.d(3, 8, this.vMq);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fU(1, this.vOB) + 0) + e.a.a.a.c(2, 8, this.vMp)) + e.a.a.a.c(3, 8, this.vMq);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.vMp.clear();
                this.vMq.clear();
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
                cx cxVar = (cx) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList JD;
                int size;
                a avt;
                e.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        cxVar.vOB = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            avt = new avt();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = avt.a(aVar4, avt, a.a(aVar4))) {
                            }
                            cxVar.vMp.add(avt);
                        }
                        return 0;
                    case 3:
                        JD = aVar3.JD(intValue);
                        size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            avt = new avs();
                            aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = avt.a(aVar4, avt, a.a(aVar4))) {
                            }
                            cxVar.vMq.add(avt);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

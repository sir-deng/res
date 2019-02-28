package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cab extends a {
    public long xgC;
    public long xgD;
    public String xgE;
    public LinkedList<cac> xgF = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int R;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xgE == null) {
                throw new b("Not all required fields were included: TotalMsg");
            }
            aVar.S(1, this.xgD);
            aVar.S(2, this.xgC);
            if (this.xgE != null) {
                aVar.g(3, this.xgE);
            }
            aVar.d(4, 8, this.xgF);
            return 0;
        } else if (i == 1) {
            R = (e.a.a.a.R(1, this.xgD) + 0) + e.a.a.a.R(2, this.xgC);
            if (this.xgE != null) {
                R += e.a.a.b.b.a.h(3, this.xgE);
            }
            return R + e.a.a.a.c(4, 8, this.xgF);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xgF.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            if (this.xgE != null) {
                return 0;
            }
            throw new b("Not all required fields were included: TotalMsg");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cab cab = (cab) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cab.xgD = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    cab.xgC = aVar3.AEQ.rA();
                    return 0;
                case 3:
                    cab.xgE = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a cac = new cac();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cac.a(aVar4, cac, a.a(aVar4))) {
                        }
                        cab.xgF.add(cac);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bj extends a {
    public aoa vNq;
    public LinkedList<aob> vNr = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNq == null) {
                throw new b("Not all required fields were included: LogHead");
            }
            if (this.vNq != null) {
                aVar.fZ(1, this.vNq.bkL());
                this.vNq.a(aVar);
            }
            aVar.d(2, 8, this.vNr);
            return 0;
        } else if (i == 1) {
            if (this.vNq != null) {
                fW = e.a.a.a.fW(1, this.vNq.bkL()) + 0;
            } else {
                fW = 0;
            }
            return fW + e.a.a.a.c(2, 8, this.vNr);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vNr.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vNq != null) {
                return 0;
            }
            throw new b("Not all required fields were included: LogHead");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bj bjVar = (bj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a aoa;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aoa = new aoa();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aoa.a(aVar4, aoa, a.a(aVar4))) {
                        }
                        bjVar.vNq = aoa;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aoa = new aob();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aoa.a(aVar4, aoa, a.a(aVar4))) {
                        }
                        bjVar.vNr.add(aoa);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

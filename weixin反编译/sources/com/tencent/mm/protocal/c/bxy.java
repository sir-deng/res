package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bxy extends a {
    public bww xfe;
    public int xfq;
    public int xfr;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfe == null) {
                throw new b("Not all required fields were included: base_request");
            }
            if (this.xfe != null) {
                aVar.fZ(1, this.xfe.bkL());
                this.xfe.a(aVar);
            }
            aVar.fX(2, this.xfq);
            aVar.fX(3, this.xfr);
            return 0;
        } else if (i == 1) {
            if (this.xfe != null) {
                fW = e.a.a.a.fW(1, this.xfe.bkL()) + 0;
            } else {
                fW = 0;
            }
            return (fW + e.a.a.a.fU(2, this.xfq)) + e.a.a.a.fU(3, this.xfr);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.xfe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: base_request");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bxy bxy = (bxy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bww = new bww();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bww.a(aVar4, bww, a.a(aVar4))) {
                        }
                        bxy.xfe = bww;
                    }
                    return 0;
                case 2:
                    bxy.xfq = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bxy.xfr = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

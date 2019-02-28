package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bcm extends a {
    public blt wPn;
    public bet wPo;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wPn == null) {
                throw new b("Not all required fields were included: SnsRecommendObject");
            }
            if (this.wPn != null) {
                aVar.fZ(1, this.wPn.bkL());
                this.wPn.a(aVar);
            }
            if (this.wPo == null) {
                return 0;
            }
            aVar.fZ(2, this.wPo.bkL());
            this.wPo.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wPn != null) {
                fW = e.a.a.a.fW(1, this.wPn.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wPo != null) {
                fW += e.a.a.a.fW(2, this.wPo.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wPn != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SnsRecommendObject");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bcm bcm = (bcm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a blt;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        blt = new blt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = blt.a(aVar4, blt, a.a(aVar4))) {
                        }
                        bcm.wPn = blt;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        blt = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = blt.a(aVar4, blt, a.a(aVar4))) {
                        }
                        bcm.wPo = blt;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

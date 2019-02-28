package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bxw extends a {
    public bwx xfg;
    public bxn xfp;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfg == null) {
                throw new b("Not all required fields were included: base_response");
            }
            if (this.xfg != null) {
                aVar.fZ(1, this.xfg.bkL());
                this.xfg.a(aVar);
            }
            if (this.xfp == null) {
                return 0;
            }
            aVar.fZ(2, this.xfp.bkL());
            this.xfp.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.xfg != null) {
                fW = e.a.a.a.fW(1, this.xfg.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.xfp != null) {
                fW += e.a.a.a.fW(2, this.xfp.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.xfg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: base_response");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bxw bxw = (bxw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bwx;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bwx = new bwx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bwx.a(aVar4, bwx, a.a(aVar4))) {
                        }
                        bxw.xfg = bwx;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bwx = new bxn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bwx.a(aVar4, bwx, a.a(aVar4))) {
                        }
                        bxw.xfp = bwx;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

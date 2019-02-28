package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bxz extends a {
    public LinkedList<bxc> xeU = new LinkedList();
    public bwx xfg;
    public int xfs;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfg == null) {
                throw new b("Not all required fields were included: base_response");
            }
            if (this.xfg != null) {
                aVar.fZ(1, this.xfg.bkL());
                this.xfg.a(aVar);
            }
            aVar.d(2, 8, this.xeU);
            aVar.fX(3, this.xfs);
            return 0;
        } else if (i == 1) {
            if (this.xfg != null) {
                fW = e.a.a.a.fW(1, this.xfg.bkL()) + 0;
            } else {
                fW = 0;
            }
            return (fW + e.a.a.a.c(2, 8, this.xeU)) + e.a.a.a.fU(3, this.xfs);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xeU.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            bxz bxz = (bxz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
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
                        bxz.xfg = bwx;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bwx = new bxc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bwx.a(aVar4, bwx, a.a(aVar4))) {
                        }
                        bxz.xeU.add(bwx);
                    }
                    return 0;
                case 3:
                    bxz.xfs = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bxq extends a {
    public bxm xfj;
    public bxd xfk;
    public String xfl;
    public String xfm;
    public String xfn;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfj != null) {
                aVar.fZ(1, this.xfj.bkL());
                this.xfj.a(aVar);
            }
            if (this.xfk != null) {
                aVar.fZ(2, this.xfk.bkL());
                this.xfk.a(aVar);
            }
            if (this.xfl != null) {
                aVar.g(3, this.xfl);
            }
            if (this.xfm != null) {
                aVar.g(4, this.xfm);
            }
            if (this.xfn == null) {
                return 0;
            }
            aVar.g(5, this.xfn);
            return 0;
        } else if (i == 1) {
            if (this.xfj != null) {
                fW = e.a.a.a.fW(1, this.xfj.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.xfk != null) {
                fW += e.a.a.a.fW(2, this.xfk.bkL());
            }
            if (this.xfl != null) {
                fW += e.a.a.b.b.a.h(3, this.xfl);
            }
            if (this.xfm != null) {
                fW += e.a.a.b.b.a.h(4, this.xfm);
            }
            if (this.xfn != null) {
                fW += e.a.a.b.b.a.h(5, this.xfn);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bxq bxq = (bxq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bxm;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bxm = new bxm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxm.a(aVar4, bxm, a.a(aVar4))) {
                        }
                        bxq.xfj = bxm;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bxm = new bxd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxm.a(aVar4, bxm, a.a(aVar4))) {
                        }
                        bxq.xfk = bxm;
                    }
                    return 0;
                case 3:
                    bxq.xfl = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bxq.xfm = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bxq.xfn = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

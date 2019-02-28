package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class bgu extends a {
    public int wSg;
    public int wSh;
    public int wSi;
    public int wSj;
    public int wSk;
    public int wSl;
    public int wSm;
    public b wgG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wgG == null) {
                throw new e.a.a.b("Not all required fields were included: data");
            }
            aVar.fX(1, this.wSg);
            aVar.fX(2, this.wSh);
            aVar.fX(3, this.wSi);
            aVar.fX(4, this.wSj);
            aVar.fX(5, this.wSk);
            aVar.fX(6, this.wSl);
            aVar.fX(7, this.wSm);
            if (this.wgG != null) {
                aVar.b(8, this.wgG);
            }
            return 0;
        } else if (i == 1) {
            int fU = ((((((e.a.a.a.fU(1, this.wSg) + 0) + e.a.a.a.fU(2, this.wSh)) + e.a.a.a.fU(3, this.wSi)) + e.a.a.a.fU(4, this.wSj)) + e.a.a.a.fU(5, this.wSk)) + e.a.a.a.fU(6, this.wSl)) + e.a.a.a.fU(7, this.wSm);
            if (this.wgG != null) {
                return fU + e.a.a.a.a(8, this.wgG);
            }
            return fU;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cKx();
                }
            }
            if (bArr != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bgu bgu = (bgu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgu.wSg = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bgu.wSh = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bgu.wSi = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bgu.wSj = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bgu.wSk = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bgu.wSl = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bgu.wSm = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    bgu.wgG = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

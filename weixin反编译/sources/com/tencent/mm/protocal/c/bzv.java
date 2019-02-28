package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class bzv extends a {
    public String kyG;
    public String kzN;
    public String noL;
    public int npU;
    public b xgt;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kyG == null) {
                throw new e.a.a.b("Not all required fields were included: UserName");
            } else if (this.kzN == null) {
                throw new e.a.a.b("Not all required fields were included: NickName");
            } else if (this.noL == null) {
                throw new e.a.a.b("Not all required fields were included: Content");
            } else {
                aVar.fX(1, this.npU);
                if (this.kyG != null) {
                    aVar.g(2, this.kyG);
                }
                if (this.kzN != null) {
                    aVar.g(3, this.kzN);
                }
                if (this.noL != null) {
                    aVar.g(4, this.noL);
                }
                if (this.xgt != null) {
                    aVar.b(5, this.xgt);
                }
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.npU) + 0;
            if (this.kyG != null) {
                fU += e.a.a.b.b.a.h(2, this.kyG);
            }
            if (this.kzN != null) {
                fU += e.a.a.b.b.a.h(3, this.kzN);
            }
            if (this.noL != null) {
                fU += e.a.a.b.b.a.h(4, this.noL);
            }
            if (this.xgt != null) {
                return fU + e.a.a.a.a(5, this.xgt);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.kyG == null) {
                throw new e.a.a.b("Not all required fields were included: UserName");
            } else if (this.kzN == null) {
                throw new e.a.a.b("Not all required fields were included: NickName");
            } else if (this.noL != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzv bzv = (bzv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzv.npU = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bzv.kyG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bzv.kzN = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bzv.noL = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bzv.xgt = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

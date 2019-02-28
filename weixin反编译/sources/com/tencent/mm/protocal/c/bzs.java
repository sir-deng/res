package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class bzs extends a {
    public String fpg;
    public String noL;
    public int npU;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.noL == null) {
                throw new b("Not all required fields were included: Content");
            } else {
                aVar.fX(1, this.npU);
                if (this.fpg != null) {
                    aVar.g(2, this.fpg);
                }
                if (this.noL != null) {
                    aVar.g(3, this.noL);
                }
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.npU) + 0;
            if (this.fpg != null) {
                fU += e.a.a.b.b.a.h(2, this.fpg);
            }
            if (this.noL != null) {
                return fU + e.a.a.b.b.a.h(3, this.noL);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.noL != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzs bzs = (bzs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzs.npU = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bzs.fpg = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bzs.noL = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

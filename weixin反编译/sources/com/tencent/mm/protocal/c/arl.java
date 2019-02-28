package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class arl extends a {
    public String fpg;
    public String phv;
    public int wFZ;
    public int wGa;
    public int wnV;
    public String wnW;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.phv == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else {
                aVar.fX(1, this.wFZ);
                if (this.fpg != null) {
                    aVar.g(2, this.fpg);
                }
                if (this.phv != null) {
                    aVar.g(3, this.phv);
                }
                aVar.fX(4, this.wnV);
                if (this.wnW != null) {
                    aVar.g(5, this.wnW);
                }
                aVar.fX(6, this.wGa);
                return 0;
            }
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wFZ) + 0;
            if (this.fpg != null) {
                fU += e.a.a.b.b.a.h(2, this.fpg);
            }
            if (this.phv != null) {
                fU += e.a.a.b.b.a.h(3, this.phv);
            }
            fU += e.a.a.a.fU(4, this.wnV);
            if (this.wnW != null) {
                fU += e.a.a.b.b.a.h(5, this.wnW);
            }
            return fU + e.a.a.a.fU(6, this.wGa);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.fpg == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.phv != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arl arl = (arl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arl.wFZ = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    arl.fpg = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    arl.phv = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    arl.wnV = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    arl.wnW = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    arl.wGa = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

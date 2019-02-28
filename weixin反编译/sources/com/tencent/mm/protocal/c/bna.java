package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;

public final class bna extends a {
    public int hQt;
    public long hQu;
    public int hQv;
    public int hQw;
    public int hQx;
    public int opType;
    public String wWX;
    public String wWY;
    public String wWZ;
    public String wXa;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wWX == null) {
                throw new b("Not all required fields were included: StatusDesc1");
            } else if (this.wWY == null) {
                throw new b("Not all required fields were included: StatusDesc2");
            } else if (this.wWZ == null) {
                throw new b("Not all required fields were included: DataFlowSourceInfo");
            } else if (this.wXa == null) {
                throw new b("Not all required fields were included: DataFlowResultInfo");
            } else {
                aVar.fX(1, this.opType);
                aVar.fX(2, this.hQx);
                aVar.fX(3, this.hQt);
                aVar.S(4, this.hQu);
                aVar.fX(5, this.hQv);
                aVar.fX(6, this.hQw);
                if (this.wWX != null) {
                    aVar.g(7, this.wWX);
                }
                if (this.wWY != null) {
                    aVar.g(8, this.wWY);
                }
                if (this.wWZ != null) {
                    aVar.g(9, this.wWZ);
                }
                if (this.wXa != null) {
                    aVar.g(10, this.wXa);
                }
                return 0;
            }
        } else if (i == 1) {
            fU = (((((e.a.a.a.fU(1, this.opType) + 0) + e.a.a.a.fU(2, this.hQx)) + e.a.a.a.fU(3, this.hQt)) + e.a.a.a.R(4, this.hQu)) + e.a.a.a.fU(5, this.hQv)) + e.a.a.a.fU(6, this.hQw);
            if (this.wWX != null) {
                fU += e.a.a.b.b.a.h(7, this.wWX);
            }
            if (this.wWY != null) {
                fU += e.a.a.b.b.a.h(8, this.wWY);
            }
            if (this.wWZ != null) {
                fU += e.a.a.b.b.a.h(9, this.wWZ);
            }
            if (this.wXa != null) {
                return fU + e.a.a.b.b.a.h(10, this.wXa);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.wWX == null) {
                throw new b("Not all required fields were included: StatusDesc1");
            } else if (this.wWY == null) {
                throw new b("Not all required fields were included: StatusDesc2");
            } else if (this.wWZ == null) {
                throw new b("Not all required fields were included: DataFlowSourceInfo");
            } else if (this.wXa != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DataFlowResultInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bna bna = (bna) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bna.opType = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    bna.hQx = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bna.hQt = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bna.hQu = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    bna.hQv = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bna.hQw = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    bna.wWX = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bna.wWY = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    bna.wWZ = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    bna.wXa = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

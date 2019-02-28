package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class aqk extends a {
    public int kzz;
    public int scene;
    public String vUV;
    public String vWw;
    public long wDP;
    public long wDQ;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.scene);
            if (this.vUV != null) {
                aVar.g(2, this.vUV);
            }
            aVar.S(3, this.wDP);
            aVar.S(4, this.wDQ);
            if (this.vWw != null) {
                aVar.g(5, this.vWw);
            }
            aVar.fX(6, this.kzz);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.scene) + 0;
            if (this.vUV != null) {
                fU += e.a.a.b.b.a.h(2, this.vUV);
            }
            fU = (fU + e.a.a.a.R(3, this.wDP)) + e.a.a.a.R(4, this.wDQ);
            if (this.vWw != null) {
                fU += e.a.a.b.b.a.h(5, this.vWw);
            }
            return fU + e.a.a.a.fU(6, this.kzz);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqk aqk = (aqk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqk.scene = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    aqk.vUV = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aqk.wDP = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    aqk.wDQ = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    aqk.vWw = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aqk.kzz = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

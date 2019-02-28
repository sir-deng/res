package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class cap extends a {
    public b vPr;
    public long xgC;
    public int xgV;

    protected final int a(int i, Object... objArr) {
        int R;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPr == null) {
                throw new e.a.a.b("Not all required fields were included: VoiceData");
            }
            aVar.S(1, this.xgC);
            if (this.vPr != null) {
                aVar.b(2, this.vPr);
            }
            aVar.fX(3, this.xgV);
            return 0;
        } else if (i == 1) {
            R = e.a.a.a.R(1, this.xgC) + 0;
            if (this.vPr != null) {
                R += e.a.a.a.a(2, this.vPr);
            }
            return R + e.a.a.a.fU(3, this.xgV);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            if (this.vPr != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: VoiceData");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cap cap = (cap) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cap.xgC = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    cap.vPr = aVar3.cKw();
                    return 0;
                case 3:
                    cap.xgV = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

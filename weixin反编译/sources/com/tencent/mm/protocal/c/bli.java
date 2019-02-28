package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bli extends a {
    public int nne;
    public long vWS;
    public bes wKx;

    protected final int a(int i, Object... objArr) {
        int R;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.vWS);
            aVar.fX(2, this.nne);
            if (this.wKx != null) {
                aVar.fZ(3, this.wKx.bkL());
                this.wKx.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            R = (e.a.a.a.R(1, this.vWS) + 0) + e.a.a.a.fU(2, this.nne);
            if (this.wKx != null) {
                return R + e.a.a.a.fW(3, this.wKx.bkL());
            }
            return R;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (R = a.a(aVar2); R > 0; R = a.a(aVar2)) {
                if (!super.a(aVar2, this, R)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bli bli = (bli) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bli.vWS = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    bli.nne = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bes = new bes();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bes.a(aVar4, bes, a.a(aVar4))) {
                        }
                        bli.wKx = bes;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

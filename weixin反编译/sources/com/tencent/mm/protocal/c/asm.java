package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class asm extends a {
    public int wGC;
    public int wGS;
    public int wGT;
    public bet wfM;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wfM == null) {
                throw new b("Not all required fields were included: UserName");
            }
            if (this.wfM != null) {
                aVar.fZ(1, this.wfM.bkL());
                this.wfM.a(aVar);
            }
            aVar.fX(2, this.wGS);
            aVar.fX(3, this.wGT);
            aVar.fX(4, this.wGC);
            return 0;
        } else if (i == 1) {
            if (this.wfM != null) {
                fW = e.a.a.a.fW(1, this.wfM.bkL()) + 0;
            } else {
                fW = 0;
            }
            return ((fW + e.a.a.a.fU(2, this.wGS)) + e.a.a.a.fU(3, this.wGT)) + e.a.a.a.fU(4, this.wGC);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wfM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asm asm = (asm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bet = new bet();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        asm.wfM = bet;
                    }
                    return 0;
                case 2:
                    asm.wGS = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    asm.wGT = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    asm.wGC = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

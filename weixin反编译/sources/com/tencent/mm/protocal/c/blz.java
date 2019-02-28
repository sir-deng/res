package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class blz extends a {
    public int kyA;
    public LinkedList<bet> kyB = new LinkedList();
    public String noE;
    public long wVU;

    protected final int a(int i, Object... objArr) {
        int R;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.wVU);
            if (this.noE != null) {
                aVar.g(2, this.noE);
            }
            aVar.fX(3, this.kyA);
            aVar.d(4, 8, this.kyB);
            return 0;
        } else if (i == 1) {
            R = e.a.a.a.R(1, this.wVU) + 0;
            if (this.noE != null) {
                R += e.a.a.b.b.a.h(2, this.noE);
            }
            return (R + e.a.a.a.fU(3, this.kyA)) + e.a.a.a.c(4, 8, this.kyB);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kyB.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            blz blz = (blz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    blz.wVU = aVar3.AEQ.rA();
                    return 0;
                case 2:
                    blz.noE = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    blz.kyA = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a bet = new bet();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        blz.kyB.add(bet);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

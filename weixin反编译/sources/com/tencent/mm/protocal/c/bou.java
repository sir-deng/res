package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bou extends a {
    public int wBF;
    public bet wYa;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYa == null) {
                throw new b("Not all required fields were included: StatReport");
            }
            aVar.fX(1, this.wBF);
            if (this.wYa != null) {
                aVar.fZ(2, this.wYa.bkL());
                this.wYa.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wBF) + 0;
            if (this.wYa != null) {
                return fU + e.a.a.a.fW(2, this.wYa.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.wYa != null) {
                return 0;
            }
            throw new b("Not all required fields were included: StatReport");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bou bou = (bou) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bou.wBF = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bet = new bet();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bou.wYa = bet;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

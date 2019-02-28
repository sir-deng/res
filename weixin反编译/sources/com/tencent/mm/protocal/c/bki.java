package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class bki extends a {
    public int vON;
    public bet wTZ;
    public bet wUb;
    public int wUc;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wTZ != null) {
                aVar.fZ(1, this.wTZ.bkL());
                this.wTZ.a(aVar);
            }
            aVar.fX(2, this.vON);
            if (this.wUb != null) {
                aVar.fZ(3, this.wUb.bkL());
                this.wUb.a(aVar);
            }
            aVar.fX(4, this.wUc);
            return 0;
        } else if (i == 1) {
            if (this.wTZ != null) {
                fW = e.a.a.a.fW(1, this.wTZ.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.vON);
            if (this.wUb != null) {
                fW += e.a.a.a.fW(3, this.wUb.bkL());
            }
            return fW + e.a.a.a.fU(4, this.wUc);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bki bki = (bki) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a bet;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bki.wTZ = bet;
                    }
                    return 0;
                case 2:
                    bki.vON = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bki.wUb = bet;
                    }
                    return 0;
                case 4:
                    bki.wUc = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

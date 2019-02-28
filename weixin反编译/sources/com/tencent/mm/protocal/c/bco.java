package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bco extends a {
    public bet wPq;
    public int wPr;
    public LinkedList<bgl> wPs = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wPq == null) {
                throw new b("Not all required fields were included: GroupName");
            }
            if (this.wPq != null) {
                aVar.fZ(1, this.wPq.bkL());
                this.wPq.a(aVar);
            }
            aVar.fX(2, this.wPr);
            aVar.d(3, 8, this.wPs);
            return 0;
        } else if (i == 1) {
            if (this.wPq != null) {
                fW = e.a.a.a.fW(1, this.wPq.bkL()) + 0;
            } else {
                fW = 0;
            }
            return (fW + e.a.a.a.fU(2, this.wPr)) + e.a.a.a.c(3, 8, this.wPs);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wPs.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wPq != null) {
                return 0;
            }
            throw new b("Not all required fields were included: GroupName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bco bco = (bco) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
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
                        bco.wPq = bet;
                    }
                    return 0;
                case 2:
                    bco.wPr = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bgl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        bco.wPs.add(bet);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

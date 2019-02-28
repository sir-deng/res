package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class aab extends a implements bkb {
    public int vQL;
    public int wqq;
    public int wqr;
    public int wqs;
    public LinkedList<bet> wqt = new LinkedList();

    public final int getRet() {
        return this.vQL;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vQL);
            aVar.fX(2, this.wqq);
            aVar.fX(3, this.wqr);
            aVar.fX(4, this.wqs);
            aVar.d(5, 8, this.wqt);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.fU(1, this.vQL) + 0) + e.a.a.a.fU(2, this.wqq)) + e.a.a.a.fU(3, this.wqr)) + e.a.a.a.fU(4, this.wqs)) + e.a.a.a.c(5, 8, this.wqt);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wqt.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                aab aab = (aab) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        aab.vQL = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        aab.wqq = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        aab.wqr = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        aab.wqs = aVar3.AEQ.rz();
                        return 0;
                    case 5:
                        LinkedList JD = aVar3.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a bet = new bet();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                            }
                            aab.wqt.add(bet);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

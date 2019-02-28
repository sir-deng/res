package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ber extends a {
    public bet wfM;
    public bet wzM;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wfM == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.wzM == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.wfM != null) {
                    aVar.fZ(1, this.wfM.bkL());
                    this.wfM.a(aVar);
                }
                if (this.wzM == null) {
                    return 0;
                }
                aVar.fZ(2, this.wzM.bkL());
                this.wzM.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wfM != null) {
                fW = e.a.a.a.fW(1, this.wfM.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wzM != null) {
                fW += e.a.a.a.fW(2, this.wzM.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wfM == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.wzM != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ber ber = (ber) objArr[1];
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
                        ber.wfM = bet;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bet = new bet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, a.a(aVar4))) {
                        }
                        ber.wzM = bet;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

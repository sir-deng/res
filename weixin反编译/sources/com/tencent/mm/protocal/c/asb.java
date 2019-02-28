package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class asb extends a {
    public bet vNv;
    public bet wGm;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNv == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.wGm == null) {
                throw new b("Not all required fields were included: ChatRoomTopic");
            } else {
                if (this.vNv != null) {
                    aVar.fZ(1, this.vNv.bkL());
                    this.vNv.a(aVar);
                }
                if (this.wGm == null) {
                    return 0;
                }
                aVar.fZ(2, this.wGm.bkL());
                this.wGm.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.vNv != null) {
                fW = e.a.a.a.fW(1, this.vNv.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wGm != null) {
                fW += e.a.a.a.fW(2, this.wGm.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vNv == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.wGm != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ChatRoomTopic");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asb asb = (asb) objArr[1];
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
                        asb.vNv = bet;
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
                        asb.wGm = bet;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class abb extends a {
    public int vNU;
    public bet wqN;
    public int wqO;
    public int wqP;
    public int wqQ = 1;
    public int wqR;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wqN == null) {
                throw new b("Not all required fields were included: ChatroomId");
            }
            if (this.wqN != null) {
                aVar.fZ(1, this.wqN.bkL());
                this.wqN.a(aVar);
            }
            aVar.fX(2, this.vNU);
            aVar.fX(3, this.wqO);
            aVar.fX(4, this.wqP);
            aVar.fX(5, this.wqQ);
            aVar.fX(6, this.wqR);
            return 0;
        } else if (i == 1) {
            if (this.wqN != null) {
                fW = e.a.a.a.fW(1, this.wqN.bkL()) + 0;
            } else {
                fW = 0;
            }
            return ((((fW + e.a.a.a.fU(2, this.vNU)) + e.a.a.a.fU(3, this.wqO)) + e.a.a.a.fU(4, this.wqP)) + e.a.a.a.fU(5, this.wqQ)) + e.a.a.a.fU(6, this.wqR);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wqN != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ChatroomId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abb abb = (abb) objArr[1];
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
                        abb.wqN = bet;
                    }
                    return 0;
                case 2:
                    abb.vNU = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    abb.wqO = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    abb.wqP = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    abb.wqQ = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    abb.wqR = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

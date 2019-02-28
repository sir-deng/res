package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class beh extends a {
    public int vnv;
    public int wMK;
    public int wQS;
    public int wQU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wMK);
            aVar.fX(2, this.wQU);
            aVar.fX(3, this.wQS);
            aVar.fX(4, this.vnv);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fU(1, this.wMK) + 0) + e.a.a.a.fU(2, this.wQU)) + e.a.a.a.fU(3, this.wQS)) + e.a.a.a.fU(4, this.vnv);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
                beh beh = (beh) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        beh.wMK = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        beh.wQU = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        beh.wQS = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        beh.vnv = aVar3.AEQ.rz();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

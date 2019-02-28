package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aly extends a {
    public String kyG;
    public int lTO;
    public String vSE;
    public String weS;
    public bet wzM;
    public int wzN;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wzM == null) {
                throw new b("Not all required fields were included: NickName");
            }
            aVar.fX(1, this.lTO);
            if (this.wzM != null) {
                aVar.fZ(2, this.wzM.bkL());
                this.wzM.a(aVar);
            }
            if (this.vSE != null) {
                aVar.g(3, this.vSE);
            }
            if (this.weS != null) {
                aVar.g(4, this.weS);
            }
            if (this.kyG != null) {
                aVar.g(5, this.kyG);
            }
            aVar.fX(6, this.wzN);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.lTO) + 0;
            if (this.wzM != null) {
                fU += e.a.a.a.fW(2, this.wzM.bkL());
            }
            if (this.vSE != null) {
                fU += e.a.a.b.b.a.h(3, this.vSE);
            }
            if (this.weS != null) {
                fU += e.a.a.b.b.a.h(4, this.weS);
            }
            if (this.kyG != null) {
                fU += e.a.a.b.b.a.h(5, this.kyG);
            }
            return fU + e.a.a.a.fU(6, this.wzN);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.wzM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: NickName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aly aly = (aly) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aly.lTO = aVar3.AEQ.rz();
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
                        aly.wzM = bet;
                    }
                    return 0;
                case 3:
                    aly.vSE = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aly.weS = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    aly.kyG = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    aly.wzN = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

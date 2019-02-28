package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aro extends bek {
    public int kzz;
    public int pgR;
    public int vNL;
    public bet vNN;
    public long vNT;
    public int vQL;
    public int wGf;
    public int wGg;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vNN == null) {
                throw new b("Not all required fields were included: ToUserName");
            }
            aVar.fX(1, this.vQL);
            if (this.vNN != null) {
                aVar.fZ(2, this.vNN.bkL());
                this.vNN.a(aVar);
            }
            aVar.fX(3, this.vNL);
            aVar.fX(4, this.wGf);
            aVar.fX(5, this.pgR);
            aVar.fX(6, this.wGg);
            aVar.fX(7, this.kzz);
            aVar.S(8, this.vNT);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vQL) + 0;
            if (this.vNN != null) {
                fU += e.a.a.a.fW(2, this.vNN.bkL());
            }
            return (((((fU + e.a.a.a.fU(3, this.vNL)) + e.a.a.a.fU(4, this.wGf)) + e.a.a.a.fU(5, this.pgR)) + e.a.a.a.fU(6, this.wGg)) + e.a.a.a.fU(7, this.kzz)) + e.a.a.a.R(8, this.vNT);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = com.tencent.mm.bp.a.a(aVar2); fU > 0; fU = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            if (this.vNN != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ToUserName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aro aro = (aro) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aro.vQL = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a bet = new bet();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bet.a(aVar4, bet, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        aro.vNN = bet;
                    }
                    return 0;
                case 3:
                    aro.vNL = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    aro.wGf = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    aro.pgR = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    aro.wGg = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    aro.kzz = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    aro.vNT = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

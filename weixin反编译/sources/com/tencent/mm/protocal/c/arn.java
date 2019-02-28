package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class arn extends a {
    public int kzz;
    public String noL;
    public int pgR;
    public bet vNN;
    public String vNR;
    public int wGf;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNN == null) {
                throw new b("Not all required fields were included: ToUserName");
            }
            if (this.vNN != null) {
                aVar.fZ(1, this.vNN.bkL());
                this.vNN.a(aVar);
            }
            if (this.noL != null) {
                aVar.g(2, this.noL);
            }
            aVar.fX(3, this.kzz);
            aVar.fX(4, this.pgR);
            aVar.fX(5, this.wGf);
            if (this.vNR == null) {
                return 0;
            }
            aVar.g(6, this.vNR);
            return 0;
        } else if (i == 1) {
            if (this.vNN != null) {
                fW = e.a.a.a.fW(1, this.vNN.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.noL != null) {
                fW += e.a.a.b.b.a.h(2, this.noL);
            }
            fW = ((fW + e.a.a.a.fU(3, this.kzz)) + e.a.a.a.fU(4, this.pgR)) + e.a.a.a.fU(5, this.wGf);
            if (this.vNR != null) {
                fW += e.a.a.b.b.a.h(6, this.vNR);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
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
            arn arn = (arn) objArr[1];
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
                        arn.vNN = bet;
                    }
                    return 0;
                case 2:
                    arn.noL = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    arn.kzz = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    arn.pgR = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    arn.wGf = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    arn.vNR = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

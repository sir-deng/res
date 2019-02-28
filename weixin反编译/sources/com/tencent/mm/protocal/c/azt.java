package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class azt extends bea {
    public int kyY;
    public String npW;
    public long wMR;
    public long wMU;
    public int wil;
    public long wim;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.npW == null) {
                throw new b("Not all required fields were included: FromUserName");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.npW != null) {
                aVar.g(2, this.npW);
            }
            aVar.fX(3, this.wil);
            aVar.S(4, this.wim);
            aVar.S(5, this.wMR);
            aVar.S(6, this.wMU);
            aVar.fX(7, this.kyY);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.npW != null) {
                fW += e.a.a.b.b.a.h(2, this.npW);
            }
            return ((((fW + e.a.a.a.fU(3, this.wil)) + e.a.a.a.R(4, this.wim)) + e.a.a.a.R(5, this.wMR)) + e.a.a.a.R(6, this.wMU)) + e.a.a.a.fU(7, this.kyY);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.npW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: FromUserName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azt azt = (azt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        azt.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    azt.npW = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    azt.wil = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    azt.wim = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    azt.wMR = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    azt.wMU = aVar3.AEQ.rA();
                    return 0;
                case 7:
                    azt.kyY = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

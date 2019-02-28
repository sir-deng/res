package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bmg extends bea {
    public String wUA;
    public long wUB;
    public bes wUf;
    public long wVX;
    public int wVY;
    public long wVZ;
    public int wWa;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wUA != null) {
                aVar.g(2, this.wUA);
            }
            aVar.S(3, this.wUB);
            aVar.S(4, this.wVX);
            aVar.fX(5, this.wVY);
            aVar.S(6, this.wVZ);
            if (this.wUf != null) {
                aVar.fZ(7, this.wUf.bkL());
                this.wUf.a(aVar);
            }
            aVar.fX(8, this.wWa);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wUA != null) {
                fW += e.a.a.b.b.a.h(2, this.wUA);
            }
            fW = (((fW + e.a.a.a.R(3, this.wUB)) + e.a.a.a.R(4, this.wVX)) + e.a.a.a.fU(5, this.wVY)) + e.a.a.a.R(6, this.wVZ);
            if (this.wUf != null) {
                fW += e.a.a.a.fW(7, this.wUf.bkL());
            }
            return fW + e.a.a.a.fU(8, this.wWa);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmg bmg = (bmg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bmg.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bmg.wUA = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bmg.wUB = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    bmg.wVX = aVar3.AEQ.rA();
                    return 0;
                case 5:
                    bmg.wVY = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bmg.wVZ = aVar3.AEQ.rA();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bmg.wUf = fhVar;
                    }
                    return 0;
                case 8:
                    bmg.wWa = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

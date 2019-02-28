package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class hy extends bea {
    public int sfa;
    public String vPI;
    public LinkedList<String> vUD = new LinkedList();
    public String vUE;
    public double vUF;
    public double vUG;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vPI != null) {
                aVar.g(2, this.vPI);
            }
            aVar.d(3, 1, this.vUD);
            aVar.fX(4, this.sfa);
            if (this.vUE != null) {
                aVar.g(5, this.vUE);
            }
            aVar.b(6, this.vUF);
            aVar.b(7, this.vUG);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vPI != null) {
                fW += e.a.a.b.b.a.h(2, this.vPI);
            }
            fW = (fW + e.a.a.a.c(3, 1, this.vUD)) + e.a.a.a.fU(4, this.sfa);
            if (this.vUE != null) {
                fW += e.a.a.b.b.a.h(5, this.vUE);
            }
            return (fW + (e.a.a.b.b.a.dX(6) + 8)) + (e.a.a.b.b.a.dX(7) + 8);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vUD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            hy hyVar = (hy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        hyVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    hyVar.vPI = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    hyVar.vUD.add(aVar3.AEQ.readString());
                    return 0;
                case 4:
                    hyVar.sfa = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    hyVar.vUE = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    hyVar.vUF = aVar3.AEQ.readDouble();
                    return 0;
                case 7:
                    hyVar.vUG = aVar3.AEQ.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

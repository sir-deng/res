package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class n extends bea {
    public int scene;
    public String vJI;
    public String vJJ;
    public long vKb;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vJI != null) {
                aVar.g(2, this.vJI);
            }
            aVar.S(3, this.vKb);
            aVar.fX(4, this.scene);
            if (this.vJJ == null) {
                return 0;
            }
            aVar.g(5, this.vJJ);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vJI != null) {
                fW += e.a.a.b.b.a.h(2, this.vJI);
            }
            fW = (fW + e.a.a.a.R(3, this.vKb)) + e.a.a.a.fU(4, this.scene);
            if (this.vJJ != null) {
                fW += e.a.a.b.b.a.h(5, this.vJJ);
            }
            return fW;
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
            n nVar = (n) objArr[1];
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
                        nVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    nVar.vJI = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    nVar.vKb = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    nVar.scene = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    nVar.vJJ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

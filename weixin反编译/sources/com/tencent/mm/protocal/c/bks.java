package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bks extends bea {
    public String wUA;
    public long wUB;
    public String wUC;
    public int wUD;

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
            if (this.wUC != null) {
                aVar.g(4, this.wUC);
            }
            aVar.fX(5, this.wUD);
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
            fW += e.a.a.a.R(3, this.wUB);
            if (this.wUC != null) {
                fW += e.a.a.b.b.a.h(4, this.wUC);
            }
            return fW + e.a.a.a.fU(5, this.wUD);
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
            bks bks = (bks) objArr[1];
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
                        bks.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bks.wUA = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bks.wUB = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    bks.wUC = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bks.wUD = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

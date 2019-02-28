package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bza extends bea {
    public String fEe;
    public int xfY;
    public String xgc;
    public String xgd;
    public String xgj;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.fEe != null) {
                aVar.g(2, this.fEe);
            }
            aVar.fX(3, this.xfY);
            if (this.xgc != null) {
                aVar.g(99, this.xgc);
            }
            if (this.xgd != null) {
                aVar.g(100, this.xgd);
            }
            if (this.xgj == null) {
                return 0;
            }
            aVar.g(101, this.xgj);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.fEe != null) {
                fW += e.a.a.b.b.a.h(2, this.fEe);
            }
            fW += e.a.a.a.fU(3, this.xfY);
            if (this.xgc != null) {
                fW += e.a.a.b.b.a.h(99, this.xgc);
            }
            if (this.xgd != null) {
                fW += e.a.a.b.b.a.h(100, this.xgd);
            }
            if (this.xgj != null) {
                fW += e.a.a.b.b.a.h(101, this.xgj);
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
            bza bza = (bza) objArr[1];
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
                        bza.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bza.fEe = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bza.xfY = aVar3.AEQ.rz();
                    return 0;
                case 99:
                    bza.xgc = aVar3.AEQ.readString();
                    return 0;
                case 100:
                    bza.xgd = aVar3.AEQ.readString();
                    return 0;
                case 101:
                    bza.xgj = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

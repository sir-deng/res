package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class xg extends bea {
    public int pWp;
    public String vUW;
    public String vUX;
    public String vUY;
    public String vUZ;
    public String vVa;
    public String vVb;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vUW != null) {
                aVar.g(2, this.vUW);
            }
            if (this.vUX != null) {
                aVar.g(3, this.vUX);
            }
            if (this.vUY != null) {
                aVar.g(4, this.vUY);
            }
            if (this.vUZ != null) {
                aVar.g(5, this.vUZ);
            }
            if (this.vVa != null) {
                aVar.g(6, this.vVa);
            }
            aVar.fX(7, this.pWp);
            if (this.vVb == null) {
                return 0;
            }
            aVar.g(8, this.vVb);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vUW != null) {
                fW += e.a.a.b.b.a.h(2, this.vUW);
            }
            if (this.vUX != null) {
                fW += e.a.a.b.b.a.h(3, this.vUX);
            }
            if (this.vUY != null) {
                fW += e.a.a.b.b.a.h(4, this.vUY);
            }
            if (this.vUZ != null) {
                fW += e.a.a.b.b.a.h(5, this.vUZ);
            }
            if (this.vVa != null) {
                fW += e.a.a.b.b.a.h(6, this.vVa);
            }
            fW += e.a.a.a.fU(7, this.pWp);
            if (this.vVb != null) {
                fW += e.a.a.b.b.a.h(8, this.vVb);
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
            xg xgVar = (xg) objArr[1];
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
                        xgVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    xgVar.vUW = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    xgVar.vUX = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    xgVar.vUY = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    xgVar.vUZ = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    xgVar.vVa = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    xgVar.pWp = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    xgVar.vVb = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class uk extends bea {
    public double latitude;
    public int lon;
    public double longitude;
    public int ohq;
    public int plL;
    public int wje;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.lon);
            aVar.fX(3, this.plL);
            aVar.fX(4, this.ohq);
            aVar.fX(5, this.wje);
            aVar.b(6, this.latitude);
            aVar.b(7, this.longitude);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            return (((((fW + e.a.a.a.fU(2, this.lon)) + e.a.a.a.fU(3, this.plL)) + e.a.a.a.fU(4, this.ohq)) + e.a.a.a.fU(5, this.wje)) + (e.a.a.b.b.a.dX(6) + 8)) + (e.a.a.b.b.a.dX(7) + 8);
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
            uk ukVar = (uk) objArr[1];
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
                        ukVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    ukVar.lon = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    ukVar.plL = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    ukVar.ohq = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    ukVar.wje = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    ukVar.latitude = aVar3.AEQ.readDouble();
                    return 0;
                case 7:
                    ukVar.longitude = aVar3.AEQ.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

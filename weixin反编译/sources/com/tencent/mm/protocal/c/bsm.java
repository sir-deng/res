package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bsm extends bea {
    public double altitude;
    public int bjj;
    public double latitude;
    public double longitude;
    public double xam;
    public double xan;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.b(2, this.latitude);
            aVar.b(3, this.longitude);
            aVar.b(4, this.altitude);
            aVar.b(5, this.xam);
            aVar.b(6, this.xan);
            aVar.fX(7, this.bjj);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            return (((((fW + (e.a.a.b.b.a.dX(2) + 8)) + (e.a.a.b.b.a.dX(3) + 8)) + (e.a.a.b.b.a.dX(4) + 8)) + (e.a.a.b.b.a.dX(5) + 8)) + (e.a.a.b.b.a.dX(6) + 8)) + e.a.a.a.fU(7, this.bjj);
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
            bsm bsm = (bsm) objArr[1];
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
                        bsm.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bsm.latitude = aVar3.AEQ.readDouble();
                    return 0;
                case 3:
                    bsm.longitude = aVar3.AEQ.readDouble();
                    return 0;
                case 4:
                    bsm.altitude = aVar3.AEQ.readDouble();
                    return 0;
                case 5:
                    bsm.xam = aVar3.AEQ.readDouble();
                    return 0;
                case 6:
                    bsm.xan = aVar3.AEQ.readDouble();
                    return 0;
                case 7:
                    bsm.bjj = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

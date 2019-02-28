package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bdo extends bea {
    public String fHP;
    public String kPy;
    public double latitude;
    public double longitude;
    public int wQe;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.b(2, this.longitude);
            aVar.b(3, this.latitude);
            aVar.fX(4, this.wQe);
            if (this.kPy != null) {
                aVar.g(5, this.kPy);
            }
            if (this.fHP == null) {
                return 0;
            }
            aVar.g(6, this.fHP);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((fW + (e.a.a.b.b.a.dX(2) + 8)) + (e.a.a.b.b.a.dX(3) + 8)) + e.a.a.a.fU(4, this.wQe);
            if (this.kPy != null) {
                fW += e.a.a.b.b.a.h(5, this.kPy);
            }
            if (this.fHP != null) {
                fW += e.a.a.b.b.a.h(6, this.fHP);
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
            bdo bdo = (bdo) objArr[1];
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
                        bdo.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bdo.longitude = aVar3.AEQ.readDouble();
                    return 0;
                case 3:
                    bdo.latitude = aVar3.AEQ.readDouble();
                    return 0;
                case 4:
                    bdo.wQe = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bdo.kPy = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    bdo.fHP = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

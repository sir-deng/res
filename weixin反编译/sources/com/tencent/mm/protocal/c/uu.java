package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class uu extends bea {
    public int vKI;
    public float vXx;
    public float vXy;
    public String wgO;
    public String wju;
    public int wjv;
    public String wjw;
    public String wjx;
    public int wjy;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.vKI);
            if (this.wju != null) {
                aVar.g(3, this.wju);
            }
            aVar.m(4, this.vXx);
            aVar.m(5, this.vXy);
            aVar.fX(6, this.wjv);
            if (this.wjw != null) {
                aVar.g(7, this.wjw);
            }
            if (this.wjx != null) {
                aVar.g(8, this.wjx);
            }
            aVar.fX(9, this.wjy);
            if (this.wgO == null) {
                return 0;
            }
            aVar.g(10, this.wgO);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW += e.a.a.a.fU(2, this.vKI);
            if (this.wju != null) {
                fW += e.a.a.b.b.a.h(3, this.wju);
            }
            fW = ((fW + (e.a.a.b.b.a.dX(4) + 4)) + (e.a.a.b.b.a.dX(5) + 4)) + e.a.a.a.fU(6, this.wjv);
            if (this.wjw != null) {
                fW += e.a.a.b.b.a.h(7, this.wjw);
            }
            if (this.wjx != null) {
                fW += e.a.a.b.b.a.h(8, this.wjx);
            }
            fW += e.a.a.a.fU(9, this.wjy);
            if (this.wgO != null) {
                fW += e.a.a.b.b.a.h(10, this.wgO);
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
            uu uuVar = (uu) objArr[1];
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
                        uuVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    uuVar.vKI = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    uuVar.wju = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    uuVar.vXx = aVar3.AEQ.readFloat();
                    return 0;
                case 5:
                    uuVar.vXy = aVar3.AEQ.readFloat();
                    return 0;
                case 6:
                    uuVar.wjv = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    uuVar.wjw = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    uuVar.wjx = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    uuVar.wjy = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    uuVar.wgO = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

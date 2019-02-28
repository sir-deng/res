package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ayz extends bea {
    public String nqi;
    public int pgW;
    public String vPI;
    public String wMx;
    public String wMy;
    public int wMz;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vPI != null) {
                aVar.g(2, this.vPI);
            }
            if (this.wMx != null) {
                aVar.g(3, this.wMx);
            }
            if (this.wMy != null) {
                aVar.g(4, this.wMy);
            }
            aVar.fX(5, this.pgW);
            if (this.nqi != null) {
                aVar.g(7, this.nqi);
            }
            aVar.fX(8, this.wMz);
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
            if (this.wMx != null) {
                fW += e.a.a.b.b.a.h(3, this.wMx);
            }
            if (this.wMy != null) {
                fW += e.a.a.b.b.a.h(4, this.wMy);
            }
            fW += e.a.a.a.fU(5, this.pgW);
            if (this.nqi != null) {
                fW += e.a.a.b.b.a.h(7, this.nqi);
            }
            return fW + e.a.a.a.fU(8, this.wMz);
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
            ayz ayz = (ayz) objArr[1];
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
                        ayz.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    ayz.vPI = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ayz.wMx = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    ayz.wMy = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ayz.pgW = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    ayz.nqi = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    ayz.wMz = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

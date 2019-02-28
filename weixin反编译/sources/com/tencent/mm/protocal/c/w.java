package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class w extends bea {
    public int asN;
    public int offset;
    public int type;
    public String vKw;
    public int vKx;
    public int vKy;
    public String vKz;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.fX(2, this.asN);
            aVar.fX(3, this.offset);
            aVar.fX(4, this.type);
            if (this.vKw != null) {
                aVar.g(5, this.vKw);
            }
            aVar.fX(6, this.vKx);
            aVar.fX(7, this.vKy);
            if (this.vKz == null) {
                return 0;
            }
            aVar.g(8, this.vKz);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((fW + e.a.a.a.fU(2, this.asN)) + e.a.a.a.fU(3, this.offset)) + e.a.a.a.fU(4, this.type);
            if (this.vKw != null) {
                fW += e.a.a.b.b.a.h(5, this.vKw);
            }
            fW = (fW + e.a.a.a.fU(6, this.vKx)) + e.a.a.a.fU(7, this.vKy);
            if (this.vKz != null) {
                fW += e.a.a.b.b.a.h(8, this.vKz);
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
            w wVar = (w) objArr[1];
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
                        wVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    wVar.asN = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    wVar.offset = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    wVar.type = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    wVar.vKw = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    wVar.vKx = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    wVar.vKy = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    wVar.vKz = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

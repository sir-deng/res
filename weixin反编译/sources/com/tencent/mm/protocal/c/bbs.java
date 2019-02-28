package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bbs extends bea {
    public int vKI;
    public float vXx;
    public float vXy;
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
            aVar.m(3, this.vXx);
            aVar.m(4, this.vXy);
            aVar.fX(5, this.wjv);
            if (this.wjw != null) {
                aVar.g(6, this.wjw);
            }
            if (this.wjx != null) {
                aVar.g(7, this.wjx);
            }
            aVar.fX(8, this.wjy);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (((fW + e.a.a.a.fU(2, this.vKI)) + (e.a.a.b.b.a.dX(3) + 4)) + (e.a.a.b.b.a.dX(4) + 4)) + e.a.a.a.fU(5, this.wjv);
            if (this.wjw != null) {
                fW += e.a.a.b.b.a.h(6, this.wjw);
            }
            if (this.wjx != null) {
                fW += e.a.a.b.b.a.h(7, this.wjx);
            }
            return fW + e.a.a.a.fU(8, this.wjy);
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
            bbs bbs = (bbs) objArr[1];
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
                        bbs.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bbs.vKI = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    bbs.vXx = aVar3.AEQ.readFloat();
                    return 0;
                case 4:
                    bbs.vXy = aVar3.AEQ.readFloat();
                    return 0;
                case 5:
                    bbs.wjv = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bbs.wjw = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bbs.wjx = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    bbs.wjy = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

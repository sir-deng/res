package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class apa extends bea {
    public String hKn;
    public int vKI;
    public float vXx;
    public float vXy;
    public int wCH;
    public int wCI;
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
            if (this.hKn != null) {
                aVar.g(9, this.hKn);
            }
            aVar.fX(10, this.wCH);
            aVar.fX(11, this.wCI);
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
            fW += e.a.a.a.fU(8, this.wjy);
            if (this.hKn != null) {
                fW += e.a.a.b.b.a.h(9, this.hKn);
            }
            return (fW + e.a.a.a.fU(10, this.wCH)) + e.a.a.a.fU(11, this.wCI);
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
            apa apa = (apa) objArr[1];
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
                        apa.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    apa.vKI = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    apa.vXx = aVar3.AEQ.readFloat();
                    return 0;
                case 4:
                    apa.vXy = aVar3.AEQ.readFloat();
                    return 0;
                case 5:
                    apa.wjv = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    apa.wjw = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    apa.wjx = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    apa.wjy = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    apa.hKn = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    apa.wCH = aVar3.AEQ.rz();
                    return 0;
                case 11:
                    apa.wCI = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

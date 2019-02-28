package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class adu extends bea {
    public int Height;
    public int Width;
    public String lTZ;
    public float vXx;
    public float vXy;
    public int wth;
    public int wti;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.m(2, this.vXx);
            aVar.m(3, this.vXy);
            aVar.fX(4, this.Width);
            aVar.fX(5, this.Height);
            if (this.lTZ != null) {
                aVar.g(6, this.lTZ);
            }
            aVar.fX(7, this.wth);
            aVar.fX(8, this.wti);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (((fW + (e.a.a.b.b.a.dX(2) + 4)) + (e.a.a.b.b.a.dX(3) + 4)) + e.a.a.a.fU(4, this.Width)) + e.a.a.a.fU(5, this.Height);
            if (this.lTZ != null) {
                fW += e.a.a.b.b.a.h(6, this.lTZ);
            }
            return (fW + e.a.a.a.fU(7, this.wth)) + e.a.a.a.fU(8, this.wti);
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
            adu adu = (adu) objArr[1];
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
                        adu.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    adu.vXx = aVar3.AEQ.readFloat();
                    return 0;
                case 3:
                    adu.vXy = aVar3.AEQ.readFloat();
                    return 0;
                case 4:
                    adu.Width = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    adu.Height = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    adu.lTZ = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    adu.wth = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    adu.wti = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

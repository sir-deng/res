package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ayx extends bek {
    public String vXS;
    public int vXT;
    public String vXU;
    public LinkedList<tr> wMu = new LinkedList();
    public LinkedList<at> wMv = new LinkedList();
    public int wMw;
    public int wsH;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRa != null) {
                aVar.fZ(1, this.wRa.bkL());
                this.wRa.a(aVar);
            }
            aVar.fX(2, this.wsH);
            aVar.d(3, 8, this.wMu);
            if (this.vXS != null) {
                aVar.g(4, this.vXS);
            }
            aVar.fX(5, this.vXT);
            if (this.vXU != null) {
                aVar.g(6, this.vXU);
            }
            aVar.d(7, 8, this.wMv);
            aVar.fX(8, this.wMw);
            return 0;
        } else if (i == 1) {
            if (this.wRa != null) {
                fW = e.a.a.a.fW(1, this.wRa.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = (fW + e.a.a.a.fU(2, this.wsH)) + e.a.a.a.c(3, 8, this.wMu);
            if (this.vXS != null) {
                fW += e.a.a.b.b.a.h(4, this.vXS);
            }
            fW += e.a.a.a.fU(5, this.vXT);
            if (this.vXU != null) {
                fW += e.a.a.b.b.a.h(6, this.vXU);
            }
            return (fW + e.a.a.a.c(7, 8, this.wMv)) + e.a.a.a.fU(8, this.wMw);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wMu.clear();
            this.wMv.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            ayx ayx = (ayx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            com.tencent.mm.bp.a fiVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ayx.wRa = fiVar;
                    }
                    return 0;
                case 2:
                    ayx.wsH = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new tr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ayx.wMu.add(fiVar);
                    }
                    return 0;
                case 4:
                    ayx.vXS = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    ayx.vXT = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    ayx.vXU = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fiVar = new at();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.a(aVar4, fiVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        ayx.wMv.add(fiVar);
                    }
                    return 0;
                case 8:
                    ayx.wMw = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class tg extends bea {
    public String nlV;
    public int pWh;
    public av vXW;
    public String wir;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wir != null) {
                aVar.g(2, this.wir);
            }
            if (this.nlV != null) {
                aVar.g(3, this.nlV);
            }
            aVar.fX(4, this.pWh);
            if (this.vXW == null) {
                return 0;
            }
            aVar.fZ(5, this.vXW.bkL());
            this.vXW.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wir != null) {
                fW += e.a.a.b.b.a.h(2, this.wir);
            }
            if (this.nlV != null) {
                fW += e.a.a.b.b.a.h(3, this.nlV);
            }
            fW += e.a.a.a.fU(4, this.pWh);
            if (this.vXW != null) {
                fW += e.a.a.a.fW(5, this.vXW.bkL());
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
            tg tgVar = (tg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        tgVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    tgVar.wir = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    tgVar.nlV = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    tgVar.pWh = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new av();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        tgVar.vXW = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class lu extends bea {
    public String fxT;
    public int oeK;
    public String vOh;
    public String wbo;
    public String wbp;
    public String wbr;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.fxT != null) {
                aVar.g(2, this.fxT);
            }
            if (this.wbr != null) {
                aVar.g(3, this.wbr);
            }
            if (this.vOh != null) {
                aVar.g(4, this.vOh);
            }
            aVar.fX(5, this.oeK);
            if (this.wbp != null) {
                aVar.g(6, this.wbp);
            }
            if (this.wbo == null) {
                return 0;
            }
            aVar.g(7, this.wbo);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.fxT != null) {
                fW += e.a.a.b.b.a.h(2, this.fxT);
            }
            if (this.wbr != null) {
                fW += e.a.a.b.b.a.h(3, this.wbr);
            }
            if (this.vOh != null) {
                fW += e.a.a.b.b.a.h(4, this.vOh);
            }
            fW += e.a.a.a.fU(5, this.oeK);
            if (this.wbp != null) {
                fW += e.a.a.b.b.a.h(6, this.wbp);
            }
            if (this.wbo != null) {
                fW += e.a.a.b.b.a.h(7, this.wbo);
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
            lu luVar = (lu) objArr[1];
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
                        luVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    luVar.fxT = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    luVar.wbr = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    luVar.vOh = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    luVar.oeK = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    luVar.wbp = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    luVar.wbo = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

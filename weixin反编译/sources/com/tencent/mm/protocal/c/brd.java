package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class brd extends bea {
    public int sfa;
    public bes vSZ;
    public String wZs;
    public String wZt;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wZs != null) {
                aVar.g(2, this.wZs);
            }
            if (this.wZt != null) {
                aVar.g(3, this.wZt);
            }
            aVar.fX(4, this.sfa);
            if (this.vSZ == null) {
                return 0;
            }
            aVar.fZ(5, this.vSZ.bkL());
            this.vSZ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wZs != null) {
                fW += e.a.a.b.b.a.h(2, this.wZs);
            }
            if (this.wZt != null) {
                fW += e.a.a.b.b.a.h(3, this.wZt);
            }
            fW += e.a.a.a.fU(4, this.sfa);
            if (this.vSZ != null) {
                fW += e.a.a.a.fW(5, this.vSZ.bkL());
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
            brd brd = (brd) objArr[1];
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
                        brd.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    brd.wZs = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    brd.wZt = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    brd.sfa = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        brd.vSZ = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

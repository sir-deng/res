package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bug extends bea {
    public bes vSZ;
    public int wPJ;
    public int wPL;
    public String wwk;
    public bun xbO;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xbO == null) {
                throw new b("Not all required fields were included: Piece");
            } else if (this.vSZ == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.xbO != null) {
                    aVar.fZ(2, this.xbO.bkL());
                    this.xbO.a(aVar);
                }
                aVar.fX(3, this.wPJ);
                aVar.fX(4, this.wPL);
                if (this.wwk != null) {
                    aVar.g(5, this.wwk);
                }
                if (this.vSZ == null) {
                    return 0;
                }
                aVar.fZ(6, this.vSZ.bkL());
                this.vSZ.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.xbO != null) {
                fW += e.a.a.a.fW(2, this.xbO.bkL());
            }
            fW = (fW + e.a.a.a.fU(3, this.wPJ)) + e.a.a.a.fU(4, this.wPL);
            if (this.wwk != null) {
                fW += e.a.a.b.b.a.h(5, this.wwk);
            }
            if (this.vSZ != null) {
                fW += e.a.a.a.fW(6, this.vSZ.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.xbO == null) {
                throw new b("Not all required fields were included: Piece");
            } else if (this.vSZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RandomEncryKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bug bug = (bug) objArr[1];
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
                        bug.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bun();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bug.xbO = fhVar;
                    }
                    return 0;
                case 3:
                    bug.wPJ = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bug.wPL = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    bug.wwk = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bug.vSZ = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

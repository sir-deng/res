package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bct extends bea {
    public int kzz;
    public int nnd;
    public bpq wPA;
    public bte wPz;
    public String wiv;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wPz == null) {
                throw new b("Not all required fields were included: UserPosition");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wiv != null) {
                aVar.g(2, this.wiv);
            }
            aVar.fX(3, this.kzz);
            if (this.wPz != null) {
                aVar.fZ(4, this.wPz.bkL());
                this.wPz.a(aVar);
            }
            aVar.fX(5, this.nnd);
            if (this.wPA == null) {
                return 0;
            }
            aVar.fZ(6, this.wPA.bkL());
            this.wPA.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wiv != null) {
                fW += e.a.a.b.b.a.h(2, this.wiv);
            }
            fW += e.a.a.a.fU(3, this.kzz);
            if (this.wPz != null) {
                fW += e.a.a.a.fW(4, this.wPz.bkL());
            }
            fW += e.a.a.a.fU(5, this.nnd);
            if (this.wPA != null) {
                fW += e.a.a.a.fW(6, this.wPA.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wPz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserPosition");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bct bct = (bct) objArr[1];
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
                        bct.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bct.wiv = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bct.kzz = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bte();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bct.wPz = fhVar;
                    }
                    return 0;
                case 5:
                    bct.nnd = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bpq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bct.wPA = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adm extends bea {
    public String vWE;
    public String vXS;
    public ce wsF;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wsF == null) {
                throw new b("Not all required fields were included: Address");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vWE != null) {
                aVar.g(2, this.vWE);
            }
            if (this.vXS != null) {
                aVar.g(3, this.vXS);
            }
            if (this.wsF == null) {
                return 0;
            }
            aVar.fZ(4, this.wsF.bkL());
            this.wsF.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vWE != null) {
                fW += e.a.a.b.b.a.h(2, this.vWE);
            }
            if (this.vXS != null) {
                fW += e.a.a.b.b.a.h(3, this.vXS);
            }
            if (this.wsF != null) {
                fW += e.a.a.a.fW(4, this.wsF.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wsF != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Address");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adm adm = (adm) objArr[1];
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
                        adm.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    adm.vWE = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    adm.vXS = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new ce();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        adm.wsF = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

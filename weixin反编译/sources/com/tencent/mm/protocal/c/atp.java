package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class atp extends bea {
    public String kyG;
    public String lTZ;
    public bes wIa;
    public bes wIb;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIa == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.wIb == null) {
                throw new b("Not all required fields were included: MaxSynckey");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.kyG != null) {
                    aVar.g(2, this.kyG);
                }
                if (this.wIa != null) {
                    aVar.fZ(3, this.wIa.bkL());
                    this.wIa.a(aVar);
                }
                if (this.wIb != null) {
                    aVar.fZ(4, this.wIb.bkL());
                    this.wIb.a(aVar);
                }
                if (this.lTZ == null) {
                    return 0;
                }
                aVar.g(5, this.lTZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.kyG != null) {
                fW += e.a.a.b.b.a.h(2, this.kyG);
            }
            if (this.wIa != null) {
                fW += e.a.a.a.fW(3, this.wIa.bkL());
            }
            if (this.wIb != null) {
                fW += e.a.a.a.fW(4, this.wIb.bkL());
            }
            if (this.lTZ != null) {
                fW += e.a.a.b.b.a.h(5, this.lTZ);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wIa == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.wIb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MaxSynckey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atp atp = (atp) objArr[1];
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
                        atp.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    atp.kyG = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        atp.wIa = fhVar;
                    }
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bes();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        atp.wIb = fhVar;
                    }
                    return 0;
                case 5:
                    atp.lTZ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

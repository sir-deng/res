package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class akg extends bea {
    public ake vSI;
    public int wyf;
    public bes wyg;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vSI == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.wyg == null) {
                throw new b("Not all required fields were included: AuthBuffer");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.vSI != null) {
                    aVar.fZ(2, this.vSI.bkL());
                    this.vSI.a(aVar);
                }
                aVar.fX(3, this.wyf);
                if (this.wyg == null) {
                    return 0;
                }
                aVar.fZ(4, this.wyg.bkL());
                this.wyg.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vSI != null) {
                fW += e.a.a.a.fW(2, this.vSI.bkL());
            }
            fW += e.a.a.a.fU(3, this.wyf);
            if (this.wyg != null) {
                fW += e.a.a.a.fW(4, this.wyg.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vSI == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.wyg != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AuthBuffer");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            akg akg = (akg) objArr[1];
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
                        akg.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new ake();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        akg.vSI = fhVar;
                    }
                    return 0;
                case 3:
                    akg.wyf = aVar3.AEQ.rz();
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
                        akg.wyg = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class pe extends bea {
    public String nlV;
    public String vQr;
    public String weM;
    public String weN;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.weM == null) {
                throw new b("Not all required fields were included: DeviceId");
            } else if (this.vQr == null) {
                throw new b("Not all required fields were included: DeviceType");
            } else if (this.weN == null) {
                throw new b("Not all required fields were included: ClientInfo");
            } else if (this.nlV == null) {
                throw new b("Not all required fields were included: AppId");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.weM != null) {
                    aVar.g(2, this.weM);
                }
                if (this.vQr != null) {
                    aVar.g(3, this.vQr);
                }
                if (this.weN != null) {
                    aVar.g(4, this.weN);
                }
                if (this.nlV == null) {
                    return 0;
                }
                aVar.g(5, this.nlV);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.weM != null) {
                fW += e.a.a.b.b.a.h(2, this.weM);
            }
            if (this.vQr != null) {
                fW += e.a.a.b.b.a.h(3, this.vQr);
            }
            if (this.weN != null) {
                fW += e.a.a.b.b.a.h(4, this.weN);
            }
            if (this.nlV != null) {
                fW += e.a.a.b.b.a.h(5, this.nlV);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.weM == null) {
                throw new b("Not all required fields were included: DeviceId");
            } else if (this.vQr == null) {
                throw new b("Not all required fields were included: DeviceType");
            } else if (this.weN == null) {
                throw new b("Not all required fields were included: ClientInfo");
            } else if (this.nlV != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AppId");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            pe peVar = (pe) objArr[1];
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
                        peVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    peVar.weM = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    peVar.vQr = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    peVar.weN = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    peVar.nlV = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

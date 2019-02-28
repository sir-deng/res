package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bqv extends bea {
    public String devicetype;
    public String ggL;
    public String pck;
    public int wZr;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.devicetype == null) {
                throw new b("Not all required fields were included: devicetype");
            } else if (this.pck == null) {
                throw new b("Not all required fields were included: deviceid");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.devicetype != null) {
                    aVar.g(2, this.devicetype);
                }
                if (this.pck != null) {
                    aVar.g(3, this.pck);
                }
                if (this.ggL != null) {
                    aVar.g(4, this.ggL);
                }
                aVar.fX(5, this.wZr);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.devicetype != null) {
                fW += e.a.a.b.b.a.h(2, this.devicetype);
            }
            if (this.pck != null) {
                fW += e.a.a.b.b.a.h(3, this.pck);
            }
            if (this.ggL != null) {
                fW += e.a.a.b.b.a.h(4, this.ggL);
            }
            return fW + e.a.a.a.fU(5, this.wZr);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.devicetype == null) {
                throw new b("Not all required fields were included: devicetype");
            } else if (this.pck != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: deviceid");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqv bqv = (bqv) objArr[1];
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
                        bqv.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bqv.devicetype = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bqv.pck = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bqv.ggL = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bqv.wZr = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

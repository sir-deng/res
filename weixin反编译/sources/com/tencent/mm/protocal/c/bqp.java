package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bqp extends bea {
    public String vUb;
    public String vUh;
    public hs wZo;
    public hs wZp;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vUh == null) {
                throw new b("Not all required fields were included: brand_user_name");
            } else if (this.vUb == null) {
                throw new b("Not all required fields were included: bizchat_id");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.vUh != null) {
                    aVar.g(2, this.vUh);
                }
                if (this.vUb != null) {
                    aVar.g(3, this.vUb);
                }
                if (this.wZo != null) {
                    aVar.fZ(4, this.wZo.bkL());
                    this.wZo.a(aVar);
                }
                if (this.wZp == null) {
                    return 0;
                }
                aVar.fZ(5, this.wZp.bkL());
                this.wZp.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vUh != null) {
                fW += e.a.a.b.b.a.h(2, this.vUh);
            }
            if (this.vUb != null) {
                fW += e.a.a.b.b.a.h(3, this.vUb);
            }
            if (this.wZo != null) {
                fW += e.a.a.a.fW(4, this.wZo.bkL());
            }
            if (this.wZp != null) {
                fW += e.a.a.a.fW(5, this.wZp.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vUh == null) {
                throw new b("Not all required fields were included: brand_user_name");
            } else if (this.vUb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bizchat_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqp bqp = (bqp) objArr[1];
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
                        bqp.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bqp.vUh = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bqp.vUb = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new hs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bqp.wZo = fhVar;
                    }
                    return 0;
                case 5:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new hs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bqp.wZp = fhVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

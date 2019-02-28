package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class zy extends bea {
    public String data;
    public int pK;
    public String wfm;

    protected final int a(int i, Object... objArr) {
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wfm == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.data == null) {
                throw new b("Not all required fields were included: data");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.wfm != null) {
                    aVar.g(2, this.wfm);
                }
                aVar.fX(3, this.pK);
                if (this.data == null) {
                    return 0;
                }
                aVar.g(4, this.data);
                return 0;
            }
        } else if (i == 1) {
            int fW;
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wfm != null) {
                fW += e.a.a.b.b.a.h(2, this.wfm);
            }
            fW += e.a.a.a.fU(3, this.pK);
            if (this.data != null) {
                fW += e.a.a.b.b.a.h(4, this.data);
            }
            return fW;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (int a = com.tencent.mm.bp.a.a(aVar2); a > 0; a = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cKx();
                }
            }
            if (this.wfm == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (bArr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zy zyVar = (zy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        zyVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    zyVar.wfm = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    zyVar.pK = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    zyVar.data = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

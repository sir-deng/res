package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ls extends bea {
    public int oeK;
    public String vOg;
    public String vOh;
    public String wbo;
    public String wbp;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vOg == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.vOh == null) {
                throw new b("Not all required fields were included: trans_id");
            } else if (this.wbp == null) {
                throw new b("Not all required fields were included: receiver_open_id");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.vOg != null) {
                    aVar.g(2, this.vOg);
                }
                if (this.vOh != null) {
                    aVar.g(3, this.vOh);
                }
                if (this.wbo != null) {
                    aVar.g(4, this.wbo);
                }
                if (this.wbp != null) {
                    aVar.g(5, this.wbp);
                }
                aVar.fX(6, this.oeK);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vOg != null) {
                fW += e.a.a.b.b.a.h(2, this.vOg);
            }
            if (this.vOh != null) {
                fW += e.a.a.b.b.a.h(3, this.vOh);
            }
            if (this.wbo != null) {
                fW += e.a.a.b.b.a.h(4, this.wbo);
            }
            if (this.wbp != null) {
                fW += e.a.a.b.b.a.h(5, this.wbp);
            }
            return fW + e.a.a.a.fU(6, this.oeK);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vOg == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.vOh == null) {
                throw new b("Not all required fields were included: trans_id");
            } else if (this.wbp != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: receiver_open_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ls lsVar = (ls) objArr[1];
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
                        lsVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    lsVar.vOg = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    lsVar.vOh = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    lsVar.wbo = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    lsVar.wbp = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    lsVar.oeK = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

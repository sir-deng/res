package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class pm extends bea {
    public String wfm;
    public String wfn;
    public String wfo;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wfm == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.wfn == null) {
                throw new b("Not all required fields were included: qychat_type");
            } else if (this.wfo == null) {
                throw new b("Not all required fields were included: qychat_id");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.wfm != null) {
                    aVar.g(2, this.wfm);
                }
                if (this.wfn != null) {
                    aVar.g(3, this.wfn);
                }
                if (this.wfo == null) {
                    return 0;
                }
                aVar.g(4, this.wfo);
                return 0;
            }
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wfm != null) {
                fW += e.a.a.b.b.a.h(2, this.wfm);
            }
            if (this.wfn != null) {
                fW += e.a.a.b.b.a.h(3, this.wfn);
            }
            if (this.wfo != null) {
                fW += e.a.a.b.b.a.h(4, this.wfo);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wfm == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.wfn == null) {
                throw new b("Not all required fields were included: qychat_type");
            } else if (this.wfo != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: qychat_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            pm pmVar = (pm) objArr[1];
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
                        pmVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    pmVar.wfm = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    pmVar.wfn = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    pmVar.wfo = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

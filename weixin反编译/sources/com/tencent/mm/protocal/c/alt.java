package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class alt extends bea {
    public String wfm;
    public String wzG;
    public LinkedList<String> wzH = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wfm == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.wzG == null) {
                throw new b("Not all required fields were included: bizchat_name");
            } else {
                if (this.wQE != null) {
                    aVar.fZ(1, this.wQE.bkL());
                    this.wQE.a(aVar);
                }
                if (this.wfm != null) {
                    aVar.g(2, this.wfm);
                }
                if (this.wzG != null) {
                    aVar.g(3, this.wzG);
                }
                aVar.d(4, 1, this.wzH);
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
            if (this.wzG != null) {
                fW += e.a.a.b.b.a.h(3, this.wzG);
            }
            return fW + e.a.a.a.c(4, 1, this.wzH);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wzH.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wfm == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.wzG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bizchat_name");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            alt alt = (alt) objArr[1];
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
                        alt.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    alt.wfm = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    alt.wzG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    alt.wzH.add(aVar3.AEQ.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

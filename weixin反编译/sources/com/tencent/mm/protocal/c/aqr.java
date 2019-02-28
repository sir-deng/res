package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aqr extends a {
    public aqs wEj;
    public aqq wEk;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wEj == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.wEk == null) {
                throw new b("Not all required fields were included: AesReqData");
            } else {
                if (this.wEj != null) {
                    aVar.fZ(1, this.wEj.bkL());
                    this.wEj.a(aVar);
                }
                if (this.wEk == null) {
                    return 0;
                }
                aVar.fZ(2, this.wEk.bkL());
                this.wEk.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wEj != null) {
                fW = e.a.a.a.fW(1, this.wEj.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wEk != null) {
                fW += e.a.a.a.fW(2, this.wEk.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wEj == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.wEk != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AesReqData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqr aqr = (aqr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a aqs;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aqs = new aqs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqs.a(aVar4, aqs, a.a(aVar4))) {
                        }
                        aqr.wEj = aqs;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        aqs = new aqq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqs.a(aVar4, aqs, a.a(aVar4))) {
                        }
                        aqr.wEk = aqs;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

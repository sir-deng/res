package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ek extends a {
    public el vQu;
    public ei vQv;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQu == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.vQv == null) {
                throw new b("Not all required fields were included: AesReqData");
            } else {
                if (this.vQu != null) {
                    aVar.fZ(1, this.vQu.bkL());
                    this.vQu.a(aVar);
                }
                if (this.vQv == null) {
                    return 0;
                }
                aVar.fZ(2, this.vQv.bkL());
                this.vQv.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.vQu != null) {
                fW = e.a.a.a.fW(1, this.vQu.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vQv != null) {
                fW += e.a.a.a.fW(2, this.vQv.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.vQu == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.vQv != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AesReqData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ek ekVar = (ek) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a elVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        elVar = new el();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = elVar.a(aVar4, elVar, a.a(aVar4))) {
                        }
                        ekVar.vQu = elVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        elVar = new ei();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = elVar.a(aVar4, elVar, a.a(aVar4))) {
                        }
                        ekVar.vQv = elVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

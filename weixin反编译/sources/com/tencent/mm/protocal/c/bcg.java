package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bcg extends bek {
    public bbz wOW;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wOW == null) {
                throw new b("Not all required fields were included: rcptinfolist");
            } else if (this.wRa == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else {
                if (this.wOW != null) {
                    aVar.fZ(1, this.wOW.bkL());
                    this.wOW.a(aVar);
                }
                if (this.wRa == null) {
                    return 0;
                }
                aVar.fZ(2, this.wRa.bkL());
                this.wRa.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wOW != null) {
                fW = e.a.a.a.fW(1, this.wOW.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wRa != null) {
                fW += e.a.a.a.fW(2, this.wRa.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.wOW == null) {
                throw new b("Not all required fields were included: rcptinfolist");
            } else if (this.wRa != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BaseResponse");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bcg bcg = (bcg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a bbz;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bbz = new bbz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbz.a(aVar4, bbz, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bcg.wOW = bbz;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        bbz = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbz.a(aVar4, bbz, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bcg.wRa = bbz;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

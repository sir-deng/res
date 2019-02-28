package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class l extends j {
    public b kyn;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.lUt == null) {
                throw new e.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.lUt != null) {
                aVar.fZ(1, this.lUt.bkL());
                this.lUt.a(aVar);
            }
            if (this.kyn == null) {
                return 0;
            }
            aVar.b(2, this.kyn);
            return 0;
        } else if (i == 1) {
            if (this.lUt != null) {
                fW = e.a.a.a.fW(1, this.lUt.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.kyn != null) {
                fW += e.a.a.a.a(2, this.kyn);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.lUt != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        lVar.lUt = eVar;
                    }
                    return 0;
                case 2:
                    lVar.kyn = aVar3.cKw();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

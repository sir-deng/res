package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cbm extends a {
    public cbp xhw;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xhw == null) {
                throw new b("Not all required fields were included: DownloadInfo");
            } else if (this.xhw == null) {
                return 0;
            } else {
                aVar.fZ(4, this.xhw.bkL());
                this.xhw.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.xhw != null) {
                fW = e.a.a.a.fW(4, this.xhw.bkL()) + 0;
            } else {
                fW = 0;
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.xhw != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DownloadInfo");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbm cbm = (cbm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 4:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a cbp = new cbp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cbp.a(aVar4, cbp, a.a(aVar4))) {
                        }
                        cbm.xhw = cbp;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class sm extends a {
    public sx whj;
    public sn whk;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.whj == null) {
                throw new b("Not all required fields were included: BannerSummary");
            } else if (this.whk == null) {
                throw new b("Not all required fields were included: BannerImg");
            } else {
                if (this.whj != null) {
                    aVar.fZ(1, this.whj.bkL());
                    this.whj.a(aVar);
                }
                if (this.whk == null) {
                    return 0;
                }
                aVar.fZ(2, this.whk.bkL());
                this.whk.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.whj != null) {
                fW = e.a.a.a.fW(1, this.whj.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.whk != null) {
                fW += e.a.a.a.fW(2, this.whk.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.whj == null) {
                throw new b("Not all required fields were included: BannerSummary");
            } else if (this.whk != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BannerImg");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sm smVar = (sm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a sxVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        sxVar = new sx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sxVar.a(aVar4, sxVar, a.a(aVar4))) {
                        }
                        smVar.whj = sxVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        sxVar = new sn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sxVar.a(aVar4, sxVar, a.a(aVar4))) {
                        }
                        smVar.whk = sxVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

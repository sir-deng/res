package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class atl extends a {
    public akv vTh;
    public ir vTi;
    public atk vTj;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vTh != null) {
                aVar.fZ(1, this.vTh.bkL());
                this.vTh.a(aVar);
            }
            if (this.vTj != null) {
                aVar.fZ(2, this.vTj.bkL());
                this.vTj.a(aVar);
            }
            if (this.vTi == null) {
                return 0;
            }
            aVar.fZ(3, this.vTi.bkL());
            this.vTi.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.vTh != null) {
                fW = e.a.a.a.fW(1, this.vTh.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vTj != null) {
                fW += e.a.a.a.fW(2, this.vTj.bkL());
            }
            if (this.vTi != null) {
                fW += e.a.a.a.fW(3, this.vTi.bkL());
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atl atl = (atl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a akv;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        akv = new akv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = akv.a(aVar4, akv, a.a(aVar4))) {
                        }
                        atl.vTh = akv;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        akv = new atk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = akv.a(aVar4, akv, a.a(aVar4))) {
                        }
                        atl.vTj = akv;
                    }
                    return 0;
                case 3:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        akv = new ir();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = akv.a(aVar4, akv, a.a(aVar4))) {
                        }
                        atl.vTi = akv;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

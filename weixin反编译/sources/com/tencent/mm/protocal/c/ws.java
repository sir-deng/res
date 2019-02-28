package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ws extends a {
    public LinkedList<hr> vUj = new LinkedList();
    public hp wnN;

    protected final int a(int i, Object... objArr) {
        int fW;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wnN != null) {
                aVar.fZ(1, this.wnN.bkL());
                this.wnN.a(aVar);
            }
            aVar.d(2, 8, this.vUj);
            return 0;
        } else if (i == 1) {
            if (this.wnN != null) {
                fW = e.a.a.a.fW(1, this.wnN.bkL()) + 0;
            } else {
                fW = 0;
            }
            return fW + e.a.a.a.c(2, 8, this.vUj);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vUj.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            ws wsVar = (ws) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a hpVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        hpVar = new hp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hpVar.a(aVar4, hpVar, a.a(aVar4))) {
                        }
                        wsVar.wnN = hpVar;
                    }
                    return 0;
                case 2:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        hpVar = new hr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hpVar.a(aVar4, hpVar, a.a(aVar4))) {
                        }
                        wsVar.vUj.add(hpVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

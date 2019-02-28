package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class m extends a {
    public int vJs;
    public int vJt;
    public LinkedList<n> vJu = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vJs);
            aVar.fX(2, this.vJt);
            aVar.d(3, 8, this.vJu);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fU(1, this.vJs) + 0) + e.a.a.a.fU(2, this.vJt)) + e.a.a.a.c(3, 8, this.vJu);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.vJu.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                m mVar = (m) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        mVar.vJs = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        mVar.vJt = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        LinkedList JD = aVar3.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a nVar = new n();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = nVar.a(aVar4, nVar, a.a(aVar4))) {
                            }
                            mVar.vJu.add(nVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

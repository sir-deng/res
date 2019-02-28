package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class vy extends a {
    public int wmj;
    public LinkedList<vx> wmk = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wmj);
            aVar.d(2, 8, this.wmk);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.fU(1, this.wmj) + 0) + e.a.a.a.c(2, 8, this.wmk);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wmk.clear();
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
                vy vyVar = (vy) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        vyVar.wmj = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        LinkedList JD = aVar3.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a vxVar = new vx();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = vxVar.a(aVar4, vxVar, a.a(aVar4))) {
                            }
                            vyVar.wmk.add(vxVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

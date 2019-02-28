package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class car extends a {
    public int vUN;
    public LinkedList<bzn> wrq = new LinkedList();
    public boolean xgs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.wrq);
            aVar.fX(2, this.vUN);
            aVar.am(3, this.xgs);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.c(1, 8, this.wrq) + 0) + e.a.a.a.fU(2, this.vUN)) + (e.a.a.b.b.a.dX(3) + 1);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wrq.clear();
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
                car car = (car) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList JD = aVar3.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a bzn = new bzn();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bzn.a(aVar4, bzn, a.a(aVar4))) {
                            }
                            car.wrq.add(bzn);
                        }
                        return 0;
                    case 2:
                        car.vUN = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        car.xgs = aVar3.cKv();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

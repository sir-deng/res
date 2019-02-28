package com.tencent.mm.ay;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class f extends a {
    public LinkedList<d> hLn = new LinkedList();
    public double hLo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.hLn);
            aVar.b(2, this.hLo);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 8, this.hLn) + 0) + (e.a.a.b.b.a.dX(2) + 8);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.hLn.clear();
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
                f fVar = (f) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList JD = aVar3.JD(intValue);
                        int size = JD.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) JD.get(intValue);
                            a dVar = new d();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                            }
                            fVar.hLn.add(dVar);
                        }
                        return 0;
                    case 2:
                        fVar.hLo = aVar3.AEQ.readDouble();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

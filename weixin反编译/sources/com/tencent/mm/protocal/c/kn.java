package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class kn extends a {
    public String name;
    public String vJU;
    public LinkedList<pq> vXY = new LinkedList();
    public int vXZ;
    public String vYa;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.vXY);
            if (this.vJU != null) {
                aVar.g(2, this.vJU);
            }
            aVar.fX(3, this.vXZ);
            if (this.vYa != null) {
                aVar.g(4, this.vYa);
            }
            if (this.name != null) {
                aVar.g(5, this.name);
            }
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vXY) + 0;
            if (this.vJU != null) {
                c += e.a.a.b.b.a.h(2, this.vJU);
            }
            c += e.a.a.a.fU(3, this.vXZ);
            if (this.vYa != null) {
                c += e.a.a.b.b.a.h(4, this.vYa);
            }
            if (this.name != null) {
                return c + e.a.a.b.b.a.h(5, this.name);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vXY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            kn knVar = (kn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        a pqVar = new pq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = pqVar.a(aVar4, pqVar, a.a(aVar4))) {
                        }
                        knVar.vXY.add(pqVar);
                    }
                    return 0;
                case 2:
                    knVar.vJU = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    knVar.vXZ = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    knVar.vYa = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    knVar.name = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

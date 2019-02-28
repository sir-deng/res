package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class fp extends a {
    public int vRX;
    public int vRY;
    public LinkedList<String> vRZ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vRX);
            aVar.fX(2, this.vRY);
            aVar.d(3, 1, this.vRZ);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fU(1, this.vRX) + 0) + e.a.a.a.fU(2, this.vRY)) + e.a.a.a.c(3, 1, this.vRZ);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.vRZ.clear();
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
                fp fpVar = (fp) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        fpVar.vRX = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        fpVar.vRY = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        fpVar.vRZ.add(aVar3.AEQ.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}

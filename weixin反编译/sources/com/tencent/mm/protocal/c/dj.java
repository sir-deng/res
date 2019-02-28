package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class dj extends a {
    public int vPe;
    public int vPf;
    public int vPm;
    public dk vPn;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vPe);
            aVar.fX(2, this.vPf);
            aVar.fX(3, this.vPm);
            if (this.vPn != null) {
                aVar.fZ(4, this.vPn.bkL());
                this.vPn.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.vPe) + 0) + e.a.a.a.fU(2, this.vPf)) + e.a.a.a.fU(3, this.vPm);
            if (this.vPn != null) {
                return fU + e.a.a.a.fW(4, this.vPn.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dj djVar = (dj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    djVar.vPe = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    djVar.vPf = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    djVar.vPm = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a dkVar = new dk();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dkVar.a(aVar4, dkVar, a.a(aVar4))) {
                        }
                        djVar.vPn = dkVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

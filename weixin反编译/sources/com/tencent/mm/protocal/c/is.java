package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class is extends bea {
    public String pQZ;
    public String vOg;
    public String vOh;
    public String vOi;
    public int vOl;
    public b vVC;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.vOg != null) {
                aVar.g(2, this.vOg);
            }
            if (this.vOh != null) {
                aVar.g(3, this.vOh);
            }
            if (this.pQZ != null) {
                aVar.g(4, this.pQZ);
            }
            aVar.fX(5, this.vOl);
            if (this.vVC != null) {
                aVar.b(6, this.vVC);
            }
            if (this.vOi == null) {
                return 0;
            }
            aVar.g(7, this.vOi);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.vOg != null) {
                fW += e.a.a.b.b.a.h(2, this.vOg);
            }
            if (this.vOh != null) {
                fW += e.a.a.b.b.a.h(3, this.vOh);
            }
            if (this.pQZ != null) {
                fW += e.a.a.b.b.a.h(4, this.pQZ);
            }
            fW += e.a.a.a.fU(5, this.vOl);
            if (this.vVC != null) {
                fW += e.a.a.a.a(6, this.vVC);
            }
            if (this.vOi != null) {
                fW += e.a.a.b.b.a.h(7, this.vOi);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            is isVar = (is) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        isVar.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    isVar.vOg = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    isVar.vOh = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    isVar.pQZ = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    isVar.vOl = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    isVar.vVC = aVar3.cKw();
                    return 0;
                case 7:
                    isVar.vOi = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

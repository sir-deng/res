package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cct extends bea {
    public b vTY;
    public String wXQ;
    public String xit;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wXQ != null) {
                aVar.g(2, this.wXQ);
            }
            if (this.vTY != null) {
                aVar.b(3, this.vTY);
            }
            if (this.xit == null) {
                return 0;
            }
            aVar.g(4, this.xit);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wXQ != null) {
                fW += e.a.a.b.b.a.h(2, this.wXQ);
            }
            if (this.vTY != null) {
                fW += e.a.a.a.a(3, this.vTY);
            }
            if (this.xit != null) {
                fW += e.a.a.b.b.a.h(4, this.xit);
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
            cct cct = (cct) objArr[1];
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
                        cct.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    cct.wXQ = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    cct.vTY = aVar3.cKw();
                    return 0;
                case 4:
                    cct.xit = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

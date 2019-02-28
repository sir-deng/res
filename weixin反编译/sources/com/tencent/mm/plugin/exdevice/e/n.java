package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public final class n extends a {
    public c lUr;
    public int lUv;
    public int lUw;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.lUr == null) {
                throw new b("Not all required fields were included: BasePush");
            }
            if (this.lUr != null) {
                aVar.fZ(1, this.lUr.bkL());
                this.lUr.a(aVar);
            }
            aVar.fX(2, this.lUv);
            aVar.fX(3, this.lUw);
            return 0;
        } else if (i == 1) {
            if (this.lUr != null) {
                fW = e.a.a.a.fW(1, this.lUr.bkL()) + 0;
            } else {
                fW = 0;
            }
            return (fW + e.a.a.a.fU(2, this.lUv)) + e.a.a.a.fU(3, this.lUw);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.lUr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BasePush");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a cVar = new c();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        nVar.lUr = cVar;
                    }
                    return 0;
                case 2:
                    nVar.lUv = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    nVar.lUw = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

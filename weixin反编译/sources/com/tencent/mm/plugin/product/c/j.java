package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class j extends a {
    public int fEo;
    public g pky;
    public String pkz;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.fEo);
            if (this.pky != null) {
                aVar.fZ(2, this.pky.bkL());
                this.pky.a(aVar);
            }
            if (this.pkz != null) {
                aVar.g(3, this.pkz);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.fEo) + 0;
            if (this.pky != null) {
                fU += e.a.a.a.fW(2, this.pky.bkL());
            }
            if (this.pkz != null) {
                return fU + e.a.a.b.b.a.h(3, this.pkz);
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
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.fEo = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a gVar = new g();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        jVar.pky = gVar;
                    }
                    return 0;
                case 3:
                    jVar.pkz = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

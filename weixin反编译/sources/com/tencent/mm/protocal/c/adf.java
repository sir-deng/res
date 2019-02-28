package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class adf extends a {
    public int vQL;
    public ake vSq;
    public String wgO;
    public int wsu;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.vQL);
            if (this.vSq != null) {
                aVar.fZ(2, this.vSq.bkL());
                this.vSq.a(aVar);
            }
            if (this.wgO != null) {
                aVar.g(3, this.wgO);
            }
            aVar.fX(4, this.wsu);
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.vQL) + 0;
            if (this.vSq != null) {
                fU += e.a.a.a.fW(2, this.vSq.bkL());
            }
            if (this.wgO != null) {
                fU += e.a.a.b.b.a.h(3, this.wgO);
            }
            return fU + e.a.a.a.fU(4, this.wsu);
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
            adf adf = (adf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    adf.vQL = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a ake = new ake();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ake.a(aVar4, ake, a.a(aVar4))) {
                        }
                        adf.vSq = ake;
                    }
                    return 0;
                case 3:
                    adf.wgO = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    adf.wsu = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

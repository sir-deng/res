package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class ayp extends a {
    public bqf wMg;
    public int wsC;
    public String wsD;
    public String wsE;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wsC);
            if (this.wsD != null) {
                aVar.g(2, this.wsD);
            }
            if (this.wsE != null) {
                aVar.g(3, this.wsE);
            }
            if (this.wMg != null) {
                aVar.fZ(4, this.wMg.bkL());
                this.wMg.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.wsC) + 0;
            if (this.wsD != null) {
                fU += e.a.a.b.b.a.h(2, this.wsD);
            }
            if (this.wsE != null) {
                fU += e.a.a.b.b.a.h(3, this.wsE);
            }
            if (this.wMg != null) {
                return fU + e.a.a.a.fW(4, this.wMg.bkL());
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
            ayp ayp = (ayp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ayp.wsC = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    ayp.wsD = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    ayp.wsE = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a bqf = new bqf();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bqf.a(aVar4, bqf, a.a(aVar4))) {
                        }
                        ayp.wMg = bqf;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

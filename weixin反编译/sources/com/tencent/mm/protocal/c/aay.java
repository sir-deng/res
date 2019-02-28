package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class aay extends a {
    public String wqC;
    public lp wqF;
    public String wqG;
    public boolean wqH;
    public int wqI;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wqF != null) {
                aVar.fZ(1, this.wqF.bkL());
                this.wqF.a(aVar);
            }
            if (this.wqC != null) {
                aVar.g(2, this.wqC);
            }
            if (this.wqG != null) {
                aVar.g(3, this.wqG);
            }
            aVar.am(4, this.wqH);
            aVar.fX(5, this.wqI);
            return 0;
        } else if (i == 1) {
            if (this.wqF != null) {
                fW = e.a.a.a.fW(1, this.wqF.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wqC != null) {
                fW += e.a.a.b.b.a.h(2, this.wqC);
            }
            if (this.wqG != null) {
                fW += e.a.a.b.b.a.h(3, this.wqG);
            }
            return (fW + (e.a.a.b.b.a.dX(4) + 1)) + e.a.a.a.fU(5, this.wqI);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aay aay = (aay) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a lpVar = new lp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = lpVar.a(aVar4, lpVar, a.a(aVar4))) {
                        }
                        aay.wqF = lpVar;
                    }
                    return 0;
                case 2:
                    aay.wqC = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    aay.wqG = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    aay.wqH = aVar3.cKv();
                    return 0;
                case 5:
                    aay.wqI = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}

package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class cdj extends a {
    public int vTR;
    public int wQO;
    public int wQQ;
    public String wgP;
    public cdg xiG;
    public int xiR;
    public boolean xiS;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xiG != null) {
                aVar.fZ(1, this.xiG.bkL());
                this.xiG.a(aVar);
            }
            aVar.fX(2, this.xiR);
            aVar.fX(3, this.wQO);
            aVar.fX(4, this.wQQ);
            aVar.am(5, this.xiS);
            aVar.fX(6, this.vTR);
            if (this.wgP == null) {
                return 0;
            }
            aVar.g(7, this.wgP);
            return 0;
        } else if (i == 1) {
            if (this.xiG != null) {
                fW = e.a.a.a.fW(1, this.xiG.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((((fW + e.a.a.a.fU(2, this.xiR)) + e.a.a.a.fU(3, this.wQO)) + e.a.a.a.fU(4, this.wQQ)) + (e.a.a.b.b.a.dX(5) + 1)) + e.a.a.a.fU(6, this.vTR);
            if (this.wgP != null) {
                fW += e.a.a.b.b.a.h(7, this.wgP);
            }
            return fW;
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
            cdj cdj = (cdj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a cdg = new cdg();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cdg.a(aVar4, cdg, a.a(aVar4))) {
                        }
                        cdj.xiG = cdg;
                    }
                    return 0;
                case 2:
                    cdj.xiR = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    cdj.wQO = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    cdj.wQQ = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    cdj.xiS = aVar3.cKv();
                    return 0;
                case 6:
                    cdj.vTR = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    cdj.wgP = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
